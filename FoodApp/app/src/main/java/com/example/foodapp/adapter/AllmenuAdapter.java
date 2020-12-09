package com.example.foodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodapp.R;
import com.example.foodapp.model.Allmenu;

import java.util.List;

public class AllmenuAdapter extends RecyclerView.Adapter<AllmenuAdapter.AllmenuViewHolder> {
    private Context context;
    private List<Allmenu> allmenus;
    public AllmenuAdapter(Context context, List<Allmenu> allmenuList) {
        this.context=context;
        this.allmenus=allmenuList;
    }

    @NonNull
    @Override
    public AllmenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.allproduct_recycler,parent,false);
        return new AllmenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllmenuViewHolder holder, int position) {
        holder.allName.setText(allmenus.get(position).getName());
        holder.allprice.setText("$ "+allmenus.get(position).getPrice());
//        holder.allmenus.setText(allmenus.get(position).getDeliveryTime());
        holder.allrating.setText(allmenus.get(position).getRating());
        holder.alldelivery.setText(allmenus.get(position).getDeliveryCharges());
        holder.allnote.setText(allmenus.get(position).getNote());

        Glide.with(context).load(allmenus.get(position).getImageUrl()).into(holder.allimageView);
    }

    @Override
    public int getItemCount() {
        return this.allmenus.size();
    }

    public static class AllmenuViewHolder extends RecyclerView.ViewHolder{
        ImageView allimageView;
        TextView allName,allnote,allrating,alldelivery,allprice;


        public AllmenuViewHolder(@NonNull View itemView) {
            super(itemView);

            allimageView=itemView.findViewById(R.id.all_menu_image);
            allName=itemView.findViewById(R.id.all_menu_name);
            allnote=itemView.findViewById((R.id.all_menu_note));
            allrating=itemView.findViewById(R.id.all_menu_rating);
            alldelivery=itemView.findViewById(R.id.all_menu_delivery_charge);
            allprice=itemView.findViewById(R.id.all_menu_price);
        }
    }
}
