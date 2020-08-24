package com.example.chatti_online;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ToggleButton okay;
    ToggleButton d1,d2,d3,d4,d5,d6;
    Integer i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         d1 = findViewById(R.id.toggleButton1);
         d2 = findViewById(R.id.toggleButton2);
         d3 = findViewById(R.id.toggleButton3);
         d4 = findViewById(R.id.toggleButton4);
         d5 = findViewById(R.id.toggleButton5);
         d6 = findViewById(R.id.toggleButton6);
         okay = findViewById(R.id.ok);

         d1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 if(b)
                 {
                     i=1;
                 }
                 else
                 {
                     i=0;
                 }
             }
         });

         d2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 if(b)
                 {
                     i=2;
                 }
                 else
                 {
                     i=0;
                 }
             }
         });

         d3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 if(b)
                 {
                     i=3;
                 }
                 else
                 {
                     i=0;
                 }
             }
         });

         d4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 if(b)
                 {
                     i=4;
                 }
                 else
                 {
                     i=0;
                 }
             }
         });

         d5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 if(b)
                 {
                     i=5;
                 }
                 else
                 {
                     i=0;
                 }
             }
         });
         d6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                 if(b)
                 {
                     i=6;
                 }
                 else
                 {
                     i = 0;
                 }
             }
         });

         okay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 if(isChecked)
                 {
                     calculate();
                 }
                 else
                 {
                     Toast.makeText(getApplicationContext(), "back to new game", Toast.LENGTH_SHORT).show();
                 }
             }
         });
    }
    private void calculate()
    {
     Integer result = getRandomInteger(6,1);
     if(i.equals(result))
     {
         Intent in = new Intent(MainActivity.this, secondActivity.class);
         startActivity(in);
     }
     else
         {
         Toast.makeText(getApplicationContext(), "Won by some other", Toast.LENGTH_SHORT).show();

     }
    }

    public static int getRandomInteger(int maximum, int minimum)
    {
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }
}