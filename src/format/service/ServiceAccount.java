package format.service;

import connect.ConnectDB;
import entity.Account;
import entity.Employee;
import model.LoginModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;
public class ServiceAccount {

    private final Connection connection;

    public ServiceAccount() throws SQLException {
        connection = ConnectDB.getConnection();
    }

    public Account login(LoginModel login) throws SQLException {
        Account account = null;
        String sql = "SELECT UserID, UserName, Email FROM Account WHERE UserName = ? AND Password = ? ";
        PreparedStatement p = connection.prepareStatement(sql);
        p.setString(1, login.getUserName());
        p.setString(2, login.getPassword());
        ResultSet rs = p.executeQuery();
        if (rs.next()) {
            int userID = rs.getInt("UserID");
            String userName = rs.getString("UserName");
            Employee em = new Employee(userName);
            String email = rs.getString("Email");
            account = new Account(userID, em, userName, login.getPassword(), email);
        }
        rs.close();
        p.close();
        return account;
    }

    public void insertUser(Account account) throws SQLException {
        String userName = account.getEmployee().getEmployeeCode();
        String email = account.getEmail();
        String password = account.getPassWord();
        PreparedStatement p = connection.prepareStatement("INSERT INTO Account (UserName, Email, Password, VerifyCode) VALUES (?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
        String code = generateVerifyCode();
        p.setString(1, userName);
        p.setString(2, email);
        p.setString(3, password);
        p.setString(4, code);
        p.execute();
        ResultSet rs = p.getGeneratedKeys();
        rs.next();
        rs.close();
        p.close();
        account.setVerifyCode(code);
    }


    private String generateVerifyCode() throws SQLException {
        DecimalFormat df = new DecimalFormat("000000");
        Random ran = new Random();
        String code = df.format(ran.nextInt(1000000));  // Random from 0 to 999999
        while (checkDuplicateCode(code)) {
            code = df.format(ran.nextInt(1000000));
        }
        return code;
    }

    private boolean checkDuplicateCode(String verifyCode) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = connection.prepareStatement("SELECT UserID FROM Account WHERE VerifyCode = ?");
        p.setString(1, verifyCode);
        ResultSet rs = p.executeQuery();
        if (rs.next()) {
            duplicate = true;
        }
        rs.close();
        p.close();
        return duplicate;
    }

    public boolean checkDuplicateUser(String account) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = connection.prepareStatement("SELECT A.UserID FROM Account A \n" +
                "INNER JOIN Employee E ON A.UserName = E.EmployeeCode \n" +
                "WHERE A.UserName = ? AND A.Status = 'Verified'");
        p.setString(1, account);
        ResultSet rs = p.executeQuery();
        if (rs.next()) {
            duplicate = true;
        }
        rs.close();
        p.close();
        return duplicate;
    }

    public boolean checkDuplicateEmail(String account) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = connection.prepareStatement("SELECT TOP 1 UserID FROM Account WHERE Email = ? AND Status = 'Verified'");
        p.setString(1, account);
        ResultSet rs = p.executeQuery();
        if (rs.next()) {
            duplicate = true;
        }
        rs.close();
        p.close();
        return duplicate;
    }

    public void doneVerify(String accountID) throws SQLException {
        PreparedStatement p = connection.prepareStatement("UPDATE Account SET VerifyCode = '', [Status] = 'Verified' WHERE UserID = ?");
        p.setString(1, accountID);
        p.execute();
        p.close();
    }

    public boolean verifyCodeWithUser(String accountID, String code) throws SQLException {
        boolean verify = false;
        PreparedStatement p = connection.prepareStatement("SELECT TOP 1 UserID FROM Account WHERE UserID = ? AND VerifyCode = ?");
        p.setString(1, accountID);
        p.setString(2, code);
        ResultSet rs = p.executeQuery();
        if (rs.first()) {
            verify = true;
        }
        rs.close();
        p.close();
        return verify;
    }
    public static void main(String[] args) throws SQLException {
        ConnectDB.getInstance().connectDataBase();
        LoginModel lm=new LoginModel("TE100", "123");
        System.out.println("dang nhap: \n" + new ServiceAccount().login(lm));
        Account a = new Account();
        Employee employee = new Employee("TE094");
        a.setEmployee(employee);
        a.setEmail("ndhuy2203@gmail.com");
        a.setPassWord("123");

        ServiceAccount serviceAccount = new ServiceAccount();
        serviceAccount.insertUser(a);
        System.out.println("tao thanh cong 1 account");

    }
}

