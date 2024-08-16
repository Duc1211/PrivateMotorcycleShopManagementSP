package dao;

import connect.ConnectDB;
import entity.Employee;
import entity.RangeOfVehicle;
import entity.Vehicle;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class RangeOfVehicleDao {
    public ArrayList<RangeOfVehicle> getAllTableRangOfVehicle(){
        ArrayList<RangeOfVehicle> listRangeOfVehicle = new ArrayList<RangeOfVehicle>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "Select * from RangeOfVehicle";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String vehicleTypeCode = rs.getString(1);
                String vehicleTypeName = rs.getString(2);

                RangeOfVehicle rv = new RangeOfVehicle(vehicleTypeCode, vehicleTypeName);
                listRangeOfVehicle.add(rv);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listRangeOfVehicle;
    }
    public boolean addTypeVehicle(RangeOfVehicle rv) throws SQLException {
        ConnectDB.getInstance();
        Connection con=ConnectDB.getConnection();
        PreparedStatement stmt=null;
        int n=0;
        try {
            stmt = con.prepareStatement("INSERT INTO RangeOfVehicle (VehicleTypeCode, VehicleTypeName " +
                    "VALUES (?, ?)");

            stmt.setString(1,rv.getVehicleTypeCode());

            stmt.setString(2, rv.getVehicleTypeName());


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
    public boolean removeTypeVehicle(RangeOfVehicle rv) throws SQLException {
        ConnectDB.getInstance();
        Connection con=ConnectDB.getConnection();
        PreparedStatement stmt=null;
        int n=0;
        try {
            stmt=con.prepareStatement("delete from "+" RangOfVehicle where VehicleTypeCode = ?");

            stmt.setString(1, rv.getVehicleTypeCode());
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

}
