package com.example.themebased;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.view.View;

import java.util.Date;

import static com.google.firebase.database.core.view.View.*;

public class chatActivity extends AppCompatActivity {

    private FirebaseListAdapter<ChatStructure> adapter;
    ChatStructure model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_chat);

        Button fab = (Button) findViewById (R.id.fab);


    }


    public void onClick1(android.view.View view) {
        EditText input = (EditText) findViewById (R.id.input);

        // Read the input field and push a new instance
        // of ChatMessage to the Firebase database
        String s=input.getText ().toString ();
        model=new ChatStructure (s,
                FirebaseAuth.getInstance ()
                        .getCurrentUser ()
                        .getDisplayName ());
        FirebaseDatabase.getInstance ()
                .getReference ()
                .push ()
                .setValue (model);

        // Clear the input
        input.setText ("");
        displayChatMessage ();
    }
    private void displayChatMessage()
    {
        ListView listOfMessages = (ListView)findViewById(R.id.list_of_messages);
        adapter = new FirebaseListAdapter<ChatStructure>(this, ChatStructure.class,
                R.layout.message, FirebaseDatabase.getInstance().getReference()) {
            @Override
            protected void populateView(android.view.View v, ChatStructure model, int position) {
                // Get references to the views of message.xml
                TextView messageText = (TextView)v.findViewById(R.id.message_text);
                TextView messageUser = (TextView)v.findViewById(R.id.message_user);
                TextView messageTime = (TextView)v.findViewById(R.id.message_time);

                // Set their text
                messageText.setText(model.getMessageText());
                messageUser.setText(model.getMessageUser());

                // Format the date before showing it
                messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
                        model.getMessageTime()));
            }
        };

        listOfMessages.setAdapter(adapter);
    }
}

