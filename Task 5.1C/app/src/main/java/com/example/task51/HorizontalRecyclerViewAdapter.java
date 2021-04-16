package com.example.task51;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.ViewHolder> {
    private List<Integer> mViewImages;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    HorizontalRecyclerViewAdapter(Context context, List<Integer> images) {
        this.mInflater = LayoutInflater.from(context);
        this.mViewImages = images;
    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.horizontalplaces_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int image = mViewImages.get(position);
        holder.myimageView.setImageResource(image);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mViewImages.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView myimageView;
        ViewHolder(View itemView) {
            super(itemView);
            myimageView = itemView.findViewById(R.id.imageView);
        }
    }


}
