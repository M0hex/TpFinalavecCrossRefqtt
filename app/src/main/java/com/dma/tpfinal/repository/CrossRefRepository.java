package com.dma.tpfinal.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.dma.tpfinal.dao.CrossRefDao;
import com.dma.tpfinal.database.DatabaseApp;
import com.dma.tpfinal.entities.CrossRef;
import com.dma.tpfinal.entities.OrderWithProducts;

import java.util.List;

public class CrossRefRepository {

    CrossRefDao myDao;
    LiveData<List<OrderWithProducts>> myList;
    public CrossRefRepository(Application application){
        DatabaseApp mydb = DatabaseApp.getInstance(application);

        myDao = mydb.crossRefDao();
        myList = myDao.getOrderWithProducts();

    }
    public LiveData<List<OrderWithProducts>> getMyList(){
        return myList;
    }
    public void insertCrossRef(CrossRef crossRef){

        new CrossRefRepository.InsertAsyncTask(myDao).execute(crossRef);
    }
    private class InsertAsyncTask extends AsyncTask<CrossRef,Void,Void>{
        CrossRefDao mydao;
       public  InsertAsyncTask(CrossRefDao mydao){

           this.mydao = mydao;
       }

       @Override
       protected Void doInBackground(CrossRef... crossRefs) {
           return null;
       }
   }

}
