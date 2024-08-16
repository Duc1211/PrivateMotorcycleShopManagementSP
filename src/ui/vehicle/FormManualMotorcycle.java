package ui.vehicle;

import connect.ConnectDB;
import dao.BrandDao;
import dao.RangeOfVehicleDao;
import dao.VehicleDao;
import entity.MotorcycleCompany;
import entity.RangeOfVehicle;
import entity.Vehicle;
import format.product.BackgroundItem;
import format.product.CusItem;
import format.event.EventItem;
import format.panel.PanelFormVehicle;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class FormManualMotorcycle extends JPanel {
    private BackgroundItem background1;
    private PanelFormVehicle mainPanel;
    private CusItem home;
    private Animator animator;
    private Point animatePoint;
    private Vehicle itemSelected;
    private VehicleDao vehicleDao;
    private ArrayList<Vehicle> listVehicle;
    private BrandDao brandDao;
    private RangeOfVehicleDao rangeOfVehicleDao;


    public FormManualMotorcycle() throws SQLException {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        init();
        try {
            ConnectDB.getInstance().connectDataBase();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        animator = PropertySetter.createAnimator(500, mainPanel, "imageLocation", animatePoint, mainPanel.getTargetLocation());
        animator.addTarget(new PropertySetter(mainPanel, "imageSize", new Dimension(180, 120), mainPanel.getTargetSize()));
        animator.addTarget(new TimingTargetAdapter() {
            @Override
            public void end() {
                mainPanel.setImageOld(null);
            }
        });
        animator.setResolution(0);
        animator.setAcceleration(.5f);
        animator.setDeceleration(.5f);
    }

    private void init() throws SQLException {
        home = new CusItem();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(home);
        testData();
    }

    private void testData() throws SQLException {
        home.setEvent(new EventItem() {
            @Override
            public void itemClick(Component com, Vehicle item) {
                if (itemSelected != null) {
                    ImageIcon image = new ImageIcon(itemSelected.getVehicleImage());
                    mainPanel.setImageOld(image);
                }
                if (itemSelected != item) {
                    if (!animator.isRunning()) {
                        itemSelected = item;
                        ImageIcon image = new ImageIcon(itemSelected.getVehicleImage());
                        animatePoint = getLocationOf(com);
                        mainPanel.setImage(image);
                        mainPanel.setImageLocation(animatePoint);
                        mainPanel.setImageSize(new Dimension(180, 120));
                        mainPanel.repaint();
                        home.setSelected(com);
                        home.showItem(item);
                        animator.start();
                    }
                }
            }
        });
        vehicleDao = new VehicleDao();
        listVehicle = vehicleDao.getVehicleByType("RANGE01");
        int ID = 1;
        for (int i = 0; i <= 5; i++) {
            for(Vehicle v : listVehicle){
                home.addItem(v);
            }
//            home.addItem(new Vehicle("H001", new ImageIcon(getClass().getClassLoader().getResource("source/Image/product/Yamaha/yamaha_exciter_150.png")),
//                    new MotorcycleCompany("BRAND12", "Yamaha"), new RangeOfVehicle("MANUAL", "Manual Motorcycle"),
//                    "Yamaha Exciter 150", "Exciter", "1.084 cc", "75kW/7.500 rpm", "2012", 2500, 120, "24.8 Liters", "10,1:1", "4-stroke, 2-cylinder, liquid-cooled",
//                    "DCT 6-speed dual- Clutch automatic transmission", "4.8 liters/100 km", LocalDate.of(2014,12,24),"A234C65GV89", "RED, BLACK"));
//
//            home.addItem(new Vehicle("H002", new ImageIcon(getClass().getClassLoader().getResource("source/Image/product/BMW/bmw_ce_04.png")),
//                    new MotorcycleCompany("B001", "BMW"), new RangeOfVehicle("MANUAL", "Manual Motorcycle"),
//                    "BMW CE 04", "CE", "1.084 cc", "75kW/7.500 rpm", "2012", 2500, 120, "24.8 Liters", "10,1:1", "4-stroke, 2-cylinder, liquid-cooled",
//                    "DCT 6-speed dual- Clutch automatic transmission", "4.8 liters/100 km", LocalDate.of(2014,12,24),"A234C65GV89", "RED, BLACK"));
//
//            home.addItem(new Vehicle("H003", new ImageIcon(getClass().getClassLoader().getResource("source/Image/product/Ducati/ducati_multistrada_v4_s_grand_tour.png")),
//                    new MotorcycleCompany("BRAND02", "Ducati"), new RangeOfVehicle("MANUAL", "Manual Motorcycle"),
//                    "Ducati Multistrada V4 S Grand Tour", "Multistrada", "1.084 cc", "75kW/7.500 rpm", "2012", 2500, 120, "24.8 Liters", "10,1:1", "4-stroke, 2-cylinder, liquid-cooled",
//                    "DCT 6-speed dual- Clutch automatic transmission", "4.8 liters/100 km", LocalDate.of(2014,12,24),"A234C65GV89", "RED, BLACK"));
//
//            home.addItem(new Vehicle("H004", new ImageIcon(getClass().getClassLoader().getResource("source/Image/product/Harley Davidson/harley_2023_nightster_special.png")),
//                    new MotorcycleCompany("BRAND03", "Harley"), new RangeOfVehicle("MANUAL", "Manual Motorcycle"),
//                    "Harley 2023 Nightster Special", "Nightster", "1.084 cc", "75kW/7.500 rpm", "2012", 2500, 120, "24.8 Liters", "10,1:1", "4-stroke, 2-cylinder, liquid-cooled",
//                    "DCT 6-speed dual- Clutch automatic transmission", "4.8 liters/100 km", LocalDate.of(2014,12,24),"A234C65GV89", "RED, BLACK"));
//
//            home.addItem(new Vehicle("H005", new ImageIcon(getClass().getClassLoader().getResource("source/Image/product/Kawasaki/kawasaki_ninja_h2sx.png")),
//                    new MotorcycleCompany("BRAND05", "Kawasaki"), new RangeOfVehicle("MANUAL", "Manual Motorcycle"),
//                    "Kawasaki Ninja H2SX", "Ninja", "1.084 cc", "75kW/7.500 rpm", "2012", 2500, 120, "24.8 Liters", "10,1:1", "4-stroke, 2-cylinder, liquid-cooled",
//                    "DCT 6-speed dual- Clutch automatic transmission", "4.8 liters/100 km", LocalDate.of(2014,12,24),"A234C65GV89", "RED, BLACK"));
//
//            home.addItem(new Vehicle("H006", new ImageIcon(getClass().getClassLoader().getResource("source/Image/product/Piaggio/piaggio_vespa_primavera_red_125.png")),
//                    new MotorcycleCompany("BRAND07", "Piaggio"), new RangeOfVehicle("MANUAL", "Manual Motorcycle"),
//                    "Piaggio Vespa Primavera Red 125", "Vespa", "1.084 cc", "75kW/7.500 rpm", "2012", 2500, 120, "24.8 Liters", "10,1:1", "4-stroke, 2-cylinder, liquid-cooled",
//                    "DCT 6-speed dual- Clutch automatic transmission", "4.8 liters/100 km", LocalDate.of(2014,12,24),"A234C65GV89", "RED"));
//
//            home.addItem(new Vehicle("H007", new ImageIcon(getClass().getClassLoader().getResource("source/Image/product/Triumph/triumph_rocket_3_gt.png")),
//                    new MotorcycleCompany("BRAND10", "Triumph"), new RangeOfVehicle("MANUAL", "Manual Motorcycle"),
//                    "Triumph Rocket 3 GT", "Rocket", "1.084 cc", "75kW/7.500 rpm", "2012", 2500, 120, "24.8 Liters", "10,1:1", "4-stroke, 2-cylinder, liquid-cooled",
//                    "DCT 6-speed dual- Clutch automatic transmission", "4.8 liters/100 km", LocalDate.of(2014,12,24),"A234C65GV89", "RED, BLACK"));

        }
    }

    private Point getLocationOf(Component com) {
        Point p = home.getPanelItemLocation();
        int x = p.x;
        int y = p.y;
        int itemX = com.getX();
        int itemY = com.getY();
        int left = 10;
        int top = 35;
        return new Point(x + itemX + left, y + itemY + top);
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        background1 = new BackgroundItem();
        mainPanel = new PanelFormVehicle();
        mainPanel.setBackground(new Color(255, 255, 255));

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 517, Short.MAX_VALUE)
        );

        GroupLayout background1Layout = new GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
                background1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(background1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(background1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        background1Layout.setVerticalGroup(
                background1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(background1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(background1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(background1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

    }
}
