package com.example.themebased;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button10 = findViewById(R.id.button10);

        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button5:
                Intent intent5= new Intent(this,Main4Activity.class);
                startActivity(intent5);
                break;
            case R.id.button6:
                Intent intent6= new Intent(this,Main4Activity.class);
                startActivity(intent6);
                break;
            case R.id.button7:
                Intent intent7= new Intent(this,Main4Activity.class);
                startActivity(intent7);
                break;
            case R.id.button8:
                Intent intent8= new Intent(this,Main4Activity.class);
                startActivity(intent8);
                break;
            case R.id.button9:
                Intent intent9= new Intent(this,Main4Activity.class);
                startActivity(intent9);
                break;
            case R.id.button10:
                Intent intent10= new Intent(this,Main4Activity.class);
                startActivity(intent10);
                break;
        }

    }
}
