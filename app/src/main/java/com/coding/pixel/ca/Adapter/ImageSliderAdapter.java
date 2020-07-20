package com.coding.pixel.ca.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coding.pixel.ca.Model.CardItemData;
import com.coding.pixel.ca.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class ImageSliderAdapter extends SliderViewAdapter<SliderViewHolder> {

    Context context;
    List<CardItemData> imageSliderModelList;

    public ImageSliderAdapter(Context context, List<CardItemData> imageSliderModelList) {
        this.context = context;
        this.imageSliderModelList = imageSliderModelList;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_list, parent, false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {
        viewHolder.sliderImageView.setImageResource(imageSliderModelList.get(position).getPic());
    }

    @Override
    public int getCount() {
        return imageSliderModelList.size();
    }
}

class SliderViewHolder extends SliderViewAdapter.ViewHolder
{
    ImageView sliderImageView;
    TextView sliderTextView;
    public SliderViewHolder(View itemView) {
        super(itemView);
        sliderImageView = itemView.findViewById(R.id.imageView);
        sliderTextView = itemView.findViewById(R.id.textView);
    }
}
