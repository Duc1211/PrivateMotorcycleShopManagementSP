package dao;

import connect.ConnectDB;
import entity.MotorcycleCompany;
import entity.RangeOfVehicle;
import entity.Vehicle;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class BrandDao {
    public ArrayList<MotorcycleCompany> getAllTableMotorcycleCompany(){
        ArrayList<MotorcycleCompany> listMotorcycleCompany = new ArrayList<MotorcycleCompany>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "Select * from MotorcycleCompany";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String vehicleCompanyCode = rs.getString(1);
                String vehicleCompanyName = rs.getString(2);

                MotorcycleCompany mc = new MotorcycleCompany(vehicleCompanyCode, vehicleCompanyName);
                listMotorcycleCompany.add(mc);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listMotorcycleCompany;
    }
    public boolean addVehicleCompany(MotorcycleCompany mc) throws SQLException {
        ConnectDB.getInstance();
        Connection con=ConnectDB.getConnection();
        PreparedStatement stmt=null;
        int n=0;
        try {
            stmt = con.prepareStatement("INSERT INTO RangeOfVehicle (VehicleCompanyCode, VehicleCompanyName " +
                    "VALUES (?, ?)");

            stmt.setString(1,mc.getVehicleCompanyCode());

            stmt.setString(2, mc.getVehicleCompanyName());


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
    public boolean removeVehicleCompany(MotorcycleCompany mc) throws SQLException {
        ConnectDB.getInstance();
        Connection con=ConnectDB.getConnection();
        PreparedStatement stmt=null;
        int n=0;
        try {
            stmt=con.prepareStatement("delete from "+" MotorcycleCompany where VehicleCompanyCode = ?");

            stmt.setString(1, mc.getVehicleCompanyCode());
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
