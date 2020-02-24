package com.example.contactdiary.ui.entryscreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contactdiary.DatabaseHelper;
import com.example.contactdiary.Entry;
import com.example.contactdiary.MainActivity;
import com.example.contactdiary.R;

public class EntryCompleteScreen extends AppCompatActivity {

    private Entry entry;
    private DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_complete_screen);


        entry = ((Entry) getApplicationContext());
        myDb = new DatabaseHelper(this);


        TextView title = findViewById(R.id.title);
        title.setText(entry.getTitle());

        TextView body = findViewById(R.id.entryBody);
        body.setText(entry.getBody());

        Button done = findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDb.insertData(entry.getTitle(), entry.getBody());
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
