package entity;

import java.io.Serializable;
import java.util.Objects;

public class MotorcycleCompany implements Serializable {
    private String vehicleCompanyCode;
    private String vehicleCompanyName;

    public MotorcycleCompany() {
    }

    public MotorcycleCompany(String vehicleCompanyCode, String vehicleCompanyName) {
        this.vehicleCompanyCode = vehicleCompanyCode;
        this.vehicleCompanyName = vehicleCompanyName;
    }

    public MotorcycleCompany(String vehicleCompanyCode) {
        this.vehicleCompanyCode = vehicleCompanyCode;
    }

    public String getVehicleCompanyCode() {
        return vehicleCompanyCode;
    }


    public String getVehicleCompanyName() {
        return vehicleCompanyName;
    }

    public void setVehicleCompanyName(String vehicleCompanyName) {
        this.vehicleCompanyName = vehicleCompanyName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleCompanyCode);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MotorcycleCompany other = (MotorcycleCompany) obj;
        return Objects.equals(vehicleCompanyCode, other.vehicleCompanyCode);
    }

}
