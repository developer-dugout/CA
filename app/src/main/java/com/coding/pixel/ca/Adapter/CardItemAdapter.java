package com.coding.pixel.ca.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coding.pixel.ca.Model.CardItemData;
import com.coding.pixel.ca.R;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class CardItemAdapter extends RecyclerView.Adapter<CardItemAdapter.ViewHolder>
{

    ArrayList<CardItemData> list;
    Context context;

    public CardItemAdapter(ArrayList<CardItemData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CardItemData data = list.get(position);
        holder.imageView.setImageResource(data.getPic());
        holder.textView.setText(data.getText());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

}
