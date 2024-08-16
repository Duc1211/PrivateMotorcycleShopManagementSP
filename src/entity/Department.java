package entity;

import java.util.Objects;

public class Department {
    private String departmentID;
    private String departmentName;

    public String getDepartmentID() {
        return departmentID;
    }
    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public Department(String departmentID, String departmentName) {
        super();
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }
    public Department() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public int hashCode() {
        return Objects.hash(departmentID);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Department other = (Department) obj;
        return Objects.equals(departmentID, other.departmentID);
    }


}
