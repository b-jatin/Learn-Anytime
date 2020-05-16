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

public class LectureNotes extends AppCompatActivity {
    ListView listView;
    // DatabaseReference mDatabaseReference;
    List<Upload> lList;


    DatabaseReference myRef3;
    //the firebase objects for storage and database
    StorageReference mStorageReference3;
    DatabaseReference mDatabaseReference3;
    FirebaseDatabase database3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_notes);
        mStorageReference3 = FirebaseStorage.getInstance().getReference();
        mDatabaseReference3 = FirebaseDatabase.getInstance().getReference(Constants2.DATABASE_PATH_QPAPER);
        database3 = FirebaseDatabase.getInstance();
        myRef3 = database3.getReference("qpaper");

        lList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView2);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                //getting the upload
                Upload upload = lList.get(i);
                Intent intent = new Intent( );
                intent.setData(Uri.parse(upload.getUrl()));
                startActivity(intent);
            }
        });


        //getting the database reference
        mDatabaseReference3 = FirebaseDatabase.getInstance().getReference(Constants2.DATABASE_PATH_QPAPER);

        //retrieving upload data from firebase database
        mDatabaseReference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Upload upload = postSnapshot.getValue(Upload.class);
                    lList.add(upload);
                }

                String[] uploads = new String[lList.size()];

                for (int i = 0; i < uploads.length; i++) {
                    uploads[i] = lList.get(i).getName();
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
