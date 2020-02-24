package com.example.contactdiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewRecord extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_complete_screen);

        Intent i = getIntent();
        String entryBody = i.getStringExtra("com.example.concussiondiary.ENTRY_BODY");
        String entryTitle = i.getStringExtra("com.example.concussiondiary.ENTRY_TITLE");

        TextView header = findViewById(R.id.header);
        header.setText("");

        TextView title = findViewById(R.id.title);
        title.setText(entryTitle);

        TextView body = findViewById(R.id.entryBody);
        body.setText(entryBody);

        Button done = findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewMyRecords.class);
                startActivity(intent);
            }
        });
    }
}

