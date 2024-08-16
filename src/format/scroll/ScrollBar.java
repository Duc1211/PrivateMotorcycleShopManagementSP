package format.scroll;

import javax.swing.*;
import java.awt.*;

public class ScrollBar extends JScrollBar {
    public ScrollBar() {
        setUI(new ModernScrollBarUIMenu());
        setPreferredSize(new Dimension(5, 5));
        setBackground(new Color(242, 242, 242));
        setUnitIncrement(20);
    }
}
