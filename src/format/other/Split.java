package format.other;


import format.table.LabelSplit;

import javax.swing.*;
import java.awt.*;

public class Split extends JPanel {
    private JLabel label;
    private LabelSplit labelSplite1;
    private LabelSplit labelSplite2;

    public Split(String name) {
        this.initComponents();
        this.label.setText(name);
        this.setOpaque(false);
    }

    private void initComponents() {
        this.labelSplite1 = new LabelSplit();
        this.label = new JLabel();
        this.labelSplite2 = new LabelSplit();
        this.label.setForeground(new Color(115, 115, 115));
        this.label.setText("Name");
        this.labelSplite2.setGradiet(true);
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.labelSplite1, -2, 15, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.label).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.labelSplite2, -1, 71, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.labelSplite1, -1, 15, 32767).addComponent(this.label, -2, 0, 32767).addComponent(this.labelSplite2, -1, -1, 32767)).addGap(0, 0, 0)));
    }
}
