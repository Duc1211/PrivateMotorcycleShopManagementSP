package ui.contract;

import format.panel.PanelRound;

import javax.swing.*;
import java.awt.*;

public class FormContractInProgress extends PanelRound {
    private JLabel lbl1;

    public FormContractInProgress() {
        initComponents();
        lbl1.setText("Form Contract In Progress");
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
