package dao;

import connect.ConnectDB;
import entity.Employee;
import entity.MotorcycleCompany;
import entity.RangeOfVehicle;
import entity.Vehicle;
import model.NameModel;

import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class VehicleDao {
    private final Connection connection;
    private ArrayList<Vehicle> listVehicle;
    private Vehicle vehicle;

    public VehicleDao()throws SQLException{
        connection = ConnectDB.getInstance().getConnection();
    }
    public ArrayList<Vehicle> getAllTableVehicle(){
        ArrayList<Vehicle> listVehicle = new ArrayList<Vehicle>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "SELECT * FROM Vehicle " +
                    "JOIN MotorcycleCompany ON Vehicle.VehicleCompany = MotorcycleCompany.VehicleCompanyCode " +
                    "JOIN RangeOfVehicle ON Vehicle.RangeOfVehicle = RangeOfVehicle.VehicleTypeCode";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                String vehicleCode = rs.getString(1);
                byte[] vehicleImage = rs.getBytes(2);
                String vehicleName = rs.getString(3);
                String vehicleModel = rs.getString(4);
                String cylinderCapacity = rs.getString(5);
                String engineCapacity = rs.getString(6);
                int yearManufacture = rs.getInt(7);
                double salePrice = rs.getDouble(8);
                int vehicleMass = rs.getInt(9);
                String petrolTankCapacity = rs.getString(10);
                String compressionRatio = rs.getString(11);
                String engineType = rs.getString(12);
                String transmissionType = rs.getString(13);
                String fuelConsumption = rs.getString(14);
                Date vehicleEntryDate = rs.getDate(15);
                LocalDate entryDate = vehicleEntryDate.toLocalDate();
                String vehicleIdNumber = rs.getString(16);
                String vehicleColor = rs.getString(17);
                String vehicleCompanyCode = rs.getString(18);
                String vehicleCompanyName = rs.getString("VehicleCompanyName");
                MotorcycleCompany mc  = new MotorcycleCompany(vehicleCompanyCode, vehicleCompanyName);
                String rangeofVehicleCode = rs.getString(19);
                String rangeofVehicleName = rs.getString("VehicleTypeName");
                RangeOfVehicle rv = new RangeOfVehicle(rangeofVehicleCode, rangeofVehicleName);
                double importPrice = rs.getDouble(20);

                Vehicle v = new Vehicle(vehicleCode, vehicleImage, mc, rv, vehicleName, vehicleModel,
                        cylinderCapacity, engineCapacity, yearManufacture, salePrice, vehicleMass, petrolTankCapacity,
                        compressionRatio, engineType, transmissionType, fuelConsumption, entryDate, vehicleIdNumber,
                        vehicleColor, importPrice);
                listVehicle.add(v);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listVehicle;
    }

    // get Vehicle by Code
    public ArrayList<Vehicle> getVehicleByCode(String code){
        ArrayList<Vehicle> listVehicle = new ArrayList<Vehicle>();
        try {
            ConnectDB.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Connection con = ConnectDB.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql =" SELECT * FROM Vehicle JOIN MotorcycleCompany ON Vehicle.VehicleCompany = MotorcycleCompany.VehicleCompanyCode JOIN RangeOfVehicle ON Vehicle.RangeOfVehicle = RangeOfVehicle.VehicleTypeCode where VehicleCode = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, code);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                String vehicleCode = rs.getString(1);
                byte[] vehicleImage = rs.getBytes(2);
                String vehicleName = rs.getString(3);
                String vehicleModel = rs.getString(4);
                String cylinderCapacity = rs.getString(5);
                String engineCapacity = rs.getString(6);
                int yearManufacture = rs.getInt(7);
                double salePrice = rs.getDouble(8);
                int vehicleMass = rs.getInt(9);
                String petrolTankCapacity = rs.getString(10);
                String compressionRatio = rs.getString(11);
                String engineType = rs.getString(12);
                String transmissionType = rs.getString(13);
                String fuelConsumption = rs.getString(14);
                Date vehicleEntryDate = rs.getDate(15);
                LocalDate entryDate = vehicleEntryDate.toLocalDate();
                String vehicleIdNumber = rs.getString(16);
                String vehicleColor = rs.getString(17);
                String vehicleCompanyCode = rs.getString(18);
                String vehicleCompanyName = rs.getString("VehicleCompanyName");
                MotorcycleCompany mc  = new MotorcycleCompany(vehicleCompanyCode, vehicleCompanyName);
                String rangeofVehicleCode = rs.getString(19);
                String rangeofVehicleName = rs.getString("VehicleTypeName");
                RangeOfVehicle rv = new RangeOfVehicle(rangeofVehicleCode, rangeofVehicleName);
                double importPrice = rs.getDouble(20);

                Vehicle v = new Vehicle(vehicleCode, vehicleImage, mc, rv, vehicleName, vehicleModel,
                        cylinderCapacity, engineCapacity, yearManufacture, salePrice, vehicleMass, petrolTankCapacity,
                        compressionRatio, engineType, transmissionType, fuelConsumption, entryDate, vehicleIdNumber,
                        vehicleColor, importPrice);
                listVehicle.add(v);
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
        return listVehicle;
    }
// get Vehicle by Name
    public ArrayList<Vehicle> getVehicleByName(String name){
        ArrayList<Vehicle> listVehicle = new ArrayList<Vehicle>();
        try {
            ConnectDB.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Connection con = ConnectDB.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql ="SELECT * FROM Vehicle JOIN MotorcycleCompany ON Vehicle.VehicleCompany = MotorcycleCompany.VehicleCompanyCode JOIN RangeOfVehicle ON Vehicle.RangeOfVehicle = RangeOfVehicle.VehicleTypeCode where VehicleName = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                String vehicleCode = rs.getString(1);
                byte[] vehicleImage = rs.getBytes(2);
                String vehicleName = rs.getString(3);
                String vehicleModel = rs.getString(4);
                String cylinderCapacity = rs.getString(5);
                String engineCapacity = rs.getString(6);
                int yearManufacture = rs.getInt(7);
                double salePrice = rs.getDouble(8);
                int vehicleMass = rs.getInt(9);
                String petrolTankCapacity = rs.getString(10);
                String compressionRatio = rs.getString(11);
                String engineType = rs.getString(12);
                String transmissionType = rs.getString(13);
                String fuelConsumption = rs.getString(14);
                Date vehicleEntryDate = rs.getDate(15);
                LocalDate entryDate = vehicleEntryDate.toLocalDate();
                String vehicleIdNumber = rs.getString(16);
                String vehicleColor = rs.getString(17);
                String vehicleCompanyCode = rs.getString(18);
                String vehicleCompanyName = rs.getString("VehicleCompanyName");
                MotorcycleCompany mc  = new MotorcycleCompany(vehicleCompanyCode, vehicleCompanyName);
                String rangeofVehicleCode = rs.getString(19);
                String rangeofVehicleName = rs.getString("VehicleTypeName");
                RangeOfVehicle rv = new RangeOfVehicle(rangeofVehicleCode, rangeofVehicleName);
                double importPrice = rs.getDouble(20);

                Vehicle v = new Vehicle(vehicleCode, vehicleImage, mc, rv, vehicleName, vehicleModel,
                        cylinderCapacity, engineCapacity, yearManufacture, salePrice, vehicleMass, petrolTankCapacity,
                        compressionRatio, engineType, transmissionType, fuelConsumption, entryDate, vehicleIdNumber,
                        vehicleColor, importPrice);
                listVehicle.add(v);
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
        return listVehicle;
    }
    // get Vehicle by Type
    public ArrayList<Vehicle> getVehicleByType(String type){
        ArrayList<Vehicle> listVehicle = new ArrayList<Vehicle>();
        try {
            ConnectDB.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Connection con = ConnectDB.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql ="SELECT * FROM Vehicle JOIN MotorcycleCompany ON Vehicle.VehicleCompany = MotorcycleCompany.VehicleCompanyCode JOIN RangeOfVehicle ON Vehicle.RangeOfVehicle = RangeOfVehicle.VehicleTypeCode where RangeOfVehicle = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, type);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                String vehicleCode = rs.getString(1);
                byte[] vehicleImage = rs.getBytes(2);
                String vehicleName = rs.getString(3);
                String vehicleModel = rs.getString(4);
                String cylinderCapacity = rs.getString(5);
                String engineCapacity = rs.getString(6);
                int yearManufacture = rs.getInt(7);
                double salePrice = rs.getDouble(8);
                int vehicleMass = rs.getInt(9);
                String petrolTankCapacity = rs.getString(10);
                String compressionRatio = rs.getString(11);
                String engineType = rs.getString(12);
                String transmissionType = rs.getString(13);
                String fuelConsumption = rs.getString(14);
                Date vehicleEntryDate = rs.getDate(15);
                LocalDate entryDate = vehicleEntryDate.toLocalDate();
                String vehicleIdNumber = rs.getString(16);
                String vehicleColor = rs.getString(17);
                String vehicleCompanyCode = rs.getString(18);
                String vehicleCompanyName = rs.getString("VehicleCompanyName");
                MotorcycleCompany mc  = new MotorcycleCompany(vehicleCompanyCode, vehicleCompanyName);
                String rangeofVehicleCode = rs.getString(19);
                String rangeofVehicleName = rs.getString("VehicleTypeName");
                RangeOfVehicle rv = new RangeOfVehicle(rangeofVehicleCode, rangeofVehicleName);
                double importPrice = rs.getDouble(20);

                Vehicle v = new Vehicle(vehicleCode, vehicleImage, mc, rv, vehicleName, vehicleModel,
                        cylinderCapacity, engineCapacity, yearManufacture, salePrice, vehicleMass, petrolTankCapacity,
                        compressionRatio, engineType, transmissionType, fuelConsumption, entryDate, vehicleIdNumber,
                        vehicleColor, importPrice);
                listVehicle.add(v);
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
        return listVehicle;
    }
    public boolean addVehicle(Vehicle v) throws SQLException {
        ConnectDB.getInstance();
        Connection con=ConnectDB.getConnection();
        PreparedStatement stmt=null;
        int n=0;
        try {
            stmt = con.prepareStatement("INSERT INTO Vehicle (VehicleCode, VehicleImage, VehicleName, VehicleModel, CylinderCapacity, EngineCapacity\n" +
                    "                        , YearManufacture, VehiclePrice, VehicleMass, PetrolTankCapacity,\n" +
                    "                        CompressionRatio, EngineType, TransmissionType, FuelConsumption, VehicleEntryDate, VehicleIdNumber,\n" +
                    "                        VehicleColor, VehicleCompany, RangeOfVehicle, ImportPrice) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1,v.getVehicleCode());
            stmt.setBytes(2, v.getVehicleImage());
            stmt.setString(3, v.getVehicleName());
            stmt.setString(4, v.getVehicleModel());
            stmt.setString(5, v.getCylinderCapacity());
            stmt.setString(6, v.getEngineCapacity());
            stmt.setInt(7, v.getYearManufacture());
            stmt.setDouble(8, v.getVehiclePrice());
            stmt.setInt(9, v.getVehicleMass());
            stmt.setString(10, v.getPetrolTankCapacity());
            stmt.setString(11, v.getCompressionRatio());
            stmt.setString(12, v.getEngineType());
            stmt.setString(13, v.getTransmissionType());
            stmt.setString(14, v.getFuelConsumption());
            LocalDate vehicleEntryDate = v.getVehicleEntryDate();
            Date entryDate = Date.valueOf(vehicleEntryDate);
            stmt.setDate(15, entryDate);
            stmt.setString(16, v.getVehicleIdNumber());
            stmt.setString(17, v.getVehicleColor());
            stmt.setString(18, v.getVehicleCompany().getVehicleCompanyCode());
            stmt.setString(19, v.getRangeOfVehicle().getVehicleTypeCode());
            stmt.setDouble(20, v.getImportPrice());

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

    public boolean removeVehicle(Vehicle v) throws SQLException {
        ConnectDB.getInstance();
        Connection con=ConnectDB.getConnection();
        PreparedStatement stmt=null;
        int n=0;
        try {
            stmt=con.prepareStatement("delete from Vehice where VehicleCode=?");

            stmt.setString(1, v.getVehicleCode());
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

    public boolean updateVehicle(Vehicle v,String code) throws SQLException {
        ConnectDB.getInstance();
        Connection con=ConnectDB.getConnection();
        PreparedStatement stmt=null;
        int n=0;
        try {
            stmt = con.prepareStatement("UPDATE  Vehicle SET VehicleImage = ?, VehicleName=?, VehicleModel=?, CylinderCapacity=?, EngineCapacity=?, YearManufacture=?, SalePrice=?, VehicleMass=?, PetrolTankCapacity=?,CompressionRatio=?, EngineType=?, TransmissionType=?, FuelConsumption=?, VehicleEntryDate=?, VehicleIdNumber=?,VehicleColor=?, VehicleCompany=?, RangeOfVehicle=?, ImportPrice=? WHERE VehicleCode = ?");

            stmt.setString(20,code);
            stmt.setBytes(1, v.getVehicleImage());
            stmt.setString(2, v.getVehicleName());
            stmt.setString(3, v.getVehicleModel());
            stmt.setString(4, v.getCylinderCapacity());
            stmt.setString(5, v.getEngineCapacity());
            stmt.setInt(6, v.getYearManufacture());
            stmt.setDouble(7, v.getVehiclePrice());
            stmt.setInt(8, v.getVehicleMass());
            stmt.setString(9, v.getPetrolTankCapacity());
            stmt.setString(10, v.getCompressionRatio());
            stmt.setString(11, v.getEngineType());
            stmt.setString(12, v.getTransmissionType());
            stmt.setString(13, v.getFuelConsumption());
            LocalDate vehicleEntryDate = v.getVehicleEntryDate();
            Date entryDate = Date.valueOf(vehicleEntryDate);
            stmt.setDate(14, entryDate);
            stmt.setString(15, v.getVehicleIdNumber());
            stmt.setString(16, v.getVehicleColor());
            stmt.setString(17, v.getVehicleCompany().getVehicleCompanyCode());
            stmt.setString(18, v.getRangeOfVehicle().getVehicleTypeCode());
            stmt.setDouble(19, v.getImportPrice());

            n=stmt.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
            System.out.println("e1 Update Vehicle Error!");
        }
        finally {
            try {
                stmt.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
                System.out.println("e2 Update Vehicle Error!");
            }
        }
        return n>0;
    }

}
