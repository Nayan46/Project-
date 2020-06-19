package com.codewithnayan.trafficsinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Setting the Up button in Activity to return to More fragment
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Setting  title to the Activity
        getSupportActionBar().setTitle("About Us");

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
