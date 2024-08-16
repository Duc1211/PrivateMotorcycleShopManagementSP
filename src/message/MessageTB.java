package message;

import format.other.GoogleMaterialDesignIcons;
import format.other.IconFontSwing;
import format.button.Button;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageTB extends JDialog {
    private Button btnOk, btnCancel;
    private JPanel pMain;
    private  JLabel lblIcon;
    private JLabel lblMessage;

        public boolean isOk() {
            return ok;
        }

        public void setOk(boolean ok) {
            this.ok = ok;
        }

        private boolean ok;
        private final Animator animator;
        private boolean show = true;

        public MessageTB(Frame parent, boolean modal) {
            super(parent, modal);
            initComponents();
            lblIcon.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.REPORT_PROBLEM, 60, new Color(254, 86, 96), new Color(113, 74, 67)));
            setOpacity(0f);
            getContentPane().setBackground(Color.WHITE);
            TimingTarget target = new TimingTargetAdapter() {
                @Override
                public void timingEvent(float fraction) {
                    if (show) {
                        setOpacity(fraction);
                    } else {
                        setOpacity(1f - fraction);
                    }
                }

                @Override
                public void end() {
                    if (show == false) {
                        setVisible(false);
                    }
                }

            };
            animator = new Animator(200, target);
            animator.setResolution(0);
            animator.setAcceleration(0.5f);
        }

        public void showMessage(String message) {
            lblMessage.setText(message);
            animator.start();
            setVisible(true);
        }

        @SuppressWarnings("unchecked")

        private void initComponents() {

            pMain = new JPanel();
            lblMessage = new JLabel();
            btnOk = new Button();
            btnCancel = new Button();
            lblIcon = new JLabel();

            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setUndecorated(true);

            pMain.setBackground(new Color(255, 255, 255));
            pMain.setBorder(BorderFactory.createLineBorder(new Color(75, 134, 253)));

            lblMessage.setFont(new Font("sansserif", 0, 14)); // NOI18N
            lblMessage.setForeground(new Color(82, 82, 82));
            lblMessage.setText("Message");

            btnOk.setForeground(new Color(66, 66, 66));
            btnOk.setText("OK");
            btnOk.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    btnOkActionPerformed(evt);
                }
            });

            btnCancel.setForeground(new Color(66, 66, 66));
            btnCancel.setText("Cancel");
            btnCancel
                    .addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    btnCancelActionPerformed(evt);
                }
            });

            lblIcon.setHorizontalAlignment(SwingConstants.CENTER);

            GroupLayout jPanel1Layout = new GroupLayout(pMain);
            pMain.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(lblIcon, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(lblMessage, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(20, 20, 20))
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblIcon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblMessage, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            GroupLayout layout = new GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(pMain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(pMain, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
            setLocationRelativeTo(null);
        }

        private void btnOkActionPerformed(ActionEvent evt) {
            ok = true;
            closeMenu();
        }

        private void btnCancelActionPerformed(ActionEvent evt) {
            closeMenu();
        }

        private void closeMenu() {
            if (animator.isRunning()) {
                animator.stop();
            }
            show = false;
            animator.start();
        }


}
