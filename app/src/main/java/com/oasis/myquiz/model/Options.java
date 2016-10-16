package com.oasis.myquiz.model;

/**
 * Created by Oasis on 09-09-2016.
 */

public class Options {

    String mOption1, mOption2, mOption3, mOption4;
    int mCorrectOption1, mCorrectOption2;

    public Options(String option1, String option2, String option3, String option4, int correctOption){

        mOption1 = option1;
        mOption2 = option2;
        mOption3 = option3;;
        mOption4 = option4;
        mCorrectOption1 = correctOption;
    }

    public Options(String option1, String option2, String option3, String option4, int correctOption1, int correctOption2){

        mOption1 = option1;
        mOption2 = option2;
        mOption3 = option3;
        mOption4 = option4;
        mCorrectOption1 = correctOption1;
        mCorrectOption2 = correctOption2;
    }


    public int getCorrectOption1(){ return mCorrectOption1; }

    public int getCorrectOption2() { return mCorrectOption2; }

    public String getOption1() {
        return mOption1;
    }

    public String getOption2() {
        return mOption2;
    }

    public String getOption3() {
        return mOption3;
    }

    public String getOption4() {
        return mOption4;
    }
}
