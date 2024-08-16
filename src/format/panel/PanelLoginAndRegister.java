package format.panel;

import entity.Employee;
import entity.Account;
import format.textfield.MyPasswordField;
import format.textfield.MyTextField;
import format.button.ButtonLogin;
import model.LoginModel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelLoginAndRegister extends JLayeredPane {
    private JPanel pLogin;
    private JPanel pRegister;
    private MyTextField txtEmail;
    private MyPasswordField txtPass;
    private MyTextField txtUser;
    private Account account;
    private LoginModel loginModel;
    private MyTextField txtUserSignup;
    private MyPasswordField txtPassSignUp;

    public LoginModel getLoginModel() {
        return loginModel;
    }
    public Account getAccount(){
        return account;
    }

    public PanelLoginAndRegister(ActionListener eventRegister, ActionListener eventLogin) {
        initComponents();
        initRegister(eventRegister);
        initLogin(eventLogin);
        pLogin.setVisible(false);
        pRegister.setVisible(true);
    }


    private void initRegister(ActionListener eventRegister) {
        pRegister.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel lblHeader = new JLabel("Create Account");
        lblHeader.setFont(new Font("sansserif", 1, 30));
        lblHeader.setForeground(new Color(7, 164, 121));
        pRegister.add(lblHeader);
        txtUserSignup = new MyTextField();
        txtUserSignup.setPrefixIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/user.png")));
        txtUserSignup.setHint("Employee Code");
        pRegister.add(txtUserSignup, "w 60%");
        txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/mail.png")));
        txtEmail.setHint("Email");
        pRegister.add(txtEmail, "w 60%");
        txtPassSignUp = new MyPasswordField();
        txtPassSignUp.setPrefixIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/pass.png")));
        txtPassSignUp.setHint("Password");
        pRegister.add(txtPassSignUp, "w 60%");
        ButtonLogin btn = new ButtonLogin();
        btn.setBackground(new Color(35, 180, 104));

        btn.setForeground(new Color(255, 255, 255));
        btn.addActionListener(eventRegister);
        btn.setText("SIGN UP");
        pRegister.add(btn, "w 40%, h 40");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = txtUserSignup.getText().trim();
                String email  = txtEmail.getText().trim();
                String passWord = String.valueOf(txtPassSignUp.getPassword());
                Employee nv = new Employee(userName);
                account = new Account(0, nv, passWord, email);
            }
        });
    }

    private void initLogin(ActionListener eventLogin) {
        pLogin.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        pLogin.add(label);
        txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/user.png")));
        txtUser.setHint("Employee Code");
        pLogin.add(txtUser, "w 60%");
        txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/pass.png")));
        txtPass.setHint("Password");
        pLogin.add(txtPass, "w 60%");
        JButton btnForget = new JButton("Forgot your password ?");
        btnForget.setForeground(new Color(100, 100, 100));
        btnForget.setFont(new Font("sansserif", 1, 12));
        btnForget.setContentAreaFilled(false);
        btnForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pLogin.add(btnForget);
        ButtonLogin btn = new ButtonLogin();
        btn.setBackground(new Color(35, 180, 104));
        btn.setForeground(new Color(255, 255, 255));
        btn.setText("SIGN IN");
        btn.addActionListener(eventLogin);
        pLogin.add(btn, "w 40%, h 40");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = txtUser.getText().trim();
                String passWord = String.valueOf(txtPass.getPassword());
                loginModel = new LoginModel(userName, passWord);
            }
        });
    }

    public void showRegister(boolean show) {
        if (show) {
            pRegister.setVisible(true);
            pLogin.setVisible(false);
        } else {
            pRegister.setVisible(false);
            pLogin.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        pLogin = new JPanel();
        pRegister = new JPanel();

        setLayout(new CardLayout());

        pLogin.setBackground(new Color(255, 255, 255));

        GroupLayout loginLayout = new GroupLayout(pLogin);
        pLogin.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
                loginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 327, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
                loginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        add(pLogin, "card3");

        pRegister.setBackground(new Color(255, 255, 255));

        GroupLayout registerLayout = new GroupLayout(pRegister);
        pRegister.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
                registerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 327, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
                registerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        add(pRegister, "card2");

    }


}
