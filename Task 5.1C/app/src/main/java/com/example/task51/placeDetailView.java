package com.example.task51;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class placeDetailView extends Fragment {
    public placeDetailView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = (View) inflater.inflate(R.layout.fragment_place_detail_view, null);

        String placeName =  getArguments().getString("placeName");
        String placeDesc =  getArguments().getString("placeDesc");
        Integer image =  getArguments().getInt("image");

        TextView name = root.findViewById(R.id.txtPlaceName);
        TextView desc = root.findViewById(R.id.txtPlaceDesc);
        ImageView img = root.findViewById(R.id.placestogoImageView);

        name.setText(placeName);
        desc.setText(placeDesc);
        img.setImageResource(image);
        return root;
       // return inflater.inflate(R.layout.fragment_place_detail_view, container, false);
    }
}