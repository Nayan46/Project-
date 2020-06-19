package com.codewithnayan.trafficsinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        // Setting  title to the Activity
        getSupportActionBar().setTitle("Contact Us");


        // Setting the Up button in Activity to return to More fragment
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // About Us //

        Element element = new Element();
        element.setTitle("Advertise here");

        View aboutpage = new AboutPage(this)
                .isRTL(false)
//                .setImage(R.drawable.about_bg)
                .setDescription("Welcome To Traffics Info")
                .addItem(new Element().setTitle("Version 1.0"))
                .addItem( element)
                .addGroup("Connect With Us")
                .addEmail("nayan.grg34@gmail.com")
                .addWebsite("https://traffic.nepalpolice.gov.np/")
                .addFacebook("www.facebook.com")
                .addYoutube("UCHbQpMEaQjKW961qPjKe0-A")
                .addInstagram("My Instragram")
                .addGitHub("Nayan46")
                .addItem(createCopyright())
                .create();


        setContentView(aboutpage);
    }

    private Element createCopyright() {

        Element copyright = new Element();
        final String copyrightstring = String.format("@Copyright %d by Traffics Info", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightstring);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ContactUs.this, copyrightstring, Toast.LENGTH_SHORT).show();
            }
        });

        return copyright;
    }



    // Setting the Up button in Activity to return to More fragment
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
}
