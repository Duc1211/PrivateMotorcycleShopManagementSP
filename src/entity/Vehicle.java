package entity;

import format.event.TableActionEvent;
import model.ActionModel;

import javax.swing.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Objects;

public class Vehicle {
    private String vehicleCode;
    private byte[] vehicleImage;
    private MotorcycleCompany vehicleCompany;
    //Hang xe
    private RangeOfVehicle rangeOfVehicle;
    //Loai xe
    private String vehicleName;
    private String vehicleModel;
    //Mau xe
    private String cylinderCapacity;
    //Dung tich xi lanh
    private String engineCapacity;
    //Cong suat dong co
    private int yearManufacture;
    //Nam san xuat
    private double vehiclePrice;
    //Gia xe
    private int vehicleMass;
    //Khoi luong xe
    private String petrolTankCapacity;
    //Dung tich binh xang
    private String compressionRatio;
    //Ty so nen
    private String engineType;
    //Loai dong co
    private String transmissionType;
    //Loai truyen dong
    private String fuelConsumption;
    //Muc tieu thu nhien lieu
    private LocalDate vehicleEntryDate;
    //Ngay nhap xe
    private String vehicleIdNumber;
    //So khung xe
    private String vehicleColor;
    private double importPrice;

    public Vehicle() {
    }

    public Vehicle(String vehicleCode, byte[] vehicleImage, MotorcycleCompany vehicleCompany,
                   RangeOfVehicle rangeOfVehicle, String vehicleName, String vehicleModel,
                   String cylinderCapacity, String engineCapacity, int yearManufacture,
                   double vehiclePrice, int vehicleMass, String petrolTankCapacity,
                   String compressionRatio, String engineType, String transmissionType,
                   String fuelConsumption, LocalDate vehicleEntryDate, String vehicleIdNumber,
                   String vehicleColor, double importPrice) {
        this.vehicleCode = vehicleCode;
        this.vehicleImage = vehicleImage;
        this.vehicleCompany = vehicleCompany;
        this.rangeOfVehicle = rangeOfVehicle;
        this.vehicleName = vehicleName;
        this.vehicleModel = vehicleModel;
        this.cylinderCapacity = cylinderCapacity;
        this.engineCapacity = engineCapacity;
        this.yearManufacture = yearManufacture;
        this.vehiclePrice = vehiclePrice;
        this.vehicleMass = vehicleMass;
        this.petrolTankCapacity = petrolTankCapacity;
        this.compressionRatio = compressionRatio;
        this.engineType = engineType;
        this.transmissionType = transmissionType;
        this.fuelConsumption = fuelConsumption;
        this.vehicleEntryDate = vehicleEntryDate;
        this.vehicleIdNumber = vehicleIdNumber;
        this.vehicleColor = vehicleColor;
        this.importPrice = importPrice;
    }

    public Vehicle(String vehicleCode, MotorcycleCompany vehicleCompany, RangeOfVehicle rangeOfVehicle,
                   String vehicleName, String vehicleModel, double vehiclePrice, String vehicleColor, double importPrice) {
        this.vehicleCode = vehicleCode;
        this.vehicleCompany = vehicleCompany;
        this.rangeOfVehicle = rangeOfVehicle;
        this.vehicleName = vehicleName;
        this.vehicleModel = vehicleModel;
        this.vehiclePrice = vehiclePrice;
        this.vehicleColor = vehicleColor;
        this.importPrice = importPrice;
    }

    public Vehicle(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleCode() {
        return vehicleCode;
    }
    public byte[] getVehicleImage() {
        return vehicleImage;
    }
    public void setVehicleImage(byte[] vehicleImage) {
        this.vehicleImage = vehicleImage;
    }
    public MotorcycleCompany getVehicleCompany() {
        return vehicleCompany;
    }
    public void setVehicleCompany(MotorcycleCompany vehicleCompany) {
        this.vehicleCompany = vehicleCompany;
    }
    public RangeOfVehicle getRangeOfVehicle() {
        return rangeOfVehicle;
    }
    public void setRangeOfVehicle(RangeOfVehicle rangeOfVehicle) {
        this.rangeOfVehicle = rangeOfVehicle;
    }
    public String getVehicleName() {
        return vehicleName;
    }
    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(String cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getYearManufacture() {
        return yearManufacture;
    }

    public void setYearManufacture(int yearManufacture) {
        this.yearManufacture = yearManufacture;
    }

    public double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public int getVehicleMass() {
        return vehicleMass;
    }

    public void setVehicleMass(int vehicleMass) {
        this.vehicleMass = vehicleMass;
    }

    public String getPetrolTankCapacity() {
        return petrolTankCapacity;
    }

    public void setPetrolTankCapacity(String petrolTankCapacity) {
        this.petrolTankCapacity = petrolTankCapacity;
    }

    public String getCompressionRatio() {
        return compressionRatio;
    }

    public void setCompressionRatio(String compressionRatio) {
        this.compressionRatio = compressionRatio;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public LocalDate getVehicleEntryDate() {
        return vehicleEntryDate;
    }

    public void setVehicleEntryDate(LocalDate vehicleEntryDate) {
        this.vehicleEntryDate = vehicleEntryDate;
    }

    public String getVehicleIdNumber() {
        return vehicleIdNumber;
    }

    public void setVehicleIdNumber(String vehicleIdNumber) {
        this.vehicleIdNumber = vehicleIdNumber;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }
    public Object[] toRowTable(TableActionEvent event) {
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        return new Object[]{ vehicleCode, vehicleName, rangeOfVehicle.getVehicleTypeName(), vehicleCompany.getVehicleCompanyName(),
                vehicleModel, vehicleColor, vehicleEntryDate, df.format(vehiclePrice), new ActionModel(this, event)};
    }
    @Override
    public int hashCode() {
        return Objects.hash(vehicleCode);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vehicle other = (Vehicle) obj;
        return Objects.equals(vehicleCode, other.vehicleCode);
    }

}