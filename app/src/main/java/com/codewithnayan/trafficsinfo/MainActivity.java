package com.codewithnayan.trafficsinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.codewithnayan.trafficsinfo.Adapters.RuleAdapter;
import com.codewithnayan.trafficsinfo.Adapters.SymbolAdapter;
import com.codewithnayan.trafficsinfo.Models.RuleModel;
import com.codewithnayan.trafficsinfo.Models.SymbolModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    RecyclerView recyclerView;

    ImageButton btnSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch = findViewById(R.id.btn_search);

        // referencing the recyclerView
        recyclerView = findViewById(R.id.recyclerView);

        // Giving Data to Adapter for tSymbols

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
        list.add(new SymbolModel(R.drawable.xvii, "Children Traffic Sign"));
        list.add(new SymbolModel(R.drawable.xviii, "MUST wear a protective helmet. Helmets MUST comply with the Regulations and they MUST be fastened securely."));
        list.add(new SymbolModel(R.drawable.xviii, "Don't sit children on fuel tanks or stand them in front of the rider"));
        list.add(new SymbolModel(R.drawable.xviii, "Dangerous Curse To Left Road Sign"));




        SymbolAdapter adapter = new SymbolAdapter(list, this);
        recyclerView.setAdapter(adapter);

        // GridLayout for tSymbols
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);



//
//        ArrayList<RuleModel> list1 = new ArrayList<>();
//        list1.add(new RuleModel("While driving always carry your driving license and important documents such as your vehicle registration certificate."));
//        list1.add(new RuleModel("MUST NOT carry more than one pillion rider and he/she MUST sit astride the machine on a proper seat and should keep both feet on the footrests."));
//        list1.add(new RuleModel("You should be aware of what is behind and in the sides before maneuvering. Look behind you; use mirrors if they are fitted."));
//        list1.add(new RuleModel("Never Drink while driving."));
//        list1.add(new RuleModel("Follow the traffic signals, lights and signs."));
//        list1.add(new RuleModel("Avoid using the cell phone when driving. If urgent move to left, stop and then take the call."));
//        list1.add(new RuleModel("Always use a helmet."));
//        list1.add(new RuleModel("Do not ride or wheel your vehicle on to the footpath."));
//        list1.add(new RuleModel("Understand the signals given by other road users and use the same when riding."));
//        list1.add(new RuleModel("Never stop abruptly in traffic. Move to the left and slow down."));
//
//        RuleAdapter adapter1 = new RuleAdapter(list1, this);
//        recyclerView.setAdapter(adapter1);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);





        //referencing  the bottom navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);


        // To display Home Fragment at the beginning
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();


        // Search


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });






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
