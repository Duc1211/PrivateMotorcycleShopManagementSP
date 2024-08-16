package ui.home;


import format.chart.CurveChart;

import format.button.Button;
import entity.Employee;

import format.panel.PanelRound;


import model.ChartModel;
import model.NameModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormDemo extends JPanel {
//
//
//    private JScrollPane jScrollPane1;
//    private Table table1;
//    private PanelRound roundPanel1;
//    private PanelRound roundPanel2;
//    private CurveChart chart;
//    private Button btnAddNew;
//
//
//    public FormDemo() {
//        initComponents();
//        setOpaque(false);
//        table1.addTableStyle(this.jScrollPane1);
//        init();
//        initDataTable();
//    }
//    private void init() {
//        chart.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
//        chart.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
//        chart.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
////        try {
////            List<ChartModel> datas = new ServiceReport().getData();
////            for (int i = datas.size() - 1; i >= 0; i--) {
////                chart.addData(datas.get(i));
////            }
////            chart.start();
////        } catch (SQLException e) {
////            System.err.println(e);
////        }
//
//
//        List<ChartModel> list = new ArrayList<>();
//        list.add(new ChartModel("2021-01-01", new double[]{424.00, 24.00, 400.00}));
//        list.add(new ChartModel("2021-01-02", new double[]{221.00, 15.00, 206.00}));
//        list.add(new ChartModel("2021-01-03", new double[]{457.00, 8.00, 449.00}));
//        list.add(new ChartModel("2021-01-04", new double[]{209.00, 8.00, 201.00}));
//        list.add(new ChartModel("2021-01-05", new double[]{286.00, 8.00, 278.00}));
//        list.add(new ChartModel("2021-01-06", new double[]{202.00, 3.00, 199.00}));
//        list.add(new ChartModel("2021-01-07", new double[]{412.00, 23.00, 389.00}));
//        list.add(new ChartModel("2021-01-08", new double[]{78.00, 16.00, 62.00}));
//        list.add(new ChartModel("2021-01-09", new double[]{120.00, 6.00, 114.00}));
//        list.add(new ChartModel("2021-01-10", new double[]{480.00, 8.00, 472.00}));
//        list.add(new ChartModel("2021-02-01", new double[]{258.00, 3.00, 255.00}));
//        list.add(new ChartModel("2021-02-02", new double[]{197.00, 13.00, 184.00}));
//        list.add(new ChartModel("2021-02-03", new double[]{145.00, 16.00, 129.00}));
//        list.add(new ChartModel("2021-02-04", new double[]{182.00, 2.00, 180.00}));
//        list.add(new ChartModel("2021-02-05", new double[]{398.00, 20.00, 378.00}));
//        list.add(new ChartModel("2021-02-06", new double[]{331.00, 6.00, 325.00}));
//        list.add(new ChartModel("2021-02-07", new double[]{30.00, 19.00, 11.00}));
//        list.add(new ChartModel("2021-02-08", new double[]{153.00, 4.00, 149.00}));
//        list.add(new ChartModel("2021-02-09", new double[]{354.00, 9.00, 345.00}));
//        list.add(new ChartModel("2021-02-10", new double[]{425.00, 0.00, 425.00}));
//        list.add(new ChartModel("2021-03-01", new double[]{134.00, 8.00, 126.00}));
//        list.add(new ChartModel("2021-03-02", new double[]{189.00, 27.00, 162.00}));
//        list.add(new ChartModel("2021-03-03", new double[]{498.00, 10.00, 488.00}));
//        list.add(new ChartModel("2021-03-04", new double[]{400.00, 22.00, 378.00}));
//        list.add(new ChartModel("2021-03-05", new double[]{255.00, 6.00, 249.00}));
//        list.add(new ChartModel("2021-03-06", new double[]{470.00, 6.00, 464.00}));
//        list.add(new ChartModel("2021-03-07", new double[]{417.00, 26.00, 391.00}));
//        list.add(new ChartModel("2021-03-08", new double[]{242.00, 29.00, 213.00}));
//        list.add(new ChartModel("2021-03-09", new double[]{107.00, 0.00, 107.00}));
//        list.add(new ChartModel("2021-03-10", new double[]{363.00, 0.00, 363.00}));
//        list.add(new ChartModel("2021-04-01", new double[]{339.00, 8.00, 331.00}));
//        list.add(new ChartModel("2021-04-02", new double[]{370.00, 6.00, 364.00}));
//        list.add(new ChartModel("2021-04-04", new double[]{202.00, 25.00, 177.00}));
//        list.add(new ChartModel("2021-04-05", new double[]{345.00, 12.00, 333.00}));
//        list.add(new ChartModel("2021-04-06", new double[]{143.00, 23.00, 120.00}));
//        list.add(new ChartModel("2021-04-07", new double[]{383.00, 26.00, 357.00}));
//        list.add(new ChartModel("2021-04-08", new double[]{141.00, 15.00, 126.00}));
//        list.add(new ChartModel("2021-04-09", new double[]{470.00, 0.00, 470.00}));
//        list.add(new ChartModel("2021-05-01", new double[]{6.00, 29.00, -23.00}));
//        list.add(new ChartModel("2021-05-02", new double[]{58.00, 16.00, 42.00}));
//        list.add(new ChartModel("2021-04-10", new double[]{109.00, 11.00, 98.00}));
//        list.add(new ChartModel("2021-05-03", new double[]{265.00, 25.00, 240.00}));
//        list.add(new ChartModel("2021-05-04", new double[]{194.00, 6.00, 188.00}));
//        list.add(new ChartModel("2021-05-05", new double[]{34.00, 7.00, 27.00}));
//        list.add(new ChartModel("2021-05-06", new double[]{256.00, 25.00, 231.00}));
//        list.add(new ChartModel("2021-05-07", new double[]{452.00, 19.00, 433.00}));
//        list.add(new ChartModel("2021-05-08", new double[]{70.00, 28.00, 42.00}));
//        list.add(new ChartModel("2021-05-09", new double[]{297.00, 1.00, 296.00}));
//        list.add(new ChartModel("2021-05-10", new double[]{231.00, 16.00, 215.00}));
//        list.add(new ChartModel("2021-06-01", new double[]{402.00, 11.00, 391.00}));
//        list.add(new ChartModel("2021-06-02", new double[]{119.00, 21.00, 98.00}));
//        list.add(new ChartModel("2021-06-03", new double[]{5000.00, 14.00, 262.00}));
//        list.add(new ChartModel("2021-06-04", new double[]{5000.00, 5.00, 107.00}));
//        list.add(new ChartModel("2021-06-05", new double[]{341.00, 6.00, 335.00}));
//        list.add(new ChartModel("2021-06-06", new double[]{177.00, 2.00, 175.00}));
//        list.add(new ChartModel("2021-06-07", new double[]{285.00, 17.00, 268.00}));
//        list.add(new ChartModel("2021-06-08", new double[]{150.00, 12.00, 138.00}));
//        list.add(new ChartModel("2021-06-09", new double[]{189.00, 27.00, 162.00}));
//        list.add(new ChartModel("2021-06-10", new double[]{490.00, 13.00, 477.00}));
//        list.add(new ChartModel("2021-07-01", new double[]{5.00, 11.00, 162.00}));
//        list.add(new ChartModel("2021-07-02", new double[]{6.00, 3.00, 354.00}));
//        list.add(new ChartModel("2021-07-03", new double[]{5000.00, 10.00, 144.00}));
//        list.add(new ChartModel("2021-07-04", new double[]{5.00, 0.00, 222.00}));
//        list.add(new ChartModel("2021-07-05", new double[]{5.00, 9000.00, 169.00}));
//        list.add(new ChartModel("2021-07-06", new double[]{98.00, 16.00, 82.00}));
//        list.add(new ChartModel("2021-07-07", new double[]{149.00, 29.00, 120.00}));
//        list.add(new ChartModel("2021-07-08", new double[]{495.00, 16.00, 5000.00}));
//        list.add(new ChartModel("2021-07-09", new double[]{215.00, 2.00, 700.00}));
//        list.add(new ChartModel("2021-07-10", new double[]{492.00, 15.00, 700.00}));
//        list.add(new ChartModel("2021-08-01", new double[]{384.00, 25.00, 0.00}));
//        list.add(new ChartModel("2021-08-02", new double[]{318.00, 16.00, 0.00}));
//        list.add(new ChartModel("2021-08-03", new double[]{95.00, 6.00, 0.00}));
//        list.add(new ChartModel("2021-08-04", new double[]{464.00, 24.00, 0.00}));
//        list.add(new ChartModel("2021-08-05", new double[]{1000.00, 16.00, 0.00}));
//        list.add(new ChartModel("2021-08-06", new double[]{276.00, 13.00, 0.00}));
//        list.add(new ChartModel("2021-08-07", new double[]{381.00, 24.00, 100.00}));
//        list.add(new ChartModel("2021-08-08", new double[]{305.00, 20.00, 100.00}));
//        list.add(new ChartModel("2021-08-09", new double[]{110.00, 23.00, 100.00}));
//        list.add(new ChartModel("2021-09-04", new double[]{325.00, 19.00, 0.00}));
//        list.add(new ChartModel("2021-09-05", new double[]{124.00, 300.00, 0.00}));
//        list.add(new ChartModel("2021-09-06", new double[]{377.00, 300.00, 371.00}));
//        list.add(new ChartModel("2021-09-07", new double[]{69.00, 300.00, 55.00}));
//        list.add(new ChartModel("2021-09-08", new double[]{342.00, 300.00, 331.00}));
//        list.add(new ChartModel("2021-09-09", new double[]{73.00, 13.00, 60.00}));
//        list.add(new ChartModel("2021-09-10", new double[]{245.00, 27.00, 218.00}));
//        list.add(new ChartModel("2021-10-01", new double[]{132.00, 17.00, 115.00}));
//        list.add(new ChartModel("2021-10-02", new double[]{6000.00, 0.00, 415.00}));
//        list.add(new ChartModel("2021-10-03", new double[]{261.00, 25.00, 236.00}));
//        list.add(new ChartModel("2021-10-04", new double[]{341.00, 200.00, 340.00}));
//        list.add(new ChartModel("2021-10-06", new double[]{442.00, 200.00, 418.00}));
//        list.add(new ChartModel("2021-10-07", new double[]{176.00, 200.00, 0.00}));
//        list.add(new ChartModel("2021-10-08", new double[]{496.00, 25.00, 471.00}));
//        list.add(new ChartModel("2021-10-09", new double[]{150.00, 29.00, 121.00}));
//        list.add(new ChartModel("2021-10-10", new double[]{48.00, 1000.00, 19.00}));
//        list.add(new ChartModel("2021-11-01", new double[]{17.00, 1000.00, -6.00}));
//        list.add(new ChartModel("2021-11-02", new double[]{221.00, 1000.00, 199.00}));
//        list.add(new ChartModel("2021-11-03", new double[]{453.00, 1000.00, 449.00}));
//        list.add(new ChartModel("2021-11-04", new double[]{300.00, 1000.00, 275.00}));
//        list.add(new ChartModel("2021-11-05", new double[]{383.00, 12.00, 371.00}));
//        list.add(new ChartModel("2021-11-06", new double[]{232.00, 25.00, 207.00}));
//        list.add(new ChartModel("2021-11-07", new double[]{400.00, 17.00, 231.00}));
//        list.add(new ChartModel("2021-11-08", new double[]{400.00, 25.00, 227.00}));
//        list.add(new ChartModel("2021-11-09", new double[]{400.00, 8.00, 278.00}));
//        list.add(new ChartModel("2021-11-10", new double[]{1000.00, 16.00, 425.00}));
//        list.add(new ChartModel("2021-12-01", new double[]{1000.00, 15.00, 0.00}));
//        list.add(new ChartModel("2021-12-02", new double[]{1000.00, 10.00, 173.00}));
//        list.add(new ChartModel("2021-12-03", new double[]{1000.00, 0.00, 118.00}));
//        list.add(new ChartModel("2021-12-04", new double[]{1000.00, 18.00, 67.00}));
//        list.add(new ChartModel("2021-12-05", new double[]{1000.00, 1.00, 50.00}));
//        list.add(new ChartModel("2021-12-06", new double[]{289.00, 5.00, 50.00}));
//        list.add(new ChartModel("2021-12-07", new double[]{115.00, 18.00, 50.00}));
//        list.add(new ChartModel("2021-12-08", new double[]{18.00, 7.00, 50.00}));
//        list.add(new ChartModel("2021-12-09", new double[]{9.00, 26.00, 50.00}));
//        list.add(new ChartModel("2021-12-10", new double[]{432.00, 19.00, 500.00}));
//        for (int i = list.size() - 1; i >= 0; i--) {
//            chart.addData(list.get(i));
//        }
//        chart.start();
//    }
//
//    @SuppressWarnings("unchecked")
//    private void initDataTable() {
//
////        table1.addTableCell(new CellCode(), 0);
////        table1.addTableCell(new CellAvatar(), 1);
////        table1.addTableCell(new CellId(), 2);
////        table1.addTableCell(new CellBirthday(), 3);
////        table1.addTableCell(new CellSex(), 4);
////        table1.addTableCell(new CellLocation(), 5);
////        table1.addTableCell(new CellPhone(), 6);
////        table1.addTableCell(new CellPosition(), 7);
////        table1.addTableCell(new CellSalary(), 8);
////        table1.addTableCell(new CellDate(), 9);
////        table1.addTableCell(new CellStatus(), 10);
////        table1.addTableCell(new CellAction(), 11);
//        table1.addRow(new Employee("NV001", new NameModel("Ra Ven", new ImageIcon(getClass().getClassLoader().getResource("source/Image/avatar/avtnu.png")), ""), "1234567891",  LocalDate.of(2002,11,12), true,"NewYork", "0876040304", "Director", 3000, LocalDate.of(2024, 01, 01), "Working"), false);  //  ture is animate row
//        table1.addRow(new Employee("NV001", new NameModel("Ra Ven", new ImageIcon(getClass().getClassLoader().getResource("source/Image/avatar/avtnu.png")), ""), "1234567891",  LocalDate.of(2002,11,12), true,"NewYork", "0876040304", "Director", 3000, LocalDate.of(2024, 01, 01), "Rest"), false);  //  ture is animate row
////        (new Thread(new Runnable() {
////            public void run() {
////                try {
////                    Iterator var1 = (new ServiceStaff()).getStaff().iterator();
////
////                    while(var1.hasNext()) {
////                        ModelStaff staff = (ModelStaff)var1.next();
////                        FormDemo.this.table1.addRow(staff, false);
////                    }
////                } catch (SQLException var3) {
////                    System.err.println(var3);
////                }
////            }
////        })).start();
//    }
//
//    private void initComponents() {
//        roundPanel1 = new PanelRound();
//        chart = new CurveChart();
//        roundPanel2 = new PanelRound();
//        jScrollPane1 = new JScrollPane();
//        table1 = new Table();
//        btnAddNew = new Button();
//        this.roundPanel1.setBackground(new Color(250, 250, 250));
//        GroupLayout roundPanel1Layout = new GroupLayout(this.roundPanel1);
//        roundPanel1.setLayout(roundPanel1Layout);
//        roundPanel1Layout.setHorizontalGroup(roundPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(roundPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.chart, -1, 928, 32767).addContainerGap()));
//        roundPanel1Layout.setVerticalGroup(roundPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(roundPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.chart, -1, 278, 32767).addContainerGap()));
//        roundPanel2.setBackground(new Color(250, 250, 250));
//        table1.setModel(new DefaultTableModel(
//                new Object [][] {
//
//                },
//                new String [] {
//                        "Code", "Name", "Citizent Number", "Birthday", "Sex", "Location",
//                        "Phone Number", "Position", "Salary", "Date Start", "Status", "Action"
//                }
//        ));
//        jScrollPane1.setViewportView(table1);
//        if (table1.getColumnModel().getColumnCount() > 0) {
//            table1.getColumnModel().getColumn(0).setMinWidth(75);
//            table1.getColumnModel().getColumn(1).setPreferredWidth(200);
//            table1.getColumnModel().getColumn(2).setMinWidth(75);
//            table1.getColumnModel().getColumn(3).setPreferredWidth(50);
//            table1.getColumnModel().getColumn(4).setPreferredWidth(30);
//            table1.getColumnModel().getColumn(5).setMinWidth(75);
//            table1.getColumnModel().getColumn(5).setPreferredWidth(75);
//            table1.getColumnModel().getColumn(5).setMaxWidth(75);
//            table1.getColumnModel().getColumn(6).setMinWidth(75);
//            table1.getColumnModel().getColumn(7).setMinWidth(100);
//            table1.getColumnModel().getColumn(8).setMinWidth(50);
//            table1.getColumnModel().getColumn(9).setMinWidth(50);
//            table1.getColumnModel().getColumn(10).setMinWidth(50);
//            table1.getColumnModel().getColumn(11).setMinWidth(75);
//            table1.getColumnModel().getColumn(11).setPreferredWidth(75);
//            table1.getColumnModel().getColumn(11).setMaxWidth(75);
//
//        }
//
//
//        btnAddNew.setForeground(new Color(200, 200, 200));
//        btnAddNew.setText("+ Add New");
//        btnAddNew.setFont(new Font("sansserif", 1, 12));
//        btnAddNew.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                FormDemo.this.btnAddNewActionPerformed(evt);
//            }
//        });
//        GroupLayout roundPanel2Layout = new GroupLayout(roundPanel2);
//        this.roundPanel2.setLayout(roundPanel2Layout);
//        roundPanel2Layout.setHorizontalGroup(roundPanel2Layout.
//                createParallelGroup(GroupLayout.Alignment.LEADING).
//                addGroup(roundPanel2Layout.createSequentialGroup().
//                        addContainerGap().addGroup(roundPanel2Layout.
//                                createParallelGroup(GroupLayout.Alignment.LEADING).
//                                addComponent(jScrollPane1).
//                                addGroup(roundPanel2Layout.
//                                        createSequentialGroup().
//                                        addComponent(btnAddNew, -2, -1, -2).
//                                        addGap(0, 0, 32767))).
//                        addContainerGap()));
//        roundPanel2Layout.setVerticalGroup(roundPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).
//                addGroup(GroupLayout.Alignment.TRAILING, roundPanel2Layout.
//                        createSequentialGroup().
//                        addContainerGap().
//                        addComponent(btnAddNew, -2, -1, -2).
//                        addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).
//                        addComponent(jScrollPane1, -1, 266, 32767).
//                        addContainerGap()));
//        GroupLayout layout = new GroupLayout(this);
//        this.setLayout(layout);
//        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).
//                addComponent(this.roundPanel1, -1, -1, 32767).
//                addComponent(this.roundPanel2, -1, -1, 32767));
//        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).
//                addGroup(layout.createSequentialGroup().addComponent(this.roundPanel1, -2, -1, -2).
//                        addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).
//                        addComponent(this.roundPanel2, -1, -1, 32767)));
//    }
//
//    private void btnAddNewActionPerformed(ActionEvent evt) {
//        this.table1.insertRowWithEdit(new Employee(" ", new NameModel( "", (Icon)null, "")," ",LocalDate.of(0000, 00, 00),true," "," "," ", 0, LocalDate.of(0000, 00, 00), " "), 0, true);
//    }
}
