package com.dma.tpfinal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dma.tpfinal.R;
import com.dma.tpfinal.entities.Product;

import java.util.List;

public class DetailCommandeAdapter extends RecyclerView.Adapter<DetailCommandeAdapter.ViewHolder> {
    Context context;
    public List<Product> productList;

    public DetailCommandeAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DetailCommandeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.produit_liste,parent,false);
        return new DetailCommandeAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(DetailCommandeAdapter.ViewHolder holder, int position) {
        holder.nom_produit.setText(productList.get(position).getProductName());
        holder.prix_produit.setText(Integer.toString((int) productList.get(position).getProductPrice()));
        holder.quantite.setText(String.valueOf(productList.get(position).getProductIdRef()));
    }

    @Override
    public int getItemCount() {
        if(productList!=null) return productList.size();
        return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nom_produit;
        TextView prix_produit;
        TextView quantite;
        public ViewHolder(View itemView) {
            super(itemView);
            nom_produit=itemView.findViewById(R.id.et_num_commande);
            prix_produit=itemView.findViewById(R.id.et_commande);
            quantite=itemView.findViewById(R.id.et_date_commande);
        }
    }
}

