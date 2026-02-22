    package com.example.clone.project.entity;

    import jakarta.persistence.*;
    import org.hibernate.annotations.UuidGenerator;

    @Entity
    @Table(name = "add_item")
    public class AddItemEntity {

        @Id
        @UuidGenerator
        @Column(name = "item_id")
        private String itemId;

        @Column(name = "product_id")
        private String productId;

        @Column(name = "customer_id")
        private String customerId;

        @Column(name = "product_name", nullable = false)
        private String productName;

        @Column(name = "quantity", nullable = false)
        private int quantity;

        @Column(name = "price")
        private double price;

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
