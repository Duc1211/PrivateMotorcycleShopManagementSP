package ui.employee;

import entity.Department;
import entity.Employee;

import format.button.Button;
import format.button.ButtonLogin;
import format.panel.PanelRound;
import format.table.Table;
import format.textfield.SearchText;
import model.NameModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import com.toedter.calendar.JDateChooser;
import connect.ConnectDB;
import dao.DepartmentDao;
import dao.EmployeeDao;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;



public class FormEmployee extends JPanel implements ActionListener, MouseListener, KeyListener {

    private static final long serialVersionUID = 1L;

    private PanelRound roundPanel1;
    private PanelRound roundPanel2;
    private PanelRound roundPanel0;
    private PanelRound roundPanel3;
    private SearchText searchText;

    private String fileName = null;
    private byte[] person_image = null;

    private JScrollPane jScrollPane1;
    private Table tableEmployee;

    private JTextField txtEmployeeId;
    private JTextField txtCitizenNumber;
    private JTextField txtEmployeeName;
    private JTextField txtEmployeeLocation;
    private JTextField txtSalary;
    private JTextField txtPhone;

    private JCheckBox chkSex;

    private JComboBox<String> cboPosition;
    private JComboBox<String> cboFind;

    private JButton btnUpdateee;
    private JButton btnDelete;
    private JButton btnDeleteField;
    private JButton btnAddd;
    private JButton btnFind;

    private JButton btnUpdate;
    private Button btnEdit;
    private ButtonLogin btnImg;

    private EmployeeDao employeeDAO;
    private DepartmentDao departmentDAO;
    private DefaultTableModel tableEmployeeModel;
    private JDateChooser birthdayy ;
    private JDateChooser dateStart;

    private JLabel imageAvatars;



