package format.other;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class ImageAvatar extends JComponent {
    private Icon image, image1;
    private int borderSize = 6;
    private int borderSpace = 5;
    private Color gradientColor1 = new Color(255, 90, 90);
    private Color gradientColor2 = new Color(42, 199, 80);


    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image= image;
    }

    public int getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
        repaint();
    }
    public int getBorderSpace() {
        return borderSpace;
    }

    public void setBorderSpace(int borderSpace) {
        this.borderSpace = borderSpace;
        repaint();
    }

    public Color getGradientColor1() {
        return gradientColor1;
    }

    public void setGradientColor1(Color gradientColor1) {
        this.gradientColor1 = gradientColor1;
        repaint();
    }

    public Color getGradientColor2() {
        return gradientColor2;
    }
    public void setGradientColor2(Color gradientColor2) {
        this.gradientColor2 = gradientColor2;
        repaint();
    }



    @Override
    protected void paintComponent(Graphics grphcs) {
        if (image != null) {
            int width = getWidth();
            int height = getHeight();
            int diameter = Math.min(width, height);
            int x = width / 2 - diameter / 2;
            int y = height / 2 - diameter / 2;
            int border = borderSize * 2;
            diameter -= border;
            Rectangle size = getAutoSize(image, diameter);
            BufferedImage img = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2_img = img.createGraphics();
            g2_img.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2_img.fillOval(0, 0, diameter, diameter);
            Composite composite = g2_img.getComposite();
            g2_img.setComposite(AlphaComposite.SrcIn);
            g2_img.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2_img.drawImage(toImage(image), size.x, size.y, size.width, size.height, null);
            g2_img.setComposite(composite);
            g2_img.dispose();
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (borderSize > 0) {
                diameter += border;
                g2.setColor(getForeground());
                g2.fillOval(x, y, diameter, diameter);
            }
            if (isOpaque()) {
                g2.setColor(getBackground());
                diameter -= border;
                g2.fillOval(x + borderSize, y + borderSize, diameter, diameter);
            }
            g2.drawImage(img, x + borderSize, y + borderSize, null);
        }
        super.paintComponent(grphcs);
    }
    private void createBorder(Graphics2D g2) {
        int width = getWidth();
        int height = getHeight();
        int diameter = Math.min(width, height);
        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;
        if (isOpaque()) {
            g2.setColor(getBackground());
            g2.fillOval(x, y, diameter, diameter);
        }
        Area area = new Area(new Ellipse2D.Double(x, y, diameter, diameter));
        int s = diameter -= (borderSize * 2);
        area.subtract(new Area(new Ellipse2D.Double(x + borderSize, y + borderSize, s, s)));
        g2.setPaint(new GradientPaint(0, 0, gradientColor1, width, height, gradientColor2));
        g2.fill(area);
    }

    private Rectangle getAutoSize(Icon image, int size) {
        int w = size;
        int h = size;
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.max(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        if (width < 1) {
            width = 1;
        }
        if (height < 1) {
            height = 1;
        }
        int cw = size;
        int ch =size;
        int x = (cw - width) / 2;
        int y = (ch - height) / 2;
        return new Rectangle(new Point(x, y), new Dimension(width, height));
    }

    private Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }
}
