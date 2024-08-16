package format.table;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class TableHeader extends JLabel {
        public TableHeader(String text) {
            super(text);
            setFont(new Font("sansserif", 1, 12));
            setForeground(new Color(255, 255, 255));
            setBorder(new EmptyBorder(10, 5, 10, 5));
        }
}
