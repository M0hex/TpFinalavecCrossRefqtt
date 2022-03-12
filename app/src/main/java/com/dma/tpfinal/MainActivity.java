package com.dma.tpfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dma.tpfinal.databinding.ActivityCommandeBinding;
import com.dma.tpfinal.databinding.ActivityMainBinding;
import com.dma.tpfinal.entities.Order;
import com.dma.tpfinal.modelview.OrderModelView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.commande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Commande.class);
                startActivity(intent);
            }
        });
        binding.liste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ListeCommande.class);
                startActivity(intent);
            }
        });
    }
}