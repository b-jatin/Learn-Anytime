package com.example.themebased;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class Main6Activity extends AppCompatActivity {
    ListView listView;
   // DatabaseReference mDatabaseReference;
    List<Upload> qList;


    DatabaseReference myRef2;
    //the firebase objects for storage and database
    StorageReference mStorageReference2;
    DatabaseReference mDatabaseReference2;
    FirebaseDatabase database2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        mStorageReference2 = FirebaseStorage.getInstance().getReference();
        mDatabaseReference2 = FirebaseDatabase.getInstance().getReference(Constants2.DATABASE_PATH_QPAPER);
        database2 = FirebaseDatabase.getInstance();
        myRef2 = database2.getReference("qpaper");

        qList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView2);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                //getting the upload
                Upload upload = qList.get(i);
                Intent intent = new Intent( );
                intent.setData(Uri.parse(upload.getUrl()));
                startActivity(intent);
            }
        });


        //getting the database reference
        mDatabaseReference2 = FirebaseDatabase.getInstance().getReference(Constants2.DATABASE_PATH_QPAPER);

        //retrieving upload data from firebase database
        mDatabaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Upload upload = postSnapshot.getValue(Upload.class);
                    qList.add(upload);
                }

                String[] uploads = new String[qList.size()];

                for (int i = 0; i < uploads.length; i++) {
                    uploads[i] = qList.get(i).getName();
                }

                //displaying it to list
                ArrayAdapter<String> adapter = new ArrayAdapter <String>(getApplicationContext(), android.R.layout.simple_list_item_1, uploads){
                    @NonNull
                    @Override
                    public View getView(int position,  View convertView, ViewGroup parent) {
                        View view=super.getView(position, convertView, parent);
                        TextView mytext=(TextView) view.findViewById(android.R.id.text1);
                        mytext.setTextColor(Color.BLACK);
                        return view;
                    }
                };
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
