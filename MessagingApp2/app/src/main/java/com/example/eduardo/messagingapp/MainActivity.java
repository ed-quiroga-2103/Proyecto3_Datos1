package com.example.eduardo.messagingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logIn(View view) {

        EditText usrtxt = (EditText) findViewById(R.id.usrtxt);
        EditText pswtxt = (EditText) findViewById(R.id.pswtxt);

        if(usrtxt.getText().toString().equals("")||pswtxt.getText().toString().equals("")) {

            Toast.makeText(this,"Invalid username or password", Toast.LENGTH_LONG).show();

        }else {
            Intent intent = new Intent(this, userChat.class);

            Bundle bundle = new Bundle();

            bundle.putString("usr", usrtxt.getText().toString());
            bundle.putString("psw", pswtxt.getText().toString());

            intent.putExtras(bundle);

            startActivity(intent);
        }
    }

    public void register(View view){

        Intent intent = new Intent(this, registerUser.class);

        startActivity(intent);

    }
}


