package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import connect.ConnectDB;
import entity.Employee;
import model.NameModel;


public class EmployeeDao {

    public EmployeeDao() {

    }
    //lấy tất cả nhân viên
    public ArrayList<Employee> getAllTableEmployee(){
        ArrayList<Employee> listEmploy = new ArrayList<Employee>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "Select * from Employee";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String employeeCode = rs.getString(1);

                NameModel name = new NameModel();
                name.setEmployeeName(rs.getString(2));

                String citizenNumber= rs.getString(3);

                Date bitrhDayy = rs.getDate(4);
                LocalDate bitrhDay = bitrhDayy.toLocalDate();

                boolean sex = rs.getBoolean(5);
                String employeeLocation = rs.getString(6);
                String employeePhone = rs.getString(7);
                String employeePosition = rs.getString(8);

                BigDecimal salary = rs.getBigDecimal(9);

                double salaryDouble = salary.doubleValue();

                Date dateStartt = rs.getDate(10);
                LocalDate dateStart = dateStartt.toLocalDate();

                byte[] image = rs.getBytes(11);

                Employee e = new Employee(employeeCode, name, citizenNumber,
                        bitrhDay, sex, employeeLocation, employeePhone,
                        employeePosition, salaryDouble, dateStart, image);
                listEmploy.add(e);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listEmploy;
    }
    // lấy nhân viên theo mã
    public ArrayList<Employee> getEmployeeByID(String id){
        ArrayList<Employee> listEmploy = new ArrayList<Employee>();
        try {
            ConnectDB.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Connection con = ConnectDB.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql ="Select * from Employee where EmployeeCode = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                String employeeCode = rs.getString(1);

                NameModel name = new NameModel();
                name.setEmployeeName(rs.getString(2));

                String citizenNumber= rs.getString(3);

                Date bitrhDayy = rs.getDate(4);
                LocalDate bitrhDay = bitrhDayy.toLocalDate();

                boolean sex = rs.getBoolean(5);
                String employeeLocation = rs.getString(6);
                String employeePhone = rs.getString(7);
                String employeePosition = rs.getString(8);

                BigDecimal salary = rs.getBigDecimal(9);
                double salaryDouble = salary.doubleValue();

                Date dateStartt = rs.getDate(10);
                LocalDate dateStart = dateStartt.toLocalDate();

                byte[] image = rs.getBytes(11);

                Employee e = new Employee(employeeCode, name, citizenNumber,
                        bitrhDay, sex, employeeLocation, employeePhone,
                        employeePosition, salaryDouble, dateStart, image);
                listEmploy.add(e);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                pstmt.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listEmploy;
    }

    //lay nhan vien theo ten
    public ArrayList<Employee> getEmployeeByName(String namee){
        ArrayList<Employee> listEmploy = new ArrayList<Employee>();
        try {
            ConnectDB.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Connection con = ConnectDB.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql ="Select * from Employee where EmployeeName = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, namee);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                String employeeCode = rs.getString(1);

                NameModel name = new NameModel();
                name.setEmployeeName(rs.getString(2));

                String citizenNumber= rs.getString(3);

                Date bitrhDayy = rs.getDate(4);
                LocalDate bitrhDay = bitrhDayy.toLocalDate();

                boolean sex = rs.getBoolean(5);
                String employeeLocation = rs.getString(6);
                String employeePhone = rs.getString(7);
                String employeePosition = rs.getString(8);

                BigDecimal salary = rs.getBigDecimal(9);
                double salaryDouble = salary.doubleValue();

                Date dateStartt = rs.getDate(10);
                LocalDate dateStart = dateStartt.toLocalDate();

                byte[] image = rs.getBytes(11);
                Employee e = new Employee(employeeCode, name, citizenNumber,
                        bitrhDay, sex, employeeLocation, employeePhone,
                        employeePosition, salaryDouble, dateStart, image);
                listEmploy.add(e);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                pstmt.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listEmploy;
    }
    //lay nhan vien theo sdt
    public ArrayList<Employee> getEmployeeByPhone(String phonee){
        ArrayList<Employee> listEmploy = new ArrayList<Employee>();
        try {
            ConnectDB.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Connection con = ConnectDB.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql ="Select * from Employee where EmployeePhoneNumber = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, phonee);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                String employeeCode = rs.getString(1);

                NameModel name = new NameModel();
                name.setEmployeeName(rs.getString(2));

                String citizenNumber= rs.getString(3);

                Date bitrhDayy = rs.getDate(4);
                LocalDate bitrhDay = bitrhDayy.toLocalDate();

                boolean sex = rs.getBoolean(5);
                String employeeLocation = rs.getString(6);
                String employeePhone = rs.getString(7);
                String employeePosition = rs.getString(8);

                BigDecimal salary = rs.getBigDecimal(9);
                double salaryDouble = salary.doubleValue();

                Date dateStartt = rs.getDate(10);
                LocalDate dateStart = dateStartt.toLocalDate();

                byte[] image = rs.getBytes(11);

                Employee e = new Employee(employeeCode, name, citizenNumber,
                        bitrhDay, sex, employeeLocation, employeePhone,
                        employeePosition, salaryDouble, dateStart, image);
                listEmploy.add(e);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                pstmt.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listEmploy;
    }
    public boolean createEmployee(Employee em) throws SQLException {
        ConnectDB.getInstance();
        Connection con=ConnectDB.getConnection();
        PreparedStatement stmt=null;
        int n=0;
        try {
            stmt = con.prepareStatement("INSERT INTO Employee (EmployeeCode, EmployeeName, CitizenIdNumber, EmployeeBirthday, EmployeeSex, EmployeeLocation, EmployeePhoneNumber, EmployeePosition, Salary, DateStart, Image) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1,em.getEmployeeCode());

            stmt.setString(2, em.getEmployeeName().getEmployeeName());

            stmt.setString(3, em.getCitizenIdNumber());

            LocalDate birth = em.getEmployeeBirthday();
            Date birthDay = Date.valueOf(birth);
            stmt.setDate(4, birthDay );

            stmt.setBoolean(5, em.isEmployeeSex());
            stmt.setString(6, em.getEmployeeLocation());
            stmt.setString(7, em.getEmployeePhoneNumber());
            stmt.setString(8, em.getEmployeePosition());

            double salary = em.getSalary();
            BigDecimal decimalSalary = BigDecimal.valueOf(salary);
            stmt.setBigDecimal(9, decimalSalary);

            LocalDate start = em.getDateStart();
            Date dateStart = Date.valueOf(start);
            stmt.setDate(10, dateStart);

            stmt.setBytes(11, em.getImage());

            n=stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                stmt.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return n>0;
    }

    public boolean removeEmployee(Employee em) throws SQLException {
        ConnectDB.getInstance();
        Connection con=ConnectDB.getConnection();
        PreparedStatement stmt=null;
        int n=0;
        try {
            stmt=con.prepareStatement("delete from "+" Employee where EmployeeCode=?");

            stmt.setString(1, em.getEmployeeCode());
            n=stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                stmt.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return n>0;
    }

    public boolean updateEmployee(Employee em,String code) throws SQLException {
        ConnectDB.getInstance();
        Connection con=ConnectDB.getConnection();
        PreparedStatement stmt=null;
        int n=0;
        try {
            stmt = con.prepareStatement("UPDATE Employee " +
                    "SET EmployeeCode = ?, EmployeeName = ?, CitizenIdNumber = ?, EmployeeBirthday = ?, EmployeeSex = ?, EmployeeLocation = ?, EmployeePhoneNumber = ?, EmployeePosition = ?, Salary = ?, DateStart = ?, Image = ? "
                    +
                    "WHERE EmployeeCode = ?");

            stmt.setString(1,em.getEmployeeCode());

            stmt.setString(2, em.getEmployeeName().getEmployeeName());

            stmt.setString(3, em.getCitizenIdNumber());

            LocalDate birth = em.getEmployeeBirthday();
            Date birthDay = Date.valueOf(birth);
            stmt.setDate(4, birthDay );

            stmt.setBoolean(5, em.isEmployeeSex());
            stmt.setString(6, em.getEmployeeLocation());
            stmt.setString(7, em.getEmployeePhoneNumber());
            stmt.setString(8, em.getEmployeePosition());

            double salary = em.getSalary();
            BigDecimal decimalSalary = BigDecimal.valueOf(salary);
            stmt.setBigDecimal(9, decimalSalary);

            LocalDate start = em.getDateStart();
            Date dateStart = Date.valueOf(start);
            stmt.setDate(10, dateStart);

            stmt.setBytes(11, em.getImage());
            stmt.setString(12, code);

            n=stmt.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
            System.out.println("e1 update customer error");
        }
        finally {
            try {
                stmt.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
                System.out.println("e2 update customer error");
            }
        }
        return n>0;
    }
//	//test	 THANH CONG
//	public static void main(String[] args) throws SQLException {
//		ConnectDB.getInstance().connectDataBase();
//		System.out.println("xuất hết table: \n" + new EmployeeDao().getAllTableEmployee()); // ra 3 db
//		System.out.println("tìm theo id: \n" + new EmployeeDao().getEmployeeByID("NV001")); // ra 1
//		System.out.println("tìm theo tên: \n"+ new EmployeeDao().getEmployeeByName("Nguyễn Văn A"));
//		System.out.println("tìm theo sdt: \n"+ new EmployeeDao().getEmployeeByPhone("0901234567"));
//
//		// Tạo đối tượng Employee mới
//        Employee employee = new Employee("EMP002");
//
//        NameModel namee = new NameModel("Huyy");
//        employee.setEmployeeName(namee);
//
//        employee.setCitizenIdNumber("123456789");
//        employee.setEmployeeBirthday(LocalDate.of(1990, 5, 15));
//        employee.setEmployeeSex(true);
//        employee.setEmployeeLocation("New York");
//        employee.setEmployeePhoneNumber("1234567890");
//        employee.setEmployeePosition("Manager");
//        employee.setSalary(5000.0);
//        employee.setDateStart(LocalDate.now());
//
//		//System.out.println("tao nv: \n" + new EmployeeDao().createEmployee(employee));
//
//		// Update đối tượng Employee theo EmployeeCode
//        Employee employee1 = new Employee("EMP003");
//
//        NameModel namee1 = new NameModel("Trinh");
//        employee1.setEmployeeName(namee1);
//
//        employee1.setCitizenIdNumber("123456789");
//        employee1.setEmployeeBirthday(LocalDate.of(1990, 5, 15));
//        employee1.setEmployeeSex(true);
//        employee1.setEmployeeLocation("New York");
//        employee1.setEmployeePhoneNumber("1234567890");
//        employee1.setEmployeePosition("Saler");
//        employee1.setSalary(15000.0);
//        employee1.setDateStart(LocalDate.now());
//		//System.out.println("update nv: \n" + new EmployeeDao().updateEmployee(employee1, "EMP002"));
//
//        // xoa đối tượng Employee theo EmployeeCode
//        Employee employee2 = new Employee("EMP001");
//        System.out.println("xoa nv theo id: \n " + new EmployeeDao().removeEmployee(employee2));
//
//	}

}
