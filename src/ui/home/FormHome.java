package ui.home;

import javax.swing.*;
import java.awt.*;


public class FormHome extends JPanel {
    private JLabel jLabel1;
        public FormHome() {
            initComponents();
        }
        @SuppressWarnings("unchecked")

        private void initComponents() {

            jLabel1 = new JLabel();

            setBackground(new Color(0, 0, 0));

            jLabel1.setFont(new Font("sansserif", 0, 36)); // NOI18N
            jLabel1.setForeground(new Color(106, 106, 106));
            jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
            jLabel1.setText("");
            jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/desktop/desktop-wallpaper-monster-energy-moto-kawasaki-side-green-neon-live-colors-bike-kawasaki-logo.png")));

            GroupLayout layout = new GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                                    .addContainerGap())
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(128, 128, 128)
                                    .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(125, 125, 125))
            );
        }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Vẽ hình ảnh đầy đủ kích thước trong JPanel
        if (jLabel1 != null && jLabel1.getIcon() != null) {
            ImageIcon icon = (ImageIcon) jLabel1.getIcon();
            Image img = icon.getImage();
            int imgWidth = img.getWidth(this);
            int imgHeight = img.getHeight(this);

            if (imgWidth > 0 && imgHeight > 0) {
                int x = (getWidth() - imgWidth) / 2;
                int y = (getHeight() - imgHeight) / 2;
                g.drawImage(img, x, y, imgWidth, imgHeight, this);
            }
        }
    }



}