    public FormEmployee(){
        init();

        try {
            ConnectDB.getInstance().connectDataBase();
            System.out.println("Success To Connect Employee Form!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        employeeDAO = new EmployeeDao();
        departmentDAO = new DepartmentDao();

        initComponent();
        tableEmployee.fixTable(jScrollPane1);
        importSQLDataToTable();

        //event
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnDeleteField.addActionListener(this);
        btnFind.addActionListener(this);
        btnAddd.addActionListener(this);
        btnImg.addActionListener(this);
        tableEmployee.addMouseListener(this);
        searchText.addKeyListener(this);
    }

    private void initComponent() {
        roundPanel1 = new PanelRound();

        roundPanel0 = new PanelRound();

        searchText = new SearchText();

        roundPanel2 = new PanelRound();

        imageAvatars = new JLabel();
        imageAvatars.setIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/avatar/avtnu.png")));

        btnImg = new ButtonLogin();
        btnImg.setText("Change Avatar");
        btnImg.setBackground(new Color(110,191,55));

        roundPanel3 = new PanelRound();
        roundPanel3.setBackground(new Color(250, 250, 250));
        roundPanel3.setRoundTopLeft(10);
        roundPanel3.setRoundTopRight(10);
        roundPanel3.setRoundBottomLeft(10);
        roundPanel3.setRoundBottomRight(10);
        roundPanel3.add(imageAvatars);
        roundPanel3.add(btnImg);

        GroupLayout layout1 = new GroupLayout(roundPanel3);
        roundPanel3.setLayout(layout1);
        layout1.setHorizontalGroup(layout1.createParallelGroup(GroupLayout.Alignment.CENTER).
                addGroup(layout1.createSequentialGroup().
                        addComponent(imageAvatars, 20, 50, 100).
                        addGap(25).
                        addComponent(btnImg, -2, 120, 150)));
        layout1.setVerticalGroup(layout1.
                createParallelGroup(GroupLayout.Alignment.LEADING).
                addGroup(layout1.createParallelGroup().
                        addComponent(imageAvatars, 20, 50, 100).
                        addGroup(layout1.createSequentialGroup().
                                addGap(25).
                                addComponent(btnImg, -2 ,20 , 30))
                ));


        roundPanel0.setBackground(new Color(250, 250, 250));
        roundPanel0.setRoundTopLeft(10);
        roundPanel0.setRoundTopRight(10);
        roundPanel0.setRoundBottomLeft(10);
        roundPanel0.setRoundBottomRight(10);

        btnEdit = new Button();
        btnEdit.setIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/edit.png")));
        btnEdit.setBackground(new Color(110,191,55));
        searchText.setPreferredSize(new Dimension(200, 30));

        roundPanel0.add(btnEdit);
        roundPanel0.add(searchText, BorderLayout.CENTER);
        roundPanel0.add(cboFind = new JComboBox<String>());

        //cboFind.setEditable(true);
        cboFind.setBackground(new Color(110,191,55));
        cboFind.addItem("Name");
        cboFind.addItem("Code");
        cboFind.addItem("Phone");

        roundPanel1.setBackground(new Color(250, 250, 250));
        roundPanel1.setRoundTopLeft(10);
        roundPanel1.setRoundTopRight(10);
        roundPanel1.setRoundBottomLeft(10);
        roundPanel1.setRoundBottomRight(10);

        Box b = Box.createVerticalBox();

        Box b5, b1, b2, b3, b4, b6;
        b.add(Box.createVerticalStrut(10));
        b.add(b1 = Box.createHorizontalBox());
        b.add(Box.createVerticalStrut(10));
        JLabel lblEmployeeId;
        b1.add(lblEmployeeId = new JLabel("Employee Id: "));
        b1.add(txtEmployeeId = new JTextField());
        JLabel lblCitizenNumber;
        b1.add(lblCitizenNumber = new JLabel("Citizen Number: "));
        b1.add(txtCitizenNumber = new JTextField());

        b.add(b2 = Box.createHorizontalBox());
        b.add(Box.createVerticalStrut(10));
        JLabel lblEmployeeName;
        b2.add(lblEmployeeName = new JLabel("Name: "));
        b2.add(txtEmployeeName = new JTextField());
        birthdayy  = new JDateChooser();
        JLabel lblBirthDay;
        b2.add(lblBirthDay = new JLabel("Birthday: "));
        b2.add(birthdayy );

        b.add(b3 = Box.createHorizontalBox());
        b.add(Box.createVerticalStrut(10));
        JLabel lblEmployeeLocation;
        b3.add(lblEmployeeLocation = new JLabel("Location: "));
        b3.add(txtEmployeeLocation = new JTextField());
        JLabel lblSex;
        b3.add(lblSex = new JLabel("Sex: "));
        b3.add(chkSex = new JCheckBox("Female"));

        b.add(b4 = Box.createHorizontalBox());
        b.add(Box.createVerticalStrut(10));
        JLabel lblPhone;
        b4.add(lblPhone = new JLabel("Phone: "));
        b4.add(txtPhone = new JTextField());
        JLabel lblPosition;
        b4.add(lblPosition = new JLabel("Position: "));

        //Tạo và đổ dữ liệu vào comboBox
        b4.add(cboPosition = new JComboBox<String>());
        //cboPosition.setEditable(true);
        cboPosition.setBackground(new Color(110,191,55));

        ArrayList<Department> listDepartment = departmentDAO.getAllTbDepartment();
        for (Department d : listDepartment) {
            cboPosition.addItem(d.getDepartmentID());
        }

        b.add(b6 = Box.createHorizontalBox());
        b.add(Box.createVerticalStrut(10));
        JLabel lblSalaray;
        b6.add(lblSalaray = new JLabel("Salary: "));
        b6.add(txtSalary = new JTextField());
        JLabel lblDateStart;
        b6.add(lblDateStart = new JLabel("Date Start: "));
        dateStart = new JDateChooser();
        b6.add(dateStart);

        b.add(b5 = Box.createHorizontalBox());
        b.add(Box.createVerticalStrut(15));
        b5.add(btnUpdate = new JButton("Update"));
        btnUpdate.setBackground(new Color(110,191,55));
        b5.add(Box.createHorizontalStrut(15));
        b5.add(btnDelete = new JButton("Delete"));
        btnDelete.setBackground(new Color(110,191,55));
        b5.add(Box.createHorizontalStrut(15));
        b5.add(btnDeleteField = new JButton("Reset"));
        btnDeleteField.setBackground(new Color(110,191,55));
        b5.add(Box.createHorizontalStrut(15));
        b5.add(btnAddd = new JButton("Add"));
        btnAddd.setBackground(new Color(110,191,55));
        b5.add(Box.createHorizontalStrut(15));
        b5.add(btnFind = new JButton("Find"));
        btnFind.setBackground(new Color(110,191,55));


        lblEmployeeName.setPreferredSize(lblEmployeeId.getPreferredSize());
        lblEmployeeLocation.setPreferredSize(lblEmployeeId.getPreferredSize());
        lblPhone.setPreferredSize(lblEmployeeId.getPreferredSize());
        lblSalaray.setPreferredSize(lblEmployeeId.getPreferredSize());

        roundPanel1.setLayout(new GridBagLayout());

        // Tạo một đối tượng GridBagConstraints để cấu hình các thuộc tính căn chỉnh và kích thước của thành phần
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH; // Thành phần sẽ được mở rộng cả theo chiều ngang và chiều dọc
        constraints.weightx = 1.0; // Thành phần sẽ được co dãn theo chiều ngang
        constraints.weighty = 1.0; // Thành phần sẽ được co dãn theo chiều dọc

        roundPanel1.add(b, constraints);


        roundPanel2.setBackground(new Color(250, 250, 250));
        roundPanel2.setRoundTopLeft(10);
        roundPanel2.setRoundTopRight(10);
        roundPanel2.setRoundBottomLeft(10);
        roundPanel2.setRoundBottomRight(10);

        GroupLayout roundPanel2Layout = new GroupLayout(this.roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);

        jScrollPane1 = new JScrollPane();
        tableEmployee = new Table();
        btnUpdateee = new Button();
        roundPanel2.setBackground(new Color(250, 250, 250));
        tableEmployee.setModel( tableEmployeeModel = new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Code", "Name", "Citizent Number", "Birthday", "Sex", "Location",
                        "Phone Number", "Position", "Salary", "Date Start", "Status", "Action"
                }
        ));
        jScrollPane1.setViewportView(tableEmployee);

        //chỉnhh tiêu đề bảng: CHỈNH MÀU
        JTableHeader tableHeader = tableEmployee.getTableHeader();
        tableHeader.setDefaultRenderer( new DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                java.awt.Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                component.setBackground(new Color(110,191,55));
                component.setForeground(Color.WHITE);
                return component;
            }
        });

        if (tableEmployee.getColumnModel().getColumnCount() > 0) {
            tableEmployee.getColumnModel().getColumn(0).setMinWidth(50);
            tableEmployee.getColumnModel().getColumn(1).setPreferredWidth(150);
            tableEmployee.getColumnModel().getColumn(2).setMinWidth(100);
            tableEmployee.getColumnModel().getColumn(3).setPreferredWidth(75);
            tableEmployee.getColumnModel().getColumn(4).setPreferredWidth(45);
            tableEmployee.getColumnModel().getColumn(5).setMinWidth(75);
            tableEmployee.getColumnModel().getColumn(5).setPreferredWidth(75);
            tableEmployee.getColumnModel().getColumn(5).setMaxWidth(75);
            tableEmployee.getColumnModel().getColumn(6).setMinWidth(75);
            tableEmployee.getColumnModel().getColumn(7).setMinWidth(100);
            tableEmployee.getColumnModel().getColumn(8).setMinWidth(50);
            tableEmployee.getColumnModel().getColumn(9).setMinWidth(50);
            tableEmployee.getColumnModel().getColumn(10).setMinWidth(50);
            tableEmployee.getColumnModel().getColumn(11).setMinWidth(75);
            tableEmployee.getColumnModel().getColumn(11).setPreferredWidth(75);
            tableEmployee.getColumnModel().getColumn(11).setMaxWidth(75);

        }

        roundPanel2Layout.setHorizontalGroup(roundPanel2Layout.
                createParallelGroup(GroupLayout.Alignment.LEADING).
                addGroup(roundPanel2Layout.createSequentialGroup().
                        addContainerGap().addGroup(roundPanel2Layout.
                                createParallelGroup(GroupLayout.Alignment.LEADING).
                                addComponent(jScrollPane1).
                                addGroup(roundPanel2Layout.
                                        createSequentialGroup().
                                        addComponent(btnUpdateee, -2, -1, -2).
                                        addGap(0, 0, 32767))).
                        addContainerGap()));
        roundPanel2Layout.setVerticalGroup(roundPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).
                addGroup(GroupLayout.Alignment.TRAILING, roundPanel2Layout.
                        createSequentialGroup().
                        addContainerGap().
                        addComponent(btnUpdateee, -2, -1, -2).
                        addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).
                        addComponent(jScrollPane1, -1, 266, 32767).
                        addContainerGap()));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).
                addComponent(roundPanel3,-1,-1,32767).
                addComponent(roundPanel0,-1,-1,32767).
                addComponent(this.roundPanel1, -1, -1, 32767).
                addComponent(this.roundPanel2, -1, -1, 32767));
        layout.setVerticalGroup(layout.
                createParallelGroup(GroupLayout.Alignment.LEADING).
                addGroup(layout.createSequentialGroup().
                        addComponent(roundPanel3,-1,-2,32767).
                        addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).
                        addComponent(roundPanel0,-1,-1,-2).
                        addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).
                        addComponent(this.roundPanel1, -2, -1, -2).
                        addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).
                        addComponent(this.roundPanel2, -1, -1, 32767)));

    }

    public void importSQLDataToTable() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        List<Employee> list = employeeDAO.getAllTableEmployee();
        for (Employee e : list) {
            double salary = e.getSalary();
            String formattedSalary = decimalFormat.format(salary);
            tableEmployeeModel.addRow(new Object[] {e.getEmployeeCode(),e.getEmployeeName(),e.getCitizenIdNumber()
                    ,e.getEmployeeBirthday(),e.isEmployeeSex()==false?"Female":"Male", e.getEmployeeLocation(),e.getEmployeePhoneNumber(),
                    e.getEmployeePosition(),formattedSalary ,e.getDateStart()});
            System.out.println("Imported Employee Data!");
        }
    }
    public void removeAllTableData() {
        DefaultTableModel dm = (DefaultTableModel) tableEmployee.getModel();
        dm.getDataVector().removeAllElements();
    }
    private void init() {

    }
