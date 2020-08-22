package com.coding.pixel.ca.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coding.pixel.ca.Model.Card2ItemData;
import com.coding.pixel.ca.R;

import java.util.ArrayList;

public class Card2ItemAdapter extends RecyclerView.Adapter<Card2ItemAdapter.ViewHolder> {

    ArrayList<Card2ItemData> c2List;
    Context c2context;

    public Card2ItemAdapter(ArrayList<Card2ItemData> c2List, Context c2context) {
        this.c2List = c2List;
        this.c2context = c2context;
    }

    @NonNull
    @Override
    public Card2ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c2context).inflate(R.layout.card2_item_list, parent, false);
        return new Card2ItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Card2ItemAdapter.ViewHolder holder, int position) {

        Card2ItemData c2data = c2List.get(position);
        holder.c2ImageView.setImageResource(c2data.getC2pic());
        holder.c2TextView.setText(c2data.getC2text());

    }

    @Override
    public int getItemCount() {
        return c2List.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView c2ImageView;
        TextView c2TextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            c2ImageView = itemView.findViewById(R.id.card_2_ImageView);
            c2TextView = itemView.findViewById(R.id.card_2_TextView);
        }
    }

    /*ArrayList<Card2ItemData> c2List;
    Context c2context;

    public Card2ItemAdapter(ArrayList<Card2ItemData> c2List, Context c2context) {
        this.c2List = c2List;
        this.c2context = c2context;
    }

    @NonNull
    @Override
    public Card2ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c2context).inflate(R.layout.card2_item_list, parent, false);
        return new Card2ItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Card2ItemAdapter.ViewHolder holder, int i) {

        Card2ItemData c2data = c2List.get(i);
        holder.c2ImageView.setImageResource(c2data.getC2pic());
        holder.c2TextView.setText(c2data.getC2text());

    }

    @Override
    public int getItemCount() {
        return c2List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView c2ImageView;
        TextView c2TextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            c2ImageView = itemView.findViewById(R.id.card_2_ImageView);
            c2TextView = itemView.findViewById(R.id.card_2_TextView);
        }
    }
*/
}
