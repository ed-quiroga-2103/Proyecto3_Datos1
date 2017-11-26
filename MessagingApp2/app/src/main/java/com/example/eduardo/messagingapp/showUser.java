package com.example.eduardo.messagingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class showUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user);

        TextView usrdisplay = (TextView) findViewById(R.id.usrdisplay);

        TextView passdisplay = (TextView) findViewById(R.id.passdisplay);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String usr = bundle.getString("usr");
        String pass = bundle.getString("psw");

        usrdisplay.setText("User: " + usr);
        passdisplay.setText("Password: "+ pass);
    }
}
