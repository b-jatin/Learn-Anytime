package com.example.themebased;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        TextView fn = (TextView) findViewById(R.id.etname);
         final EditText etmail=(EditText)findViewById(R.id.etmail);
         final EditText etpass=(EditText)findViewById(R.id.etpass);
        Button btn=(Button)findViewById(R.id.button4);
          final FirebaseAuth mAuth;
         mAuth= FirebaseAuth.getInstance();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=etmail.getText().toString().trim();
                String password=etpass.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    etmail.setError("Email Required");

                }
                if(TextUtils.isEmpty(password)){
                    etpass.setError("Password is required");
                }
                if(password.length()<6){
                    etpass.setError("password should be atleat 6 characters");

                }
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Register1.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(Register1.this, "Success", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                                    //FirebaseUser user = mAuth.getCurrentUser();
                                   //updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(Register1.this, "Failed"+task.getException(), Toast.LENGTH_SHORT).show();
                                    //updateUI(null);
                                }
                            }
                        });



            }
        });



    }


}
