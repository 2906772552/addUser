package com.zhw.homework.User_info;

public class Product_info {
    private String productName;
    private double productPrice;
    private int productNumber;
    private String productImgUrl;


    public Product_info(String productName, double productPrice, int productNumber, String productImgUrl) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productNumber = productNumber;
        this.productImgUrl = productImgUrl;
    }

    public Product_info() {
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

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductImgUrl() {
        return productImgUrl;
    }

    public void setProductImgUrl(String productImgUrl) {
        this.productImgUrl = productImgUrl;
    }
}
