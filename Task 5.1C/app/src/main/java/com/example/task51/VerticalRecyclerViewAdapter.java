package com.example.task51;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<VerticalRecyclerViewAdapter.ViewHolder> {
    private List<Integer> mViewImages;
    private List<String> mPlacesName;
    private List<String> mPlacesDesc;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    VerticalRecyclerViewAdapter(Context context, List<Integer> images,List<String> placesName,List<String> placesDesc) {
        this.mInflater = LayoutInflater.from(context);
        this.mViewImages = images;
        this.mPlacesDesc = placesDesc;
        this.mPlacesName = placesName;
    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.verticalplacestogo_item, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int image = mViewImages.get(position);
        String placeName = mPlacesName.get(position);
        String placeDesc = mPlacesDesc.get(position);
        holder.myimageView.setImageResource(image);
        holder.placesTextView.setText(placeName);
        holder.placesDescTextView.setText(placeDesc);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mViewImages.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView myimageView;
        TextView placesTextView;
        TextView placesDescTextView;
        ViewHolder(View itemView) {
            super(itemView);
            myimageView = itemView.findViewById(R.id.placestogoImageView);
            placesTextView = itemView.findViewById(R.id.txtPlaceName);
            placesDescTextView = itemView.findViewById(R.id.txtPlaceDesc);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onImageClick(view, getAbsoluteAdapterPosition());
        }
    }


    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onImageClick(View view, int position);
    }
}
