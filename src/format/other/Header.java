package format.other;

import format.button.Button;
import format.button.ButtonBadges;
import format.textfield.SearchText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Header extends JPanel {
    private ButtonBadges buttonBadges1, buttonBadges2;
    private Button btnMenu;
    private JLabel lblSearchIcon;
    private SearchText searchText;
    private JSeparator jSeparator1;
    private JLabel lblRole, lblUserName;
    private ImageAvatar pic;

    public Header() {
        initComponents();
    }

    public void addMenuEvent(ActionListener event) {
        btnMenu.addActionListener(event);
    }


    private void initComponents() {

        btnMenu = new Button();
        lblSearchIcon = new JLabel();
        searchText = new SearchText();
        pic = new ImageAvatar();
        lblUserName = new JLabel();
        lblRole = new JLabel();
        jSeparator1 = new JSeparator();
        buttonBadges1 = new ButtonBadges();
        buttonBadges2 = new ButtonBadges();


        setBackground(new Color(255, 255, 255));


        lblSearchIcon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/search.png")));
        btnMenu.setIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/menu.png"))); // NOI18N

        pic.setImage(new ImageIcon(getClass().getClassLoader().getResource("source/Image/avatar/avtnu.png")));
        pic.setBorderSize(2);// NOI18N
        lblUserName.setFont(new Font("sansserif", 1, 12)); // NOI18N
        lblUserName.setForeground(new Color(127, 127, 127));
        lblUserName.setText("Amie");
        lblRole.setForeground(new Color(127, 127, 127));
        lblRole.setText("Accountant");

        jSeparator1.setOrientation(SwingConstants.VERTICAL);

        buttonBadges1.setForeground(new Color(250, 49, 49));
        buttonBadges1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/notification.png"))); // NOI18N
        buttonBadges1.setBadges(8);

        buttonBadges2.setForeground(new Color(63, 178, 232));
        buttonBadges2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/mail.png"))); // NOI18N
        buttonBadges2.setBadges(5);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnMenu, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lblSearchIcon,GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchText,GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonBadges2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(buttonBadges1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblUserName, GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblRole, GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addComponent(pic, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblUserName)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblRole))
                                        .addComponent(btnMenu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblSearchIcon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(searchText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pic, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator1)
                                        .addComponent(buttonBadges1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonBadges2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }
}