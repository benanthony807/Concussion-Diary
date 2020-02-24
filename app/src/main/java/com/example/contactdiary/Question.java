package com.example.contactdiary;

public class Question {

    private String question;
    private Object answer;

    public Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswer(Object answer) {
        this.answer = answer;
    }

    public Object getAnswer() {
        return answer;
    }
}
