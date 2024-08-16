package ui.order;


import format.panel.PanelRound;
import format.textfield.MyTextField;
import format.textfield.SearchText;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.raven.datechooser.DateChooser;

import connect.ConnectDB;
import dao.CustomerDao;
import dao.OrderDao;
import dao.VehicleDao;
import entity.Customer;
import entity.Order;
import entity.Vehicle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FormOrder extends PanelRound implements ActionListener, MouseListener{
    private PanelRound roundPanel1;
    private PanelRound roundPanel2;
    private JLabel lbl1, lbl2;
    private SearchText searchText;
    private JTextField txtName,txtID,txtPhone,txtLocation;
    private JButton btnAdd,btnDel,btnFind,btnReset,btnUpdate;
    private JCheckBox chkWMen;
    private CustomerDao cusDao;
    private DefaultTableModel tableModel;

    private JComboBox<String> cboFind;
    private JLabel lblFind;
    private MyTextField txtFind;
    private OrderDao orderDao;
    private DateChooser date;
    private JTextField txtDate;
    private JComboBox<String> cbxCustomer;
    private JButton btnFindCus;
    private JComboBox cbxVehicle;
    private VehicleDao veDao;
    private JButton btnFindVe;
    private JTable tableOrder;
    private JButton btnChangStatus;
    private ArrayList<Customer> ls;
    private String nameCus;
    private ArrayList<Vehicle> lsV;
    private String nameVe;
    private String veCode;
    private JCheckBox chkInsurance;
    private JTextField txtDeposit;
    private JComboBox<String> cbxFindCus;
    private JComboBox<String> cbxFindVe;
    public FormOrder(){
        init();
        try {
            ConnectDB.getInstance().connectDataBase();
            System.out.println("Success To Connect Form!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
//	    	removeAllTableData();
        orderDao=new OrderDao();
        initComponent();
    }

    private void initComponent() {


        cusDao=new CustomerDao();
        try {
            veDao=new VehicleDao();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        roundPanel1 = new PanelRound();

        Box box,b1,b2,b3;
        box=Box.createVerticalBox();
        b1=Box.createHorizontalBox();

        JLabel lblCus=new JLabel("Customer: ");
        cbxCustomer = new JComboBox();

        ls=cusDao.getAllCustomers();
        for(Customer c:ls) {
            nameCus=c.getCustomerName();
            String phone=c.getCustomerPhoneNumber();
            cbxCustomer.addItem(nameCus+" - "+phone);
        }
        JLabel lblFindCus=new JLabel("Find Customer By:");
        cbxFindCus=new JComboBox<String>();
        cbxFindCus.addItem("ID");
        cbxFindCus.addItem("Name");
        cbxFindCus.addItem("Phone Number");
        btnFindCus=new JButton("Find");


        b1.add(lblCus);
        b1.add(cbxCustomer);
        b1.add(lblFindCus);
        b1.add(cbxFindCus);
        b1.add(btnFindCus);

        b2=Box.createHorizontalBox();
        JLabel lblVehicle=new JLabel("Vehicle: ");
        cbxVehicle = new JComboBox();

        lsV=veDao.getAllTableVehicle();
        for(Vehicle v:lsV) {
            nameVe=v.getVehicleName();
            veCode=v.getVehicleCode();
            cbxVehicle.addItem(nameVe+" - "+veCode);
        }
        JLabel lblFindVe=new JLabel("Find Vehicle By:");
        cbxFindVe=new JComboBox<String>();
        cbxFindVe.addItem("Code");
        cbxFindVe.addItem("Name");
        btnFindVe=new JButton("Find");
        b2.add(lblVehicle);
        b2.add(cbxVehicle);
        b2.add(lblFindVe);
        b2.add(cbxFindVe);
        b2.add(btnFindVe);

        b3=Box.createHorizontalBox();
        JLabel lblDate=new JLabel("Order Date: ");
        txtDate = new JTextField(20);
        date = new DateChooser();
        date.setTextField(txtDate);
        JLabel lblLocation=new JLabel("Receiver Location: ");
        txtLocation=new JTextField(30);
        chkInsurance=new JCheckBox("Insurance");
        JLabel lblDeposit=new JLabel("Deposit:");
        txtDeposit=new JTextField(20);
        b3.add(lblDate);
        b3.add(txtDate);
        b3.add(lblLocation);
        b3.add(txtLocation);
        b3.add(lblDeposit);
        b3.add(txtDeposit);
        b3.add(chkInsurance);

        Box b4;
        b4=Box.createHorizontalBox();
        btnAdd=new JButton("Add");
        btnDel=new JButton("Delete");
        btnReset=new JButton("Reset Form");
        btnUpdate=new JButton("Update Order");
        btnFind=new JButton("Find");
        cboFind=new JComboBox<String>();
        lblFind=new JLabel("Find Order By");
        txtFind=new MyTextField();
        btnChangStatus=new JButton("Change Status");

        txtFind.setHint("Type what you want to find here!");
        cboFind.setBackground(new Color(110,191,55));
        cboFind.addItem("Order Code");
        cboFind.addItem("Customer Phone");
        cboFind.addItem("Vehicle Code");
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
        b4.add(btnChangStatus);
        btnChangStatus.setBackground(Color.GREEN);
        cbxVehicle.setPreferredSize(cbxCustomer.getPreferredSize());
        cbxFindVe.setPreferredSize(cbxFindCus.getPreferredSize());
        lblCus.setPreferredSize(lblDate.getPreferredSize());
        lblVehicle.setPreferredSize(lblCus.getPreferredSize());
        lblFindVe.setPreferredSize(lblFindCus.getPreferredSize());
        // Tạo một đối tượng GridBagConstraints để cấu hình các thuộc tính căn chỉnh và kích thước của thành phần
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH; // Thành phần sẽ được mở rộng cả theo chiều ngang và chiều dọc
        constraints.weightx = 1.0; // Thành phần sẽ được co dãn theo chiều ngang
        constraints.weighty = 1.0; // Thành phần sẽ được co dãn theo chiều dọc
        roundPanel1.setLayout(new GridBagLayout());

        box.add(b1);
        box.add(b2);
        box.add(b3);
        box.add(b4);


        roundPanel1.add(box,constraints);
        roundPanel2 = new PanelRound();

        PanelRound pnlBott=new PanelRound();
        String[] header= {"Order Code","Date","Customer","Vehicle","Location","Insurance","Deposit","Status"};
        tableModel = new DefaultTableModel(header,0);
        tableOrder=new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableOrder);

        scrollPane.setPreferredSize(new Dimension(1030, 500));
        pnlBott.add(scrollPane,constraints);
        removeAllTableData();
        importSQLDataToTable();
        TableColumn columnCode= tableOrder.getColumnModel().getColumn(0);
        columnCode.setPreferredWidth(60);
        TableColumn columnDate=tableOrder.getColumnModel().getColumn(1);
        columnDate.setPreferredWidth(80);
        TableColumn columnCustomer = tableOrder.getColumnModel().getColumn(2);
        columnCustomer.setPreferredWidth(220);
        TableColumn columnVehicle = tableOrder.getColumnModel().getColumn(3);
        columnVehicle.setPreferredWidth(220);
        TableColumn columnLocation = tableOrder.getColumnModel().getColumn(4);
        columnLocation.setPreferredWidth(100);
        TableColumn columnInsurance = tableOrder.getColumnModel().getColumn(5);
        columnInsurance.setPreferredWidth(60);
        TableColumn columnDeposit = tableOrder.getColumnModel().getColumn(6);
        columnDeposit.setPreferredWidth(70);
        TableColumn columnStatus = tableOrder.getColumnModel().getColumn(7);
        columnStatus.setPreferredWidth(60);
//			TableColumn columnAction = tableOrder.getColumnModel().getColumn(8);
//			columnAction.setPreferredWidth(40);
        pnlBott.setBorder(new TitledBorder("List Of Orders:"));

        roundPanel2.add(pnlBott,constraints);
        btnFindCus.addActionListener(this);
        btnFindVe.addActionListener(this);
        btnAdd.addActionListener(this);
        btnDel.addActionListener(this);
        btnReset.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnFind.addActionListener(this);
        tableOrder.addMouseListener(this);

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
        List<Order> list=orderDao.getAllTableOrder();
        for(Order o:list) {
            tableModel.addRow(new Object[] {o.getOrderCode(),o.getOrderDate(),
                    o.getCustomer().getCustomerPhoneNumber()+o.getCustomer().getCustomerPhoneNumber(),
                    o.getVehicle().getVehicleCode()+" - "+o.getVehicle().getVehicleName(),o.getLocation(),
                    o.isInsurance(),o.getDeposit(),o.isStatus()==true?"Done":"Inprogress"});
            System.out.println("Imported Data!");
        }
    }
    public void removeAllTableData() {
        DefaultTableModel dm = (DefaultTableModel) tableOrder.getModel();
        dm.getDataVector().removeAllElements();
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        Object o=e.getSource();
//        if(o.equals(btnAdd)) {
//            if(!validData()) {
//                return;
//            }
//            ArrayList<Customer> list=cusDao.getAllCustomers();
//            ArrayList<Vehicle> listV=veDao.getAllTableVehicle();
//            Customer cus=list.get(cbxCustomer.getSelectedIndex());
//            Vehicle ve=listV.get(cbxVehicle.getSelectedIndex());
//            String oLocation=txtLocation.getText().trim();
//            boolean oInsurance=chkInsurance.isSelected();
//            double oDeposit=Double.parseDouble(txtDeposit.getText().trim());
//            Date oDate=date.getSelectedDate();
//            LocalDate oLocalDate=oDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//            boolean oStatus=false;
//            Order newOrder=new Order(cus, ve, oLocation, oInsurance, oDeposit, oLocalDate, oStatus);
//            try {
//                orderDao.createOrder(newOrder);
//                removeAllTableData();
//                importSQLDataToTable();
//            } catch (SQLException e2) {
//                e2.printStackTrace();
//            }
//        }else if(o.equals(btnDel)) {
//            int r=tableOrder.getSelectedRow();
//            String code=(String)tableOrder.getValueAt(r, 0);
//            tableModel.removeRow(r);
//            Order order=new Order(r);
//            try {
//                orderDao.removeOrder(order);
//                System.out.println("Removed!");
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
//        }else if(o.equals(btnReset)) {
//            txtDate.setText("");
//            txtDeposit.setText("");
//            txtFind.setText("");
//            txtLocation.setText("");
//            cbxCustomer.setSelectedIndex(0);
//            cbxVehicle.setSelectedIndex(0);
//            cboFind.setSelectedIndex(0);
//            cbxFindCus.setSelectedIndex(0);
//            cbxFindVe.setSelectedIndex(0);
//        }else if(o.equals(btnUpdate)) {
//            Customer cus=ls.get(cbxCustomer.getSelectedIndex());
//            Vehicle ve=lsV.get(cbxVehicle.getSelectedIndex());
//            String oLocation=txtLocation.getText().trim();
//            boolean oInsurance=chkInsurance.isSelected();
//            double oDeposit=Double.parseDouble(txtDeposit.getText().trim());
//            Date oDate=date.getSelectedDate();
//            LocalDate oLocalDate=oDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//            boolean oStatus=false;
//            Order newOrder=new Order(cus, ve, oLocation, oInsurance, oDeposit, oLocalDate, oStatus);
//            int r=tableOrder.getSelectedRow();
//            int orderCode=Integer.parseInt(tableOrder.getValueAt(r, 0).toString());
//            try {
//                orderDao.updateOrder(newOrder,orderCode);
//                System.out.println("Order Updated!");
//                removeAllTableData();
//                importSQLDataToTable();
//
//
//            } catch (SQLException e0) {
//                // TODO Auto-generated catch block
//                e0.printStackTrace();
//                System.out.println("e0 update error");
//            }
//
//        }else if(o.equals(btnFind)) {
//            String filter = cboFind.getSelectedItem().toString();
//            String find=txtFind.getText().trim();
////				String find=JOptionPane.showInputDialog(btnFind,"Please type the "+filter+" you want to find");
//            if(filter.equalsIgnoreCase("Order Code")) {
//
//                if(find.matches("[0-9]{1,9}")) {
//                    ArrayList<Order> l=orderDao.getOrderByCode(find);
//
//                    if(!l.isEmpty()) {
//                        for(Order o1:l) {
//                            removeAllTableData();
//                            tableModel.addRow(new Object[] {o1.getOrderCode(),o1.getOrderDate(),
//                                    o1.getCustomer().getCustomerPhoneNumber()+o1.getCustomer().getCustomerPhoneNumber(),
//                                    o1.getVehicle().getVehicleCode()+" - "+o1.getVehicle().getVehicleName(),o1.getLocation(),
//                                    o1.isInsurance(),o1.getDeposit(),o1.isStatus()==true?"Done":"Inprogress"});
//                        }
//                    }else {
//                        JOptionPane.showMessageDialog(this, "Cant find any Order!");
//                    }
//                }else {
//                    JOptionPane.showMessageDialog(txtFind,"Invalid Order Code!");
//                }
//                System.out.println("Founded!");
//            }else if(filter.equalsIgnoreCase("Customer Phone")){
//                if(find.matches("^(09|08)\\\\d{8}$")) {
//                    String phone=txtFind.getText().trim();
//                    ArrayList<Order> l=orderDao.getAllTableOrder();
//                    for(Order o1:l) {
//                        removeAllTableData();
//                        if(o1.getCustomer().getCustomerPhoneNumber()==phone) {
//                            tableModel.addRow(new Object[] {o1.getOrderCode(),o1.getOrderDate(),
//                                    o1.getCustomer().getCustomerPhoneNumber()+o1.getCustomer().getCustomerPhoneNumber(),
//                                    o1.getVehicle().getVehicleCode()+" - "+o1.getVehicle().getVehicleName(),o1.getLocation(),
//                                    o1.isInsurance(),o1.getDeposit(),o1.isStatus()==true?"Done":"Inprogress"});
//                        }
//                    }
//                }else {
//                    JOptionPane.showMessageDialog(this, "Cant find any customer!");
//                }
//
//            }else if(filter.equalsIgnoreCase("Vehicle Code")) {
//                String vehicle=txtFind.getText().trim();
//                ArrayList<Order> l=orderDao.getAllTableOrder();
//                for(Order o1:l) {
//                    removeAllTableData();
//                    if(o1.getVehicle().getVehicleCode()==vehicle) {
//                        tableModel.addRow(new Object[] {o1.getOrderCode(),o1.getOrderDate(),
//                                o1.getCustomer().getCustomerPhoneNumber()+o1.getCustomer().getCustomerPhoneNumber(),
//                                o1.getVehicle().getVehicleCode()+" - "+o1.getVehicle().getVehicleName(),o1.getLocation(),
//                                o1.isInsurance(),o1.getDeposit(),o1.isStatus()==true?"Done":"Inprogress"});
//                    }
//                }
//            }
//        }
//
//    }

    private boolean validData()
    {

        String location=txtLocation.getText().trim();
        String deposit=txtDeposit.getText().trim();
        if(location==null) {
            JOptionPane.showMessageDialog(txtLocation, "Invalid Location!");
            return false;
        }
        if(deposit==null) {
            JOptionPane.showMessageDialog(txtLocation, "Invalid Deposit!");
            return false;
        }
        return true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row=tableOrder.getSelectedRow();
//			txtCode.setText(tableModel.getValueAt(row, 0).toString());
        txtDate.setText(tableModel.getValueAt(row, 1).toString());
        cbxCustomer.setSelectedItem(tableModel.getValueAt(row, 2).toString());
        cbxVehicle.setSelectedItem(tableModel.getValueAt(row, 3).toString());
        txtLocation.setText(tableModel.getValueAt(row, 4).toString());
        txtDeposit.setText(tableModel.getValueAt(row, 6).toString());
        chkInsurance.setSelected(tableModel.getValueAt(row, 5).toString()=="true"?true:false);


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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
