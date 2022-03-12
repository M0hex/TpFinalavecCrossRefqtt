package com.dma.tpfinal;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CountViewModel extends ViewModel {
    MutableLiveData<Integer> count=new MutableLiveData<>(0);
    public MutableLiveData<Integer> getCount(){
        return count;
    }
    public void setCount(){
        int i = count.getValue();
        i++;
        count.setValue(i);
    }
}
