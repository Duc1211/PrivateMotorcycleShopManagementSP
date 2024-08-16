package dao;

import java.sql.Statement;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connect.ConnectDB;
import entity.Customer;
import entity.Employee;


public class CustomerDao {

    public CustomerDao() {
        super();
    }

    public ArrayList<Customer> getAllCustomers(){
        ArrayList<Customer> list=new ArrayList<Customer>();
        try {
            ConnectDB.getInstance();
            Connection con=ConnectDB.getConnection();
            String sql="Select * from Customer ";
            Statement statement=con.createStatement();
            //thuc thi cau lenh sql tra ve ket qua resultset
            ResultSet rs= statement.executeQuery(sql);
            //duyet ket qua
            while(rs.next()) {
                int cusCode=rs.getInt("CustomerCode");
                String cusID=rs.getString("NationalID");
                String cusName=rs.getString("Name");
                boolean cusGender=rs.getBoolean("Gender");
                String cusPhone=rs.getString("PhoneNumber");
                String cusLocation=rs.getString("Location");

                Customer cus=new Customer(cusCode, cusID, cusName, cusGender,
                        cusPhone, cusLocation);
                list.add(cus);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Customer> getCustomerByCode(String code) throws SQLException {
        ArrayList<Customer> list = new ArrayList<Customer>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM Customer WHERE CustomerCode = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, code);
            // ketqua
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int cusCode = rs.getInt(1);
                String cusID = rs.getString(2);
                String cusName = rs.getString(3);
                boolean cusGender = rs.getBoolean(4);
                String cusPhone = rs.getString(5);
                String cusLocation = rs.getString(6);

                Customer cus = new Customer(cusCode, cusID, cusName, cusGender, cusPhone, cusLocation);
                list.add(cus);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return list;

    }
    public ArrayList<Customer> getCustomerBySaleContractStatus(Boolean status) throws SQLException {
        ArrayList<Customer> list = new ArrayList<Customer>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM Customer as C INNER JOIN SaleContract as S\n"
                    + "ON C.CustomerCode = S.Customer\n"
                    + "Where S.Status=? ";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, status==true?1:0);
            // ketqua
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int cusCode = rs.getInt(1);
                String cusID = rs.getString(2);
                String cusName = rs.getString(3);
                boolean cusGender = rs.getBoolean(4);
                String cusPhone = rs.getString(5);
                String cusLocation = rs.getString(6);

                Customer cus = new Customer(cusCode, cusID, cusName, cusGender, cusPhone, cusLocation);
                list.add(cus);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return list;

    }
    //	public ArrayList<Customer> getCustomerByOrderStatus(Boolean status) throws SQLException {
//		ArrayList<Customer> list = new ArrayList<Customer>();
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		try {
//			String sql = "SELECT * FROM Customer as C INNER JOIN Order as S\n"
//					+ "ON C.CustomerCode = S.Customer\n"
//					+ "Where S.Status=? ";
//			stmt = con.prepareStatement(sql);
//			stmt.setInt(1, status==true?1:0);
//			// ketqua
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				int cusCode = rs.getInt(1);
//				String cusID = rs.getString(2);
//				String cusName = rs.getString(3);
//				boolean cusGender = rs.getBoolean(4);
//				String cusPhone = rs.getString(5);
//				String cusLocation = rs.getString(6);
//
//				Customer cus = new Customer(cusCode, cusID, cusName, cusGender, cusPhone, cusLocation);
//				list.add(cus);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				stmt.close();
//			} catch (SQLException e2) {
//				e2.printStackTrace();
//			}
//		}
//		return list;
//
//	}
    public ArrayList<Customer> getCustomerByName(String name) throws SQLException {
        ArrayList<Customer> list = new ArrayList<Customer>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM Customer WHERE Name = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            // ketqua
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int cusCode = rs.getInt(1);
                String cusID = rs.getString(2);
                String cusName = rs.getString(3);
                boolean cusGender = rs.getBoolean(4);
                String cusPhone = rs.getString(5);
                String cusLocation = rs.getString(6);

                Customer cus = new Customer(cusCode, cusID, cusName, cusGender, cusPhone, cusLocation);
                list.add(cus);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return list;

    }
    public ArrayList<Customer> getCustomerByPhone(String phone) throws SQLException {
        ArrayList<Customer> list = new ArrayList<Customer>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT * FROM Customer WHERE PhoneNumber = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, phone);
            // ketqua
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int cusCode = rs.getInt(1);
                String cusID = rs.getString(2);
                String cusName = rs.getString(3);
                boolean cusGender = rs.getBoolean(4);
                String cusPhone = rs.getString(5);
                String cusLocation = rs.getString(6);

                Customer cus = new Customer(cusCode, cusID, cusName, cusGender, cusPhone, cusLocation);
                list.add(cus);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return list;

    }

    public boolean createCustomer(Customer cus) throws SQLException {
        ConnectDB.getInstance();
        Connection con=ConnectDB.getConnection();
        PreparedStatement stmt=null;
        int n=0;
        try {
            stmt=con.prepareStatement("insert into Customer (NationalID,Name,Gender,PhoneNumber,Location)"
                    + "  values( ?, ?, ?, ?, ?)");
            stmt.setString(1,cus.getCitizenIdNumber());
            stmt.setString(2, cus.getCustomerName());
            stmt.setBoolean(3,cus.isCustomerSex());
            stmt.setString(4,cus.getCustomerPhoneNumber());
            stmt.setString(5,cus.getCustomerLocation());
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
    public boolean removeCustomer(Customer cus) throws SQLException {
        ConnectDB.getInstance();
        Connection con=ConnectDB.getConnection();
        PreparedStatement stmt=null;
        int n=0;
        try {
            stmt=con.prepareStatement("delete from "+" Customer where CustomerCode=?");

            stmt.setInt(1,cus.getCustomerCode());
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
    public boolean updateCustomer(Customer cus,int code) throws SQLException {
        ConnectDB.getInstance();
        Connection con=ConnectDB.getConnection();
        PreparedStatement stmt=null;
        int n=0;
        try {
            stmt = con.prepareStatement("UPDATE Customer SET NationalID =?, Name =?, Gender =?, PhoneNumber =?, Location =? WHERE CustomerCode =? ");


            stmt.setString(1,cus.getCitizenIdNumber());
            stmt.setString(2,cus.getCustomerName());
            stmt.setInt(3, cus.isCustomerSex()==true?1:0);
            stmt.setString(4,cus.getCustomerPhoneNumber());
            stmt.setString(5,cus.getCustomerLocation());
            stmt.setInt(6,code);
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
    public boolean updateStatus(int cusCode,boolean status) throws SQLException {
        ConnectDB.getInstance();
        Connection con=ConnectDB.getConnection();
        PreparedStatement stmt=null;
        int n=0;
        try {
            stmt = con.prepareStatement("UPDATE SaleContract  SET Status=? Where Customer=?");


            stmt.setInt(2,cusCode);
            stmt.setInt(1,status==true?1:0);
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

}