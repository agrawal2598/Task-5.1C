package com.example.task51;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements VerticalRecyclerViewAdapter.ItemClickListener {

    private HorizontalRecyclerViewAdapter adapter;
    private VerticalRecyclerViewAdapter vadapter;
    ArrayList<Integer> images = new ArrayList<>();
    ArrayList<String> placesName = new ArrayList<>();
    ArrayList<String> placesDesc = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data to populate the RecyclerView with
        images.add(R.drawable.reef_barrier);
        images.add(R.drawable.oloru_place);
        images.add(R.drawable.park);
        images.add(R.drawable.opera_sydney);
        images.add(R.drawable.road_ocean);

        placesName.add("Great Barrier Reef");
        placesName.add("Uluru");
        placesName.add("Kakadu National Park");
        placesName.add("Sydney Opera House");
        placesName.add("Great Ocean Road");

        placesDesc.add("The Great Barrier Reef is the world's largest coral reef system.The Great Barrier Reef can be seen from outer space and is the world's biggest single structure made by living organisms");
        placesDesc.add("Uluru, also known as Ayers Rock and officially gazetted as Uluru / Ayers Rock, is a large sandstone rock formation in the southern part of the Northern Territory in Australia");
        placesDesc.add("Kakadu National Park is a protected area in the Northern Territory of Australia, 171 km southeast of Darwin. It is a World Heritage Site");
        placesDesc.add("The Sydney Opera House is a multi-venue performing arts centre at Sydney Harbour located in Sydney, New South Wales, Australia. It is one of the 20th century's most famous and distinctive buildings");
        placesDesc.add("The Great Ocean Road is an Australian National Heritage listed 243-kilometre stretch of road along the south-eastern coast of Australia between the Victorian cities of Torquay and Allansford");
        // set up the Horizontal RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvTours);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        adapter = new HorizontalRecyclerViewAdapter(this, images);
        recyclerView.setAdapter(adapter);

        // set up the Vertical RecyclerView
        RecyclerView vrecyclerView = findViewById(R.id.rvPlacesToGo);
        vadapter = new VerticalRecyclerViewAdapter(this, images,placesName,placesDesc);
        LinearLayoutManager verticalLayoutManager
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        vrecyclerView.setLayoutManager(verticalLayoutManager);
        vadapter.setClickListener(this);
        vrecyclerView.setAdapter(vadapter);
    }
    @Override
    public void onBackPressed(){
        if(getFragmentManager().getBackStackEntryCount() > 0){
            Log.i("MainActivity", "popping backstack");
            getFragmentManager().popBackStack();
        }
        else{
            Log.i("MainActivity", "nothing on backstack, calling super");
            super.onBackPressed();
        }
    }

    public void onImageClick(View view, int position) {
        // Toast.makeText(this, "You clicked " + " on item position " + position, Toast.LENGTH_SHORT).show();

        placeDetailView fr = new placeDetailView();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containermain, fr);
        transaction.addToBackStack(null);
        transaction.commit();

        Bundle bundle = new Bundle();
        String name = placesName.get(position);
        String desc = placesDesc.get(position);
        Integer image = images.get(position);
        bundle.putString("placeName", name);
        bundle.putString("placeDesc", desc);
        bundle.putInt("image",image);

        fr.setArguments(bundle);
    }
}