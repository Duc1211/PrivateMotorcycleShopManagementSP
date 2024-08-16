package ui.profile;

import format.other.*;
import format.button.ButtonLogin;
import format.button.RadioButton;

import format.panel.PanelNoInfo;
import format.panel.PanelRound;
import format.textfield.TextFieldDuck;
import model.NoInforModel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


import connect.ConnectDB;
import dao.EmployeeDao;
import entity.Employee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;

public class FormProfile extends PanelRound  {



    private JLabel lblCode, lblPosition, lblID, lblBirthday, lblGender, lblPhone, lblLocation, lblDate, lblDateStart;
    private TextFieldDuck txtPosition, txtID, txtBirthday, txtPhone, txtLocation, txtName;
    private ButtonLogin btnEdit, btnImg, btnSave;
    private RadioButton rbnMale, rbnFemale;
    private PanelNoInfo pNoInfo;
    private JLabel imageAvatar;

    private String fileName = null;
    byte[] person_image = null;

    private EmployeeDao employeeDAO;
    private Icon imageIcon;

    public FormProfile(Employee em) {

        try {
            ConnectDB.getInstance().connectDataBase();
            System.out.println("Success To Connect Profile Form!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        employeeDAO = new EmployeeDao();
        String code = em.getEmployeeCode();
        ArrayList<Employee> listEm = employeeDAO.getEmployeeByID(code);
        if(! listEm.isEmpty())
        {
            for(Employee em1: listEm)
            {
                em.setCitizenIdNumber(em1.getCitizenIdNumber());
                em.setDateStart(em1.getDateStart());
                em.setEmployeeBirthday(em1.getEmployeeBirthday());
                em.setEmployeeLocation(em1.getEmployeeLocation());
                em.setEmployeeName(em1.getEmployeeName());
                em.setEmployeePhoneNumber(em1.getEmployeePhoneNumber());
                em.setEmployeePosition(em1.getEmployeePosition());
                em.setEmployeeSex(em1.isEmployeeSex());
                em.setSalary(em1.getSalary());
                em.setImage(em1.getImage());
            }
        }

        System.out.println(em.getSalary());
        System.out.println(em.getImage());


        initComponents(em);

        setOpaque(false);
        initNoInfo();
        setBackground(Color.decode("#7A8C8D"));
        setRoundTopLeft(20);
        setRoundTopRight(20);
        setRoundBottomLeft(20);
        setRoundBottomRight(20);

    }

    private void initNoInfo() {
        pNoInfo.addDate("04/10/2021");
        pNoInfo.addNoticeBoard(new NoInforModel(new Color(94, 49, 238), "Hidemode", "Now", "Sets the hide mode for the component. If the hide mode has been specified in the This hide mode can be overridden by the component constraint."));
        pNoInfo.addNoticeBoard(new NoInforModel(new Color(218, 49, 238), "Tag", "2h ago", "Tags the component with metadata name that can be used by the layout engine. The tag can be used to explain for the layout manager what the components is showing, such as an OK or Cancel button."));
        pNoInfo.addDate("03/10/2021");
        pNoInfo.addNoticeBoard(new NoInforModel(new Color(32, 171, 43), "Further Reading", "12:30 PM", "There are more information to digest regarding MigLayout. The resources are all available at www.migcomponents.com"));
        pNoInfo.addNoticeBoard(new NoInforModel(new Color(50, 93, 215), "Span", "10:30 AM", "Spans the current cell (merges) over a number of cells. Practically this means that this cell and the count number of cells will be treated as one cell and the component can use the space that all these cells have."));
        pNoInfo.addNoticeBoard(new NoInforModel(new Color(27, 188, 204), "Skip ", "9:00 AM", "Skips a number of cells in the flow. This is used to jump over a number of cells before the next free cell is looked for. The skipping is done before this component is put in a cell and thus this cells is affected by it. \"count\" defaults to 1 if not specified."));
        pNoInfo.addNoticeBoard(new NoInforModel(new Color(238, 46, 57), "Push", "7:15 AM", "Makes the row and/or column that the component is residing in grow with \"weight\". This can be used instead of having a \"grow\" keyword in the column/row constraints."));
        pNoInfo.scrollToTop();
    }

    @SuppressWarnings("unchecked")
    private void initComponents(Employee e3) {
        imageAvatar = new JLabel();
        imageAvatar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/avatar/avtnu.png")));

        if(e3.getImage()!=null) {
            ImageIcon imageIcon = new ImageIcon(e3.getImage());
            imageAvatar.setIcon(imageIcon);
        }else {
            imageAvatar.setIcon(null);
        }

        Font font = new Font("sansserif", Font.PLAIN, 18);


        lblCode = new JLabel();
        lblCode.setText(e3.getEmployeeCode());
        lblCode.setFont(new Font("sansserif", Font.PLAIN, 20));
        lblCode.setForeground(Color.WHITE);

        lblPosition = new JLabel("Position");
        lblPosition.setFont(font);
        lblID = new JLabel("Citizen Id Number");
        lblID.setFont(font);
        lblBirthday = new JLabel("Birthday");
        lblBirthday.setFont(font);
        lblGender = new JLabel("Gender");
        lblGender.setFont(font);
        lblPhone = new JLabel("Phone Number");
        lblPhone.setFont(font);
        lblLocation = new JLabel("Location");
        lblLocation.setFont(font);
        lblDate = new JLabel("Date Start");
        lblDate.setFont(font);

        txtName = new TextFieldDuck();
        txtName.setHint(e3.getEmployeeName().getEmployeeName());
        txtName.setEditable(false);

        txtPosition = new TextFieldDuck();
        txtPosition.setHint(e3.getEmployeePosition());
        txtPosition.setEditable(false);

        txtID = new TextFieldDuck();
        txtID.setHint(e3.getCitizenIdNumber());
        txtID.setEditable(false);

        txtBirthday = new TextFieldDuck();
        txtBirthday.setHint(e3.getEmployeeBirthday().toString());
        txtBirthday.setEditable(false);

        txtPhone = new TextFieldDuck();
        txtPhone.setHint(e3.getEmployeePhoneNumber());
        txtPhone.setEditable(false);

        txtLocation = new TextFieldDuck();
        txtLocation.setHint(e3.getEmployeeLocation());
        txtLocation.setEditable(false);

        lblDateStart = new JLabel(e3.getDateStart().toString());
        lblDateStart.setFont(new Font("sansserif", Font.PLAIN, 20));
        lblDateStart.setForeground(Color.WHITE);


        rbnMale = new RadioButton();
        rbnMale.setText("Male");
        rbnMale.setForeground(Color.WHITE);
        rbnMale.setFont(new Font("sansserif", Font.PLAIN, 20));

        rbnFemale = new RadioButton();
        rbnFemale.setText("Female");
        rbnFemale.setFont(new Font("sansserif", Font.PLAIN, 20));
        rbnFemale.setForeground(Color.WHITE);
        if(e3.isEmployeeSex() == true)
            rbnMale.setSelected(true);
        else
            rbnFemale.setSelected(true);
        rbnFemale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbnFemale.isSelected()){
                    rbnMale.setSelected(false);
                }
            }
        });
        rbnMale.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbnMale.isSelected()){
                    rbnFemale.setSelected(false);
                }
            }
        });

        btnSave = new ButtonLogin();
        btnSave.setIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/bookmark.png")));
        btnEdit = new ButtonLogin();
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEditText();
            }
        });
        btnSave.setBackground(Color.decode("#7A8C8D"));
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNotEditText();
            }
        });

        btnImg = new ButtonLogin();
        btnImg.setText("Change Avatar");
        btnImg.setForeground(Color.decode("#7A8C8D"));
        btnImg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnImgActionEvent(e);
            }
        });

        btnEdit.setBackground(Color.decode("#7A8C8D"));
        btnEdit.setIcon(new ImageIcon(getClass().getClassLoader().getResource("source/Image/icon/editing.png")));
        pNoInfo = new PanelNoInfo();

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(30)
                                                .addComponent(lblLocation, GroupLayout.DEFAULT_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                .addGap(20)
                                                .addComponent(txtLocation, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                                                .addGap(100))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(imageAvatar, 200, 200, 250)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(85)
                                                                                .addComponent(btnImg))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(80)
                                                                                .addComponent(lblCode, GroupLayout.DEFAULT_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(30)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(lblBirthday, GroupLayout.DEFAULT_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(20)
                                                                                .addComponent(txtBirthday, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(lblID, GroupLayout.DEFAULT_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(20)
                                                                                .addComponent(txtID, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(lblPosition, GroupLayout.DEFAULT_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(20)
                                                                                .addComponent(txtPosition, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(lblPhone, GroupLayout.DEFAULT_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(lblGender, GroupLayout.DEFAULT_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(rbnMale)
                                                                                                .addGap(30)
                                                                                                .addComponent(rbnFemale))
                                                                                        .addComponent(lblDate, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addComponent(txtName, GroupLayout.DEFAULT_SIZE, 400, 450)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(lblDateStart, GroupLayout.DEFAULT_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))))
                                                .addGap(30)))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(200)
                                                .addComponent(btnEdit)
                                                .addGap(20)
                                                .addComponent(btnSave)
                                                .addGap(30))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(pNoInfo, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                                .addGap(20)
                                                .addContainerGap())))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnEdit)
                                                                .addGap(40))
                                                        .addComponent(btnSave)
                                                        .addComponent(txtName, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(33)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(lblPosition)
                                                                        .addComponent(txtPosition, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(35)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(lblID)
                                                                        .addComponent(txtID, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(35)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(lblGender)
                                                                        .addComponent(rbnMale)
                                                                        .addComponent(rbnFemale))
                                                                .addGap(35)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(lblBirthday)
                                                                        .addComponent(txtBirthday, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(35)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblPhone))
                                                                .addGap(35)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(lblDateStart, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblDate))
                                                                .addGap(35))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(pNoInfo, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(20)
                                                                .addContainerGap())))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(imageAvatar, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                .addGap(20)
                                                .addComponent(btnImg)
                                                .addGap(30)
                                                .addComponent(lblCode)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lblLocation)
                                                        .addComponent(txtLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(50))))
        );
    }

    private void setEditText() {
        txtName.setEditable(true);
        txtName.setBackground(new Color(11, 35, 52));
        txtPosition.setEditable(true);
        txtPosition.setBackground(new Color(11, 35, 52));
        txtID.setEditable(true);
        txtID.setBackground(new Color(11, 35, 52));
        txtBirthday.setEditable(true);
        txtBirthday.setBackground(new Color(11, 35, 52));
        txtPhone.setEditable(true);
        txtPhone.setBackground(new Color(11, 35, 52));
        txtLocation.setEditable(true);
        txtLocation.setBackground(new Color(11, 35, 52));
    }
    private void setNotEditText() {
        txtName.setEditable(false);
        txtName.setBackground(Color.decode("#7A8C8D"));
        txtPosition.setEditable(false);
        txtPosition.setBackground(Color.decode("#7A8C8D"));
        txtID.setEditable(false);
        txtID.setBackground(Color.decode("#7A8C8D"));
        txtBirthday.setEditable(false);
        txtBirthday.setBackground(Color.decode("#7A8C8D"));
        txtPhone.setEditable(false);
        txtPhone.setBackground(Color.decode("#7A8C8D"));
        txtLocation.setEditable(false);
        txtLocation.setBackground(Color.decode("#7A8C8D"));
    }

    private void btnImgActionEvent(ActionEvent e) {

        JFileChooser chooser = new JFileChooser();
        System.setProperty("apple.awt.fileDialogForDirectories", "true");
        chooser.setCurrentDirectory(new File("/Users/duckzyyy/Documents/Lập Trình Hướng SK/Thực Hành/N4_QuanLyCuaHangXeMayTuNhan/src/source/Image"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("All Pic", "png", "jpeg", "jpg", "gif");
        chooser.addChoosableFileFilter(filter);
        int a = chooser.showSaveDialog(null);
        if (a == JFileChooser.APPROVE_OPTION) {
        File f = chooser.getSelectedFile();
        fileName = f.getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(imageAvatar.getWidth(), imageAvatar.getHeight(), Image.SCALE_SMOOTH));
        imageAvatar.setIcon(imageIcon);
        try {
            File imaage = new File(fileName);
            FileInputStream fis = new FileInputStream(imaage);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int readNum; (readNum = fis.read(buf))!= -1; ) {
                bos.write(buf,0,readNum);
            }
            person_image=bos.toByteArray();

        }catch (Exception e1) {
            JOptionPane.showMessageDialog(null, e1);
        }
    }}


}
