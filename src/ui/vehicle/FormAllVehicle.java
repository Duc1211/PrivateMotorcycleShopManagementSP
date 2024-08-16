package ui.vehicle;

import com.raven.datechooser.DateChooser;
import connect.ConnectDB;
import dao.BrandDao;
import dao.RangeOfVehicleDao;
import dao.VehicleDao;
import entity.*;
import format.combobox.ComboBox;
import format.event.TableActionEvent;
import format.panel.PanelRound;
import format.spinner.Spinner;
import format.table.Table;
import format.textfield.TextField;
import message.MessageTB;
import model.NameModel;
import ui.main.Home;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class FormAllVehicle extends PanelRound implements MouseListener{

    private PanelRound roundPanel1;
    private PanelRound roundPanel2;
    private TextField txtName, txtCylinderCapacity, txtEngineCapacity, txtModel;
    private TextField txtPrice, txtPetrolTank, txtCompressionRatio, txtEngineType;
    private TextField txtTransmisionType, txtFuelConsumption, txtColor, txtEntryDate, txtIDNumber, txtCode, txtImportPrice;
    private JLabel lblImg;
    private JSeparator separator;
    private Button btnAdd, btnSave, btnErase, btnImg;
    private JComboBox<String> cbxBrand;
    private JComboBox<String> cbxRange;
    private Spinner spnMass, spnManufacture;
    private DateChooser date;
    private JScrollPane scrlPane;
    private Table table;
    private ImageIcon imageIcon;
    private VehicleDao vehicleDao;
    private Vehicle v;
    private ArrayList<Vehicle> listVehicle;
    private byte[] image;
    private TableActionEvent eventAction;
    private String fileName;
    private MotorcycleCompany mc;
    private BrandDao brandDao;
    private RangeOfVehicle rv;

    private RangeOfVehicleDao rangeOfVehicleDao;
    private byte[] imageIn;


    public FormAllVehicle() throws SQLException {

        initComponent();
        table.fixTable(scrlPane);
        setBackground(new Color(255, 255, 255));
        setOpaque(false);
        try {
            ConnectDB.getInstance().connectDataBase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        init();
    }

    private void init() throws SQLException {

//        JSpinner.NumberEditor editor = (JSpinner.NumberEditor) spnManufacture.getEditor();
//        DefaultFormatter formatter = (DefaultFormatter) editor.getTextField().getFormatter();
//        formatter.setCommitsOnValidEdit(true);
//        editor.getTextField().setHorizontalAlignment(SwingConstants.CENTER);

        for(Vehicle v : listVehicle){
            table.addRow(v.toRowTable(eventAction));
            System.out.println(v.getVehicleName());
        }
    }

    private boolean showMessage(String message) {
        MessageTB obj = new MessageTB(Home.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    private void initComponent() throws SQLException {

        imageIcon = new ImageIcon();
        txtCode = new format.textfield.TextField();
        txtCode.setLabelText("Vehicle Code");
        txtName = new format.textfield.TextField();
        txtName.setLabelText("Vehicle Name");
        txtImportPrice = new TextField();
        txtImportPrice.setLabelText("Import Price");
        txtCylinderCapacity = new format.textfield.TextField();
        txtCylinderCapacity.setLabelText("Cylinder Capacity");
        txtEngineCapacity = new format.textfield.TextField();
        txtEngineCapacity.setLabelText("Engine Capacity");
        txtModel = new format.textfield.TextField();
        txtModel.setLabelText("Vehicle Line");
        txtPrice = new format.textfield.TextField();
        txtPrice.setLabelText("Price");
        txtPetrolTank = new format.textfield.TextField();
        txtPetrolTank.setLabelText("Petrol Tank Capacity");
        txtCompressionRatio = new format.textfield.TextField();
        txtCompressionRatio.setLabelText("Compression Ratio");
        txtEngineType = new format.textfield.TextField();
        txtEngineType.setLabelText("Engine Type");
        txtTransmisionType = new format.textfield.TextField();
        txtTransmisionType.setLabelText("Transmission Type");
        txtFuelConsumption = new format.textfield.TextField();
        txtFuelConsumption.setLabelText("Fuel Consumption");
        txtColor = new format.textfield.TextField();
        txtColor.setLabelText("Color");
        txtEntryDate = new format.textfield.TextField();
        txtEntryDate.setLabelText("Entry Date");
        txtIDNumber = new TextField();
        txtIDNumber.setLabelText("ID Number");
        cbxRange = new JComboBox<>();
        cbxBrand = new JComboBox<>();
        scrlPane = new JScrollPane();
        table = new Table();
        vehicleDao = new VehicleDao();
        listVehicle = new ArrayList<Vehicle>();
        listVehicle = vehicleDao.getAllTableVehicle();
        brandDao = new BrandDao();
        rangeOfVehicleDao = new RangeOfVehicleDao();


        ArrayList<MotorcycleCompany> listBrand = brandDao.getAllTableMotorcycleCompany();
        for (MotorcycleCompany mc : listBrand) {
            cbxBrand.addItem(mc.getVehicleCompanyCode());
            System.out.println(mc.getVehicleCompanyName());
        }
        ArrayList<RangeOfVehicle> listType = rangeOfVehicleDao.getAllTableRangOfVehicle();
        for (RangeOfVehicle rv : listType) {
            cbxRange.addItem(rv.getVehicleTypeCode());
            System.out.println(rv.getVehicleTypeName());
        }
//        cbxBrand.addItem("BMW");
//        cbxBrand.addItem("Ducati");
//        cbxBrand.addItem("Harley Davidson");
//        cbxBrand.addItem("Honda");
//        cbxBrand.addItem("Kawasaki");
//        cbxBrand.addItem("Kymco");
//        cbxBrand.addItem("Piaggio");
//        cbxBrand.addItem("Suzuki");
//        cbxBrand.addItem("SYM");
//        cbxBrand.addItem("Triumph");
//        cbxBrand.addItem("Vinfast");
//        cbxBrand.addItem("Yamaha");
//
//        cbxRange.addItem("Manual Motorcycle");
//        cbxRange.addItem("Automatic Scooter");
//        cbxRange.addItem("Electric Motorcycle");
//        cbxRange.addItem("Manual Transmission");


        SpinnerNumberModel numberModel = new SpinnerNumberModel(2023, 1900, 2023, 1);
        spnMass = new Spinner(numberModel);
        spnMass.setLabelText("Self-Volume");
        spnMass.setEnabled(true);
        spnMass.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (int) spnMass.getValue();

            }
        });
        spnManufacture = new Spinner(numberModel);
        spnManufacture.setLabelText("Year Manufacture");


        date = new DateChooser();
        date.setTextField(txtEntryDate);


        lblImg = new JLabel();
        lblImg.setBackground(new Color(255, 255, 255));
        lblImg.setIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/avatar/avtnu.png")));
        btnImg = new Button("Library");
        btnImg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnImgActionEvent(evt);
            }
        });
        separator = new JSeparator();
        btnAdd = new Button("ADD");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAddActionEvent(e);
            }
        });
        btnErase = new Button("ERASE");
        btnErase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEraseActionEvent(e);
            }
        });
        btnSave = new Button("SAVE");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSaveActionListener(e);
            }
        });
        roundPanel1 = new PanelRound();
        table.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Vehicle Code", "Vehicle Name", "Range of Vehicle", "Brand", "Vehicle Line", "Color", "Entry Date", "Price", "Action"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        scrlPane.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(1).setPreferredWidth(200);
            table.getColumnModel().getColumn(2).setPreferredWidth(150);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
            table.getColumnModel().getColumn(4).setPreferredWidth(100);
            table.getColumnModel().getColumn(5).setPreferredWidth(100);
            table.getColumnModel().getColumn(6).setPreferredWidth(100);
            table.getColumnModel().getColumn(7).setPreferredWidth(100);
            table.getColumnModel().getColumn(8).setPreferredWidth(100);

        }
        eventAction = new TableActionEvent() {

            @Override
            public void delete(Vehicle vehicle) {
                int row = table.getSelectedRow();
                String code = (String) table.getValueAt(row, 0);
                table.remove(row);
                JOptionPane.showMessageDialog(Home.getFrames()[0],"Delete success!" );
                Vehicle v = new Vehicle(code);
                try {
                    vehicleDao.removeVehicle(v);
                    System.out.println("Removed Successfully In Database!");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                showMessage("Delete Vehicle : " + vehicle.getVehicleName());
                System.out.println("Click!");
            }

            @Override
            public void update(Vehicle vehicle) {
                int row = table.getSelectedRow();
                txtCode.setText(table.getValueAt(row, 0).toString());
                txtName.setText(table.getValueAt(row, 1).toString());
                txtModel.setText(table.getValueAt(row, 4).toString());
                txtColor.setText((table.getValueAt(row, 5).toString()));
                listVehicle = vehicleDao.getVehicleByCode(table.getValueAt(row, 0).toString());
                Vehicle v = listVehicle.get(0);
                txtCompressionRatio.setText(v.getCompressionRatio().toString());
                txtPetrolTank.setText(v.getPetrolTankCapacity().toString());
                txtFuelConsumption.setText(v.getFuelConsumption().toString());
                txtCylinderCapacity.setText(v.getCylinderCapacity().toString());
                txtImportPrice.setText(String.valueOf(v.getImportPrice()));
                txtTransmisionType.setText(v.getTransmissionType().toString());
                txtEngineType.setText(v.getEngineType().toString());
                txtEngineCapacity.setText(v.getEngineCapacity());
                spnMass.setValue(v.getVehicleMass());
                spnManufacture.setValue(v.getYearManufacture());
//            ImageIcon image = new ImageIcon(v.getVehicleImage());
//            lblImg.setIcon(image);

                txtPrice.setText(table.getValueAt(row, 7).toString());
                cbxBrand.setSelectedItem(v.getVehicleCompany());
                cbxRange.setSelectedItem((v.getRangeOfVehicle()));
            }
        };


        roundPanel2 = new PanelRound();
        roundPanel1.setBackground(new Color(217, 243, 229, 255));
        roundPanel1.setRoundTopLeft(20);
        roundPanel1.setRoundTopRight(20);
        roundPanel1.setRoundBottomLeft(20);
        roundPanel1.setRoundBottomRight(20);
        separator.setBackground(new Color(153, 255, 153));
        separator.setOrientation(SwingConstants.VERTICAL);

        GroupLayout layoutRoundPanel1 = new GroupLayout(roundPanel1);
        roundPanel1.setLayout(layoutRoundPanel1);
        layoutRoundPanel1.setHorizontalGroup(
                layoutRoundPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layoutRoundPanel1.createSequentialGroup()
                                .addGroup(layoutRoundPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layoutRoundPanel1.createSequentialGroup()
                                                .addGap(20)
                                                .addGroup(layoutRoundPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layoutRoundPanel1.createSequentialGroup()
                                                                .addGap(25)
                                                                .addComponent(btnImg, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(lblImg, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layoutRoundPanel1.createSequentialGroup()
                                                .addContainerGap()
                                                .addGap(20)
                                                .addComponent(txtIDNumber, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layoutRoundPanel1.createSequentialGroup()
                                                .addContainerGap()
                                                .addGap(20)
                                                .addComponent(txtCode, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                                .addGap(30)
                                .addGroup(layoutRoundPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layoutRoundPanel1.createSequentialGroup()
                                                .addGroup(layoutRoundPanel1.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(layoutRoundPanel1.createSequentialGroup()
                                                                .addComponent(txtName, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(20)
                                                                .addComponent(txtPrice))
                                                        .addGroup(GroupLayout.Alignment.LEADING, layoutRoundPanel1.createSequentialGroup()
                                                                .addComponent(txtModel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(20)
                                                                .addComponent(txtEntryDate))
                                                        .addGroup(GroupLayout.Alignment.LEADING, layoutRoundPanel1.createSequentialGroup()
                                                                .addComponent(txtColor, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(20)
                                                                .addComponent(txtCylinderCapacity, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(20)
                                                .addGroup(layoutRoundPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layoutRoundPanel1.createSequentialGroup()
                                                                .addComponent(cbxBrand, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(100, Short.MAX_VALUE))
                                                        .addGroup(layoutRoundPanel1.createSequentialGroup()
                                                                .addComponent(cbxRange, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(layoutRoundPanel1.createSequentialGroup()
                                                .addGroup(layoutRoundPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layoutRoundPanel1.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(txtEngineType, 250, 250, 250)
                                                                .addComponent(txtEngineCapacity, 250, 250, 250))
                                                        .addComponent(txtTransmisionType, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                                .addGap(20)
                                                .addGroup(layoutRoundPanel1.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(txtCompressionRatio, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                                        .addComponent(txtPetrolTank, GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtFuelConsumption, GroupLayout.Alignment.LEADING))
                                                .addGap(20)
                                                .addGroup(layoutRoundPanel1.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(spnManufacture, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                        .addComponent(spnMass)
                                                        .addComponent(txtImportPrice))
                                                .addGap(30)
                                                .addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(30)
                                                .addGroup(layoutRoundPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnErase)
                                                        .addComponent(btnAdd)
                                                        .addComponent(btnSave))
                                                .addGap(30))))
        );
        layoutRoundPanel1.setVerticalGroup(
                layoutRoundPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layoutRoundPanel1.createSequentialGroup()
                                .addGap(5)
                                .addGroup(layoutRoundPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layoutRoundPanel1.createSequentialGroup()
                                                .addGap(10)
                                                .addGroup(layoutRoundPanel1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(15)
                                                .addGroup(layoutRoundPanel1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtModel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtEntryDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(15)
                                                .addGroup(layoutRoundPanel1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtCylinderCapacity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(15)
                                                .addGroup(layoutRoundPanel1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtEngineCapacity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtFuelConsumption, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(15)
                                                .addGroup(layoutRoundPanel1.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtEngineType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtPetrolTank, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(15)
                                                .addGroup(layoutRoundPanel1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtIDNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtTransmisionType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtCompressionRatio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layoutRoundPanel1.createSequentialGroup()
                                                .addGap(15)
                                                .addComponent(lblImg, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnImg, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layoutRoundPanel1.createSequentialGroup()
                                                .addGap(40)
                                                .addComponent(cbxBrand, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(20)
                                                .addComponent(cbxRange, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(20)
                                                .addComponent(spnMass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(20)
                                                .addComponent(spnManufacture, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(20)
                                                .addComponent(txtImportPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(25))
                        .addGroup(GroupLayout.Alignment.TRAILING, layoutRoundPanel1.createSequentialGroup()
                                .addGap(20)
                                .addComponent(btnAdd)
                                .addGap(20)
                                .addComponent(btnErase)
                                .addGap(20)
                                .addComponent(btnSave)
                                .addGap(20))
                        .addGroup(GroupLayout.Alignment.TRAILING, layoutRoundPanel1.createSequentialGroup()
                                .addGap(15)
                                .addComponent(separator)
                                .addGap(15))
        );

        roundPanel2.setBackground(new Color(217, 243, 229, 255));
        roundPanel2.setRoundTopLeft(10);
        roundPanel2.setRoundTopRight(10);
        roundPanel2.setRoundBottomLeft(10);
        roundPanel2.setRoundBottomRight(10);
        GroupLayout roundPanel2Layout = new GroupLayout(this.roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(roundPanel2Layout.
                createParallelGroup(GroupLayout.Alignment.LEADING).
                addGroup(roundPanel2Layout.createSequentialGroup().
                        addContainerGap().
                        addComponent(scrlPane, -1, 928, 32767).
                        addContainerGap()));
        roundPanel2Layout.setVerticalGroup(roundPanel2Layout.
                createParallelGroup(GroupLayout.Alignment.LEADING).
                addGroup(roundPanel2Layout.
                        createSequentialGroup().
                        addContainerGap().
                        addComponent(scrlPane, -1, 278, 32767).
                        addContainerGap()));


        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).
                addComponent(this.roundPanel1, -1, -1, 32767).
                addComponent(this.roundPanel2, -1, -1, 32767));
        layout.setVerticalGroup(layout.
                createParallelGroup(GroupLayout.Alignment.LEADING).
                addGroup(layout.createSequentialGroup().
                        addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).
                        addComponent(this.roundPanel1, -2, -1, -2).
                        addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).
                        addComponent(this.roundPanel2, -1, -1, 32767)));
    }

    private void btnSaveActionListener(ActionEvent e) {
        String vehicleCode = txtCode.getText().trim();
        String vehicleName = txtName.getText().trim();
        String vehicleModel = txtModel.getText().trim();
        String vehicleIdNumber = txtIDNumber.getText().trim();
        String color = txtColor.getText().trim();
        String engineCapacity = txtEngineCapacity.getText().trim();
        String engineType = txtEngineType.getText().trim();
        String transmissionType = txtTransmisionType.getText().trim();
        double salePrice = Double.parseDouble(txtPrice.getText().trim());
        String cylinderCapacity = txtCylinderCapacity.getText().trim();
        String fuelConsumption = txtFuelConsumption.getText().trim();
        String petrolTank = txtPetrolTank.getText().trim();
        String compressionRatio = txtCompressionRatio.getText().trim();
        String brand = (String) cbxBrand.getSelectedItem();
        MotorcycleCompany mc = new MotorcycleCompany(brand);
        String range = (String) cbxRange.getSelectedItem();
        RangeOfVehicle rv = new RangeOfVehicle(range);
        int yearManufacture = (int) spnManufacture.getValue();
        Date eDate = date.getSelectedDate();
        Instant instant = eDate.toInstant();
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        LocalDate entryDate = zonedDateTime.toLocalDate();
        int mass = (int) spnMass.getValue();
        String inPrice = txtImportPrice.getText().trim();
        double importPrice = Double.parseDouble(inPrice);
        byte[] image = imageIn;

        v = new Vehicle(vehicleCode, image, mc, rv, vehicleName, vehicleModel, cylinderCapacity, engineCapacity, yearManufacture,
                salePrice, mass, petrolTank, compressionRatio, engineType, transmissionType, fuelConsumption, entryDate,
                vehicleIdNumber, color, importPrice);

        try {
            vehicleDao.updateVehicle(v, vehicleCode);
            if(vehicleDao.updateVehicle(v, vehicleCode))
            {
                JOptionPane.showMessageDialog(this, "Employee Updated Successfully!");
                table.removeAll();

            }
            else
            {
                txtCode.requestFocus();
            }
        }catch (SQLException e2) {
            e2.printStackTrace();
        }

    }

    private void btnEraseActionEvent(ActionEvent e) {
        eraseTextField();
    }

    private void btnAddActionEvent(ActionEvent e) {
        if(validData()) {
            try {
                String vehicleCode = txtCode.getText().trim();
                String vehicleName = txtName.getText().trim();
                String vehicleModel = txtModel.getText().trim();
                String vehicleIdNumber = txtIDNumber.getText().trim();
                String color = txtColor.getText().trim();
                String engineCapacity = txtEngineCapacity.getText().trim();
                String engineType = txtEngineType.getText().trim();
                String transmissionType = txtTransmisionType.getText().trim();
                double salePrice = Double.parseDouble(txtPrice.getText().trim());
                String cylinderCapacity = txtCylinderCapacity.getText().trim();
                String fuelConsumption = txtFuelConsumption.getText().trim();
                String petrolTank = txtPetrolTank.getText().trim();
                String compressionRatio = txtCompressionRatio.getText().trim();
                String brand = (String) cbxBrand.getSelectedItem();
                MotorcycleCompany mc = new MotorcycleCompany(brand);
                String range = (String) cbxRange.getSelectedItem();
                RangeOfVehicle rv = new RangeOfVehicle(range);
                int yearManufacture = (int) spnManufacture.getValue();
                Date eDate = date.getSelectedDate();
                Instant instant = eDate.toInstant();
                ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
                LocalDate entryDate = zonedDateTime.toLocalDate();
                int mass = (int) spnMass.getValue();
                String inPrice = txtImportPrice.getText().trim();
                double importPrice = Double.parseDouble(inPrice);
                byte[] image = imageIn;

                v = new Vehicle(vehicleCode, image, mc, rv, vehicleName, vehicleModel, cylinderCapacity, engineCapacity, yearManufacture,
                        salePrice, mass, petrolTank, compressionRatio, engineType, transmissionType, fuelConsumption, entryDate,
                        vehicleIdNumber, color, importPrice);
                vehicleDao.addVehicle(v);
                table.addRow(v.toRowTable(eventAction));
                eraseTextField();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }

        private void btnImgActionEvent (ActionEvent evt){
            JFileChooser fileChooser = new JFileChooser();
            System.setProperty("apple.awt.fileDialogForDirectories", "true");
            fileChooser.setCurrentDirectory(new File("/Users/duckzyyy/Documents/Lập Trình Hướng SK/Thực Hành/N4_QuanLyCuaHangXeMayTuNhan/src/source"));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("All Pic", "png", "jpeg", "jpg", "gif");
            fileChooser.addChoosableFileFilter(filter);

            int a = fileChooser.showSaveDialog(null);
            if (a == JFileChooser.APPROVE_OPTION) {

                File f = fileChooser.getSelectedFile();
                fileName = f.getAbsolutePath();

                ImageIcon imageIcon = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH));
                lblImg.setIcon(imageIcon);
                try {
                    File image = new File(fileName);
                    FileInputStream fis = new FileInputStream(image);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] buf = new byte[1024];
                    for(int readNum; (readNum = fis.read(buf))!= -1; ) {
                        bos.write(buf,0,readNum);
                    }
                    imageIn = bos.toByteArray();

                }catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1);
                }
            }

        }


        public void removeAllTableData () {
            table.removeAll();
        }
        public void eraseTextField () {
            txtCode.setText("");
            txtIDNumber.setText("");
            txtName.setText("");
            txtModel.setText("");
            txtColor.setText("");
            txtEngineCapacity.setText("");
            txtTransmisionType.setText("");
            txtEngineType.setText("");
            txtPrice.setText("");
            txtImportPrice.setText("");
            date.clearDate();
            txtCylinderCapacity.setText("");
            txtFuelConsumption.setText("");
            txtPetrolTank.setText("");
            txtCompressionRatio.setText("");
            spnMass.setValue(100);
            spnManufacture.setValue(2023);
        }
        private boolean FullInput ()
        {
            if (txtCode.getText() == "" || txtName.getText() == "" || txtIDNumber.getText() == ""
                    || txtModel.getText() == "" || txtColor.getText() == "" || txtPrice.getText() == "" || txtEngineCapacity.getText() == ""
                    || txtTransmisionType.getText() == "" || txtImportPrice.getText() == "" || txtCylinderCapacity.getText() == "" || txtFuelConsumption.getText() == ""
                    || spnMass.getValue() == null || spnMass.getValue() == null) {
                JOptionPane.showMessageDialog(this, "Please provide complete information!");
                return false;
            }
            return true;
        }


    @Override
    public void mouseClicked(MouseEvent e) {
        int row = table.getSelectedRow();
        txtCode.setText(table.getValueAt(row, 0).toString());
        txtName.setText(table.getValueAt(row, 1).toString());
        txtModel.setText(table.getValueAt(row, 4).toString());
        txtColor.setText((table.getValueAt(row, 5).toString()));
        listVehicle = vehicleDao.getVehicleByCode(table.getValueAt(row, 0).toString());
        Vehicle v = listVehicle.get(0);
        txtCompressionRatio.setText(v.getCompressionRatio().toString());
        txtPetrolTank.setText(v.getPetrolTankCapacity().toString());
        txtFuelConsumption.setText(v.getFuelConsumption().toString());
        txtCylinderCapacity.setText(v.getCylinderCapacity().toString());
        txtImportPrice.setText(String.valueOf(v.getImportPrice()));
        txtTransmisionType.setText(v.getTransmissionType().toString());
        txtEngineType.setText(v.getEngineType().toString());
        txtEngineCapacity.setText(v.getEngineCapacity());
        spnMass.setValue(v.getVehicleMass());
        spnManufacture.setValue(v.getYearManufacture());
//            ImageIcon image = new ImageIcon(v.getVehicleImage());
//            lblImg.setIcon(image);

        txtPrice.setText(table.getValueAt(row, 7).toString());
        cbxBrand.setSelectedItem(v.getVehicleCompany());
        cbxRange.setSelectedItem((v.getRangeOfVehicle()));
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    private boolean validData() {
        String vehicleCode = txtCode.getText().trim();
        if (!vehicleCode.matches("^V[A-Z]{3}[A-Za-z0-9]{3}$")) {
            JOptionPane.showMessageDialog(txtCode, "Invalid Vehicle Code.");
            return false;
        }
        String vehicleIdNumber = txtIDNumber.getText().trim();
        if (!vehicleIdNumber.matches("^[A-Z*]{17}$")) {
            JOptionPane.showMessageDialog(txtIDNumber, "Invalid Vehicle ID Number.");
            return false;
        }

        Double importPrice = Double.parseDouble(txtPrice.getText().trim());
        if (importPrice <= 100) {
            JOptionPane.showMessageDialog(txtPrice, "Import Price must > 100$");
            return false;
        }
        Double salePrice = Double.parseDouble(txtPrice.getText().trim());
        if (salePrice <= importPrice) {
            JOptionPane.showMessageDialog(txtPrice, "Sale price must > Import Price");
            return false;
        }
        return true;
    }


}
