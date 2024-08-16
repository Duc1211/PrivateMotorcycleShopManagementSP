package entity;

import java.util.Objects;

public class Customer {
    private int customerCode;
    private String nationalID;
    private String Name;
    private boolean Gender;
    private String PhoneNumber;
    private String Location;




    public Customer(int customerCode, String nationalID, String name, boolean gender, String phoneNumber,
                    String location) {
        super();
        this.customerCode = customerCode;
        this.nationalID = nationalID;
        this.Name = name;
        this.Gender = gender;
        this.PhoneNumber = phoneNumber;
        this.Location = location;
    }


    public Customer(int customerCode) {
        super();
        this.customerCode = customerCode;
    }


//	public Customer(String phoneNumber) {
//		super();
//		this.PhoneNumber = phoneNumber;
//	}


    public Customer() {
    }




    public Customer(String name) {
        super();
        this.Name = name;
    }


    public Customer(String name, String phoneNumber) {
        super();
        Name = name;
        PhoneNumber = phoneNumber;
    }


    public Customer(String nationalID, String name, boolean gender, String phoneNumber, String location) {
        super();
        this.nationalID = nationalID;
        this.Name = name;
        this.Gender = gender;
        this.PhoneNumber = phoneNumber;
        this.Location = location;
    }


    public int getCustomerCode() {
        return customerCode;
    }



    public String getCustomerName() {
        return Name;
    }

    public void setCustomerName(String customerName) {
        this.Name = customerName;
    }

    public String getCitizenIdNumber() {
        return nationalID;
    }

    public void setCitizenIdNumber(String citizenIdNumber) {
        this.nationalID = citizenIdNumber;
    }

    public String getCustomerLocation() {
        return Location;
    }

    public void setCustomerLocation(String customerLocation) {
        this.Location = customerLocation;
    }

    public String getCustomerPhoneNumber() {
        return PhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.PhoneNumber = customerPhoneNumber;
    }

    public boolean isCustomerSex() {
        return Gender;
    }

    public void setCustomerSex(boolean customerSex) {
        this.Gender = customerSex;
    }


    @Override
    public int hashCode() {
        return Objects.hash(customerCode);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        return Objects.equals(customerCode, other.customerCode);
    }


    @Override
    public String toString() {
        return "Customer [customerCode=" + customerCode + ", nationalID=" + nationalID + ", Name=" + Name + ", Gender="
                + Gender + ", PhoneNumber=" + PhoneNumber + ", Location=" + Location + "]";
    }


}
