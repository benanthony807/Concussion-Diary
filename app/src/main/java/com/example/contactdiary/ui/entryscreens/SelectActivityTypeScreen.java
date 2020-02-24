package com.example.contactdiary.ui.entryscreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contactdiary.Entry;
import com.example.contactdiary.R;
import com.example.contactdiary.ui.entryscreens.questionscreens.Question1Screen;


public class SelectActivityTypeScreen extends AppCompatActivity {

    private Entry entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type_screen);


        entry = ((Entry)getApplicationContext());

        Button typePractice = findViewById(R.id.typePractice);
        typePractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Question1Screen.class);
                entry.type = "Practice";
                startActivity(i);
            }
        });

        Button typeGame = findViewById(R.id.typeGame);
        typeGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entry.type = "Game";
                Intent i = new Intent(getApplicationContext(), Question1Screen.class);
                startActivity(i);
            }
        });
    }
}
