package format.menu;

import format.event.EventMenu;
import format.event.EventMenuSelected;
import format.event.EventShowPopupMenu;
import format.other.Profile;
import format.scroll.ScrollBarCustomMenu;
import model.MenuModel;
import net.miginfocom.swing.MigLayout;

import java.awt.*;
import javax.swing.*;

public class Menu extends JPanel {

    private boolean showMenu = true;

    private boolean enableMenu = true;
    private JScrollPane scrlPane;
    private MigLayout migLayout;
    private EventMenuSelected eventMenuSelected;
    private JPanel panel;
    private EventShowPopupMenu eventShowPopupMenu;
    private Profile profile;
    private JPanel panelMenu;



    public boolean isShowMenu() {
        return showMenu;
    }

    public void addEvent(EventMenuSelected eventMenuSelected) {
        this.eventMenuSelected = eventMenuSelected;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public void addEventShowPopup(EventShowPopupMenu eventShowPopupMenu) {
        this.eventShowPopupMenu = eventShowPopupMenu;
    }


    public Menu() {
        initComponents();
        setOpaque(false);
        scrlPane.getViewport().setOpaque(false);
        scrlPane.setVerticalScrollBar(new ScrollBarCustomMenu());
        migLayout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setLayout(migLayout);
        panelMenu = new JPanel();
    }
    private void addMenu(MenuModel menu) {
        panel.add(new MenuItem(menu, getEventMenu(), eventMenuSelected, panel.getComponentCount()), "h 40!");
    }

    public void initMenuItem() {
        addMenu(new MenuModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/home.png")), "Home"));
        addMenu(new MenuModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/product.png")), "Products", "All", "Manual Motorcycle", "Automatic Scooter","Electric Motorcycle", "Manual Transmission"));
        addMenu(new MenuModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/owner.png")), "Employees", "All", "Technical Employee", "Office Employee"));
        addMenu(new MenuModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/contract.png")), "Contracs", "Contract Completed", "Contract In Progress"));
        addMenu(new MenuModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/customer.png")), "Customer", "Customer Completed", "Incomplete Customer "));
        addMenu(new MenuModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/analysis.png")), " Analysis", "Revenue Analysis", "Inventory Analysis", "Best-Sellers Statistics"));
        addMenu(new MenuModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/guide.png")), "User guide"));
        addMenu(new MenuModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/feedback.png")), "Order"));
        addMenu(new MenuModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/profile.png")), "User Profile"));
        addEmpty();
        addMenu(new MenuModel(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/logout.png")), "Logout"));
    }

    private void addEmpty() {
        panelMenu.add(new JLabel(), "push");
    }

    public void hideallMenu() {
        for (Component com : panel.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.isOpen()) {
                new MenuAnimation(migLayout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }

    private void initComponents() {

            scrlPane = new JScrollPane();
            panel = new JPanel();
            profile = new Profile();
            panelMenu = new JPanel();

            scrlPane.setBorder(null);
            scrlPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scrlPane.setViewportBorder(null);

            panel.setOpaque(false);

            GroupLayout panelLayout = new GroupLayout(panel);
            panel.setLayout(panelLayout);
            panelLayout.setHorizontalGroup(
                    panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGap(0, 312, Short.MAX_VALUE)
            );
            panelLayout.setVerticalGroup(
                    panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGap(0, 523, Short.MAX_VALUE)
            );

        panelMenu.setBackground(new Color(165, 225, 193));

        GroupLayout panelMenuLayout = new GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
                panelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 208, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
                panelMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 578, Short.MAX_VALUE)
        );

            scrlPane.setViewportView(panel);

            GroupLayout layout = new GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(scrlPane, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(profile, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(profile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(scrlPane, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
            );


    }
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, new Color(22, 77, 47), getWidth(), 0, new Color(9, 248, 122));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }
    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if (enableMenu) {
                    if (isShowMenu()) {
                        if (open) {
                            new MenuAnimation(migLayout, com).openMenu();
                        } else {
                            new MenuAnimation(migLayout, com).closeMenu();
                        }
                        return true;
                    } else {
                        eventShowPopupMenu.showPopup(com);
                    }
                }
                return false;
            }
        };
    }


}
