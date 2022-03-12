package com.dma.tpfinal.entities;


import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class OrderWithProducts {

    @Embedded
    public Order order;
    @Relation(

            parentColumn = "orderIdRef",
            entityColumn = "productIdRef",
            associateBy = @Junction(value = CrossRef.class)
    )
    public List<Product> orderedProducts;

}
