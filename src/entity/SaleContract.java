package entity;

import java.time.LocalDate;

public class SaleContract {
    private Employee employee;
    private Customer customer;
    private String contractCode;
    //Ma hop dong he thong
    private int contractNumber;
    //So hop dong phap ly
    private LocalDate transactionDate;
    //Ngay giao dich
    private String paymentMethod;
    //Hinh thuc thanh toan
    private double contractValue;
    //Gia tri hop dong
    private double totalAmountPaid;
    //tong so tien da thanh toan
    private int warrantyPeriod;
    private Vehicle vehicle;

   public SaleContract(Employee employee, Customer customer, String contractCode, int contractNumber,
                       LocalDate transactionDate, String paymentMethod, double contractValue,
                       double totalAmountPaid, int warrantyPeriod, Vehicle vehicle) {
       this.employee = employee;
       this.customer = customer;
       this.contractCode = contractCode;
       this.contractNumber = contractNumber;
       this.transactionDate = transactionDate;
       this.paymentMethod = paymentMethod;
       this.contractValue = contractValue;
       this.totalAmountPaid = totalAmountPaid;
       this.warrantyPeriod = warrantyPeriod;
       this.vehicle = vehicle;
   }

    public SaleContract(Employee employee) {
        this.employee = employee;
    }

    public SaleContract() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getContractCode() {
        return contractCode;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumer(int contractNumer) {
        this.contractNumber = contractNumber;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getContractValue() {
        return contractValue;
    }

    public void setContractValue(double contractValue) {
        this.contractValue = contractValue;
    }

    public double getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(double totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
