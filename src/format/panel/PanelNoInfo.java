package format.panel;

import format.scroll.ScrollBarCustomMenu;
import model.NoInforModel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PanelNoInfo extends PanelRound{

    private JScrollPane scrollPane;
    private PanelRound panel;
        public PanelNoInfo() {
            initComponents();
            setOpaque(false);
            scrollPane.getViewport().setOpaque(false);
            scrollPane.setViewportBorder(null);
            scrollPane.setVerticalScrollBar(new ScrollBarCustomMenu());
            panel.setLayout(new MigLayout("nogrid, fillx"));
            this.setRoundTopRight(20);
            this.setRoundTopLeft(20);
            this.setRoundBottomRight(20);
            this.setRoundBottomLeft(20);
        }

        public void addNoticeBoard(NoInforModel data) {
            JLabel lblTitle = new JLabel(data.getTitle());
            lblTitle.setFont(new Font("sansserif", 1, 16));
            lblTitle.setForeground(data.getTitleColor());
            panel.add(lblTitle);
            JLabel lblTime = new JLabel(data.getTime());
            lblTime.setForeground(new Color(47, 47, 47));
            lblTime.setFont(new Font("sansserif", 1, 16));
            panel.add(lblTime, "gap 10, wrap");
            JTextPane txt = new JTextPane();
            txt.setBackground(new Color(0, 0,0,0));
            txt.setForeground(new Color(0, 0, 0));
            txt.setSelectionColor(new Color(35, 180, 104));
            txt.setFont(new Font("sansserif", 1, 15));
            txt.setBorder(null);
            txt.setOpaque(false);
            txt.setEditable(false);
            txt.setText(data.getDescription());
            panel.add(txt, "w 100::90%, wrap");
        }

        public void addDate(String date) {
            JLabel lblDate = new JLabel(date);
            lblDate.setBorder(new EmptyBorder(5, 5, 5, 5));
            lblDate.setFont(new Font("sansserif", 1, 18));
            lblDate.setForeground(new Color(80, 80, 80));
            panel.add(lblDate, "wrap");
        }

        public void scrollToTop() {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    scrollPane.getVerticalScrollBar().setValue(0);
                }
            });
        }

        @SuppressWarnings("unchecked")
        private void initComponents() {

            scrollPane = new JScrollPane();
            panel = new PanelRound();

            scrollPane.setBorder(null);
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            panel.setOpaque(false);

            GroupLayout panelLayout = new GroupLayout(panel);
            panel.setLayout(panelLayout);
            panelLayout.setHorizontalGroup(
                    panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGap(0, 329, Short.MAX_VALUE)
            );
            panelLayout.setVerticalGroup(
                    panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGap(0, 351, Short.MAX_VALUE)
            );

            scrollPane.setViewportView(panel);

            GroupLayout layout = new GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPane)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPane)
            );
        }
}
