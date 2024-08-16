package entity;

import java.io.Serializable;
import java.util.Objects;

public class RangeOfVehicle implements Serializable {
    private String vehicleTypeCode;
    private String vehicleTypeName;

    public RangeOfVehicle() {
    }

    public RangeOfVehicle(String vehicleTypeCode, String vehicleTypeName) {
        this.vehicleTypeCode = vehicleTypeCode;
        this.vehicleTypeName = vehicleTypeName;
    }

    public RangeOfVehicle(String vehicleTypeCode) {
        this.vehicleTypeCode = vehicleTypeCode;
    }

    public String getVehicleTypeCode() {
        return vehicleTypeCode;
    }


    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }
    @Override
    public int hashCode() {
        return Objects.hash(vehicleTypeCode);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RangeOfVehicle other = (RangeOfVehicle) obj;
        return Objects.equals(vehicleTypeCode, other.vehicleTypeCode);
    }

}
