package entity;

public class Account {
    private int accountID;
    private Employee employee;
    private String passWord;
    private String verifyCode;
    private String email;

    public Account() {
    }

    public Account(int accountID, Employee employee, String passWord, String verifyCode, String email) {
        this.accountID = accountID;
        this.employee = employee;
        this.passWord = passWord;
        this.verifyCode = verifyCode;
        this.email = email;
    }

    public Account(int accountID, Employee employee, String passWord, String email) {
        this.accountID = accountID;
        this.employee = employee;
        this.passWord = passWord;
        this.email = email;
    }
    public Account(Employee employee, String passWord, String email) {
        this.employee = employee;
        this.passWord = passWord;
        this.email = email;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
