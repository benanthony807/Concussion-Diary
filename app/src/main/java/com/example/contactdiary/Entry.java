package com.example.contactdiary;

import android.app.Application;

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
        Question q1 = new Question("On a scale of 1-10, how much contact did you experience in today’s practice?");
        Question q2 = new Question("How many times did you get knocked out during practice/game?");
        Question q3 = new Question("Stand on one foot for 20 seconds, how many times did you fall?");
        Question q4 = new Question("Does it hurt to look at bright lights?");
        Question q5 = new Question("Do you have a headache, or did you at any point during practice/game?");
        Question q6 = new Question("Do you feel nauseous, or did you at any point during practice/game?");
        Question q7 = new Question("Do you feel dizzy, or did you at any point during practice/game?");
        Question q8 = new Question("Does the screen look blurry or fuzzy? Are the words hard to read?");
        Question q9 = new Question("Do you feel like you’re more tired than you should be for the workout you just did?");
        Question q10 = new Question("Do you remember seeing stars at any point during practice?");
        Question q11 = new Question("Are your ears ringing, or were they at any point during practice/game?");
        Question q12 = new Question("Do you feel very nervous, anxious, irritable, or sad?");
        Question q13 = new Question("Say aloud: Eleven benevolent elephants. Did you slur your words?");
        Question q14 = new Question("What word was shown to you at the beginning of the quiz?");
        Question q15 = new Question("Would you like to note anything else about your practice/game?");
        return new ArrayList<>(Arrays.asList(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15));
    }

    public String getCurrentQuestion() {
        return questions.get(current).getQuestion();
    }

    public void setCurrentAnswer(Object answer) {
        questions.get(current).setAnswer(answer);
        current++;
    }


    public void reduceCurrent() {
        current--;
    }

    public String getTitle() {
        return type + " on " + date.toString();
    }

    public String getBody() {
        return
                        "1. Amount of contact, scale of 1-10: " + questions.get(0).getAnswer() + "\n" +
                        "2. Times knockout out: " + questions.get(1).getAnswer() + "\n" +
                        "3. Times fell standing on one foot for 20 seconds: " + questions.get(2).getAnswer() + "\n" +
                        "4. Hurt to look at bright lights? " + questions.get(3).getAnswer() + "\n" +
                        "5. Headache at any point? " + questions.get(4).getAnswer() + "\n" +
                        "6. Nauseous at any point? " + questions.get(5).getAnswer() + "\n" +
                        "7. Dizzy  at any point? " + questions.get(6).getAnswer() + "\n" +
                        "8. Vision blurry? " + questions.get(7).getAnswer() + "\n" +
                        "9. Extreme fatigue? " + questions.get(8).getAnswer() + "\n" +
                        "10. Saw starts at any point? " + questions.get(9).getAnswer() + "\n" +
                        "11. Ears ringing at any point? " + questions.get(10).getAnswer() + "\n" +
                        "12. Nervous, anxious, irritable, or sad? " + questions.get(11).getAnswer() + "\n" +
                        "13. Slurring speech? " + questions.get(12).getAnswer() + "\n" +
                        "14. Remembered word from beginning? " + questions.get(13).getAnswer() + "\n" +
                        "15. Your notes: " + questions.get(14).getAnswer() + "\n";
    }

    public String getWord() {
        return wordToRemember;
    }
}