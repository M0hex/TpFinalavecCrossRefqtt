package com.dma.tpfinal.modelview;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dma.tpfinal.entities.Order;
import com.dma.tpfinal.entities.Product;
import com.dma.tpfinal.repository.OrderRepository;
import com.dma.tpfinal.repository.ProductRepository;

import java.util.List;

public class OrderModelView extends AndroidViewModel {
    OrderRepository mOrderRepository;
    LiveData<List<Order>> mListOrder;
    public OrderModelView(Application application) {
        super(application);
        mOrderRepository = new OrderRepository(application);
        mListOrder = mOrderRepository.getMyList();

    }

    public LiveData<List<Order>> getmListOrder(){
        mListOrder = mOrderRepository.getMyList();
        return mListOrder;
    }

    public long addOrder(Order order) {
       return mOrderRepository.insertOrder(order);}
}
