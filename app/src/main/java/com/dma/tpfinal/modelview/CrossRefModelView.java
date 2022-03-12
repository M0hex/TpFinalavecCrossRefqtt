package com.dma.tpfinal.modelview;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dma.tpfinal.entities.CrossRef;
import com.dma.tpfinal.entities.Order;
import com.dma.tpfinal.entities.OrderWithProducts;
import com.dma.tpfinal.repository.CrossRefRepository;
import com.dma.tpfinal.repository.OrderRepository;

import java.util.List;

public class CrossRefModelView extends AndroidViewModel {
    CrossRefRepository mCrossRefRepository;
    LiveData<List<OrderWithProducts>> mListCrossRef;
    public CrossRefModelView( Application application) {
        super(application);
        mCrossRefRepository = new CrossRefRepository(application);
        mListCrossRef = mCrossRefRepository.getMyList();


    }
    public LiveData<List<OrderWithProducts>> getmListCrossRef(){
        mListCrossRef = mCrossRefRepository.getMyList();
        return mListCrossRef;
    }

    public void addCrossRef(CrossRef crossRef) {
        mCrossRefRepository.insertCrossRef(crossRef);}
}
