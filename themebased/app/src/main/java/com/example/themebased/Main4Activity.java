package com.example.themebased;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Button button11,button12,button13,button14,button15;
        button11 =(Button) findViewById(R.id.button11);
        button12=(Button) findViewById(R.id.button12);
        button15=(Button)findViewById (R.id.button15);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent i= new Intent(Main4Activity.this,Main5Activity.class);
                startActivity(i);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Main4Activity.this,chatActivity.class);
                startActivity(i);
            }
        });
        button14 =(Button) findViewById(R.id.button14);
        button14.setOnClickListener(new View.OnClickListener() {
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
        button15 =(Button) findViewById(R.id.button15);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Main4Activity.this,LectureNotes.class);
                startActivity(i);
            }
        });

    }

    }
