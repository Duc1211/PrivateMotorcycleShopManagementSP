package format.chart;


import model.LegendModel;

import javax.swing.*;

public class LegendItem extends JPanel {
    private LabelColor lblColor;
    private JLabel lblName;

    public LegendItem(LegendModel data) {
        initComponents();
        setOpaque(false);
        lblColor.setBackground(data.getColor());
        lblName.setText(data.getName());
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        lblColor = new LabelColor();
        lblName = new JLabel();

        lblColor.setText("labelColor1");

        lblName.setForeground(new java.awt.Color(180, 180, 180));
        lblName.setText("Name");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblColor, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblName)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblName)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(lblColor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }



}
