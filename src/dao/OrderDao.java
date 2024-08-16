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
import entity.Customer;
import entity.Employee;
import entity.Order;
import entity.Vehicle;
import model.NameModel;

public class OrderDao {
    public OrderDao() {
        // TODO Auto-generated constructor stub
    }
    public ArrayList<Order> getAllTableOrder(){
        ArrayList<Order> list = new ArrayList<Order>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "Select * from Order";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                int orderCode = rs.getInt(1);
                Customer customer=new Customer(rs.getString("Customer"));
//				 Employee employee=new Employee(rs.getString("Employee"));
                Vehicle vehicle=new Vehicle(rs.getString("Vehicle"));
                String location=rs.getString("Location");
                boolean insurance=rs.getBoolean("Insurance");
                double deposit=rs.getDouble("Deposit");
                Date date = rs.getDate("OrderDate");
                LocalDate orderDate = date.toLocalDate();
                boolean status = rs.getBoolean("Status");

                Order o=new Order(orderCode, customer, vehicle,
                        location, insurance, deposit, orderDate, status);
                list.add(o);
            }
        }
        catch (SQLException e) {
            System.out.println("getAllOrder sql error!");
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<Order> getOrderByCode(String code){
        ArrayList<Order> list = new ArrayList<Order>();
        try {
            ConnectDB.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Connection con = ConnectDB.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql ="Select * from Order where OrderCode = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, code);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                int orderCode = rs.getInt(1);
                Customer customer=new Customer(rs.getString("Customer"));
//				 Employee employee=new Employee(rs.getString("Employee"));
                Vehicle vehicle=new Vehicle(rs.getString("Vehicle"));
                String location=rs.getString("Location");
                boolean insurance=rs.getBoolean("Insurance");
                double deposit=rs.getDouble("Deposit");
                Date date = rs.getDate("OrderDate");
                LocalDate orderDate = date.toLocalDate();
                boolean status = rs.getBoolean("Status");

                Order o=new Order(orderCode, customer, vehicle,
                        location, insurance, deposit, orderDate, status);
                list.add(o);
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
        return list;
    }
    //	public ArrayList<Order> getOrderByInfo(Customer cus,Vehicle v){
//		 ArrayList<Order> list = new ArrayList<Order>();
//		 try {
//			ConnectDB.getInstance();
//		 } catch (SQLException e) {
//			e.printStackTrace();
//		 }
//
//		 Connection con = ConnectDB.getConnection();
//		 PreparedStatement pstmt = null;
//		 try {
//			 String sql ="Select * from Order where Customer=?,Vehicle=?";
//			 pstmt = con.prepareStatement(sql);
////			 pstmt.setString(1, em.getEmployeeCode());
//			 pstmt.setInt(1, cus.getCustomerCode());
//			 pstmt.setString(2, v.getVehicleCode());
//
//			 ResultSet rs = pstmt.executeQuery();
//			 while(rs.next())
//			 {
//				 int orderCode = rs.getInt(1);
//				 Customer customer=new Customer(rs.getString("Customer"));
////				 Employee employee=new Employee(rs.getString("Employee"));
//				 Vehicle vehicle=new Vehicle(rs.getString("Vehicle"));
//				 String location=rs.getString("Location");
//				 boolean insurance=rs.getBoolean("Insurance");
//				 double deposit=rs.getDouble("Deposit");
//				 Date date = rs.getDate("OrderDate");
//				 LocalDate orderDate = date.toLocalDate();
//				 boolean status = rs.getBoolean("Status");
//
//				 Order o=new Order(orderCode, customer, vehicle,
//						 location, insurance, deposit, orderDate, status);
//				 list.add(o);
//			 }
//		 }
//		 catch (SQLException e) {
//			e.printStackTrace();
//		}
//		 finally {
//			try {
//				pstmt.close();
//			}
//			catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		 return list;
//	}
    //lay nhan vien theo ten
    public ArrayList<Order> getOrderByEmployeeCode(Employee em){
        ArrayList<Order> list = new ArrayList<Order>();
        try {
            ConnectDB.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Connection con = ConnectDB.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql ="Select * from Order where Employee = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, em.getEmployeeCode());

            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                int orderCode = rs.getInt(1);
                Customer customer=new Customer(rs.getString("Customer"));
//				 Employee employee=new Employee(rs.getString("Employee"));
                Vehicle vehicle=new Vehicle(rs.getString("Vehicle"));
                String location=rs.getString("Location");
                boolean insurance=rs.getBoolean("Insurance");
                double deposit=rs.getDouble("Deposit");
                Date date = rs.getDate("OrderDate");
                LocalDate orderDate = date.toLocalDate();
                boolean status = rs.getBoolean("Status");

                Order o=new Order(orderCode, customer,  vehicle,
                        location, insurance, deposit, orderDate, status);
                list.add(o);
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
        return list;
    }
    //lay nhan vien theo sdt
    public ArrayList<Order> getOrderByCustomer(Customer cus){
        ArrayList<Order> list = new ArrayList<Order>();
        try {
            ConnectDB.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Connection con = ConnectDB.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql ="Select * from Order where Employee = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, cus.getCustomerCode());

            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                int orderCode = rs.getInt(1);
                Customer customer=new Customer(rs.getString("Customer"));
//				 Employee employee=new Employee(rs.getString("Employee"));
                Vehicle vehicle=new Vehicle(rs.getString("Vehicle"));
                String location=rs.getString("Location");
                boolean insurance=rs.getBoolean("Insurance");
                double deposit=rs.getDouble("Deposit");
                Date date = rs.getDate("OrderDate");
                LocalDate orderDate = date.toLocalDate();
                boolean status = rs.getBoolean("Status");

                Order o=new Order(orderCode, customer,  vehicle,
                        location, insurance, deposit, orderDate, status);
                list.add(o);
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
        return list;
    }
    public boolean createOrder(Order o) throws SQLException {
        ConnectDB.getInstance();
        Connection con=ConnectDB.getConnection();
        PreparedStatement stmt=null;
        int n=0;
        try {
            stmt = con.prepareStatement("INSERT INTO Order ( Customer,"
                    + " Vehicle, Location, Insurance, Deposit, OrderDate, status) " +
                    "VALUES (  ?, ?, ?, ?, ?, ?, ?)");

//			stmt.setInt(1,o.getOrderCode());

            stmt.setInt(1, o.getCustomer().getCustomerCode());

//			stmt.setString(2, o.getEmployee().getEmployeeCode());
            stmt.setString(2, o.getVehicle().getVehicleCode());
            stmt.setString(3, o.getLocation());
            stmt.setBoolean(4,o.isInsurance());
            stmt.setDouble(5, o.getDeposit());
            LocalDate date = o.getOrderDate();
            Date orderDate = Date.valueOf(date);
            stmt.setDate(6, orderDate );
            stmt.setBoolean(7, o.isStatus());

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

    public boolean removeOrder(Order o) throws SQLException {
        ConnectDB.getInstance();
        Connection con=ConnectDB.getConnection();
        PreparedStatement stmt=null;
        int n=0;
        try {
            stmt=con.prepareStatement("delete from Order where OrderCode=?");

            stmt.setInt(1, o.getOrderCode());
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

    public boolean updateOrder(Order o,String code) throws SQLException {
        ConnectDB.getInstance();
        Connection con=ConnectDB.getConnection();
        PreparedStatement stmt=null;
        int n=0;
        try {
            stmt = con.prepareStatement("UPDATE Order SET Customer= ? Vehicle = ?, Location = ?, Insurance = ?, Deposit= ?, OrderDate = ?, status = ? WHERE OrderCode = ?");

//			stmt.setString(1,o.getOrderCode());

            stmt.setInt(1, o.getCustomer().getCustomerCode());

//			stmt.setString(2, o.getEmployee().getEmployeeCode());
            stmt.setString(2, o.getVehicle().getVehicleCode());
            stmt.setString(3, o.getLocation());
            stmt.setBoolean(4,o.isInsurance());
            stmt.setDouble(5, o.getDeposit());
            LocalDate date = o.getOrderDate();
            Date orderDate = Date.valueOf(date);
            stmt.setDate(6, orderDate );
            stmt.setBoolean(7, o.isStatus());
            stmt.setString(8, code);

            n=stmt.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
            System.out.println("e1 update order error");
        }
        finally {
            try {
                stmt.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
                System.out.println("e2 update order error");
            }
        }
        return n>0;
    }
}
