package com.codewithnayan.trafficsinfo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {

    Spinner spinner;
    Locale myLocale;
    String currentLanguage = "en", currentLang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        loadLocale();
        setContentView(R.layout.activity_language);

       getSupportActionBar().hide();


        currentLanguage = getIntent().getStringExtra(currentLang);

        spinner = (Spinner) findViewById(R.id.spinner);

        List<String> list = new ArrayList<String>();

        list.add("Select language");
        list.add("English");
        list.add("नेपाली");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        setLocale("en");
                        break;

                    case 2:
                        setLocale("ne");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void setLocale(String localeName) {
        if (!localeName.equals(currentLanguage)) {
            myLocale = new Locale(localeName);
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(this, MainActivity.class);
            refresh.putExtra(currentLang, localeName);
            startActivity(refresh);
        } else {
            Toast.makeText(LanguageActivity.this, "Language already selected!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        System.exit(0);
    }
}


//         Button changeLang = findViewById(R.id.changeMyLanguage);
//         changeLang .setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//
//                 showChangeLanguageDialog();
//
//
//
//             }
//         });



//    }

//    private void showChangeLanguageDialog() {
//
//        final String[] listItems = {"नेपाली" , "English"};
//        AlertDialog.Builder mBuilder = new AlertDialog.Builder(LanguageActivity.this);
//        mBuilder.setTitle("Choose Language... ");
//        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int i) {
//
//                if (i == 0){
//                    setLocale("nep");
//                    recreate();
//                }
//
//                else if (i==1){
//                    setLocale("eng");
//                    recreate();
//                }
//
//                // dismiss alert dialog when language selected
//                dialog.dismiss();
//            }
//        });
//
//        AlertDialog mDialog = mBuilder.create();
//
//        mDialog.show();
//
//    }
//
//    private void setLocale(String lang) {
//        Locale locale = new Locale(lang);
//        Locale.setDefault(locale);
//        Configuration config = new Configuration();
//        config.locale = locale;
//        getBaseContext().getResources().updateConfiguration(config, getBaseContext(). getResources().getDisplayMetrics());
//
//        //save Data to shared Preference
//        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
//        editor.putString("My_Lang", lang);
//        editor.apply();
//
//    }
//
//    //load language saved in shared preferences
//    public void loadLocale(){
//        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
//        String language = prefs.getString("My_Lang", "");
//        setLocale(language);
//
//    }

//}
