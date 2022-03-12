package com.dma.tpfinal.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity(tableName ="order_table")
public class Order implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = "orderIdRef")
    public long orderIdRef;
    @ColumnInfo(name = "quantity")
    public int orderQuantity;
    public String orderDate;

    public Order(){}

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderDatef() {
        SimpleDateFormat date = new SimpleDateFormat("hh:mm dd/MM/yyyy");
        String dateTime = date.format(new Date());
        return dateTime;
    }



    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public void setOrderID(long orderId) {
        this.orderIdRef = orderId;
    }

    public long getOrderID() {
        return orderIdRef;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }
}
