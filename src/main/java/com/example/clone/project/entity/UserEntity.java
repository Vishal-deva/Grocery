package com.example.clone.project.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "user_table")
public class UserEntity {

    @Id
    @UuidGenerator
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_email_id")
    private String customerEmailId;
    @Column(name = "customer_mobile_number")
    private String customerMobileNumber;
    @Column(name = "customer_address")
    private String customerAddress;
    @Column(name = "customer_pin_code")
    private String customerPinCode;
    @Column(name = "customer_password")
    private String customerPassword;



    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword){
        this.customerPassword = customerPassword;
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customreId) {
        this.customerId = customreId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmailId() {
        return customerEmailId;
    }

    public void setCustomerEmailId(String customerEmailId) {
        this.customerEmailId = customerEmailId;
    }

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPinCode() {
        return customerPinCode;
    }

    public void setCustomerPinCode(String customerPinCode) {
        this.customerPinCode = customerPinCode;
    }

}
