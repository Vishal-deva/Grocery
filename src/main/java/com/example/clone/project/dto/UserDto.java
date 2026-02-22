package com.example.clone.project.dto;

public class UserDto {

    private String customerId;
    private String customerName;
    private String customerEmailId;
    private String customerMobileNumber;
    private String customerAddress;
    private String customerPinCode;
    private String customerPassword;


    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword){
        this.customerPassword = customerPassword;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
