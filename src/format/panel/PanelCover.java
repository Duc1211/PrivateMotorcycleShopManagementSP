package format.panel;

import format.button.ButtonOutLine;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class PanelCover extends JPanel {

        private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
        private ActionListener event;
        private MigLayout layout;
        private JLabel lblDescription, lblDescription1, lblTitle;
        private ButtonOutLine btnOutLine;
        private boolean isLogin;

        public PanelCover() {
            initComponents();
            setOpaque(false);
            layout = new MigLayout("wrap, fill", "[center]", "push[]25[]10[]25[]push");
            setLayout(layout);
            init();

        }

        private void init() {
            lblTitle = new JLabel("Welcome Back!");
            lblTitle.setFont(new Font("sansserif", 1, 30));
            lblTitle.setForeground(new Color(245, 245, 245));
            add(lblTitle);
            lblDescription = new JLabel("To keep connected with us please");
            lblDescription.setForeground(new Color(245, 245, 245));
            add(lblDescription);
            lblDescription1 = new JLabel("login with your personal info");
            lblDescription1.setForeground(new Color(245, 245, 245));
            add(lblDescription1);
            btnOutLine = new ButtonOutLine();
            btnOutLine.setBackground(new Color(255, 255, 255));
            btnOutLine.setForeground(new Color(255, 255, 255));
            btnOutLine.setText("SIGN IN");
            btnOutLine.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    event.actionPerformed(ae);
                }
            });
            add(btnOutLine, "w 60%, h 40");
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 327, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 300, Short.MAX_VALUE)
            );
        }// </editor-fold>//GEN-END:initComponents

        @Override
        protected void paintComponent(Graphics grphcs) {
            Graphics2D g2 = (Graphics2D) grphcs;
            GradientPaint gra = new GradientPaint(0, 0, new Color(35, 180, 104), 0, getHeight(), new Color(7, 51, 26));
            g2.setPaint(gra);
            g2.fillRect(0, 0, getWidth(), getHeight());
            super.paintComponent(grphcs);
        }

        public void addEvent(ActionListener event) {
            this.event = event;
        }

        public void registerLeft(double v) {
            v = Double.valueOf(df.format(v));
            login(false);
            layout.setComponentConstraints(lblTitle, "pad 0 -" + v + "% 0 0");
            layout.setComponentConstraints(lblDescription, "pad 0 -" + v + "% 0 0");
            layout.setComponentConstraints(lblDescription1, "pad 0 -" + v + "% 0 0");
        }

        public void registerRight(double v) {
            v = Double.valueOf(df.format(v));
            login(false);
            layout.setComponentConstraints(lblTitle, "pad 0 -" + v + "% 0 0");
            layout.setComponentConstraints(lblDescription, "pad 0 -" + v + "% 0 0");
            layout.setComponentConstraints(lblDescription1, "pad 0 -" + v + "% 0 0");
        }

        public void loginLeft(double v) {
            v = Double.valueOf(df.format(v));
            login(true);
            layout.setComponentConstraints(lblTitle, "pad 0 " + v + "% 0 " + v + "%");
            layout.setComponentConstraints(lblDescription, "pad 0 " + v + "% 0 " + v + "%");
            layout.setComponentConstraints(lblDescription1, "pad 0 " + v + "% 0 " + v + "%");
        }

        public void loginRight(double v) {
            v = Double.valueOf(df.format(v));
            login(true);
            layout.setComponentConstraints(lblTitle, "pad 0 " + v + "% 0 " + v + "%");
            layout.setComponentConstraints(lblDescription, "pad 0 " + v + "% 0 " + v + "%");
            layout.setComponentConstraints(lblDescription1, "pad 0 " + v + "% 0 " + v + "%");
        }

        public void login(boolean login) {
            if (this.isLogin != login) {
                if (login) {
                    lblTitle.setText("Hello, Friend!");
                    lblDescription.setText("The beginning is the most important part of the work");
                    lblDescription1.setText("And start journey with us");
                    btnOutLine.setText("SIGN UP");
                } else {
                    lblTitle.setText("Welcome Back!");
                    lblDescription.setText("Alone we can do so little");
                    lblDescription1.setText("Together we can do so much");
                    btnOutLine.setText("SIGN IN");
                }
                this.isLogin = login;
            }
        }


}
