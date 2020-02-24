package com.example.contactdiary.ui.entryscreens.questionscreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contactdiary.Entry;
import com.example.contactdiary.R;

public class Question5Screen extends AppCompatActivity {

    private Entry entry;
    private boolean answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bool_question_screen);


        entry = ((Entry)getApplicationContext());

        TextView question = findViewById(R.id.question);
        question.setText(entry.getCurrentQuestion());

        RadioButton answerYes = findViewById(R.id.yes);
        answerYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = true;
            }
        });
        RadioButton answerNo = findViewById(R.id.no);
        answerNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = false;
            }
        });


        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entry.reduceCurrent();
                Intent intent = new Intent(getApplicationContext(), Question4Screen.class);
                startActivity(intent);
            }
        });

        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entry.setCurrentAnswer(answer);
                Intent intent = new Intent(getApplicationContext(), Question6Screen.class);
                startActivity(intent);
            }
        });
    }
}