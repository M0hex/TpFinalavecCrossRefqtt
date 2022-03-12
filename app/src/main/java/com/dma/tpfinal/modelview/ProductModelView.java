package com.dma.tpfinal.modelview;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dma.tpfinal.entities.Product;
import com.dma.tpfinal.repository.ProductRepository;

import java.util.List;

public class ProductModelView extends AndroidViewModel {

    ProductRepository mProductRepository;
    LiveData<List<Product>> mListProduct;
    public ProductModelView(Application application) {
        super(application);
        mProductRepository = new ProductRepository(application);
        mListProduct = mProductRepository.getMyList();

    }

    public LiveData<List<Product>> getmListProduct(){
        mListProduct = mProductRepository.getMyList();
        return mListProduct;
    }

    public long addProduct(Product product) {
       return mProductRepository.insertProduct(product);
    }
}
