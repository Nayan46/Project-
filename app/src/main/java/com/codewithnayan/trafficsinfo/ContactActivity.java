package com.codewithnayan.trafficsinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.codewithnayan.trafficsinfo.Adapters.EmergencyAdapter;
import com.codewithnayan.trafficsinfo.Models.EmergencyModel;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        // Setting  title to the Activity
        getSupportActionBar().setTitle(R.string.title_emergency);

        // Setting the Up button in ContactActivity to return to Home fragment
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        recyclerView = findViewById(R.id.rv_emergency);

        ArrayList<EmergencyModel> list = new ArrayList<>();
       list.add(new EmergencyModel(R.string.a));
        list.add(new EmergencyModel(R.string.b));
        list.add(new EmergencyModel(R.string.c));
        list.add(new EmergencyModel(R.string.d));
        list.add(new EmergencyModel(R.string.e));
        list.add(new EmergencyModel(R.string.f));
        list.add(new EmergencyModel(R.string.g));
        list.add(new EmergencyModel(R.string.h));
        list.add(new EmergencyModel(R.string.i));
        list.add(new EmergencyModel(R.string.j));
        list.add(new EmergencyModel(R.string.k));
        list.add(new EmergencyModel(R.string.l));
        list.add(new EmergencyModel(R.string.m));
        list.add(new EmergencyModel(R.string.n));


        EmergencyAdapter adapter = new EmergencyAdapter(list, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return true;
    }

    public void CallHim(View view)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:100"));
        startActivity(intent);

    }
}
