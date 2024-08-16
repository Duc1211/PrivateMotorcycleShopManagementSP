package ui.customer;


import format.panel.PanelRound;
import format.textfield.MyTextField;
import format.textfield.SearchText;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import connect.ConnectDB;
import dao.CustomerDao;
import entity.Customer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FormCustomer extends PanelRound implements ActionListener, MouseListener{
    private PanelRound roundPanel1;
    private PanelRound roundPanel2;
    private JLabel lbl1, lbl2;
    private SearchText searchText;
    private JTextField txtName,txtID,txtPhone,txtLocation;
    private JButton btnAdd,btnDel,btnFind,btnReset,btnUpdate;
    private JCheckBox chkWMen;
    private CustomerDao cusDao;
    private DefaultTableModel tableModel;
    private JTable tableCustomer;
    private JComboBox<String> cboFind;
    private JLabel lblFind;
    private MyTextField txtFind;
    public FormCustomer(){
        init();
        try {
            ConnectDB.getInstance().connectDataBase();
            System.out.println("Success To Connect Customer Form!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
//	    	removeAllTableData();
        cusDao=new CustomerDao();
        initComponent();
    }

    private void initComponent() {



        roundPanel1 = new PanelRound();

        Box box,b1,b2,b3;
//	    	JLabel lblHeader=new JLabel("Customer info form:", JLabel.CENTER);
//	    	lblHeader.setFont(new Font("Calibri", Font.BOLD, 30));
//	    	lblHeader.setForeground(Color.RED);
        box=Box.createVerticalBox();
//	    	box.add(lblHeader);
        b1=Box.createHorizontalBox();
//	    	JLabel lblCode =new JLabel("Customer Code: ");
//	    	txtCode=new JTextField(20);
        JLabel lblID=new JLabel("National ID:           ");
        txtID =new JTextField(30);
        JLabel lblName=new JLabel("Customer Name: ");
        txtName=new JTextField(45);
//	    	b1.add(lblCode);
//	    	b1.add(txtCode);
        b1.add(lblID);
        b1.add(txtID);
        b1.add(lblName);
        b1.add(txtName);
        b2=Box.createHorizontalBox();
        JLabel lblPhone=new JLabel("Phone Number: ");
        txtPhone=new JTextField(15);
        JLabel lblLocation=new JLabel("Location: ");
        txtLocation=new JTextField(30);
//	    	JLabel lblWMen=new JLabel("Customer's Gender: ");
        chkWMen=new JCheckBox("Women");
        b2.add(lblPhone);
        b2.add(txtPhone);
        b2.add(lblLocation);
        b2.add(txtLocation);
//	    	b2.add(lblWMen);
        b2.add(chkWMen);

        b3=Box.createHorizontalBox();



//	    	lblCode.setPreferredSize(lblName.getPreferredSize());
//	    	lblID.setPreferredSize(lblName.getPreferredSize());
//	    	lblLocation.setPreferredSize(lblName.getPreferredSize());
        lblPhone.setPreferredSize(lblName.getPreferredSize());
        JLabel lblNull=new JLabel("        ");
        Box boxNull=Box.createHorizontalBox();
        boxNull.add(lblNull);
        Box b4;
        b4=Box.createHorizontalBox();
        btnAdd=new JButton("Add");
        btnDel=new JButton("Delete");
        btnReset=new JButton("Reset Form");
        btnUpdate=new JButton("Update Customer");
        btnFind=new JButton("Find");
        cboFind=new JComboBox<String>();
        lblFind=new JLabel("Find By");
        txtFind=new MyTextField();

        txtFind.setHint("Type what you want to find here!");
        cboFind.setBackground(new Color(110,191,55));
        cboFind.addItem("Name");
        cboFind.addItem("Customer Code");
        cboFind.addItem("Phone Number");
        btnAdd.setBackground(Color.GREEN);
        btnDel.setBackground(Color.GREEN);
        btnReset.setBackground(Color.GREEN);
        btnUpdate.setBackground(Color.green);
        btnFind.setBackground(Color.GREEN);
        b4.add(btnAdd);
        b4.add(btnDel);
        b4.add(btnReset);
        b4.add(btnUpdate);
        b4.add(lblFind);
        b4.add(cboFind);
        b4.add(txtFind);
        b4.add(btnFind);
        // Tạo một đối tượng GridBagConstraints để cấu hình các thuộc tính căn chỉnh và kích thước của thành phần
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH; // Thành phần sẽ được mở rộng cả theo chiều ngang và chiều dọc
        constraints.weightx = 1.0; // Thành phần sẽ được co dãn theo chiều ngang
        constraints.weighty = 1.0; // Thành phần sẽ được co dãn theo chiều dọc
        roundPanel1.setLayout(new GridBagLayout());

        box.add(b1);
        box.add(b2);
        box.add(b3);
        box.add(boxNull);
        box.add(b4);


        roundPanel1.add(box);
//	        searchText = new SearchText();
//	    	roundPanel2.setLayout(new GridBagLayout());
        roundPanel2 = new PanelRound();




//	        roundPanel1.setBackground(new Color(250, 250, 250));
//	        roundPanel1.setRoundTopLeft(10);
//	        roundPanel1.setRoundTopRight(10);
//	        roundPanel1.setRoundBottomLeft(10);
//	        roundPanel1.setRoundBottomRight(10);
//	        GroupLayout roundPanel1Layout = new GroupLayout(this.roundPanel1);
//	        roundPanel1.setLayout(roundPanel1Layout);
//	        roundPanel1Layout.setHorizontalGroup(roundPanel1Layout.
//	                createParallelGroup(GroupLayout.Alignment.LEADING).
//	                addGroup(roundPanel1Layout.createSequentialGroup().
//	                        addContainerGap().
//	                        addComponent(lbl1, -1, 928, 32767).
//	                        addContainerGap()));
//
//	        roundPanel1Layout.setVerticalGroup(roundPanel1Layout.
//	                createParallelGroup(GroupLayout.Alignment.LEADING).
//	                addGroup(roundPanel1Layout.
//	                        createSequentialGroup().
//	                        addContainerGap().
//	                        addComponent(lbl1, -1, 278, 32767).
//	                        addContainerGap()));
        PanelRound pnlBott=new PanelRound();
        String[] header= {"Customer Code","National ID","Name","Gender","Phone Number","Location"};
        tableModel = new DefaultTableModel(header,0);
        tableCustomer=new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableCustomer);

        scrollPane.setPreferredSize(new Dimension(1030, 500));
        pnlBott.add(scrollPane,constraints);
        importSQLDataToTable();
        TableColumn columnCode= tableCustomer.getColumnModel().getColumn(0);
        columnCode.setPreferredWidth(150);
        TableColumn columnID = tableCustomer.getColumnModel().getColumn(1);
        columnID.setPreferredWidth(220);
        TableColumn columnName = tableCustomer.getColumnModel().getColumn(2);
        columnName.setPreferredWidth(200);
        TableColumn columnGender = tableCustomer.getColumnModel().getColumn(3);
        columnGender.setPreferredWidth(100);
        TableColumn columnPhone = tableCustomer.getColumnModel().getColumn(4);
        columnPhone.setPreferredWidth(200);
        TableColumn columnLocation = tableCustomer.getColumnModel().getColumn(5);
        columnLocation.setPreferredWidth(250);
        pnlBott.setBorder(new TitledBorder("List of customers"));

        roundPanel2.add(pnlBott,constraints);


//	        roundPanel2.setBackground(new Color(250, 250, 250));
//	        roundPanel2.setRoundTopLeft(10);
//	        roundPanel2.setRoundTopRight(10);
//	        roundPanel2.setRoundBottomLeft(10);
//	        roundPanel2.setRoundBottomRight(10);
//	        GroupLayout roundPanel2Layout = new GroupLayout(this.roundPanel2);
//	        roundPanel2.setLayout(roundPanel2Layout);
//	        roundPanel2Layout.setHorizontalGroup(roundPanel2Layout.
//	                createParallelGroup(GroupLayout.Alignment.LEADING).
//	                addGroup(roundPanel2Layout.createSequentialGroup().
//	                        addContainerGap().
//	                        addComponent(lbl2, -1, 928, 32767).
//	                        addContainerGap()));
//	        roundPanel2Layout.setVerticalGroup(roundPanel2Layout.
//	                createParallelGroup(GroupLayout.Alignment.LEADING).
//	                addGroup(roundPanel2Layout.
//	                        createSequentialGroup().
//	                        addContainerGap().
//	                        addComponent(lbl2, -1, 278, 32767).
//	                        addContainerGap()));

        btnAdd.addActionListener(this);
        btnDel.addActionListener(this);
        btnReset.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnFind.addActionListener(this);
        tableCustomer.addMouseListener(this);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).
//	                addComponent(searchText).
        addComponent(this.roundPanel1, -1, -1, 32767).
                addComponent(this.roundPanel2, -1, -1, 32767));
        layout.setVerticalGroup(layout.
                createParallelGroup(GroupLayout.Alignment.LEADING).
                addGroup(layout.createSequentialGroup().
//	                        addComponent(searchText).
        addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).
                        addComponent(this.roundPanel1, -2, -1, -2).
                        addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).
                        addComponent(this.roundPanel2, -1, -1, 32767)));
    }


    private void init() {

    }
    public void importSQLDataToTable() {
        List<Customer> list=cusDao.getAllCustomers();
        for(Customer c:list) {
            tableModel.addRow(new Object[] {c.getCustomerCode(),c.getCitizenIdNumber(),c.getCustomerName(),
                    c.isCustomerSex()==false?"Male":"Female",c.getCustomerPhoneNumber(),c.getCustomerLocation()});
            System.out.println("Imported Data!");
        }
    }
    public void removeAllTableData() {
        DefaultTableModel dm = (DefaultTableModel) tableCustomer.getModel();
        dm.getDataVector().removeAllElements();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o=e.getSource();
        if(o.equals(btnAdd)) {
            if(!validData()) {
                return;
            }
            String phone1=txtPhone.getText().trim();
            ArrayList<Customer> list = null;
            try {
                list = cusDao.getCustomerByPhone(phone1);
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            String id=txtID.getText().trim();
            String name=txtName.getText().trim();
            boolean gender=chkWMen.isSelected();
            String phone=txtPhone.getText().trim();
            String location=txtLocation.getText().trim();
            Customer c=new Customer(id, name, gender, phone, location);
            if(list.isEmpty()) {
                try {
                    cusDao.createCustomer(c);
                    ArrayList<Customer>d= cusDao.getCustomerByPhone(c.getCustomerPhoneNumber());
                    for(Customer cus:d) {
                        tableModel.addRow(new Object[] {cus.getCustomerCode(),cus.getCitizenIdNumber(),cus.getCustomerName(),
                                cus.isCustomerSex()==false?"Male":"Female",cus.getCustomerPhoneNumber(),cus.getCustomerLocation()});
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }else {
                JOptionPane.showMessageDialog(this,"Customer Existed!");
            }
        }else if(o.equals(btnDel)) {
            int r=tableCustomer.getSelectedRow();
            int code=(int)tableCustomer.getValueAt(r, 0);
            tableModel.removeRow(r);
            Customer cus=new Customer(code);
            try {
                cusDao.removeCustomer(cus);
                System.out.println("Removed!");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }else if(o.equals(btnReset)) {
//				txtCode.setText("");
            txtID.setText("");
            txtName.setText("");
            chkWMen.setSelected(false);
            txtPhone.setText("");
            txtLocation.setText("");
        }else if(o.equals(btnUpdate)) {
//				String code=txtCode.getText().trim();
            String id=txtID.getText().trim();
            String name=txtName.getText().trim();
            boolean gender=chkWMen.isSelected();
            String phone=txtPhone.getText().trim();
            String location=txtLocation.getText().trim();
            Customer c=new Customer(id, name, gender, phone, location);
            int r=tableCustomer.getSelectedRow();
            int cusCode=Integer.parseInt(tableCustomer.getValueAt(r, 0).toString());
            try {
                cusDao.updateCustomer(c, cusCode);
                System.out.println("Customer Updated!");
                removeAllTableData();
                importSQLDataToTable();


            } catch (SQLException e0) {
                // TODO Auto-generated catch block
                e0.printStackTrace();
                System.out.println("e0 update customer error");
            }

        }else if(o.equals(btnFind)) {
            String filter = cboFind.getSelectedItem().toString();
            String find=txtFind.getText().trim();
//				String find=JOptionPane.showInputDialog(btnFind,"Please type the "+filter+" you want to find");
            try {
                if(filter.equalsIgnoreCase("Customer Code")) {

                    if(find.matches("[0-9]{1,9}")) {
                        ArrayList<Customer> d= cusDao.getCustomerByCode(find);

                        if(!d.isEmpty()) {
                            for(Customer c:d) {
                                removeAllTableData();
                                tableModel.addRow(new Object[] {c.getCustomerCode(),c.getCitizenIdNumber(),c.getCustomerName(),
                                        c.isCustomerSex()==false?"Male":"Female",c.getCustomerPhoneNumber(),c.getCustomerLocation()});

                            }
                        }else {
                            JOptionPane.showMessageDialog(this, "Cant find any customer!");
                        }
                    }else {
                        JOptionPane.showMessageDialog(txtFind,"Invalid Customer Code!");
                    }
                    System.out.println("Founded!");
                }else if(filter.equalsIgnoreCase("Name")) {
                    if(find.matches("^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]"
                            + "[a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*"
                            + "(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]"
                            + "[a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$")) {
                        ArrayList<Customer> d= cusDao.getCustomerByCode(find);

                        if(!d.isEmpty()) {
                            for(Customer c:d) {
                                removeAllTableData();
                                tableModel.addRow(new Object[] {c.getCustomerCode(),c.getCitizenIdNumber(),c.getCustomerName(),
                                        c.isCustomerSex()==false?"Male":"Female",c.getCustomerPhoneNumber(),c.getCustomerLocation()});

                            }
                        }else {
                            JOptionPane.showMessageDialog(this, "Cant find any customer!");
                        }
                    }else {
                        JOptionPane.showMessageDialog(txtFind,"Invalid Customer Name!");
                    }
                    System.out.println("Founded!");
                }else if(filter.equalsIgnoreCase("Phone Number")) {
                    if(find.matches("^(09|08)\\\\d{8}$")) {
                        ArrayList<Customer> d= cusDao.getCustomerByCode(find);

                        if(!d.isEmpty()) {
                            for(Customer c:d) {
                                removeAllTableData();
                                tableModel.addRow(new Object[] {c.getCustomerCode(),c.getCitizenIdNumber(),c.getCustomerName(),
                                        c.isCustomerSex()==false?"Male":"Female",c.getCustomerPhoneNumber(),c.getCustomerLocation()});

                            }
                        }else {
                            JOptionPane.showMessageDialog(this, "Cant find any customer!");
                        }
                    }else {
                        JOptionPane.showMessageDialog(txtFind,"Invalid Customer Phone Number!");
                    }
                    System.out.println("Founded!");
                }

            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }

    }

    private boolean validData()
    {
        // Kiểm tra biểu thức chính quy cho từng trường cụ thể
//			   String cusCode = txtCode.getText().trim();
//			   if (cusCode==null) {
//			      JOptionPane.showMessageDialog(txtCode, "Invalid Customer Code!");
//			      return false;
//			   }
        String nationalID = txtID.getText().trim();
        if (!nationalID.matches("\\d{12}")||nationalID==null) {
            JOptionPane.showMessageDialog(txtID, "Invalid National ID!");
            return false;
        }

        String phone = txtPhone.getText().trim();
        if (!phone.matches("^(09|08)\\d{8}$")||phone==null) {
            JOptionPane.showMessageDialog(txtPhone, "Invalid Phone Number!");
            return false;
        }
        String name=txtName.getText().trim();
        if(!name.matches("^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]"
                + "[a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*"
                + "(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]"
                + "[a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$")||name==null) {
            JOptionPane.showMessageDialog(txtName, "Invalid Name Input!");
            return false;
        }
        String location=txtLocation.getText().trim();
        if(location==null) {
            JOptionPane.showMessageDialog(txtLocation, "Invalid Location!");
            return false;
        }
        return true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row=tableCustomer.getSelectedRow();
//			txtCode.setText(tableModel.getValueAt(row, 0).toString());
        txtID.setText(tableModel.getValueAt(row, 1).toString());
        txtName.setText(tableModel.getValueAt(row, 2).toString());
        chkWMen.setSelected(tableModel.getValueAt(row, 3).toString()=="Female"?true:false);
        txtPhone.setText(tableModel.getValueAt(row, 4).toString());
        txtLocation.setText(tableModel.getValueAt(row, 5).toString());

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

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

}
