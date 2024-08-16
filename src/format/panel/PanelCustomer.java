package format.panel;

import format.button.ButtonLogin;
import format.button.RadioButton;

import javax.swing.*;

public class PanelCustomer extends PanelRound{
    private JTextField txtNameCus, txtIdCus, txtSex, txtPhone, txtLocationCus;
    private JLabel  lblNameCus, lblIdCus, lblSex, lblPhone, lblLocationCus;
    private RadioButton rbnMale, rbnFemale;
    private ButtonLogin btnAddCus, btnEraseCus;
    public PanelCustomer(){
        initComponent();
    }

    private void initComponent() {

        lblNameCus = new JLabel("Name Customer");
        lblIdCus = new JLabel("Id Customer");
        lblPhone  = new JLabel("Phone");
        lblSex = new JLabel("Sex");
        lblLocationCus = new JLabel("Location");

        txtNameCus = new JTextField();
        txtIdCus = new JTextField();
        txtPhone = new JTextField();
        txtLocationCus = new JTextField();
        rbnMale = new RadioButton();
        rbnFemale = new RadioButton();
        btnAddCus = new ButtonLogin();
        btnAddCus.setText("Add");
        btnEraseCus = new ButtonLogin();
        btnEraseCus.setText("Erase");
        GroupLayout layoutPCustomer = new GroupLayout(this);
        this.setLayout(layoutPCustomer);
        layoutPCustomer.setHorizontalGroup(
                layoutPCustomer.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layoutPCustomer.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layoutPCustomer.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layoutPCustomer.createSequentialGroup()
                                                .addComponent(lblNameCus)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtNameCus))
                                        .addGroup(layoutPCustomer.createSequentialGroup()
                                                .addComponent(lblIdCus)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtIdCus))
                                        .addGroup(layoutPCustomer.createSequentialGroup()
                                                .addComponent(lblPhone)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtPhone))
                                        .addGroup(layoutPCustomer.createSequentialGroup()
                                                .addComponent(lblLocationCus)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtLocationCus))
                                        .addGroup(layoutPCustomer.createSequentialGroup()
                                                .addComponent(lblSex)
                                                .addGap(18, 18, 18)
                                                .addComponent(rbnMale)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rbnFemale)))
                                .addGap(18, 18, 18)
                                .addGroup(layoutPCustomer.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnEraseCus)
                                        .addComponent(btnAddCus))
                                .addContainerGap(10, Short.MAX_VALUE))
        );
        layoutPCustomer.setVerticalGroup(
                layoutPCustomer.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layoutPCustomer.createSequentialGroup()
                                .addGroup(layoutPCustomer.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layoutPCustomer.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layoutPCustomer.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblNameCus)
                                                        .addComponent(txtNameCus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layoutPCustomer.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblIdCus)
                                                        .addComponent(txtIdCus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layoutPCustomer.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblPhone)
                                                        .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layoutPCustomer.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblSex)
                                                        .addComponent(rbnMale)
                                                        .addComponent(rbnFemale))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layoutPCustomer.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblLocationCus)
                                                        .addComponent(txtLocationCus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layoutPCustomer.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(btnEraseCus)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnAddCus)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

}
