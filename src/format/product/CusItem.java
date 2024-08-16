package format.product;

import entity.Vehicle;
import format.button.ButtonLogin;
import format.event.EventItem;
import format.panel.PanelItem;
import format.panel.PanelRound;
import format.product.Item;
import format.scroll.ScrollBar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javax.swing.*;

public class CusItem extends PanelRound {
    private JPanel jPanel1;
    private JSeparator jSeparator1;
    private JLabel  lblCompany, lblName, lblCylinderCapacity, lblEngineCapacity ;
    private JLabel lblPrice, lblMass, lblPetrolTank, lblCompressionRatio, lblEngineType;
    private JLabel lblTransmisionType, lblFuelConsumption,  lblColor;
    private ButtonLogin btnDelete, btnCreateContract, btnEdit;

    private PanelItem panelItem;
    private JScrollPane scroll;


        public void setEvent(EventItem event) {
            this.event = event;
        }

        private EventItem event;

        public CusItem() {
            initComponents();
            scroll.setVerticalScrollBar(new ScrollBar());
        }

        public void addItem(Vehicle data) {
            Item item = new Item();
            item.setData(data);
            item.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent me) {
                    if (SwingUtilities.isLeftMouseButton(me)) {
                        event.itemClick(item, data);
                    }
                }
            });
            panelItem.add(item);
            panelItem.repaint();
            panelItem.revalidate();
        }

        public void setSelected(Component item) {
            for (Component com : panelItem.getComponents()) {
                Item i = (Item) com;
                if (i.isSelected()) {
                    i.setSelected(false);
                }
            }
            ((Item) item).setSelected(true);
        }

        public void showItem(Vehicle data) {
            lblName.setText(data.getVehicleName());
            lblColor.setText(data.getVehicleColor());
            lblCompany.setText(data.getVehicleCompany().getVehicleCompanyName());
            DecimalFormat dfF = new DecimalFormat("$#,##0.00");
            lblPrice.setText(dfF.format(data.getVehiclePrice()));
            lblCompressionRatio.setText("Compression ratio     " + data.getCompressionRatio());
            lblTransmisionType.setText ("Transmission type     " + data.getTransmissionType());
            lblCylinderCapacity.setText("Cylinder capacity       " + data.getCylinderCapacity());
            lblFuelConsumption.setText ("Fuel consumption      " + data.getFuelConsumption());
            lblEngineCapacity.setText  ("Maximum power        " + data.getEngineCapacity());
            lblEngineType.setText      ("Engine type               " + data.getEngineType());
            lblPetrolTank.setText      ("Fuel tank capacity      " + data.getPetrolTankCapacity());
            DecimalFormat dfI = new DecimalFormat("## Kg");
            lblMass.setText(dfI.format(data.getVehicleMass()));

        }

        public Point getPanelItemLocation() {
            Point p = scroll.getLocation();
            return new Point(p.x, p.y - scroll.getViewport().getViewPosition().y);
        }

        @SuppressWarnings("unchecked")
        private void initComponents() {

            scroll = new JScrollPane();
            panelItem = new PanelItem();
            jPanel1 = new JPanel();
            lblName = new JLabel();
            lblPrice = new JLabel();
            lblCompany = new JLabel();
            jSeparator1 = new JSeparator();
            lblColor = new JLabel();
            lblMass = new JLabel();
            lblCompressionRatio = new JLabel();
            lblCylinderCapacity = new JLabel();
            lblEngineCapacity = new JLabel();
            lblEngineType = new JLabel();
            lblFuelConsumption = new JLabel();
            lblTransmisionType = new JLabel();
            lblPetrolTank = new JLabel();
            btnEdit = new ButtonLogin();
            btnDelete = new ButtonLogin();
            btnCreateContract = new ButtonLogin();

            setOpaque(false);

            scroll.setBorder(null);
            scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scroll.setViewportView(panelItem);

            jPanel1.setOpaque(false);
            jPanel1.setBackground(new Color(255, 255, 255));

            lblName.setFont(new Font("sansserif", 1, 18)); // NOI18N
            lblName.setForeground(new Color(76, 76, 76));
            lblName.setText("Product Name");

            lblPrice.setFont(new Font("sansserif", 1, 18)); // NOI18N
            lblPrice.setForeground(new Color(76, 76, 76));
            lblPrice.setText("$0.00");

            lblCompany.setFont(new Font("sansserif", 1, 14)); // NOI18N
            lblCompany.setForeground(new Color(76, 76, 76));
            lblCompany.setText("Brand Name");


            lblColor.setFont(new Font("sansserif", 1, 14)); // NOI18N
            lblColor.setForeground(new Color(76, 76, 76));
            lblColor.setText("Color");

            lblMass.setFont(new Font("sansserif", 1, 14)); // NOI18N
            lblMass.setForeground(new Color(76, 76, 76));
            lblMass.setText("Self-volume");

            lblPetrolTank.setFont(new Font("sansserif", 1, 14)); // NOI18N
            lblPetrolTank.setForeground(new Color(76, 76, 76));
            lblPetrolTank.setText("Fuel tank capacity");

            lblEngineType.setFont(new Font("sansserif", 1, 14)); // NOI18N
            lblEngineType.setForeground(new Color(76, 76, 76));
            lblEngineType.setText("Engine type");

            lblEngineCapacity.setFont(new Font("sansserif", 1, 14)); // NOI18N
            lblEngineCapacity.setForeground(new Color(76, 76, 76));
            lblEngineCapacity.setText("Maximum power");

            lblFuelConsumption.setFont(new Font("sansserif", 1, 14)); // NOI18N
            lblFuelConsumption.setForeground(new Color(76, 76, 76));
            lblFuelConsumption.setText("Fuel consumption");

            lblTransmisionType.setFont(new Font("sansserif", 1, 14)); // NOI18N
            lblTransmisionType.setForeground(new Color(76, 76, 76));
            lblTransmisionType.setText("Transmission type");

            lblCylinderCapacity.setFont(new Font("sansserif", 1, 14)); // NOI18N
            lblCylinderCapacity.setForeground(new Color(76, 76, 76));
            lblCylinderCapacity.setText("Cylinder capacity");

            lblCompressionRatio.setFont(new Font("sansserif", 1, 14)); // NOI18N
            lblCompressionRatio.setForeground(new Color(76, 76, 76));
            lblCompressionRatio.setText("Compression ratio");



            btnCreateContract.setFont(new Font("sansserif", 1, 18)); // NOI18N
            btnCreateContract.setForeground(new Color(255, 255, 255));
            btnCreateContract.setBackground(new Color(35, 180, 104));
            btnCreateContract.setText("Create Contract");
            btnCreateContract.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Create Contract!");
                }
            });

            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                            .addComponent(lblCompany)
                                                            .addComponent(lblPrice))
                                                    .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                            .addComponent(lblName, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblColor, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblMass, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblPetrolTank, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblEngineType, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblEngineCapacity, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblFuelConsumption, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblTransmisionType, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblCylinderCapacity, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblCompressionRatio, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jSeparator1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(40, 50, 60))
                                            .addGroup(GroupLayout.Alignment.CENTER, jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                                            .addComponent(btnCreateContract, GroupLayout.Alignment.CENTER,GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                            .addGap(40, 50, 60)
                                                    ))))
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(250, 250,250)
                                    .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblName)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblPrice)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblCompany)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblColor)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGap(15)
                                    .addComponent(lblMass)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGap(15)
                                    .addComponent(lblPetrolTank)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGap(15)
                                    .addComponent(lblEngineType)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGap(15)
                                    .addComponent(lblEngineCapacity)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGap(15)
                                    .addComponent(lblFuelConsumption)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGap(15)
                                    .addComponent(lblTransmisionType)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGap(15)
                                    .addComponent(lblCylinderCapacity)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGap(15)
                                    .addComponent(lblCompressionRatio)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGap(30)
                                    .addComponent(btnCreateContract, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(100, Short.MAX_VALUE))
            );

            GroupLayout layout = new GroupLayout(this);
            this.setBackground(new Color(255, 255, 255));
            this.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(scroll, GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(scroll)
                            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
        }

}