//    public ImageIcon setIcon(String m, byte[] image){
//        if(m != null){
//            imageIcon = new ImageIcon();
//        }else{
//            imageIcon = new ImageIcon(image);
//        }
//        Image img1 = imageIcon.getImage();
//        Image img2 = img1.getScaledInstance(imgAvatar.getWidth(), imgAvatar.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon i = new ImageIcon(img2);
//        return i;
//    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int row = tableEmployee.getSelectedRow();
        txtEmployeeId.setText(tableEmployeeModel.getValueAt(row, 0).toString());
        txtEmployeeName.setText(tableEmployeeModel.getValueAt(row, 1).toString());
        txtCitizenNumber.setText(tableEmployeeModel.getValueAt(row, 2).toString());

        // Lấy giá trị từ ô cột "birthday" trong bảng
        Date d1,d2;
        try {
            d1 = new SimpleDateFormat("yyyy-MM-dd").parse(tableEmployeeModel.getValueAt(row, 3).toString());
            birthdayy.setDate(d1);

        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        //checkbox
        chkSex.setSelected(tableEmployeeModel.getValueAt(row, 4).toString()=="Female"?true:false);
        txtEmployeeLocation.setText(tableEmployeeModel.getValueAt(row, 5).toString());
        txtPhone.setText(tableEmployeeModel.getValueAt(row, 6).toString());
        //combobox
        cboPosition.setSelectedItem(tableEmployeeModel.getValueAt(row, 7).toString());
        txtSalary.setText(tableEmployee.getValueAt(row, 8).toString());

        try {
            d2 = new SimpleDateFormat("yyyy-MM-dd").parse(tableEmployeeModel.getValueAt(row, 9).toString());
            dateStart.setDate(d2);

        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object o = e.getSource();
        if( o.equals(btnUpdate))
        {
            FullInput();
            String code = txtEmployeeId.getText().trim();
            String citizenNumber= txtCitizenNumber.getText().trim();

            String employeeName = txtEmployeeName.getText().trim();
            NameModel nameModel = new NameModel(employeeName);

            Date birthDay = birthdayy.getDate();
            Instant instant = birthDay.toInstant();
            ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
            LocalDate birthday = zonedDateTime.toLocalDate();

            String location = txtEmployeeLocation.getText().trim();
            boolean sex = chkSex.isSelected();
            String phone = txtPhone.getText().trim();
            String position = (String)cboPosition.getSelectedItem();
            double salary = Double.parseDouble(txtSalary.getText().trim());

            Date start = dateStart.getDate();
            Instant instant2 = start.toInstant();
            ZonedDateTime zonedDateTime2 = instant2.atZone(ZoneId.systemDefault());
            LocalDate dayStart = zonedDateTime2.toLocalDate();

            byte[] image = person_image;


            Employee em = new Employee(code, nameModel, citizenNumber, birthday, sex, location, phone, position, salary, dayStart, image);
            int r = tableEmployee.getSelectedRow();

            try {
                employeeDAO.updateEmployee(em, code);
                if(employeeDAO.updateEmployee(em, code))
                {
                    JOptionPane.showMessageDialog(this, "Employee Updated Successfully!");
                    removeAllTableData();
                    importSQLDataToTable();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Employee Code doessn't match any Employee in Database");
                    txtEmployeeId.requestFocus();
                    txtEmployeeId.selectAll();
                }
            }catch (SQLException e2) {
                e2.printStackTrace();
            }
        }

        else if(o.equals(btnDeleteField))
        {
            txtEmployeeName.setText("");
            txtCitizenNumber.setText("");
            txtSalary.setText("");
            txtEmployeeId.setText("");
            txtEmployeeLocation.setText("");
            txtPhone.setText("");
            chkSex.setSelected(false);
            cboPosition.setSelectedIndex(0);
            birthdayy.setDate(null);
            dateStart.setDate(null);
            txtEmployeeId.requestFocus();
            txtEmployeeId.selectAll();
            imageAvatars.setIcon(null);
        }
        else if( o.equals(btnDelete))
        {
            int r = tableEmployee.getSelectedRow();
            String code = (String) tableEmployee.getValueAt(r, 0);
            tableEmployeeModel.removeRow(r);
            JOptionPane.showMessageDialog(this, "Delete Employee On Table Success!");
            Employee em = new Employee(code);
            try {
                employeeDAO.removeEmployee(em);
                System.out.println("Removed Successfully In Database!");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
        else if(o.equals(btnFind))
        {
            DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
            String filter = cboFind.getSelectedItem().toString();
            if(filter.equalsIgnoreCase("Code"))
            {
                String code = searchText.getText();
                ArrayList<Employee> listEm = employeeDAO.getEmployeeByID(code);
                if((! listEm.isEmpty()))
                {
                    removeAllTableData();
                    JOptionPane.showMessageDialog(searchText, "Find By Code Successfully!");

                }
                else {
                    JOptionPane.showMessageDialog(searchText, "Cant Find Any Employee With This ID In Database.");

                }
                for(Employee em: listEm)
                {
                    double salary = em.getSalary();
                    String formattedSalary = decimalFormat.format(salary);
                    tableEmployeeModel.addRow(new Object[] {
                            em.getEmployeeCode(),em.getEmployeeName(),em.getCitizenIdNumber()
                            ,em.getEmployeeBirthday(),em.isEmployeeSex()==false?"Female":"Male", em.getEmployeeLocation(),em.getEmployeePhoneNumber(),
                            em.getEmployeePosition(),formattedSalary,em.getDateStart()
                    });
                    ImageIcon imageIcon = new ImageIcon(em.getImage());
                    // Thay đổi kích thước của hình ảnh để phù hợp với kích thước của JLabel (lbl_img là JLabel hiển thị hình ảnh)
                    Image image = imageIcon.getImage().getScaledInstance(imageAvatars.getWidth(), imageAvatars.getHeight(), Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(image);

                    imageAvatars.setIcon(imageIcon);
                }
            }
            else if( filter.equalsIgnoreCase("Name"))
            {
                String name = searchText.getText();
                ArrayList<Employee> listEm = employeeDAO.getEmployeeByName(name);
                if((listEm.isEmpty()))
                {
                    JOptionPane.showMessageDialog(searchText, "Cant Find Any Employee With This Name In Database.");

                }
                else
                {
                    removeAllTableData();
                    JOptionPane.showMessageDialog(searchText, "Find By Name Successfully!");

                }
                for(Employee em: listEm)
                {
                    double salary = em.getSalary();
                    String formattedSalary = decimalFormat.format(salary);
                    tableEmployeeModel.addRow(new Object[] {
                            em.getEmployeeCode(),em.getEmployeeName(),em.getCitizenIdNumber()
                            ,em.getEmployeeBirthday(),em.isEmployeeSex()==false?"Female":"Male", em.getEmployeeLocation(),em.getEmployeePhoneNumber(),
                            em.getEmployeePosition(),formattedSalary,em.getDateStart()
                    });
                    ImageIcon imageIcon = new ImageIcon(em.getImage());
                    // Thay đổi kích thước của hình ảnh để phù hợp với kích thước của JLabel (lbl_img là JLabel hiển thị hình ảnh)
                    Image image = imageIcon.getImage().getScaledInstance(imageAvatars.getWidth(), imageAvatars.getHeight(), Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(image);

                    imageAvatars.setIcon(imageIcon);
                }
            }
            else if( filter.equalsIgnoreCase("Phone"))
            {
                String phone = searchText.getText();
                ArrayList<Employee> listEm = employeeDAO.getEmployeeByPhone(phone);
                if((! listEm.isEmpty()))
                {
                    removeAllTableData();
                    JOptionPane.showMessageDialog(searchText, "Find By Phone Successfully!");

                }
                else {
                    JOptionPane.showMessageDialog(searchText, "Cant Find Any Employee With This Phone In Database.");

                }
                for(Employee em: listEm)
                {
                    double salary = em.getSalary();
                    String formattedSalary = decimalFormat.format(salary);
                    tableEmployeeModel.addRow(new Object[] {
                            em.getEmployeeCode(),em.getEmployeeName(),em.getCitizenIdNumber()
                            ,em.getEmployeeBirthday(),em.isEmployeeSex()==false?"Female":"Male", em.getEmployeeLocation(),em.getEmployeePhoneNumber(),
                            em.getEmployeePosition(),formattedSalary,em.getDateStart()
                    });
                    ImageIcon imageIcon = new ImageIcon(em.getImage());
                    // Thay đổi kích thước của hình ảnh để phù hợp với kích thước của JLabel (lbl_img là JLabel hiển thị hình ảnh)
                    Image image = imageIcon.getImage().getScaledInstance(imageAvatars.getWidth(), imageAvatars.getHeight(), Image.SCALE_SMOOTH);
                    imageIcon = new ImageIcon(image);

                    imageAvatars.setIcon(imageIcon);
                }
            }

        }
        else if(o.equals(btnAddd))
        {
            System.out.println(person_image);
            if(! FullInput())
                return;
            else
            if(validData())
            {
                FullInput();
                String employeeCode = txtEmployeeId.getText().trim();

                ArrayList<Employee> listE = null;
                listE = employeeDAO.getEmployeeByID(employeeCode);

                String citizenNumber= txtCitizenNumber.getText().trim();

                String employeeName = txtEmployeeName.getText().trim();
                NameModel nameModel = new NameModel(employeeName);

                Date birthDay = birthdayy.getDate();
                Instant instant = birthDay.toInstant();
                ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
                LocalDate birthday = zonedDateTime.toLocalDate();

                String location = txtEmployeeLocation.getText().trim();
                boolean sex = chkSex.isSelected();
                String phone = txtPhone.getText().trim();
                String position = (String)cboPosition.getSelectedItem();
                double salary = Double.parseDouble(txtSalary.getText().trim());

                Date start = dateStart.getDate();
                Instant instant2 = start.toInstant();
                ZonedDateTime zonedDateTime2 = instant2.atZone(ZoneId.systemDefault());
                LocalDate dayStart = zonedDateTime2.toLocalDate();
                // Lấy hình ảnh từ JLabel "imageAvatars"

                byte[] image = person_image;

                Employee em = new Employee(employeeCode, nameModel, citizenNumber, birthday, sex, location, phone, position, salary, dayStart, image);
                if(listE.isEmpty())
                {
                    try {
                        employeeDAO.createEmployee(em);
                        JOptionPane.showMessageDialog(this, "Create Employee Successfully!");
                        tableEmployeeModel.addRow(new Object[] {em.getEmployeeCode(),em.getEmployeeName(),em.getCitizenIdNumber()
                                ,em.getEmployeeBirthday(),em.isEmployeeSex()==false?"Female":"Male", em.getEmployeeLocation(),em.getEmployeePhoneNumber(),
                                em.getEmployeePosition(),em.getSalary(),em.getDateStart(),em.getImage()});
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(this, "Employee Existed!");
                }
            }

        }
        else if( o.equals(btnImg))
        {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            fileName = f.getAbsolutePath();
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(imageAvatars.getWidth(), imageAvatars.getHeight(), Image.SCALE_SMOOTH));
            imageAvatars.setIcon(imageIcon);
            try {
                File imaage = new File(fileName);
                FileInputStream fis = new FileInputStream(imaage);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for(int readNum; (readNum = fis.read(buf))!= -1; ) {
                    bos.write(buf,0,readNum);
                }
                person_image=bos.toByteArray();

            }catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1);
            }
        }

    }
    private boolean FullInput()
    {
        if(txtEmployeeId.getText()=="" || txtCitizenNumber.getText()=="" || txtEmployeeLocation.getText()==""
                || txtEmployeeName.getText()=="" || txtPhone.getText()=="" || txtSalary.getText() == ""	||
                birthdayy.getDate() == null || dateStart.getDate() == null)
        {
            JOptionPane.showMessageDialog(this, "Please provide complete information!");
            return false;
        }
        return true;
    }
    private boolean validData()
    {
        // Kiểm tra biểu thức chính quy cho từng trường cụ thể
        String employeeId = txtEmployeeId.getText().trim();
        if (!employeeId.matches("^(MA|SA|TE)\\d{3,5}$")) {
            JOptionPane.showMessageDialog(txtEmployeeId, "Invalid ID.");
            return false;
        }
        String citizenNumber = txtCitizenNumber.getText().trim();
        if (!citizenNumber.matches("\\d{12}")) {
            JOptionPane.showMessageDialog(txtCitizenNumber, "Invalid Citizen Number.");
            return false;
        }
        Calendar birth = birthdayy.getCalendar();
        if (birth != null) {
            int birthYear = birth.get(Calendar.YEAR);

            if (birthYear > 2005) {
                JOptionPane.showMessageDialog(birthdayy, "Invalid Year < 18 .");
                return false;
            }
        }
        String phone = txtPhone.getText().trim();
        if (!phone.matches("^(09|08)\\d{8}$")) {
            JOptionPane.showMessageDialog(txtPhone, "Invalid Phone Number.");
            return false;
        }
        Double salary = Double.parseDouble(txtSalary.getText().trim());
        if( salary <= 1000000)
        {
            JOptionPane.showMessageDialog(txtSalary, "Salary must > 1.000.000.");
            return false;
        }
        Date dateStartt = dateStart.getDate();
        Date currentDate = new Date();
        if(dateStartt.compareTo(currentDate) > 0)
        {
            JOptionPane.showMessageDialog(dateStart, "dateStart cant be greater than currentDate");
            return false;
        }
        return true;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        Object o = e.getSource();
        if(o.equals(searchText)){
            String keyFind = searchText.getText();
            DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
            String filter = cboFind.getSelectedItem().toString();
            if(filter.equalsIgnoreCase("Code"))
            {
                String code = searchText.getText();
                ArrayList<Employee> listEm = employeeDAO.getEmployeeByID(code);
                if((! listEm.isEmpty()))
                {
                    removeAllTableData();
//					JOptionPane.showMessageDialog(txtFind, "Find By Code Successfully!");

                }
                else {
//					JOptionPane.showMessageDialog(txtFind, "Cant Find Any Employee With This ID In Database.");

                }
                for(Employee em: listEm)
                {
                    double salary = em.getSalary();
                    String formattedSalary = decimalFormat.format(salary);
                    tableEmployeeModel.addRow(new Object[] {
                            em.getEmployeeCode(),em.getEmployeeName(),em.getCitizenIdNumber()
                            ,em.getEmployeeBirthday(),em.isEmployeeSex()==false?"Female":"Male", em.getEmployeeLocation(),em.getEmployeePhoneNumber(),
                            em.getEmployeePosition(),formattedSalary,em.getDateStart()
                    });
                }
            }
            else if( filter.equalsIgnoreCase("Name"))
            {
                String name = searchText.getText();
                ArrayList<Employee> listEm = employeeDAO.getEmployeeByName(name);
                if((listEm.isEmpty()))
                {
//					JOptionPane.showMessageDialog(txtFind, "Cant Find Any Employee With This Name In Database.");

                }
                else
                {
                    removeAllTableData();
//					JOptionPane.showMessageDialog(txtFind, "Find By Name Successfully!");

                }
                for(Employee em: listEm)
                {
                    double salary = em.getSalary();
                    String formattedSalary = decimalFormat.format(salary);
                    tableEmployeeModel.addRow(new Object[] {
                            em.getEmployeeCode(),em.getEmployeeName(),em.getCitizenIdNumber()
                            ,em.getEmployeeBirthday(),em.isEmployeeSex()==false?"Female":"Male", em.getEmployeeLocation(),em.getEmployeePhoneNumber(),
                            em.getEmployeePosition(),formattedSalary,em.getDateStart()
                    });
                }
            }
            else if( filter.equalsIgnoreCase("Phone"))
            {
                String phone = searchText.getText();
                ArrayList<Employee> listEm = employeeDAO.getEmployeeByPhone(phone);
                if((! listEm.isEmpty()))
                {
                    removeAllTableData();
//					JOptionPane.showMessageDialog(txtFind, "Find By Phone Successfully!");

                }
                else {
//					JOptionPane.showMessageDialog(txtFind, "Cant Find Any Employee With This Phone In Database.");

                }
                for(Employee em: listEm)
                {
                    double salary = em.getSalary();
                    String formattedSalary = decimalFormat.format(salary);
                    tableEmployeeModel.addRow(new Object[] {
                            em.getEmployeeCode(),em.getEmployeeName(),em.getCitizenIdNumber()
                            ,em.getEmployeeBirthday(),em.isEmployeeSex()==false?"Female":"Male", em.getEmployeeLocation(),em.getEmployeePhoneNumber(),
                            em.getEmployeePosition(),formattedSalary,em.getDateStart()
                    });
                }
            }
        }


    }

}
