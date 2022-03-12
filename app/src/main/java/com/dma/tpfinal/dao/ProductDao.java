package com.dma.tpfinal.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.dma.tpfinal.entities.Product;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long addProduct(Product product) ;

    @Update
    public void modifyProduct(Product product);

    @Delete
    public void deleteProduct(Product product);

    @Query("select * from product_table")
    public LiveData<List<Product>> getAllProducts();

}
