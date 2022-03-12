package com.dma.tpfinal.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.dma.tpfinal.entities.Order;

import java.util.List;

@Dao
public interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long addOrder(Order order);
    @Update
    public void modifyOrder(Order order);
    @Delete
    public void deleteOrder(Order order);
    @Query("Select * from ORDER_TABLE")
    public LiveData<List<Order>> getAllOrders();


}
