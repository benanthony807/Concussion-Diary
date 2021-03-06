package com.ben.contactdiary.ui.entryscreens.questionscreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ben.contactdiary.Entry;
import com.ben.contactdiary.R;

public class StringQuestionScreen extends AppCompatActivity {

    private Entry entry;
    private String answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_question_screen);


        entry = ((Entry)getApplicationContext());

        TextView question = findViewById(R.id.question);
        question.setText(entry.getCurrentQuestion());
        EditText answerBox = findViewById(R.id.answer);


        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), entry.getPrevScreen());
                entry.reduceCurrent();
                startActivity(intent);
            }
        });

        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = answerBox.getText().toString();
                    entry.setCurrentAnswer(answer);
                Intent intent = new Intent(getApplicationContext(), entry.getNextScreen());
                entry.increaseCurrent();
                startActivity(intent);
            }
        });
    }
}