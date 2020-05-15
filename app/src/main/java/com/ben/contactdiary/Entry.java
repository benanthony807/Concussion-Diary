package com.ben.contactdiary;

import android.app.Application;

import com.ben.contactdiary.ui.entryscreens.EntryCompleteScreen;
import com.ben.contactdiary.ui.entryscreens.SelectActivityTypeScreen;
import com.ben.contactdiary.ui.entryscreens.questionscreens.BoolQuestionScreen;
import com.ben.contactdiary.ui.entryscreens.questionscreens.IntQuestionScreen;
import com.ben.contactdiary.ui.entryscreens.questionscreens.StringQuestionScreen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Entry extends Application {

    public String type;
    public ArrayList<Question> questions;
    private int current;
    private Date date;
    private String wordToRemember;

    public Entry() {

        questions = buildQuestions();
        current = 0;
        date = Calendar.getInstance().getTime();
        wordToRemember = new Word().getWord();
    }

    public ArrayList<Question> buildQuestions() {
        Question q0 = new Question("On a scale of 1-10, how much contact did you experience in today’s practice?");
        Question q1 = new Question("How many times did you get knocked out during practice/game?");
        Question q2 = new Question("Stand on one foot for 20 seconds, how many times did you fall?");
        Question q3 = new Question("Does it hurt to look at bright lights?");
        Question q4 = new Question("Do you have a headache, or did you at any point during practice/game?");
        Question q5 = new Question("Do you feel nauseous, or did you at any point during practice/game?");
        Question q6 = new Question("Do you feel dizzy, or did you at any point during practice/game?");
        Question q7 = new Question("Does the screen look blurry or fuzzy? Are the words hard to read?");
        Question q8 = new Question("Do you feel like you’re more tired than you should be for the workout you just did?");
        Question q9 = new Question("Do you remember seeing stars at any point during practice?");
        Question q10 = new Question("Are your ears ringing, or were they at any point during practice/game?");
        Question q11 = new Question("Do you feel very nervous, anxious, irritable, or sad?");
        Question q12 = new Question("Say aloud: Eleven benevolent elephants. Did you slur your words?");
        Question q13 = new Question("What word was shown to you at the beginning of the quiz?");
        Question q14 = new Question("Would you like to note anything else about your practice/game?");
        return new ArrayList<>(Arrays.asList(q0, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14));
    }

    public String getCurrentQuestion() {
        return questions.get(current).getQuestion();
    }

    public void setCurrentAnswer(Object answer) {
        questions.get(current).setAnswer(answer);
    }

    public void increaseCurrent() {
        current++;
    }


    public void reduceCurrent() {
        current = Math.max(0, current - 1);
    }


    public String getTitle() {
        return type + "\n" + date.toString();
    }

    public String getBody() {
        return
                "1. Amount of contact, scale of 1-10: " + questions.get(0).getAnswer() + "\n" +
                "2. Times knockout out: " + questions.get(1).getAnswer() + "\n" +
                "3. Times fell standing on 1 foot for 20sec: " + questions.get(2).getAnswer() + "\n" +
                "4. Hurt to look at bright lights? " + questions.get(3).getAnswer() + "\n" +
                "5. Headache at any point? " + questions.get(4).getAnswer() + "\n" +
                "6. Nauseous at any point? " + questions.get(5).getAnswer() + "\n" +
                "7. Dizzy  at any point? " + questions.get(6).getAnswer() + "\n" +
                "8. Vision blurry? " + questions.get(7).getAnswer() + "\n" +
                "9. Extreme fatigue? " + questions.get(8).getAnswer() + "\n" +
                "10. Saw stars at any point? " + questions.get(9).getAnswer() + "\n" +
                "11. Ears ringing at any point? " + questions.get(10).getAnswer() + "\n" +
                "12. Nervous, anxious, irritable, or sad? " + questions.get(11).getAnswer() + "\n" +
                "13. Slurring speech? " + questions.get(12).getAnswer() + "\n" +
                "14. Word to remember: " + wordToRemember + "\n" +
                "       Your answer: " + questions.get(13).getAnswer() + "\n" +
                "15. Your notes: " + questions.get(14).getAnswer() + "\n";
    }

    public String getWord() {
        return wordToRemember;
    }

    public Class<?> getPrevScreen() {
        if (current == 0)
            return SelectActivityTypeScreen.class;
        if (current <= 3)
            return IntQuestionScreen.class;
        if (current <= 13)
            return BoolQuestionScreen.class;
        return StringQuestionScreen.class;
    }

    public Class<?> getNextScreen() {
        if (current < 2)
            return IntQuestionScreen.class;
        if (current < 12)
            return BoolQuestionScreen.class;
        if (current < 14)
            return StringQuestionScreen.class;
        return EntryCompleteScreen.class;
    }

    public void reset() {
        current = 0;
        date = Calendar.getInstance().getTime();
        wordToRemember = new Word().getWord();
    }
}