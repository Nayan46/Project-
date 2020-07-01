package com.codewithnayan.trafficsinfo;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.MenuItem;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;


public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        // Setting the Up button in Activity to return to More fragment
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Setting  title to the Activity
        getSupportActionBar().setTitle(R.string.title_aboutus);


        // Image-slider
        ImageSlider imageSlider = findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.homei));
        slideModels.add(new SlideModel(R.drawable.homeii));
        slideModels.add(new SlideModel(R.drawable.homeiii));
        slideModels.add(new SlideModel(R.drawable.homeiv));
        imageSlider.setImageList(slideModels, true);

    }




    // Setting the Up button in Activity to return to More fragment
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }


}
