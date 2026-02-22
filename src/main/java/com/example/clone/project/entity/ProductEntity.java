package com.example.clone.project.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "product_details")
public class ProductEntity {

    @Id
    @UuidGenerator
    @Column(name = "product_id")
    private String productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_description")
    private String productDescription;
    private String price;
    private String quantity;
    @Column(name = "seller_name")
    private String sellerName;
    @Column(name = "seller_address")
    private String SellerAddress;
    @Column(name = "seller_email_id")
    private String sellerEmailID;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerAddress() {
        return SellerAddress;
    }

    public void setSellerAddress(String sellerAddress) {
        SellerAddress = sellerAddress;
    }

    public String getSellerEmailID() {
        return sellerEmailID;
    }

    public void setSellerEmailID(String sellerEmailID) {
        this.sellerEmailID = sellerEmailID;
    }
}
