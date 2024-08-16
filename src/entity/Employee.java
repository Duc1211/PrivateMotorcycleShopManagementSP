package entity;


import format.table.TableRowData;
import model.NameModel;


import java.time.LocalDate;

public class Employee extends TableRowData {

    private String employeeCode;
    private NameModel employeeName;
    private String citizenIdNumber;
    private LocalDate employeeBirthday;
    private boolean employeeSex;
    private String employeeLocation;
    private String employeePhoneNumber;
    private String employeePosition;
    private double salary;
    private LocalDate dateStart;
    private byte[] image;

    public Employee() {
        // TODO Auto-generated constructor stub
    }

    public Employee(String nv001, NameModel raVen, String number, LocalDate localDate, boolean b, String newYork, String id, String director, int i, LocalDate date, String working) {
    }

    @Override
    public Object[] toTableRow() {
        return new Object[]{employeeCode, employeeName, citizenIdNumber, employeeBirthday, employeeSex,
                employeeLocation, employeePhoneNumber, employeePosition, salary, dateStart};
    }



    public Employee(String employeeCode, NameModel employeeName, String citizenIdNumber, LocalDate employeeBirthday,
                    boolean employeeSex, String employeeLocation, String employeePhoneNumber, String employeePosition,
                    double salary, LocalDate dateStart, byte[] image) {
        super();
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.citizenIdNumber = citizenIdNumber;
        this.employeeBirthday = employeeBirthday;
        this.employeeSex = employeeSex;
        this.employeeLocation = employeeLocation;
        this.employeePhoneNumber = employeePhoneNumber;
        this.employeePosition = employeePosition;
        this.salary = salary;
        this.dateStart = dateStart;
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Employee(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Employee(String employeeCode, NameModel employeeName, String citizenIdNumber,LocalDate employeeBirthday, boolean employeeSex, String employeeLocation, String employeePhoneNumber, String employeePosition, double salary, LocalDate dateStart) {
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.citizenIdNumber = citizenIdNumber;
        this.employeeBirthday = employeeBirthday;
        this.employeeSex = employeeSex;
        this.employeeLocation = employeeLocation;
        this.employeePhoneNumber = employeePhoneNumber;
        this.employeePosition = employeePosition;
        this.salary = salary;
        this.dateStart = dateStart;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }


    public NameModel getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(NameModel employeeName) {
        this.employeeName = employeeName;
    }

    public String getCitizenIdNumber() {
        return citizenIdNumber;
    }

    public void setCitizenIdNumber(String citizenIdNumber) {
        this.citizenIdNumber = citizenIdNumber;
    }

    public LocalDate getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(LocalDate employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public boolean isEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(boolean employeeSex) {
        this.employeeSex = employeeSex;
    }

    public String getEmployeeLocation() {
        return employeeLocation;
    }

    public void setEmployeeLocation(String employeeLocation) {
        this.employeeLocation = employeeLocation;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

}
