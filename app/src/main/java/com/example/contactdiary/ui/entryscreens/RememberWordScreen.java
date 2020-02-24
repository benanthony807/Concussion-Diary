package com.example.contactdiary.ui.entryscreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contactdiary.Entry;
import com.example.contactdiary.R;

public class RememberWordScreen extends AppCompatActivity {

    private Entry entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember_word_screen);

        entry = ((Entry)getApplicationContext());

        TextView word = findViewById(R.id.wordToRemember);
        word.setText(entry.getWord());


        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectActivityTypeScreen.class);
                startActivity(intent);
            }
        });
    }
}
