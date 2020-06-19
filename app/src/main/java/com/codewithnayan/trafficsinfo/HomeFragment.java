package com.codewithnayan.trafficsinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HomeFragment extends Fragment {

    View rootView;

    FloatingActionButton fabAddNew;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Setting the current date in a home fragment
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textView = rootView.findViewById(R.id.text_view_date);
        textView.setText(currentDate);

        //floating action button
        fabAddNew = rootView.findViewById(R.id.fab_add_contact);

        fabAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ContactActivity.class);
                startActivity(intent);
            }
        });


        // Image-slider
        ImageSlider imageSlider = rootView.findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.homei));
        slideModels.add(new SlideModel(R.drawable.homeii));
        slideModels.add(new SlideModel(R.drawable.homeiii));
        slideModels.add(new SlideModel(R.drawable.homeiv));
        imageSlider.setImageList(slideModels, true);

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Setting the title for each fragment
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Home");

    }
}
