package format.product;
import format.panel.PanelRound;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
public class BackgroundItem extends PanelRound {
    private int round = 10;
        public int getRound() {
            return round;
        }

        public void setRound(int round) {
            this.round = round;
            repaint();
        }

        public BackgroundItem() {
            setOpaque(false);
        }


        @Override
        public void paint(Graphics grphcs) {
            Graphics2D g2 = (Graphics2D) grphcs.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), round, round);
            g2.dispose();
            super.paint(grphcs);
        }

}
