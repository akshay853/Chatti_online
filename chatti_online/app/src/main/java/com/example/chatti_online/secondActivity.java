package com.example.chatti_online;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import static com.example.chatti_online.LoginActivity.MyPREFERENCES;


public class secondActivity extends AppCompatActivity {
    String email,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        SharedPreferences sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        sharedPreferences.getString("user_email",email);
        sharedPreferences.getString("full_name",name);

        Toast.makeText(getApplicationContext(), email, Toast.LENGTH_LONG).show();
       // Toast.makeText(this, name, Toast.LENGTH_SHORT).show();




    }
}