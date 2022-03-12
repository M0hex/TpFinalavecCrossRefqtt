package com.dma.tpfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dma.tpfinal.adapter.CommandeAdapter;
import com.dma.tpfinal.entities.Order;
import com.dma.tpfinal.modelview.OrderModelView;

import java.util.List;

public class ListeCommande extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_commande);
        /*CountViewModel model= new ViewModelProvider(this).get(CountViewModel.class);
        model.getCount().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                textView.setText(integer+"");
            }
        });
        */
        /*Intent intent=getIntent();
        int count=intent.getIntExtra("count",0);
        binding.etNumCommande.setText(""+count);*/
        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.rv_liste);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //initialisation de viewmodel
        OrderModelView orderModelView=new ViewModelProvider(this).get(OrderModelView.class);
        //cree l'adapter
        CommandeAdapter commandeAdapter=new CommandeAdapter(this,null);
        //lier l'adapter au recycler
        recyclerView.setAdapter(commandeAdapter);
        //lier l'adapter a la liste des contact
        //l'adapter vas observer la liste des contact si les donner change ,live data notify l'adapter qui notify le recyclerview
        orderModelView.getmListOrder().observe(this, new Observer<List<Order>>() {
            @Override
            public void onChanged(List<Order> orders) {
                commandeAdapter.setAchatlist(orders);
            }
        });

    }
}