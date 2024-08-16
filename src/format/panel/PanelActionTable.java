package format.panel;

import format.button.ActionButton;
import format.button.Button;
import format.event.TableActionEvent;
import model.ActionModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelActionTable extends JPanel {

    private Button btnDelete;
    private Button btnEdit;

        public PanelActionTable(ActionModel data) {
            initComponents();
            setOpaque(false);
            btnEdit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    data.getEvent().update(data.getVehicle());
                }
            });
            btnDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    data.getEvent().delete(data.getVehicle());
                }
            });
        }

        @Override
        protected void paintComponent(Graphics grphcs) {
            super.paintComponent(grphcs);
            grphcs.setColor(new Color(30, 30, 30, 50));
            grphcs.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
        }

        @SuppressWarnings("unchecked")

        private void initComponents() {
            btnEdit = new Button();
            btnDelete = new Button();

            btnEdit.setIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/draw.png"))); // NOI18N

            btnDelete.setIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/trash.png"))); // NOI18N

            GroupLayout layout = new GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnEdit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addContainerGap())
            );
        }
}
