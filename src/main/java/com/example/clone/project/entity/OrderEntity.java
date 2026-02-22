    package com.example.clone.project.entity;

    import com.example.clone.project.dto.OrderItemDto;
    import jakarta.persistence.*;
    import org.hibernate.annotations.UuidGenerator;

    import java.time.LocalDateTime;
    import java.util.List;

    @Entity
    @Table(name = "orders")
    public class OrderEntity {

        @Id
        @UuidGenerator
        @Column(name = "order_id")
        private String orderId;

        @Column(name = "customer_Id")
        private String customerId;

        @Column(name = "customer_name")
        private String customerName;

        @Column(name = "customer_email")
        private String customerEmail;

        @Column(name = "customer_address")
        private String customerAddress;

        @Column(name = "total_amount")
        private Double totalAmount;

        @Column(name = "order_status")
        private String orderStatus = "PENDING";

        @Column(name = "created_at")
        private LocalDateTime createdAt;

        @Column(name = "updated_at")
        private LocalDateTime updatedAt;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getCustomerEmail() {
            return customerEmail;
        }

        public void setCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
        }

        public String getCustomerAddress() {
            return customerAddress;
        }

        public void setCustomerAddress(String customerAddress) {
            this.customerAddress = customerAddress;
        }

        public Double getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(Double totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public LocalDateTime getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }
    }

