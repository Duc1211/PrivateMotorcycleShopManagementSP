package ui.main;

import connect.ConnectDB;
import entity.Account;
import entity.Employee;
import model.MailModel;
import format.panel.PanelCover;
import format.panel.PanelLoading;
import format.panel.PanelLoginAndRegister;
import format.panel.PanelVerifyCode;
import format.service.ServiceAccount;
import format.service.ServiceMail;
import message.MessageLG;
import model.LoginModel;
import net.miginfocom.swing.MigLayout;
import ui.profile.FormProfile;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.awt.EventQueue.invokeLater;

import java.awt.Color;

public class Login extends JFrame {
    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private MigLayout layout;
    private PanelCover pCover;
    private PanelVerifyCode pVerifyCode;
    private PanelLoading pLoading;
    private JLayeredPane bg;
    private PanelLoginAndRegister pLoginAndRegister;
    private boolean isLogin = true;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;
    private ServiceAccount serviceAccount;
    private Home home;
    private Account a;


    public Login(){
        try {
            ConnectDB.getInstance().connectDataBase();
            System.out.println("Success!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setTitle("Cửa Hàng Xe Funny");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
        init();}
    private void init() {
        try {
            serviceAccount=new ServiceAccount();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Loi e ser acc");
        }
        layout = new MigLayout("fill, insets 0");
        pCover = new PanelCover();
        pVerifyCode = new PanelVerifyCode();
        pLoading = new PanelLoading();
        ActionListener eventRegister = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        };
        ActionListener eventLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        };
        pLoginAndRegister = new PanelLoginAndRegister(eventRegister, eventLogin);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionLogin;
                double size = coverSize;
                if (fraction <= 0.5f) {
                    size += fraction * addSize;
                } else {
                    size += addSize - fraction * addSize;
                }
                if (isLogin) {
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    if (fraction >= 0.5f) {
                        pCover.registerRight(fractionCover * 100);
                    } else {
                        pCover.loginRight(fractionLogin * 100);
                    }
                } else  {
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    if (fraction <= 0.5f) {
                        pCover.registerLeft(fraction * 100);
                    } else {
                        pCover.loginLeft((1f - fraction) * 100);
                    }
                }
                if (fraction >= 0.5f) {
                    pLoginAndRegister.showRegister(isLogin);
                }
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionLogin = Double.valueOf(df.format(fractionLogin));
                layout.setComponentConstraints(pCover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(pLoginAndRegister, "width " + loginSize + "%, pos " + fractionLogin + "al 0 n 100%");
                bg.revalidate();
            }

            @Override
            public void end() {
                isLogin = !isLogin;
            }
        };
        Animator animator = new Animator(800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);
        bg.setLayout(layout);
        bg.setLayer(pLoading, JLayeredPane.POPUP_LAYER);
        bg.setLayer(pVerifyCode, JLayeredPane.POPUP_LAYER);

        bg.add(pLoading, "pos 0 0 100% 100%");
        bg.add(pVerifyCode, "pos 0 0 100% 100%");
        bg.add(pCover, "width " + coverSize + "%, pos " + (isLogin ? "1al" : "0al") + " 0 n 100%");
        bg.add(pLoginAndRegister, "width " + loginSize + "%, pos " + (isLogin ? "0al" : "1al") + " 0 n 100%"); //  1al as 100%
        pLoginAndRegister.showRegister(!isLogin);
        pCover.login(isLogin);
        pCover.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });
    }

    private void register() {

        Account account = pLoginAndRegister.getAccount();


        try {
            //           	if (serviceAccount.checkDuplicateUser(account.getEmployee().getEmployeeCode()))
            //           	{
            //           		showMessage(MessageLG.MessageType.ERROR, "Employee code not exist");
            //
            //           	}
//                else if (serviceAccount.checkDuplicateEmail(account.getEmail()))
//                {
//                	showMessage(MessageLG.MessageType.ERROR, "Email already exit");
//            	}
            //               else
            //               {
            serviceAccount.insertUser(account);
            System.out.println("dang ky thanh cong2!");

            // sendMain(account);
            //   }
        } catch (SQLException e) {
            showMessage(MessageLG.MessageType.ERROR, "Error Register");
            e.printStackTrace();
        }
    }

    public void login() {
        LoginModel data = pLoginAndRegister.getLoginModel();
        try {
            Account account = serviceAccount.login(data);
            if (account != null) {
                this.dispose();
                Home home = new Home();
                home.setVisible(true);

                this.a = account;
                home.setLogin(this);
                FormProfile formProfile = new FormProfile(account.getEmployee());


            } else {
                showMessage(MessageLG.MessageType.ERROR, "Email and Password incorrect");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            showMessage(MessageLG.MessageType.ERROR, "Error Login");
        }
    }

    private void sendMain(Account account) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                pLoading.setVisible(true);
                MailModel ms = new ServiceMail().sendMain(account.getEmail(), account.getVerifyCode());
                if (ms.isSuccess()) {
                    pLoading.setVisible(false);
                    pVerifyCode.setVisible(true);
                } else {
                    pLoading.setVisible(false);
                    showMessage(MessageLG.MessageType.ERROR, "Mail error");
                }
            }
        }).start();
    }
    private  void showMessage(MessageLG.MessageType messageType, String message) {
        MessageLG mess = new MessageLG();
        mess.showMessage(messageType, message);
        TimingTarget timingTarget = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (!mess.isShow()) {
                    bg.add(mess, "pos 0.5al -30", 0);
                    mess.setVisible(true);
                    bg.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                if (mess.isShow()) {
                    f = 40 * (1f - fraction);
                } else {
                    f = 40 * fraction;
                }
                layout.setComponentConstraints(mess, "pos 0.5al " + (int) (f - 30));
                bg.repaint();
                bg.revalidate();
            }

            @Override
            public void end() {
                if (mess.isShow()) {
                    bg.remove(mess);
                    bg.repaint();
                    bg.revalidate();
                } else {
                    mess.setShow(true);
                }
            }
        };
        Animator animator = new Animator(300, timingTarget);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    animator.start();
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }
        }).start();
    }

    private void initComponents() {

        bg = new JLayeredPane();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(false);
//        setExtendedState(JFrame.MAXIMIZED_BOTH);

        bg.setBackground(new Color(255, 255, 255));
        bg.setOpaque(true);

        GroupLayout bgLayout = new GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
                bgLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 933, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
                bgLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 537, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(bg, GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        try {
            ConnectDB.getInstance().connectDataBase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    public Account getLoggedInAccount() {
        return a;
    }


}
