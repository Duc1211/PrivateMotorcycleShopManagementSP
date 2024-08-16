package format.scroll;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustomMenu extends JScrollBar {

    public ScrollBarCustomMenu() {
        setUI(new ModernScrollBarUIMenu());
        setPreferredSize(new Dimension(5, 5));
        setForeground(new Color(94, 139, 231));
        setUnitIncrement(20);
        setOpaque(false);
    }
}