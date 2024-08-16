package ui.analysis;

import format.panel.PanelRound;

import javax.swing.*;
import java.awt.*;

public class FormRevenueAnalysis extends PanelRound {
    private JLabel lbl1;

    public FormRevenueAnalysis() {
        initComponents();
        lbl1.setText("Form Revenue Analysis");
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lbl1 = new JLabel();

        lbl1.setFont(new Font("sansserif", 1, 48));
        lbl1.setForeground(new Color(198, 198, 198));
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl1, GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl1, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }
}
