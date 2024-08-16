package format.other;

import model.CardModel;

import javax.swing.*;
import java.awt.*;

public class Card extends JPanel {
    private JLabel lblDescription, lblIcon, lblTitle, lblValue;
    private Color color1,color2;

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }



    public Card() {
        initComponents();
        setOpaque(false);
        color1 = Color.BLACK;
        color2 = Color.WHITE;
    }

    public void setData(CardModel data) {
        lblIcon.setIcon(data.getIcon());
        lblTitle.setText(data.getTitle());
        lblValue.setText(data.getValue());
        lblDescription.setText(data.getDescription());
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        lblIcon = new JLabel();
        lblTitle = new JLabel();
        lblValue = new JLabel();
        lblDescription = new JLabel();

        lblIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/owner.png"))); // NOI18N

        lblTitle.setFont(new Font("sansserif", 1, 24)); // NOI18N
        lblTitle.setForeground(new Color(255, 255, 255));
        lblTitle.setText("Title");

        lblValue.setFont(new Font("sansserif", 1, 18)); // NOI18N
        lblValue.setForeground(new Color(255, 255, 255));
        lblValue.setText("Values");

        lblDescription.setFont(new Font("sansserif", 0, 14)); // NOI18N
        lblDescription.setForeground(new Color(255, 255, 255));
        lblDescription.setText("Description");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblDescription)
                                        .addComponent(lblValue)
                                        .addComponent(lblTitle)
                                        .addComponent(lblIcon))
                                .addContainerGap(283, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(lblIcon)
                                .addGap(24, 24, 24)
                                .addComponent(lblTitle)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblValue)
                                .addGap(10, 10, 10)
                                .addComponent(lblDescription)
                                .addContainerGap(25, Short.MAX_VALUE))
        );
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(new Color(255, 255, 255, 50));
        g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
        g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
        super.paintComponent(grphcs);
    }

}
