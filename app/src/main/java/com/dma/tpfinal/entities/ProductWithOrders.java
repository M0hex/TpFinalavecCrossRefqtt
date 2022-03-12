package com.dma.tpfinal.entities;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class ProductWithOrders
{

    @Embedded
    public Product product;
    @Relation(

            parentColumn = "productIdRef",
            entityColumn = "orderIdRef",
            associateBy = @Junction(value = CrossRef.class)
    )
    public List<Order> ordersOfProduct;


}


