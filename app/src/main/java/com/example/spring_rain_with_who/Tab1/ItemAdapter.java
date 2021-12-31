package com.example.spring_rain_with_who.Tab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spring_rain_with_who.R;

import java.util.ArrayList;

class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder>{
    private ArrayList<Item> items;
    private LayoutInflater Inflater;
    private Context context;

    public ItemAdapter(Context context, ArrayList<Item> items){
        this.context = context;
        this.Inflater = LayoutInflater.from(context);
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = Inflater.inflate(R.layout.tab1_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.name.setText(items.get(position).getName());
        holder.contact.setText(items.get(position).getPhone());
        holder.imageView.setImageResource(items.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //ViewHolder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView contact;
        public ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            contact = (TextView) itemView.findViewById(R.id.phone);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}