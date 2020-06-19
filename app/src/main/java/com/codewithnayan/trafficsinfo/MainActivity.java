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



    ImageButton btnSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch = findViewById(R.id.btn_search);


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
