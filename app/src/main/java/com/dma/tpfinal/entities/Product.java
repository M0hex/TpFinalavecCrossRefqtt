package com.dma.tpfinal.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName ="product_table")
public class Product {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = "productIdRef")
    public long productIdRef;
    public String productName;
    public float productPrice;
    @ColumnInfo(name = "category")
    public String productCategory;


    public Product(){}
    public Product(String nom, float prix, String cat){
        this.productName =nom;
        this.productPrice = prix;
        this.productCategory = cat;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductIdRef(int productIdRef) {
        this.productIdRef = productIdRef;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public long getProductIdRef() {
        return productIdRef;
    }
}
