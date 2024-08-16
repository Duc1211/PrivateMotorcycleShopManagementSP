package format.table;

import javax.swing.*;
import java.awt.*;

public class LabelSplit extends JLabel {
    private boolean gradiet;

    public LabelSplit() {
    }

    public boolean isGradiet() {
        return this.gradiet;
    }

    public void setGradiet(boolean gradiet) {
        this.gradiet = gradiet;
    }

    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D)grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setComposite(AlphaComposite.getInstance(3, 0.3F));
        if (this.gradiet) {
            g2.setPaint(new GradientPaint(0.0F, 0.0F, new Color(115, 115, 115), (float)this.getWidth(), 0.0F, new Color(115, 115, 115, 0)));
        } else {
            g2.setColor(new Color(115, 115, 115));
        }

        g2.drawLine(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
        g2.dispose();
        super.paint(grphcs);
    }
}

