package com.oasis.myquiz.model;

/**
 * Created by Oasis on 09-09-2016.
 */

public class Questions {
    private MultipleChoiceProto[] mPages;
    private SingleLineAnsProto mPageSingleLine;
    private MultipleChoiceProto mPageMultipleCorrectAnswers;

    public Questions() {
        mPages = new MultipleChoiceProto[10];

        mPages[0] = new MultipleChoiceProto("Question 1", "In which decade was the American Institute of Electrical Engineers (AIEE) founded?",
                new Options("1850s", "1880s", "1930s", "1950s", 2), false);

        mPages[1] = new MultipleChoiceProto("Question 2", "What is part of a database that holds only one type of information?",
                new Options("Report", "Field", "Record", "File", 2), false);

        mPages[2] = new MultipleChoiceProto("Question 3", "'OS' computer abbreviation usually means?", new Options("Order of Significance",
                "Open Software", "Operating System", "Optical Sensor", 3), false);

        mPages[3] = new MultipleChoiceProto("Question 4", "In which decade with the first transatlantic radio broadcast occur?", new Options("1850s",
                "1860s", "1870s", "1900s", 4), false);

        mPages[4] = new MultipleChoiceProto("Question 5", "'.MOV' extension refers usually to what kind of file?", new Options("Image file",
                "Animation/movie file", "Audio file", "MS Office document", 2), false);

        mPages[5] = new MultipleChoiceProto("Question 6", "In which decade was the SPICE simulator introduced?", new Options("1950s",
                "1960s", "1970s", "1980s", 3), false);

        mPages[6] = new MultipleChoiceProto("Question 7", "Most modern TV's draw power even if turned off. The circuit the power is used in does what function?",
                new Options("Sound", "Remote control", "Color balance", "High voltage", 2), false);

        mPages[7] = new MultipleChoiceProto("Question 8", "Which is a type of Electrically-Erasable Programmable Read-Only Memory?",
                new Options("Flash", "Flange", "Fury", "FRAM", 1), false);

        mPages[8] = new MultipleChoiceProto("Question 9", "The purpose of choke in tube light is ?", new Options("To decrease the current",
                "To increase the current", "To decrease the voltage momentarily", "To increase the voltage momentarily", 4), false);

        mPages[9] = new MultipleChoiceProto("Question 10", "Who developed Yahoo?",
                new Options("Dennis Ritchie & Ken Thompson", "David Filo & Jerry Yang",
                        "Vint Cerf & Robert Kahn", "Steve Case & Jeff Bezos", 2), false);

        mPageSingleLine = new SingleLineAnsProto("Question 11", "Who is considered to be the father of computer science?", "Alan Turing",
                false);

        mPageMultipleCorrectAnswers = new MultipleChoiceProto("Question 12", "How to kill an activity in Android? (Multiple answers may be correct.)",
                new Options("finish()", "finishActivity(int requestCode)", "kill()", "None of the Above", 1, 2), true);

    }

    public MultipleChoiceProto getPage(int pageNumber) {
        return mPages[pageNumber];
    }

    public SingleLineAnsProto getPageSingleLine() {
        return mPageSingleLine;
    }

    public MultipleChoiceProto getPageMultipleCorrectAnswers(){
        return mPageMultipleCorrectAnswers;
    }
}

