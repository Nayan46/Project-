package com.codewithnayan.trafficsinfo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class Feedback extends AppCompatActivity {
    EditText namedata, emaildata, messagedata;
    Button send, details;
    Firebase firebase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        // Setting  title to the Activity
        getSupportActionBar().setTitle("Feedback");

        // Setting the Up button in Activity to return to More fragment
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // referencing the variable for feedback activity
        namedata = findViewById(R.id.namedata);
        emaildata = findViewById(R.id.emaildata);
        messagedata = findViewById(R.id.messagedata);

        send = findViewById(R.id.btn_send);
        details = findViewById(R.id.btn_details);

        Firebase.setAndroidContext(this);

        // creating structure in database by unique id
        String UniqueID =
        Settings.Secure.getString(getApplicationContext().getContentResolver(),
        Settings.Secure.ANDROID_ID);

        firebase = new Firebase("https://nayan-gurung.firebaseio.com/Users" + UniqueID);

        //onclick listner for send button

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                details.setEnabled(true);


                // creating string variable to take all edittext into string
                final String name = namedata.getText().toString();
                final String email = emaildata.getText().toString();
                final String message = messagedata.getText().toString();

                // creating firebase child
                Firebase child_name = firebase.child("Name");

                child_name.setValue(name);
                if (name.isEmpty()){
                    namedata.setError("This is a required field!");
                    send.setEnabled(false);
                }

                else {
                    namedata.setError(null);
                    send.setEnabled(true);
                }


                // creating  firebase child
                Firebase child_email = firebase.child("Email");

                child_email.setValue(email);
                if (email.isEmpty()){
                    emaildata.setError("This is a required field!");
                    send.setEnabled(false);
                }

                else {
                    emaildata.setError(null);
                    send.setEnabled(true);
                }


                // creating firebase child
                Firebase child_message = firebase.child("Message");

                child_message.setValue(message);
                if (message.isEmpty()){
                    messagedata.setError("This is a required field!");
                    send.setEnabled(false);
                }

                else {
                    messagedata.setError(null);
                    send.setEnabled(true);
                }
                
                // creating Toast
                Toast.makeText(Feedback.this, "Your Data Was Sended To The Server", Toast.LENGTH_SHORT).show();

                // onclicklistner for details button

                details.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        new AlertDialog.Builder(Feedback.this)
                                .setTitle("Sended Details:")
                                .setMessage("Name - " + name + "\n\nEmail - " + email + "\n\nMessage - " + message)
                                .show();
                    }
                });

            }
        });

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
