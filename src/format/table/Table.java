package format.table;


import format.panel.PanelActionTable;
import format.scroll.ScrollBarCustomMenu;
import model.ActionModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class Table extends JTable {

    public Table() {
        setOpaque(false);
        getTableHeader().setBackground(new Color(35, 180, 104));
        setBackground(new Color(0, 0, 0, 0));
        setShowHorizontalLines(true);
        setGridColor(new Color(30, 30, 30, 50));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                if (i1 == 9) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focus, int i, int i1){

                 if (o instanceof ActionModel) {
                    ActionModel data = (ActionModel) o;
                    PanelActionTable cell = new PanelActionTable(data);
                    if (selected) {
                        cell.setBackground(new Color(239, 244, 255));
                    } else {
                        cell.setBackground(Color.WHITE);
                    }
                    return cell;
                } else {
                    Component com = super.getTableCellRendererComponent(jtable, o, selected, focus, i, i1);
                    setBorder(noFocusBorder);
                    com.setForeground(new Color(0, 0, 0, 0));
                    JLabel label = new JLabel(o + "");
                    label.setForeground(new Color(102, 102, 102));
                    return label;
                }
            }
        });
    }

    @Override
    public TableCellEditor getCellEditor(int row, int col) {
        if (col == 9) {
            return new TableCellAction();
        } else {
            return super.getCellEditor(row, col);
        }
    }

    public void addRow(Object[] row) {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.addRow(row);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        scroll.setVerticalScrollBar(new ScrollBarCustomMenu());
        JPanel p = new JPanel();
        p.setOpaque(false);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
    }
}
