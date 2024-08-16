package format.other;

import format.panel.PanelRound;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainForm extends PanelRound {

    public MainForm() {
        initComponents();
        setOpaque(false);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 20, 10, 20));
        setRoundBottomLeft(20);
        setRoundTopLeft(20);
        setRoundTopRight(20);
        setRoundBottomRight(20);
    }

    public void showForm(Component form) {
        removeAll();
        add(form);
        repaint();
        revalidate();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );
    }
}
