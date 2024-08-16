package entity;

import java.time.LocalDate;
import java.util.Objects;

public class Order {
    private int orderCode;
    private Customer customer;
    //	private Employee employee;
    private Vehicle vehicle;
    private String location;
    private boolean insurance;
    private double deposit;
    private LocalDate orderDate;
    private boolean status;
    public int getOrderCode() {
        return orderCode;
    }
    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    //	public Employee getEmployee() {
////		return employee;
//	}
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public boolean isInsurance() {
        return insurance;
    }
    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }
    public double getDeposit() {
        return deposit;
    }
    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }
    public LocalDate getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }


    public Order(boolean status) {
        super();
        this.status = status;
    }
    public Order(Vehicle vehicle) {
        super();
        this.vehicle = vehicle;
    }
    //	public Order(Employee employee) {
//		super();
//		this.employee = employee;
//	}
    public Order(Customer customer) {
        super();
        this.customer = customer;
    }
    public Order(int orderCode, Customer customer, Vehicle vehicle, String location,
                 boolean insurance, double deposit, LocalDate orderDate, boolean status) {
        super();
        this.orderCode = orderCode;
        this.customer = customer;
//		this.employee = employee;
        this.vehicle = vehicle;
        this.location = location;
        this.insurance = insurance;
        this.deposit = deposit;
        this.orderDate = orderDate;
        this.status = status;
    }
    @Override
    public int hashCode() {
        return Objects.hash(orderCode);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        return Objects.equals(orderCode, other.orderCode);
    }
    public Order(int orderCode) {
        super();
        this.orderCode = orderCode;
    }
    @Override
    public String toString() {
        return "Order [orderCode=" + orderCode + ", customer=" + customer + ", vehicle="
                + vehicle + ", location=" + location + ", insurance=" + insurance + ", deposit=" + deposit
                + ", orderDate=" + orderDate + ", status=" + status + "]";
    }



}
