package ui.analysis;
import format.chart.Chart;
import format.chart.LineChart;
import format.panel.PanelRound;
import format.progress.Progress;
import model.ChartModel;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
public class FormAnalysis extends JPanel {
    private Chart chart;
    private JLabel lbl1, lbl2 , lbl3, lbl4;
    private JPanel p1, p2, p3;
    private LineChart lineChart;
    private Progress progress1;
    private Progress progress2;
    private Progress progress3;
    private PanelRound roundPanel1, roundPanel2, roundPanel3;


        public FormAnalysis() {
            initComponents();
            setOpaque(false);
            init();
        }

        private void init() {
            chart.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
            chart.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
            chart.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
            chart.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
//            chart.addData(new ChartModel("January", new double[]{500, 200, 80, 89}));
            chart.addData(new ChartModel("January", new double[]{500, 200, 80, 89}));
            chart.addData(new ChartModel("February", new double[]{600, 750, 90, 150}));
            chart.addData(new ChartModel("March", new double[]{200, 350, 460, 900}));
            chart.addData(new ChartModel("April", new double[]{480, 150, 750, 700}));
            chart.addData(new ChartModel("May", new double[]{350, 540, 300, 150}));
            chart.addData(new ChartModel("June", new double[]{190, 280, 81, 200}));
            chart.start();
            lineChart.addLegend("Income", new Color(12, 84, 175), new Color(0, 108, 247));
            lineChart.addLegend("Expense", new Color(54, 4, 143), new Color(104, 49, 200));
            lineChart.addLegend("Profit", new Color(5, 125, 0), new Color(95, 209, 69));
            lineChart.addLegend("Cost", new Color(186, 37, 37), new Color(241, 100, 120));
            lineChart.addData(new ChartModel("January", new double[]{500, 200, 80, 89}));
            lineChart.addData(new ChartModel("February", new double[]{600, 750, 90, 150}));
            lineChart.addData(new ChartModel("March", new double[]{200, 350, 460, 900}));
            lineChart.addData(new ChartModel("April", new double[]{480, 150, 750, 700}));
            lineChart.addData(new ChartModel("May", new double[]{350, 540, 300, 150}));
            lineChart.addData(new ChartModel("June", new double[]{190, 280, 81, 200}));
            lineChart.start();
            progress1.start();
            progress2.start();
            progress3.start();
        }

        @SuppressWarnings("unchecked")

        private void initComponents() {

            roundPanel1 = new PanelRound();
            p1 = new JPanel();
            progress1 = new Progress();
            lbl1 = new JLabel();
            lbl2 = new JLabel();
            p2 = new JPanel();
            progress2 = new Progress();
            lbl3 = new JLabel();
            p3 = new JPanel();
            progress3 = new Progress();
            lbl4 = new JLabel();
            roundPanel2 = new PanelRound();
            chart = new Chart();
            roundPanel3 = new PanelRound();
            lineChart = new LineChart();

            roundPanel1.setBackground(new Color(255, 255, 255));

            p1.setOpaque(false);

            progress1.setBackground(new Color(66, 246, 84));
            progress1.setForeground(new Color(19, 153, 32));
            progress1.setValue(60);

            lbl1.setFont(new Font("sansserif", 0, 14)); // NOI18N
            lbl1.setForeground(new Color(220, 220, 220));
            lbl1.setHorizontalAlignment(SwingConstants.CENTER);
            lbl1.setText("Total Income Sold");

            GroupLayout jPanel1Layout = new GroupLayout(p1);
            p1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(progress1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbl1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lbl1)
                                    .addGap(18, 18, 18)
                                    .addComponent(progress1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
            );

            lbl2.setFont(new Font("sansserif", 1, 15)); // NOI18N
            lbl2.setForeground(new Color(220, 220, 220));
            lbl2.setText("Report Monthly");
            lbl2.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));

            lbl2.setOpaque(false);

            progress2.setBackground(new Color(132, 66, 246));
            progress2.setForeground(new Color(64, 18, 153));
            progress2.setValue(70);

            lbl3.setFont(new Font("sansserif", 0, 14)); // NOI18N
            lbl3.setForeground(new Color(220, 220, 220));
            lbl3.setHorizontalAlignment(SwingConstants.CENTER);
            lbl3.setText("Total Income Profit");

            GroupLayout jPanel2Layout = new GroupLayout(p2);
            p2.setLayout(jPanel2Layout);
            p2.setBackground(new Color(255,255,255));
            jPanel2Layout.setHorizontalGroup(
                    jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(progress2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbl3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap())
            );
            jPanel2Layout.setVerticalGroup(
                    jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lbl3)
                                    .addGap(18, 18, 18)
                                    .addComponent(progress2, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
            );

            p3.setOpaque(false);

            progress3.setBackground(new Color(66, 193, 246));
            progress3.setForeground(new Color(26, 132, 181));
            progress3.setValue(85);

            lbl4.setFont(new Font("sansserif", 0, 14)); // NOI18N
            lbl4.setForeground(new Color(220, 220, 220));
            lbl4.setHorizontalAlignment(SwingConstants.CENTER);
            lbl4.setText("Total Expense");

            GroupLayout jPanel3Layout = new GroupLayout(p3);
            p3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                    jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(progress3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbl4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap())
            );
            jPanel3Layout.setVerticalGroup(
                    jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lbl4)
                                    .addGap(18, 18, 18)
                                    .addComponent(progress3, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
            );

            GroupLayout roundPanel1Layout = new GroupLayout(roundPanel1);
            roundPanel1.setLayout(roundPanel1Layout);
            roundPanel1Layout.setHorizontalGroup(
                    roundPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(roundPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                                    .addComponent(p1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(p2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(p3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(lbl2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap())
            );
            roundPanel1Layout.setVerticalGroup(
                    roundPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lbl2)
                                    .addGap(20, 20, 20)
                                    .addGroup(roundPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(p1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(p2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(p3, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap())
            );

            roundPanel2.setBackground(new Color(255, 255, 255));

            GroupLayout roundPanel2Layout = new GroupLayout(roundPanel2);
            roundPanel2.setLayout(roundPanel2Layout);
            roundPanel2Layout.setHorizontalGroup(
                    roundPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(chart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addContainerGap())
            );
            roundPanel2Layout.setVerticalGroup(
                    roundPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(chart, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                                    .addContainerGap())
            );

            roundPanel3.setBackground(new Color(255, 255, 255));

            GroupLayout roundPanel3Layout = new GroupLayout(roundPanel3);
            roundPanel3.setLayout(roundPanel3Layout);
            roundPanel3Layout.setHorizontalGroup(
                    roundPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lineChart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addContainerGap())
            );
            roundPanel3Layout.setVerticalGroup(
                    roundPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lineChart, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addContainerGap())
            );

            GroupLayout layout = new GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(roundPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(roundPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(roundPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(roundPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(roundPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(10, 10, 10)
                                    .addComponent(roundPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }
    }


