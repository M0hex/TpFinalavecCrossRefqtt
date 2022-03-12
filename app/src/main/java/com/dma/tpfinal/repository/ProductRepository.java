package com.dma.tpfinal.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;


import com.dma.tpfinal.dao.ProductDao;
import com.dma.tpfinal.database.DatabaseApp;

import com.dma.tpfinal.entities.Product;

import java.util.List;

public class ProductRepository {
    ProductDao myDao;
    LiveData<List<Product>> myList;
    long myProductId;

    public ProductRepository(Application application){
        DatabaseApp mydb = DatabaseApp.getInstance(application);

        myDao = mydb.productDao();

        myList= myDao.getAllProducts();





    }

    public LiveData<List<Product>> getMyList() {
        return myList;
    }

    //insert

    public long insertProduct(Product product){

        new ProductRepository.InsertAsyncTask(myDao).execute(product);
        return myProductId;
    }
    //le corps du processus
    private  class  InsertAsyncTask extends AsyncTask<Product,Void,Void> {
        ProductDao mydao;
        public  InsertAsyncTask(ProductDao mydao){

            this.mydao = mydao;
        }
        @Override
        protected Void doInBackground(Product... products) {

            myProductId = mydao.addProduct(products[0]);
            return null;
        }
    }

}
