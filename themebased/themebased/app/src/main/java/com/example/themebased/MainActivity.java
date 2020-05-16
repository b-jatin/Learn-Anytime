package com.example.themebased;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    EditText ed1, ed2;
    TextView tx;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        tx = (TextView) findViewById(R.id.textView);
        b1 = (Button) findViewById(R.id.button1);
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        b2 = (Button) findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=ed1.getText().toString().trim();
                String password=ed2.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    ed1.setError("Email Required");
                }
                if(TextUtils.isEmpty(password)){
                    ed2.setError("Password is required");
                }
                if(password.length()<6){
                    ed2.setError("password should be atleat 6 characters");
                }
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Main2Activity.class));
                        } else {
                            Toast.makeText(MainActivity.this, "Not Registered", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
           /* public void onClick(View v) {
                finish();*/


            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Register1.class);
                startActivity(i);

            }
        });
    }
}

