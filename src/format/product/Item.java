package format.product;

import entity.Vehicle;
import format.panel.PanelRound;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class Item extends PanelRound {
    private JLabel lblCompany, lblPrice;
    private JLabel lblName, lblColor;
    private CustomProductItem pic;
    private Vehicle data;

    private boolean selected;
    public Vehicle getData() {
        return data;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }



    public Item() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }



    public void setData(Vehicle data) {
        this.data = data;
        ImageIcon image  =new ImageIcon(data.getVehicleImage());
        pic.setImage(image);
        lblName.setText(data.getVehicleName());
        lblColor.setText(data.getVehicleColor());
        lblCompany.setText(data.getVehicleCompany().getVehicleCompanyName());
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        lblPrice.setText(df.format(data.getVehiclePrice()));
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(242, 242, 242));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        if (selected) {
            g2.setColor(new Color(94, 156, 255));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        }
        g2.dispose();
        super.paint(grphcs);
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        lblName = new JLabel();
        lblColor = new JLabel();
        pic = new CustomProductItem();
        lblPrice = new JLabel();
        lblCompany = new JLabel();

        lblName.setFont(new Font("sansserif", 1, 18)); // NOI18N
        lblName.setForeground(new Color(76, 76, 76));
        lblName.setText("Name");

        lblColor.setFont(new Font("sansserif", 1, 14)); // NOI18N
        lblColor.setForeground(new Color(178, 178, 178));
        lblColor.setText("Color");

        pic.setImage(new ImageIcon(getClass().getClassLoader().getResource("source/Image/product/Honda/honda_cbr150r.png"))); // NOI18N

        lblPrice.setFont(new Font("sansserif", 1, 18)); // NOI18N
        lblPrice.setForeground(new Color(76, 76, 76));
        lblPrice.setText("$0.00");

        lblCompany.setFont(new Font("sansserif", 1, 12)); // NOI18N
        lblCompany.setForeground(new Color(76, 76, 76));
        lblCompany.setText("Company");

        GroupLayout layout = new GroupLayout(this);
        this.setRoundTopLeft(15);
        this.setRoundTopRight(15);
        this.setRoundBottomLeft(15);
        this.setRoundBottomRight(15);
        this.setBackground(new Color(0xC0EED6));
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(pic, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lblCompany)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(lblPrice))
                                                        .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblColor, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))))
                                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblName)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblColor)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pic, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblPrice)
                                        .addComponent(lblCompany))
                                .addGap(20, 20, 20))
        );
    }


}
