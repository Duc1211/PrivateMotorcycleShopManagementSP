package ui.main;


import format.event.EventMenuSelected;
import format.event.EventShowPopupMenu;

import format.menu.MenuItem;
import format.menu.Menu;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import entity.Account;
import format.menu.PopupMenu;
import format.other.GoogleMaterialDesignIcons;
import format.other.Header;
import format.other.IconFontSwing;
import format.other.MainForm;
import ui.analysis.FormAnalysis;
import ui.analysis.FormBestSellersStatistics;
import ui.analysis.FormInventoryAnalysis;
import ui.analysis.FormRevenueAnalysis;
import ui.contract.FormContract;
import ui.contract.FormContractComplete;
import ui.contract.FormContractInProgress;
import ui.customer.FormCustomer;
import ui.customer.FormCustomerComplete;
import ui.customer.FormCustomerInComplete;
import ui.employee.FormAllEmployee;
import ui.employee.FormEmployee;
import ui.employee.FormOfficeEmployee;
import ui.employee.FormTechnicalEmployee;
import ui.guide.FormUserGuide;
import ui.home.FormDemo;
import ui.home.FormHome;
import ui.order.FormOrder;
import ui.profile.FormProfile;
import ui.vehicle.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Home extends JFrame  {

    private Header header;
    private Menu menu;
    private MigLayout migLayout;
    private MainForm mainForm;
    private JLayeredPane bg;
    private Animator animator;
    private EventMenuSelected eventMenuSelected;

    private Login login;

    public void setLogin(Login login) {
        this.login = login;
    }


    public Home() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        init();
        eventMenuSelected = new EventMenuSelected();

    }


    private void init() {
        migLayout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(migLayout);
        menu = new Menu();
        header = new Header();
        mainForm = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            private FormProfile formProfile;

            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) throws SQLException {
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index: " + subMenuIndex);
                //Home
                if (menuIndex == 0) {
                    if (subMenuIndex == -1) {
                        mainForm.showForm(new FormHome());
                    }
                }
                //Product
                if (menuIndex == 1) {
                    if (subMenuIndex == -1) {
                        mainForm.showForm(new FormProduct());
                    } else if (subMenuIndex == 0) {
                        try {
                            mainForm.showForm(new FormAllVehicle());
                        } catch (SQLException e) {

                            e.printStackTrace();
                        }
                    }
                    else if (subMenuIndex == 1) {
                        mainForm.showForm(new FormManualMotorcycle());
                    }
                    else if (subMenuIndex == 2) {
                        mainForm.showForm(new FormAutomaticScooter());
                    }
                    else if (subMenuIndex == 3) {
                        mainForm.showForm(new FormElectricMotorcycle());
                    }
                    else if (subMenuIndex == 4) {
                        mainForm.showForm(new FormManualTransmission());
                    }
                }

                //Employee
                if(menuIndex == 2){
                    if(subMenuIndex == -1){
                        mainForm.showForm(new FormEmployee());
                    } else if (subMenuIndex == 0) {
                        mainForm.showForm(new FormAllEmployee());
                    } else if (subMenuIndex == 1) {
                        mainForm.showForm(new FormTechnicalEmployee());
                    } else if (subMenuIndex == 2) {
                        mainForm.showForm(new FormOfficeEmployee());
                    }
                }
                //Contract
                if(menuIndex == 3){
                    if(subMenuIndex == -1){
                        mainForm.showForm(new FormContract());
                    }else if (subMenuIndex == 0) {
                        mainForm.showForm(new FormContractComplete());
                    } else if (subMenuIndex == 1) {
                        mainForm.showForm(new FormContractInProgress());
                    }
                }
                //Customer
                if(menuIndex == 4){
                    if(subMenuIndex == -1){
                        mainForm.showForm(new FormCustomer());
                    }else if (subMenuIndex == 0) {
                        mainForm.showForm(new FormCustomerComplete());
                    } else if (subMenuIndex == 1) {
                        mainForm.showForm(new FormCustomerInComplete());
                    }
                }

                //Analysis
                if(menuIndex == 5){
                    if(subMenuIndex == -1){
                        mainForm.showForm(new FormAnalysis());
                    } else if (subMenuIndex == 0) {
                        mainForm.showForm(new FormRevenueAnalysis());
                    } else if (subMenuIndex == 1) {
                        mainForm.showForm(new FormInventoryAnalysis());
                    } else if (subMenuIndex == 2) {
                        mainForm.showForm(new FormBestSellersStatistics());
                    }
                }
                //Use Guide
                if(menuIndex == 6){
                    if(subMenuIndex == -1){
                        mainForm.showForm(new FormUserGuide());
                    }
                }
                //Analysis
                if(menuIndex == 7){
                    if(subMenuIndex == -1){
                        mainForm.showForm(new FormOrder());
                    }
                }

                //Profile
                if(menuIndex == 8){
                    if(subMenuIndex == -1){
                        if(login != null) {
                            Account loggedAccount = login.getLoggedInAccount();
                            if(loggedAccount != null) {
                                FormProfile formProfile = new FormProfile(loggedAccount.getEmployee());
                                mainForm.showForm(formProfile);
                            }
                            else {
                                System.out.println("loggedAccount null!");
                            }
                        }
                        else {
                            System.out.println("login null");
                        }

                    }
                }

                //Logout
                if(menuIndex == 9){
                    if(subMenuIndex == -1){
                        setVisible(false);
                    }
                    new Login().setVisible(true);
                }
            }
        });
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(Home.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = Home.this.getX() + 52;
                int y = Home.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.initMenuItem();
        bg.add(menu, "w 250!, spany 2");    // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        bg.add(mainForm, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                migLayout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }
            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });

        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        mainForm.showForm(new FormHome());
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        bg = new JLayeredPane();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new Color(245, 245, 245));
        bg.setOpaque(true);

        GroupLayout bgLayout = new GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
                bgLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 1366, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
                bgLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 783, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(bg)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
}


