package com.pluralsight;

public class Product {
    //Properties for my Products
    private String productSku;
    private String productName;
    private double productPrice;
    private String department;

    //Added a constructor
    public Product(String productSku,String productName, double productPrice, String department) {
        this.productSku = productSku;
        this.productName = productName;
        this.productPrice = productPrice;
        this.department = department;
    }

    //Added Setters/Getters


    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
