package com.dma.tpfinal.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.dma.tpfinal.entities.CrossRef;
import com.dma.tpfinal.entities.OrderWithProducts;

import java.util.List;
@Dao
public interface CrossRefDao {


@Transaction
@Query("select * from order_table")
    public LiveData<List<OrderWithProducts>> getOrderWithProducts();

@Insert
    public void addCrossRef(CrossRef CrossRef);

}
