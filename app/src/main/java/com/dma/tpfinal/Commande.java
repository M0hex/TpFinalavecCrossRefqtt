package com.dma.tpfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dma.tpfinal.databinding.ActivityCommandeBinding;
import com.dma.tpfinal.databinding.ActivityMainBinding;
import com.dma.tpfinal.databinding.FragmentJouetBinding;
import com.dma.tpfinal.entities.Order;
import com.dma.tpfinal.entities.Product;
import com.dma.tpfinal.fragment.Jouet;
import com.dma.tpfinal.fragment.Objet;
import com.dma.tpfinal.fragment.Parfum;
import com.dma.tpfinal.modelview.OrderModelView;
import com.dma.tpfinal.modelview.ProductModelView;

import java.sql.Date;
import java.util.Calendar;

public class Commande extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    Button valider;
    EditText quantite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCommandeBinding binding = ActivityCommandeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        btn1=findViewById(R.id.jouet);
        btn2=findViewById(R.id.parfum);
        btn3=findViewById(R.id.objet);
        valider=findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, Jouet.class,null).commit();
                quantite=binding.fragmentContainerView.findViewById(R.id.et_qt1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, Parfum.class,null).commit();
                quantite=binding.fragmentContainerView.findViewById(R.id.et_qt1);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, Objet.class,null).commit();
                quantite=binding.fragmentContainerView.findViewById(R.id.et_qt1);
            }
        });
        OrderModelView orderModelView=new ViewModelProvider(this).get(OrderModelView.class);
        ProductModelView productModelView=new ViewModelProvider(this).get(ProductModelView.class);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*int count=0;
                count++;
                Intent intent=new Intent(Commande.this,ListeCommande.class);
                intent.putExtra("count",count);
                startActivity(intent);*/

                // une partie statique
                Product product=new Product("Objet2",200,"Objet");
                productModelView.addProduct(product);
                Order order = new Order();
                // ici tu utilise quantity de OPCrossRefTable
              //  order.setquantity(Integer.parseInt(quantite.getText().toString()));
                order.setOrderDate(order.getOrderDatef());

                orderModelView.addOrder(order);
                Toast.makeText(getApplicationContext(),"achat effectuer",Toast.LENGTH_LONG).show();
            }
        });
    }
}