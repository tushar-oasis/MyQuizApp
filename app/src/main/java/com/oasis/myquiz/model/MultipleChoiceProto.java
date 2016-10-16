package com.oasis.myquiz.model;

/**
 * Created by Oasis on 09-09-2016.
 */

public class MultipleChoiceProto {

    private String mQuestionNumber;
    private String mQuestion;
    private Options mOptions;
    private boolean mIsFinal = false;

    public MultipleChoiceProto(String questionNumber, String question, Options option, boolean isFinal){

        mQuestionNumber = questionNumber;
        mQuestion = question;
        mOptions = option;
        mIsFinal = isFinal;
    }


    public Options getOptions(){
        return mOptions;
    }

    public String getQuestionNumber() {
        return mQuestionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
        mQuestionNumber = questionNumber;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }



    public void setFinal(boolean aFinal) {
        mIsFinal = aFinal;
    }

    public String getQuestion() {
        return mQuestion;
    }



    public boolean isFinal(){

        return mIsFinal;
    }


}
