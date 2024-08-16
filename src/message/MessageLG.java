package message;


import java.awt.*;
import javax.swing.*;

public class MessageLG extends JPanel {
    private JLabel lblMessage;
    private MessageType messageType = MessageType.SUCCESS;
    private boolean show;

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }


    public MessageLG() {
        initComponents();
        setOpaque(false);
        setVisible(false);
    }

    public void showMessage(MessageType messageType, String message) {
        this.messageType = messageType;
        lblMessage.setText(message);
        if (messageType == MessageType.SUCCESS) {
            lblMessage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/success.png")));
        } else {
            lblMessage.setIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/error.png")));
        }
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        lblMessage = new JLabel();

        lblMessage.setFont(new Font("sansserif", 0, 14)); // NOI18N
        lblMessage.setForeground(new Color(248, 248, 248));
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
        lblMessage.setText("Message");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblMessage, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblMessage, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        if (messageType == MessageType.SUCCESS) {
            g2.setColor(new Color(15, 174, 37));
        } else {
            g2.setColor(new Color(240, 52, 53));
        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setComposite(AlphaComposite.SrcOver);
        g2.setColor(new Color(245, 245, 245));
        g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        super.paintComponent(grphcs);
    }

    public static enum MessageType {
        SUCCESS, ERROR
    }

}