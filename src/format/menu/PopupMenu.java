package format.menu;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.SQLException;

import format.event.EventMenuSelected;
import format.panel.PanelPopup;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import javax.swing.*;

public class PopupMenu extends JDialog {
    private PanelPopup panel;

    private Animator animator;
    private boolean show = true;

    public PopupMenu(Frame parent, int index, EventMenuSelected eventSelected, String... subMenu) {
        super(parent, false);
        initComponents();
        setOpacity(0f);
        setBackground(new Color(0, 0, 0, 0));
        panel.setLayout(new MigLayout("fill, wrap", "8[fill, 120]0", "0[35, fill]0[35, fill]0"));
        int subMenuIndex = -1;
        for (String st : subMenu) {
            MenuButton item = new MenuButton(st, true);
            item.setIndex(++subMenuIndex);
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    try {
                        eventSelected.menuSelected(index, item.getIndex());
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    closeMenu();
                }
            });
            panel.add(item);
            setSize(new Dimension(120, 35 * subMenu.length));
        }
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (show) {
                    setOpacity(fraction);
                } else {
                    setOpacity(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (show == false) {
                    setVisible(false);
                }
            }
        };
        animator = new Animator(200, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
    }

    @Override
    public void setVisible(boolean bln) {
        super.setVisible(bln);
        if (show) {
            animator.start();
        }
    }

    private void closeMenu() {
        if (animator.isRunning()) {
            animator.stop();
        }
        show = false;
        animator.start();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        panel = new PanelPopup();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowFocusListener(new WindowFocusListener() {
            public void windowGainedFocus(WindowEvent evt) {
            }
            public void windowLostFocus(WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 200, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void formWindowLostFocus(WindowEvent evt) {
        closeMenu();
    }
}
