package com.example.contactdiary.ui.entryscreens.questionscreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contactdiary.Entry;
import com.example.contactdiary.R;
import com.example.contactdiary.ui.entryscreens.SelectActivityTypeScreen;

public class Question1Screen extends AppCompatActivity {

    private Entry entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_int_question_screen);


       entry = ((Entry)getApplicationContext());


        TextView question = findViewById(R.id.question);
        question.setText(entry.getCurrentQuestion());

        EditText answerBox = findViewById(R.id.answer);

        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // current doesn't get reduced here because it's already at 0
//                entry.reduceCurrent();
                Intent intent = new Intent(getApplicationContext(), SelectActivityTypeScreen.class);
                startActivity(intent);
            }
        });

        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answerBox.getText().toString().equals("")) {
                    int answer = Integer.parseInt(answerBox.getText().toString());
                    entry.setCurrentAnswer(answer);
                    Intent intent = new Intent(getApplicationContext(), Question2Screen.class);
                    startActivity(intent);
                }
            }
        });
    }
}
