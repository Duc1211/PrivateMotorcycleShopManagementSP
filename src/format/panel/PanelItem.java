package format.panel;

import format.other.WrapLayout;

import java.awt.Color;
import javax.swing.JPanel;

public class PanelItem extends JPanel {

    public PanelItem() {
        setBackground(Color.WHITE);
        setLayout(new WrapLayout(WrapLayout.LEFT, 5, 5));
    }
}
