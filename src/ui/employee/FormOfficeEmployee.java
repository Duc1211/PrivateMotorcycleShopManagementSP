package ui.employee;


import format.textfield.*;
import format.button.Button;
import format.panel.PanelRound;
import format.table.Table;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import connect.ConnectDB;
import dao.DepartmentDao;
import dao.EmployeeDao;
import entity.Employee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FormOfficeEmployee extends PanelRound implements ActionListener, KeyListener {


    private PanelRound roundPanel1;
    private PanelRound roundPanel2;
    private JButton btnDelete;
    private JButton btnFind;
    private JScrollPane jScrollPane1;
    private Table table1Employee;
    private Button btnAdd;

    private EmployeeDao employeeDAO;
    private DepartmentDao departmentDAO;
    private DefaultTableModel tableEmployeeModel;
    private SearchText txtFind;
    private JComboBox<String> cboFind;

    public FormOfficeEmployee() {

        initComponents();
        setOpaque(false);

        try {
            ConnectDB.getInstance().connectDataBase();
            System.out.println("Success To Connect FormOfficeEmployee Form!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        employeeDAO = new EmployeeDao();
        departmentDAO = new DepartmentDao();

        importSQLDataToTable();

        btnDelete.addActionListener(this);
        btnFind.addActionListener(this);
        txtFind.addKeyListener(this);
    }

    private void importSQLDataToTable() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        List<Employee> list= employeeDAO.getAllTableEmployee();
        for (Employee e : list) {
            double salary = e.getSalary();
            String formattedSalary = decimalFormat.format(salary);
            String employeeCode = e.getEmployeeCode();
            if (employeeCode.startsWith("SA") || employeeCode.startsWith("MA")) { // Chỉ thêm vào bảng nếu mã nhân viên bắt đầu với "NV"
                tableEmployeeModel.addRow(new Object[] {e.getEmployeeCode(),e.getEmployeeName(),e.getCitizenIdNumber()
                        ,e.getEmployeeBirthday(),e.isEmployeeSex()==false?"Female":"Male", e.getEmployeeLocation(),e.getEmployeePhoneNumber(),
                        e.getEmployeePosition(),formattedSalary,e.getDateStart()});
                System.out.println("Imported Employee Data!");
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        roundPanel1 = new PanelRound();


        roundPanel2 = new PanelRound();

        roundPanel1.setBackground(new Color(250, 250, 250));
        roundPanel1.setRoundTopLeft(10);
        roundPanel1.setRoundTopRight(10);
        roundPanel1.setRoundBottomLeft(10);
        roundPanel1.setRoundBottomRight(10);
        GroupLayout roundPanel1Layout = new GroupLayout(this.roundPanel1);


        Box b = Box.createVerticalBox();

        Box b6,b5;
        b.add(b5 = Box.createHorizontalBox());
        b5.add(txtFind = new SearchText());
        txtFind.setPreferredSize(new Dimension(50, 30));
        txtFind.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        b5.add(cboFind = new JComboBox<String>());
        //cboFind.setEditable(true);
        cboFind.setBackground(new Color(110,191,55));
        cboFind.addItem("Name");
        cboFind.addItem("Code");
        cboFind.addItem("Phone");

        b.add(b6 = Box.createHorizontalBox());
        b6.add(Box.createHorizontalStrut(15));
        b6.add(btnFind = new JButton("Find"));
        btnFind.setBackground(new Color(110,191,55));
        b6.add(Box.createHorizontalStrut(25));
        b6.add(btnDelete = new JButton("Delete"));
        btnDelete.setBackground(new Color(110,191,55));


        add(b, BorderLayout.NORTH);

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
        table1Employee = new Table();
        btnAdd = new Button();
        roundPanel2.setBackground(new Color(250, 250, 250));
        table1Employee.setModel(tableEmployeeModel = new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Code", "Name", "Citizent Number", "Birthday", "Sex", "Location",
                        "Phone Number", "Position", "Salary", "Date Start", "Status", "Action"
                }
        ));
        jScrollPane1.setViewportView(table1Employee);

        //chỉnhh tiêu đề bảng: CHỈNH MÀU
        JTableHeader tableHeader = table1Employee.getTableHeader();
        tableHeader.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                java.awt.Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                component.setBackground(new Color(110,191,55));
                component.setForeground(Color.WHITE);
                return component;
            }
        });

        if (table1Employee.getColumnModel().getColumnCount() > 0) {
            table1Employee.getColumnModel().getColumn(0).setMinWidth(75);
            table1Employee.getColumnModel().getColumn(1).setPreferredWidth(200);
            table1Employee.getColumnModel().getColumn(2).setMinWidth(75);
            table1Employee.getColumnModel().getColumn(3).setPreferredWidth(50);
            table1Employee.getColumnModel().getColumn(4).setPreferredWidth(30);
            table1Employee.getColumnModel().getColumn(5).setMinWidth(75);
            table1Employee.getColumnModel().getColumn(5).setPreferredWidth(75);
            table1Employee.getColumnModel().getColumn(5).setMaxWidth(75);
            table1Employee.getColumnModel().getColumn(6).setMinWidth(75);
            table1Employee.getColumnModel().getColumn(7).setMinWidth(100);
            table1Employee.getColumnModel().getColumn(8).setMinWidth(50);
            table1Employee.getColumnModel().getColumn(9).setMinWidth(50);
            table1Employee.getColumnModel().getColumn(10).setMinWidth(50);
            table1Employee.getColumnModel().getColumn(11).setMinWidth(75);
            table1Employee.getColumnModel().getColumn(11).setPreferredWidth(75);
            table1Employee.getColumnModel().getColumn(11).setMaxWidth(75);

        }
        roundPanel2Layout.setHorizontalGroup(roundPanel2Layout.
                createParallelGroup(GroupLayout.Alignment.LEADING).
                addGroup(roundPanel2Layout.createSequentialGroup().
                        addContainerGap().addGroup(roundPanel2Layout.
                                createParallelGroup(GroupLayout.Alignment.LEADING).
                                addComponent(jScrollPane1).
                                addGroup(roundPanel2Layout.
                                        createSequentialGroup().
                                        addComponent(btnAdd, -2, -1, -2).
                                        addGap(0, 0, 32767))).
                        addContainerGap()));
        roundPanel2Layout.setVerticalGroup(roundPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).
                addGroup(GroupLayout.Alignment.TRAILING, roundPanel2Layout.
                        createSequentialGroup().
                        addContainerGap().
                        addComponent(btnAdd, -2, -1, -2).
                        addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).
                        addComponent(jScrollPane1, -1, 266, 32767).
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
    public void removeAllTableData() {
        DefaultTableModel dm = (DefaultTableModel) table1Employee.getModel();
        dm.getDataVector().removeAllElements();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o =e.getSource();
        if( o.equals(btnDelete))
        {
            int r = table1Employee.getSelectedRow();
            String code = (String) table1Employee.getValueAt(r, 0);
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
        else if( o.equals(btnFind))
        {
            DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
            String filter = cboFind.getSelectedItem().toString();
            if(filter.equalsIgnoreCase("Code"))
            {
                String code = txtFind.getText();
                ArrayList<Employee> listEm = employeeDAO.getEmployeeByID(code);
                if((! listEm.isEmpty()))
                {
                    removeAllTableData();
                    JOptionPane.showMessageDialog(txtFind, "Find By Code Successfully!");

                }
                else {
                    JOptionPane.showMessageDialog(txtFind, "Cant Find Any Employee With This ID In Database.");

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
                String name = txtFind.getText();
                ArrayList<Employee> listEm = employeeDAO.getEmployeeByName(name);
                if((listEm.isEmpty()))
                {
                    JOptionPane.showMessageDialog(txtFind, "Cant Find Any Employee With This Name In Database.");

                }
                else
                {
                    removeAllTableData();
                    JOptionPane.showMessageDialog(txtFind, "Find By Name Successfully!");

                }
                for(Employee em: listEm)
                {
                    double salary = em.getSalary();
                    String formattedSalary = decimalFormat.format(salary);
                    tableEmployeeModel.addRow(new Object[] {
                            em.getEmployeeCode(),em.getEmployeeName(),em.getCitizenIdNumber()
                            ,em.getEmployeeBirthday(),em.isEmployeeSex()==false?"Female":"Male", em.getEmployeeLocation(),em.getEmployeePhoneNumber(),
                            em.getEmployeePosition(), formattedSalary, em.getDateStart()
                    });
                }
            }
            else if( filter.equalsIgnoreCase("Phone"))
            {
                String phone = txtFind.getText();
                ArrayList<Employee> listEm = employeeDAO.getEmployeeByPhone(phone);
                if((! listEm.isEmpty()))
                {
                    removeAllTableData();
                    JOptionPane.showMessageDialog(txtFind, "Find By Phone Successfully!");

                }
                else {
                    JOptionPane.showMessageDialog(txtFind, "Cant Find Any Employee With This Phone In Database.");

                }
                for(Employee em: listEm)
                {
                    double salary = em.getSalary();
                    String formattedSalary = decimalFormat.format(salary);
                    tableEmployeeModel.addRow(new Object[] {
                            em.getEmployeeCode(),em.getEmployeeName(),em.getCitizenIdNumber()
                            ,em.getEmployeeBirthday(),em.isEmployeeSex()==false?"Female":"Male", em.getEmployeeLocation(),em.getEmployeePhoneNumber(),
                            em.getEmployeePosition(), formattedSalary, em.getDateStart()
                    });
                }
            }
        }
    }
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        Object o = e.getSource();
        if(o.equals(txtFind)){
            String keyFind = txtFind.getText();
            DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
            String filter = cboFind.getSelectedItem().toString();
            if(filter.equalsIgnoreCase("Code"))
            {
                String code = txtFind.getText();
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
                String name = txtFind.getText();
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
                String phone = txtFind.getText();
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

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}
