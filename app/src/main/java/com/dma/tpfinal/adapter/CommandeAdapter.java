package com.dma.tpfinal.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.dma.tpfinal.DetailCommande;
import com.dma.tpfinal.R;
import com.dma.tpfinal.entities.Order;

public class CommandeAdapter extends RecyclerView.Adapter<CommandeAdapter.ViewHolder> {
    Context context;
    public List<Order> achatlist;

    public CommandeAdapter(Context context, List<Order> achatlist) {
        this.context = context;
        this.achatlist = achatlist;
    }

    public void setAchatlist(List<Order> achatlist) {
        this.achatlist = achatlist;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CommandeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_liste,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.num_commande.setText(String.valueOf(achatlist.get(position).getOrderID()));
        holder.commande.setText(Integer.toString(achatlist.get(position).getOrderQuantity()));
        holder.date.setText(achatlist.get(position).getOrderDate());
    }

    @Override
    public int getItemCount() {
        if(achatlist!=null) return achatlist.size();
        return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView num_commande;
        TextView commande;
        TextView date;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetailCommande.class);
                    intent.putExtra("aer", achatlist.get(getAdapterPosition()));
                    v.getContext().startActivity(intent);
                }
            });
            num_commande=itemView.findViewById(R.id.et_num_commande);
            commande=itemView.findViewById(R.id.et_commande);
            date=itemView.findViewById(R.id.et_date_commande);
        }
    }
}
