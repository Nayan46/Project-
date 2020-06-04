package com.codewithnayan.trafficsinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.codewithnayan.trafficsinfo.Adapters.SymbolAdapter;
import com.codewithnayan.trafficsinfo.Models.SymbolModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar().setTitle("Home");


        // referencing the recyclerView
        recyclerView = findViewById(R.id.recyclerView);

        // Giving Data to Adapter

        ArrayList<SymbolModel> list = new ArrayList<>();
        list.add(new SymbolModel(R.drawable.i , "10% Slope Danger Warning Road Sign"));
        list.add(new SymbolModel(R.drawable.ii, "Bike Path Road Sign"));
        list.add(new SymbolModel(R.drawable.iii, "Danger Warning River Bank Road Sign"));
        list.add(new SymbolModel(R.drawable.iv , "No Right Turn Traffic Sign"));
        list.add(new SymbolModel(R.drawable.v, "No Left Turn Traffic Sign"));
        list.add(new SymbolModel(R.drawable.vi , "Speed Limit Road Sign"));
        list.add(new SymbolModel(R.drawable.vii, "No Overtaking Road Sign"));
        list.add(new SymbolModel(R.drawable.viii, "Slippery Road Warning Sign"));
        list.add(new SymbolModel(R.drawable.ix, "Men At Work"));
        list.add(new SymbolModel(R.drawable.x, "No Motorcycles Road Sign"));
        list.add(new SymbolModel(R.drawable.xi , "3.5T Restriction Truck Road Sign"));
        list.add(new SymbolModel(R.drawable.xii, "One Way Street Road Sign"));
        list.add(new SymbolModel(R.drawable.xiii, "No Entry Traffic Sign"));
        list.add(new SymbolModel(R.drawable.xiv, "Zigzag Road Warning Road Sign"));
        list.add(new SymbolModel(R.drawable.xv, "Width Restriction Road Sign"));
        list.add(new SymbolModel(R.drawable.xvi, "Stop Sign on Pole"));


        SymbolAdapter adapter = new SymbolAdapter(list, this);
        recyclerView.setAdapter(adapter);

        // GridLayout
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);


        //referencing  the bottom navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);


        // To display Home Fragment at the beginning
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

    }

    // implementing on create listener
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {
            Fragment selectedFragment = null;

            switch (item.getItemId())
            {
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;

                case R.id.nav_symbols:
                    selectedFragment = new SymbolsFragment();
                    break;

                case R.id.nav_rules:
                    selectedFragment = new RulesFragment();
                    break;

                case R.id.nav_more:
                    selectedFragment = new MoreFragment();
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };
}
