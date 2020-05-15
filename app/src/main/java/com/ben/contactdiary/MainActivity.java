package com.ben.contactdiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ben.contactdiary.ui.entryscreens.NewEntryMainScreen;

public class MainActivity extends AppCompatActivity {

    protected Entry entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entry = ((Entry)getApplicationContext());

        Button makeNewEntry = findViewById(R.id.makeNewEntry);
        makeNewEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), NewEntryMainScreen.class);
                startActivity(i);
            }
        });

        Button viewMyRecords = findViewById(R.id.viewRecords);
        viewMyRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ViewMyRecords.class);
                startActivity(i);
            }
        });
    }
}
