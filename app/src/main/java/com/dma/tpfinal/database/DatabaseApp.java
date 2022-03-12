package com.dma.tpfinal.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.dma.tpfinal.dao.CrossRefDao;
import com.dma.tpfinal.dao.OrderDao;
import com.dma.tpfinal.dao.ProductDao;
import com.dma.tpfinal.entities.CrossRef;
import com.dma.tpfinal.entities.Order;
import com.dma.tpfinal.entities.Product;

@androidx.room.Database(entities = {Product.class, Order.class, CrossRef.class},version = 1,exportSchema = false)
public abstract class DatabaseApp extends RoomDatabase {

    public abstract OrderDao orderDao();
    public abstract ProductDao productDao();

    public  abstract CrossRefDao crossRefDao();

    private  static DatabaseApp INSTANCE;

    public static DatabaseApp getInstance(Context context){

        if(INSTANCE==null){

            synchronized (DatabaseApp.class){
                if (INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(context, DatabaseApp.class,"base").build();

                }
            }

        } return  INSTANCE;
    }}