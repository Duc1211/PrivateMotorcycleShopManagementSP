package format.scroll;

import javax.swing.*;
import java.awt.*;

public class ScrollBarCustomComboBox extends JScrollBar {
    public ScrollBarCustomComboBox() {
        setUI(new ModernScrollBarUIComboBox());
        setPreferredSize(new Dimension(5, 5));
        setForeground(new Color(94, 139, 231));
        setUnitIncrement(20);
    }
}
