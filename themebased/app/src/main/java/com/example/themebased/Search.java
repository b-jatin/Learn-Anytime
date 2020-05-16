package com.example.themebased;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Button sb,vb;
        final EditText textView3;
        textView3=(EditText)findViewById(R.id.editText3);
        sb =(Button) findViewById(R.id.sbutton);
        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sText=textView3.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,sText);
                startActivity(intent);
            }
        });
        vb =(Button) findViewById(R.id.vbutton);
        vb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sp = new Intent(RecognizerIntent.ACTION_WEB_SEARCH);
                sp.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                sp.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak please");
                startActivity(sp);

            }
        });

    }
}
