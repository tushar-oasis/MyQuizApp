package com.oasis.myquiz.model;

/**
 * Created by Oasis on 16-09-2016.
 */

public class SingleLineAnsProto {

    private String mQuestionNumber;
    private String mQuestion;
    private String mCorrectAnswer;
    private boolean mIsFinal = false;

    public SingleLineAnsProto(String questionNumber, String question, String correctAnswer, boolean isFinal){
        mQuestionNumber = questionNumber;
        mQuestion = question;
        mCorrectAnswer = correctAnswer;
        mIsFinal = isFinal;
    }

    public String getQuestionNumber() {
        return mQuestionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
        mQuestionNumber = questionNumber;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public String getCorrectAnswer() {
        return mCorrectAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        mCorrectAnswer = correctAnswer;
    }

    public boolean isFinal() {
        return mIsFinal;
    }

    public void setFinal(boolean aFinal) {
        mIsFinal = aFinal;
    }
}
