package ui.contract;

import format.panel.PanelRound;

import javax.swing.*;
import javax.swing.SpringLayout.Constraints;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormContract extends PanelRound implements ActionListener,MouseListener{
    private JLabel lbl1;
    private JTextField txtTim;
    private JDateChooser date_TRansactionDate;
    private JTextField txtEmoloyee;

    private JTextField txtContractNumer;
    private JComboBox<String> paymentMethod;
    private JTextField txtContractValue;
    private JTextField txttotalAmountPaid;
    private JTextField txtVehicle;
    private JTextField txtWarrantyPeriod;
    private JTextField txtCustomer;
    private JButton bttFind;
    private JButton bttAdd;
    private JButton bttReset;
    private JButton bttDelete;
    private JButton bttUpdate;
    private JButton bttComplete;
    private DefaultTableModel modelContract;
    private JTable tableContract;
    private JTextField txtContractCode;
    private JComboBox<Integer> installmentPeriod;
    private PanelRound roundPanel2;
    private PanelRound roundPanel1;




    public FormContract() {
        initComponents();
//        lbl1.setText("Form Customer");
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        roundPanel1=new PanelRound();
        roundPanel2=new PanelRound();

        roundPanel1.setBackground(new Color(250, 250, 250));
        Box b = Box.createVerticalBox();

        Box b11, b1, b2, b3, b4, b5,b6;

        JLabel lblVehicle, lblCustomer, lblWarrantyPeriod, lblContractNumer, lblContractCode, lblTotalAmountPaid,
                lblContractValue, lblPaymentMethod,lblexpected,lblComplete ,lblEmployee, lblContract, lblTransactionDate,lblInstallmentPeriod;

        b.add(b2 = Box.createHorizontalBox());
        b.add(Box.createVerticalStrut(10));
        b2.add(lblEmployee = new JLabel("Employee:"));
        b2.add(txtEmoloyee = new JTextField());
        b2.add(lblCustomer = new JLabel("Customer:"));
        b2.add(txtCustomer = new JTextField());

        b.add(b1 = Box.createHorizontalBox());
        b.add(Box.createVerticalStrut(10));
        b1.add(lblContractNumer = new JLabel("ContractNumer:"));
        b1.add(txtContractNumer = new JTextField());
        b1.add(lblContractCode = new JLabel("ContractCode:"));
        b1.add(txtContractCode = new JTextField());

        b.add(b3 = Box.createHorizontalBox());
        b.add(Box.createVerticalStrut(10));
        b3.add(lblPaymentMethod = new JLabel("PaymentMethod:"));
        paymentMethod=new JComboBox<String>();
        paymentMethod.addItem("Cash");
        paymentMethod.addItem("Transfer Banking");
        paymentMethod.addItem("Installment");
        paymentMethod.addItem("Swipe Card");
        b3.add(paymentMethod);
        b3.add(lblTransactionDate = new JLabel("TransactionDate:"));
        b3.add(date_TRansactionDate = new JDateChooser());
        b3.add(lblInstallmentPeriod=new JLabel("Installment Period (month):"));
        installmentPeriod = new JComboBox<Integer>();
        installmentPeriod.addItem(3);
        installmentPeriod.addItem(6);
        installmentPeriod.addItem(9);
        installmentPeriod.addItem(12);
        b3.add(installmentPeriod);

        b.add(b4 = Box.createHorizontalBox());
        b.add(Box.createVerticalStrut(10));
        b4.add(lblContractValue = new JLabel("ContractValue:"));
        b4.add(txtContractValue = new JTextField());
        b4.add(lblTotalAmountPaid = new JLabel("TotalAmountPaid:"));
        b4.add(txttotalAmountPaid = new JTextField());

        b.add(b5 = Box.createHorizontalBox());
        b.add(Box.createVerticalStrut(30));
        b5.add(lblWarrantyPeriod = new JLabel("WarrantyPeriod:"));
        b5.add(txtWarrantyPeriod = new JTextField());
        b5.add(lblVehicle = new JLabel("Vehicle:"));
        b5.add(txtVehicle = new JTextField());

        b.add(b6 = Box.createHorizontalBox());
        b.add(Box.createVerticalStrut(15));
        JLabel lblcode;
        b6.add(lblcode = new JLabel("Code:"));
        b6.add(txtTim = new JTextField());
        b6.add(bttFind = new JButton("Find"));
        bttFind.setBackground(new Color(110,191,55));
        b6.add(Box.createHorizontalStrut(15));
        b6.add(bttAdd = new JButton("Add"));
        bttAdd.setBackground(new Color(110,191,55));
        b6.add(Box.createHorizontalStrut(15));
        b6.add(bttReset = new JButton("Reset"));
        bttReset.setBackground(new Color(110,191,55));
        b6.add(Box.createHorizontalStrut(15));
        b6.add(bttDelete = new JButton("Delete"));
        bttDelete.setBackground(new Color(110,191,55));
        b6.add(Box.createHorizontalStrut(15));
        b6.add(bttUpdate = new JButton("Upadate"));
        bttUpdate.setBackground(new Color(110,191,55));
        b6.add(Box.createHorizontalStrut(15));
        b6.add(bttComplete = new JButton("Complete"));
        bttComplete.setBackground(new Color(110,191,55));

        lblEmployee.setPreferredSize(lblPaymentMethod.getPreferredSize());
        lblCustomer.setPreferredSize(lblContractCode.getPreferredSize());
        lblPaymentMethod.setPreferredSize(lblPaymentMethod.getPreferredSize());
//		lblTransactionDate.setPreferredSize(lblContractNumer.getPreferredSize());
        lblContractValue.setPreferredSize(lblPaymentMethod.getPreferredSize());
//		lblTotalAmountPaid.setPreferredSize(lblContractCode.getPreferredSize());
        lblWarrantyPeriod.setPreferredSize(lblPaymentMethod.getPreferredSize());
        lblVehicle.setPreferredSize(lblContractCode.getPreferredSize());
        lblContractNumer.setPreferredSize(lblPaymentMethod.getPreferredSize());
        lblcode.setPreferredSize(lblPaymentMethod.getPreferredSize());
//		lblInstallmentPeriod.setPreferredSize(lblTotalAmountPaid.getPreferredSize());
        b.add(Box.createVerticalStrut(10));

        roundPanel1.setLayout(new GridBagLayout());
        // Tạo một đối tượng GridBagConstraints để cấu hình các thuộc tính căn chỉnh và kích thước của thành phần
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH; // Thành phần sẽ được mở rộng cả theo chiều ngang và chiều dọc
        constraints.weightx = 1.0; // Thành phần sẽ được co dãn theo chiều ngang
        constraints.weighty = 1.0; // Thành phần sẽ được co dãn theo chiều dọc

        roundPanel1.add(b, constraints);

        roundPanel2.setBackground(new Color(250, 250, 250));


        PanelRound tb = new PanelRound();

        String[] colHeader = { "Employee", "Customer",  "ContractNumer","ContractCode",
                "PaymentMethod","TransactionDate","Installment period", "ContractValue", "TotalAmountPaid", "WarrantyPeriod", "Vehicle","Status" };
        modelContract = new DefaultTableModel(colHeader, 0);
        tableContract = new JTable(modelContract);
        JScrollPane scrollPane1 = new JScrollPane(tableContract);
        scrollPane1.setPreferredSize(new Dimension(1000, 420));

        tb.add(scrollPane1);
        TableColumn columnEmloyee= tableContract.getColumnModel().getColumn(0);
        columnEmloyee.setPreferredWidth(150);
        TableColumn columnCustomer = tableContract.getColumnModel().getColumn(1);
        columnCustomer.setPreferredWidth(150);
        TableColumn columnContractNumer = tableContract.getColumnModel().getColumn(2);
        columnContractNumer.setPreferredWidth(100);
        TableColumn columnContractCode = tableContract.getColumnModel().getColumn(3);
        columnContractCode.setPreferredWidth(100);
        TableColumn columnPaymentMethod = tableContract.getColumnModel().getColumn(4);
        columnPaymentMethod.setPreferredWidth(100);
        TableColumn columnTransactionDate = tableContract.getColumnModel().getColumn(5);
        columnTransactionDate.setPreferredWidth(100);
        TableColumn columnInstallment = tableContract.getColumnModel().getColumn(6);
        columnInstallment.setPreferredWidth(100);
        TableColumn columnContractValue = tableContract.getColumnModel().getColumn(7);
        columnContractValue.setPreferredWidth(100);
        TableColumn columnTotalAmountPaid = tableContract.getColumnModel().getColumn(8);
        columnTotalAmountPaid.setPreferredWidth(100);
        TableColumn columnWarrantyPeriod = tableContract.getColumnModel().getColumn(9);
        columnWarrantyPeriod.setPreferredWidth(100);
        TableColumn columnVehicle = tableContract.getColumnModel().getColumn(10);
        columnVehicle.setPreferredWidth(100);
        TableColumn status = tableContract.getColumnModel().getColumn(11);
        columnVehicle.setPreferredWidth(100);
        roundPanel2.add(tb);




        bttAdd.addActionListener(this);
        bttUpdate.addActionListener(this);
        bttDelete.addActionListener(this);
        bttFind.addActionListener(this);
        bttReset.addActionListener(this);
        tableContract.addMouseListener(this);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).
//                addComponent(searchText).
        addComponent(this.roundPanel1, -1, -1, 32767).
                addComponent(this.roundPanel2, -1, -1, 32767));
        layout.setVerticalGroup(layout.
                createParallelGroup(GroupLayout.Alignment.LEADING).
                addGroup(layout.createSequentialGroup().
//                        addComponent(searchText).
        addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).
                        addComponent(this.roundPanel1, -2, -1, -2).
                        addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).
                        addComponent(this.roundPanel2, -1, -1, 32767)));


    }

    private boolean validateInput() {
        try {
            int contractNumer = Integer.parseInt(txtContractNumer.getText());
            double contractValue = Double.parseDouble(txtContractValue.getText());
            double totalAmountPaid = Double.parseDouble(txttotalAmountPaid.getText());
            int warrantyPeriod = Integer.parseInt(txtWarrantyPeriod.getText());

            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row=tableContract.getSelectedRow();
        txtEmoloyee.setText(modelContract.getValueAt(row, 0).toString());
        txtCustomer.setText(modelContract.getValueAt(row, 1).toString());
        txtContractNumer.setText(modelContract.getValueAt(row, 2).toString());
        txtContractCode.setText(modelContract.getValueAt(row, 3).toString());
        paymentMethod.setSelectedItem(modelContract.getValueAt(row, 4).toString());
        installmentPeriod.setSelectedItem(modelContract.getValueAt(row, 6).toString());
        txtContractValue.setText(modelContract.getValueAt(row, 7).toString());
        txttotalAmountPaid.setText(tableContract.getValueAt(row, 8).toString());
        txtWarrantyPeriod.setText(tableContract.getValueAt(row, 9).toString());
        txtVehicle.setText(tableContract.getValueAt(row, 10).toString());

        String dateString = modelContract.getValueAt(row, 5).toString();


        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date transactionDate = dateFormat.parse(dateString);
            date_TRansactionDate.setDate(transactionDate);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

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
        Object o = e.getSource();
        if (o.equals(bttAdd)) {
            if (validateInput()) {
                String employee = txtEmoloyee.getText();
                String customer = txtCustomer.getText();
                int contractNumer = Integer.parseInt(txtContractNumer.getText());
                String contractCode = txtContractCode.getText();
                String payment = (String) paymentMethod.getSelectedItem();
                Date transactionDate = date_TRansactionDate.getDate();
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String transactionDateString = "";
                if (transactionDate != null) {
                    transactionDateString = dateFormat.format(transactionDate);
                }
                String installment = installmentPeriod.getSelectedItem().toString();
                double contractValue = Double.parseDouble(txtContractValue.getText());
                double totalAmountPaid = Double.parseDouble(txttotalAmountPaid.getText());
                int warrantyPeriod = Integer.parseInt(txtWarrantyPeriod.getText());
                String vehicle = txtVehicle.getText();

                boolean duplicateFound = false;
                for (int i = 0; i < modelContract.getRowCount(); i++) {
                    int existingContractNumber = Integer.parseInt(modelContract.getValueAt(i, 2).toString());
                    String existingContractCode = modelContract.getValueAt(i, 3).toString();
                    if (existingContractNumber == contractNumer || existingContractCode.equals(contractCode)) {
                        duplicateFound = true;
                        break;
                    }
                }

                if (duplicateFound) {
                    JOptionPane.showMessageDialog(this, "ContractNumber or ContractCode already exists.");
                } else {
                    modelContract.addRow(new Object[] { employee, customer, contractNumer,contractCode, payment,
                            transactionDateString,installment, contractValue, totalAmountPaid, warrantyPeriod, vehicle });
                }
            } else {
                // Nếu dữ liệu không hợp lệ, hiển thị thông báo lỗi
                JOptionPane.showMessageDialog(this, "Invalid input data. Please check your inputs.");
            }
        } else if (o.equals(bttDelete)) {
            int selectedRow = tableContract.getSelectedRow();
            if (selectedRow >= 0) {
                modelContract.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a contract to delete.");
            }
        } else if (o.equals(bttFind)) {
            String searchCode = txtTim.getText();
            if (!searchCode.isEmpty()) {
                boolean contractFound = false;
                for (int i = 0; i < modelContract.getRowCount(); i++) {
                    String code = modelContract.getValueAt(i, 3).toString(); // Assuming contract code is in the third
                    // column (index 2)
                    if (code.equals(searchCode)) {
                        tableContract.setRowSelectionInterval(i, i);
                        contractFound = true;
                        break;
                    }
                }
                if (!contractFound) {
                    JOptionPane.showMessageDialog(this, "Contract not found.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a contract code to search.");
            }
        } else if (o.equals(bttReset)) {
            // Reset all JTextFields
            txtEmoloyee.setText("");
            txtCustomer.setText("");
            txtContractNumer.setText("");
            txtContractCode.setText("");
            paymentMethod.setSelectedItem("");
            txtContractValue.setText("");
            txttotalAmountPaid.setText("");
            txtWarrantyPeriod.setText("");
            txtVehicle.setText("");
            date_TRansactionDate.setDate(null);
        }
        else if (o.equals(bttUpdate)) {
            int selectedRow = tableContract.getSelectedRow();
            if (selectedRow >= 0) {
                // Lấy dữ liệu từ các JTextField
                String employee = txtEmoloyee.getText();
                String customer = txtCustomer.getText();
                String contractNumerStr = txtContractNumer.getText();
                int contractNumer = 0;
                if (!contractNumerStr.isEmpty()) {
                    contractNumer = Integer.parseInt(contractNumerStr);
                }
                String contractCode = txtContractCode.getText();
                String payment = (String) paymentMethod.getSelectedItem();
                Date transactionDate = date_TRansactionDate.getDate();
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String transactionDateString = "";
                if (transactionDate != null) {
                    transactionDateString = dateFormat.format(transactionDate);
                }
                String installment = installmentPeriod.getSelectedItem().toString();
                String contractValueStr = txtContractValue.getText();
                double contractValue = 0.0;
                if (!contractValueStr.isEmpty()) {
                    contractValue = Double.parseDouble(contractValueStr);
                }
                String totalAmountPaidStr = txttotalAmountPaid.getText();
                double totalAmountPaid = 0.0;
                if (!totalAmountPaidStr.isEmpty()) {
                    totalAmountPaid = Double.parseDouble(totalAmountPaidStr);
                }
                String warrantyPeriodStr = txtWarrantyPeriod.getText();
                int warrantyPeriod = 0;
                if (!warrantyPeriodStr.isEmpty()) {
                    warrantyPeriod = Integer.parseInt(warrantyPeriodStr);
                }
                String vehicle = txtVehicle.getText();

                // Cập nhật lại dữ liệu trong bảng
                tableContract.setValueAt(employee, selectedRow, 0);
                tableContract.setValueAt(customer, selectedRow, 1);
                tableContract.setValueAt(contractCode, selectedRow, 3);
                tableContract.setValueAt(contractNumer, selectedRow, 2);
                tableContract.setValueAt(payment, selectedRow, 4);
                tableContract.setValueAt(transactionDateString, selectedRow, 5);
                tableContract.setValueAt(installment, selectedRow, 6);
                tableContract.setValueAt(contractValue, selectedRow, 7);
                tableContract.setValueAt(totalAmountPaid, selectedRow, 8);
                tableContract.setValueAt(warrantyPeriod, selectedRow, 9);
                tableContract.setValueAt(vehicle, selectedRow, 10);

                JOptionPane.showMessageDialog(this, "Contract updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Please select a contract to update.");
            }
        }
        else if (o.equals(bttComplete)) {
            int selectedRow = tableContract.getSelectedRow();
            if (selectedRow >= 0) {
                // Update the "Status" column to "true" for the selected contract
                tableContract.setValueAt(true, selectedRow, 11); // Assuming status is the 12th column (index 11)
                JOptionPane.showMessageDialog(this, "Contract marked as complete.");
            } else {
                JOptionPane.showMessageDialog(this, "Please select a contract to mark as complete.");
            }
        }

    }
}
