package com.example.themebased;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

//import static com.example.themebased.R.id.button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button1:
                Intent intent1= new Intent(this,Main3Activity.class);
                startActivity(intent1);
                break;
            case R.id.button2:
                Intent intent2= new Intent(this,Main3Activity.class);
                startActivity(intent2);
                break;
            case R.id.button3:
                Intent intent3= new Intent(this,Main3Activity.class);
                startActivity(intent3);
                break;
            case R.id.button4:
                Intent intent4= new Intent(this,Main3Activity.class);
                startActivity(intent4);
                break;
        }

    }
}

