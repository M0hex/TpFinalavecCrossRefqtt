package com.dma.tpfinal.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.dma.tpfinal.dao.OrderDao;
import com.dma.tpfinal.database.DatabaseApp;
import com.dma.tpfinal.entities.Order;

import java.util.List;

public class OrderRepository {
    OrderDao myDao;
    LiveData<List<Order>> myList;

    public OrderRepository(Application application){
        DatabaseApp mydb = DatabaseApp.getInstance(application);

        myDao = mydb.orderDao();

        myList= myDao.getAllOrders();



    }

    public LiveData<List<Order>> getMyList() {
        return myList;
    }

    //insert

    public void insertOrder(Order order){

        new InsertAsyncTask(myDao).execute(order);
    }
    //le corps du processus
    private  class  InsertAsyncTask extends AsyncTask<Order,Void,Void> {
        OrderDao mydao;
        public  InsertAsyncTask(OrderDao mydao){

            this.mydao = mydao;
        }
        @Override
        protected Void doInBackground(Order... orders) {
            mydao.addOrder(orders[0]);
            return null;
        }
    }
}
