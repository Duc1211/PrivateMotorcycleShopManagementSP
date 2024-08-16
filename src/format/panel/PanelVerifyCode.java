package format.panel;

import format.button.ButtonOutLine;
import format.textfield.MyTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class PanelVerifyCode extends JPanel {
    private ButtonOutLine btnCancel;
    private ButtonOutLine btnOK;
    private JLabel lbl1, lbl2;
    private PanelRound pRound1;
    private MyTextField txtCode;

    public PanelVerifyCode() {
        initComponents();
        setOpaque(false);
        setFocusCycleRoot(true);
        super.setVisible(false);
        addMouseListener(new MouseAdapter() {
        });
    }

    @Override
    public void setVisible(boolean bln) {
        super.setVisible(bln);
        if (bln) {
            txtCode.grabFocus();
            txtCode.setText("");
        }
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        pRound1 = new PanelRound();
        txtCode = new MyTextField();
        lbl1 = new JLabel();
        lbl2 = new JLabel();
        btnOK = new ButtonOutLine();
        btnCancel = new ButtonOutLine();

        txtCode.setHorizontalAlignment(JTextField.CENTER);

        lbl1.setFont(new Font("sansserif", 1, 24)); // NOI18N
        lbl1.setForeground(new Color(63, 63, 63));
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl1.setText("Verify Code");

        lbl2.setForeground(new Color(63, 63, 63));
        lbl2.setHorizontalAlignment(SwingConstants.CENTER);
        lbl2.setText("Check your mail to get verify code");

        btnOK.setBackground(new Color(18, 138, 62));
        btnOK.setText("OK");

        btnCancel.setBackground(new Color(192, 25, 25));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        GroupLayout pRound1Layout = new GroupLayout(pRound1);
        pRound1.setLayout(pRound1Layout);
        pRound1Layout.setHorizontalGroup(
                pRound1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pRound1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(pRound1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(pRound1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtCode, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lbl1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lbl2, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                                        .addGroup(pRound1Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(btnOK, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
                                .addGap(100, 100, 100))
        );
        pRound1Layout.setVerticalGroup(
                pRound1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, pRound1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lbl1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(pRound1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnOK, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(50, Short.MAX_VALUE)
                                .addComponent(pRound1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(50, Short.MAX_VALUE)
                                .addComponent(pRound1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(50, Short.MAX_VALUE))
        );
    }

    private void btnCancelActionPerformed(ActionEvent evt) {
        setVisible(false);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setColor(new Color(50, 50, 50));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setComposite(AlphaComposite.SrcOver);
        super.paintComponent(grphcs);
    }

    public String getInputCode() {
        return txtCode.getText().trim();
    }

    public void addEventButtonOK(ActionListener event) {
        btnOK.addActionListener(event);
    }



}
