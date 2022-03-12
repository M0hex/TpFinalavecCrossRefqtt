package com.dma.tpfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dma.tpfinal.adapter.DetailCommandeAdapter;
import com.dma.tpfinal.entities.Product;
import com.dma.tpfinal.modelview.ProductModelView;

import java.util.List;

public class DetailCommande extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_commande);
        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.rv_liste);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ProductModelView productModelView=new ViewModelProvider(this).get(ProductModelView.class);

        DetailCommandeAdapter detailCommandeAdapter=new DetailCommandeAdapter(this,null);

        recyclerView.setAdapter(detailCommandeAdapter);

        productModelView.getmListProduct().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                detailCommandeAdapter.setProductList(products);
            }
        });
    }
}