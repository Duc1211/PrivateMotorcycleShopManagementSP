package format.other;


import javax.swing.*;
import java.awt.*;

public class Profile extends JPanel {
    private JLabel label;

    public Profile() {
        initComponents();
        setOpaque(false);
    }


    private void initComponents() {

        label = new JLabel();

        label.setFont(new Font("sansserif", 1, 24)); // NOI18N
        label.setForeground(new Color(224, 224, 224));
        label.setIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/logo.png"))); // NOI18N
        label.setText(" Funny Store");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(label, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }


}
