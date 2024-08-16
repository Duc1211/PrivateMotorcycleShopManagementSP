package ui.customer;

import format.panel.PanelRound;
import format.textfield.MyTextField;

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
import java.sql.SQLException;
import java.util.ArrayList;

public class FormCustomerComplete extends PanelRound implements ActionListener {
    private PanelRound pnl1,pnl2;
    private JButton btnDel,btnFind,btnComplete;
    private JComboBox<String> cboFind;
    private MyTextField txtFind;
    private CustomerDao cusDao;
    private DefaultTableModel tableModel;
    private JTable tableCustomer;
    private ArrayList<Customer> ls;
    private ArrayList<Customer> ls2;
    public FormCustomerComplete() throws SQLException {
        try {
            ConnectDB.getInstance().connectDataBase();
            System.out.println("Success To Connect Customer Form!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
//    	removeAllTableData();
        cusDao=new CustomerDao();
        initComponents();

        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() throws SQLException {
        pnl1=new PanelRound();
        pnl2=new PanelRound();
        Box b4;
        b4=Box.createHorizontalBox();
        btnDel=new JButton("Delete");
        btnFind=new JButton("Find");
        cboFind=new JComboBox<String>();
        JLabel lblFind=new JLabel("Find By");
        txtFind=new MyTextField();
        txtFind.setPreferredSize(new Dimension(300, HEIGHT));
        txtFind.setHint("Type what you want to find here!");
        cboFind.setBackground(new Color(110,191,55));
        cboFind.addItem("Name");
        cboFind.addItem("Customer Code");
        cboFind.addItem("Phone Number");
        btnDel.setBackground(Color.GREEN);
        btnFind.setBackground(Color.GREEN);
        btnComplete=new JButton("Incomplete");
        btnComplete.setBackground(Color.GREEN);
        b4.add(btnDel);
        b4.add(btnComplete);
        b4.add(lblFind);
        b4.add(cboFind);
        b4.add(txtFind);
        b4.add(btnFind);

        pnl1.add(b4);

        PanelRound pnlBott=new PanelRound();
        String[] header= {"Customer Code","National ID","Name","Gender","Phone Number","Location"};
        tableModel = new DefaultTableModel(header,0);
        tableCustomer=new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableCustomer);

        scrollPane.setPreferredSize(new Dimension(1000, 420));
        pnlBott.add(scrollPane);
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
        pnl2.add(pnlBott);

        importSQLDataToTable();

        btnComplete.addActionListener(this);
        btnDel.addActionListener(this);
        btnFind.addActionListener(this);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).
//                addComponent(searchText).
        addComponent(this.pnl1, -1, -1, 32767).
                addComponent(this.pnl2, -1, -1, 32767));
        layout.setVerticalGroup(layout.
                createParallelGroup(GroupLayout.Alignment.LEADING).
                addGroup(layout.createSequentialGroup().
//                        addComponent(searchText).
        addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).
                        addComponent(this.pnl1, -2, -1, -2).
                        addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).
                        addComponent(this.pnl2, -1, -1, 32767)));
    }
    public void removeAllTableData() {
        DefaultTableModel dm = (DefaultTableModel) tableCustomer.getModel();
        dm.getDataVector().removeAllElements();
    }
    private void importSQLDataToTable() throws SQLException {

        ls=cusDao.getCustomerBySaleContractStatus(true);
//	    ls2=cusDao.getCustomerByOrderStatus(false);
        for(Customer cus:ls) {
            int n=0;
            for(int i=0;i<tableCustomer.getRowCount();i++) {
                int code=Integer.parseInt(tableCustomer.getValueAt(i, 0).toString());
                if(cus.getCustomerCode()==code) {
                    n++;
                }
            }
            if(n==0) {
                tableModel.addRow(new Object[] {cus.getCustomerCode(),cus.getCitizenIdNumber(),cus.getCustomerName(),
                        cus.isCustomerSex()==false?"Male":"Female",cus.getCustomerPhoneNumber(),cus.getCustomerLocation()});
            }else {
                System.out.println("No Data!");
            }
        }
//	    for(Customer cus:ls2) {
//	    	tableModel.addRow(new Object[] {cus.getCustomerCode(),cus.getCitizenIdNumber(),cus.getCustomerName(),
//					cus.isCustomerSex()==false?"Male":"Female",cus.getCustomerPhoneNumber(),cus.getCustomerLocation()});
//	    }
//
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o=e.getSource();
        if(o.equals(btnDel)) {
            int r=tableCustomer.getSelectedRow();
            String code=(String)tableCustomer.getValueAt(r, 1);
            tableModel.removeRow(r);
            Customer cus=new Customer(code);
            try {
                cusDao.removeCustomer(cus);
                System.out.println("Removed!");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }else if(o.equals(btnFind)) {
            String filter = cboFind.getSelectedItem().toString();
            String find=txtFind.getText().trim();
//			String find=JOptionPane.showInputDialog(btnFind,"Please type the "+filter+" you want to find");
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

        }else  if(o.equals(btnComplete)) {
            int r=tableCustomer.getSelectedRow();
            int code=(int)tableCustomer.getValueAt(r, 0);
            try {
                cusDao.updateStatus(code, false);
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            try {
                removeAllTableData();
                importSQLDataToTable();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                ls=cusDao.getCustomerBySaleContractStatus(true);
                if(ls.size()==0) {
                    removeAllTableData();
                    tableCustomer.setRowSelectionAllowed(false);
                }
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}
