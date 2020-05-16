package com.example.themebased;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class Main4Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Button button11;
        Button button12;
        Button button13;
        Button chat;
        button11 =(Button) findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent i= new Intent(Main4Activity.this,Main5Activity.class);
                startActivity(i);
            }
        });
        button12 =(Button) findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Main4Activity.this,Main6Activity.class);
                startActivity(i);
            }
        });

        button13 =(Button) findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Main4Activity.this,Search.class);
                startActivity(i);
            }
        });

    }
    }
