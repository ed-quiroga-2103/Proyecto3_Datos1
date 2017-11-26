package com.example.eduardo.messagingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registerUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);


    }

    public void register(View view){

        EditText email = (EditText) findViewById(R.id.email);
        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);
        EditText fname = (EditText) findViewById(R.id.fname);
        EditText lname = (EditText) findViewById(R.id.lname);

        EditText[] texts = {email,username,password,fname,lname};

        if(verifyText(texts)){

            Toast.makeText(this,"User registered!", Toast.LENGTH_LONG).show();

        }else{

            Toast.makeText(this,"Please complete all the required information", Toast.LENGTH_LONG).show();

        }
    }

    public boolean verifyText(EditText[] array){

        for(EditText e: array){

            if(e.getText().toString().equals("")){
                return false;
            }

        }

        return true;
    }
}

