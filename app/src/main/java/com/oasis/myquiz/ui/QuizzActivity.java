package com.oasis.myquiz.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.oasis.myquiz.R;
import com.oasis.myquiz.model.Options;
import com.oasis.myquiz.model.MultipleChoiceProto;
import com.oasis.myquiz.model.Questions;
import com.oasis.myquiz.model.SingleLineAnsProto;

public class QuizzActivity extends AppCompatActivity {

    public static final String TAG = QuizzActivity.class.getSimpleName();

    private int mPageNumber;
    private int mCorrectAnswers = 0;
    private Questions mQuestions = new Questions();
    private MultipleChoiceProto mCurrentPage;
    private SingleLineAnsProto mCurrentPageSingleLine;
    private MultipleChoiceProto mCurrentPageMultipleAnswers;
    private TextView mQuestionNumberView;
    private TextView mQuestionTextView;
    private Button mSubmit;
    private Button mNext;
    private RadioButton mChoice1;
    private RadioButton mChoice2;
    private RadioButton mChoice3;
    private RadioButton mChoice4;
    private CheckBox mCheckBox1;
    private CheckBox mCheckBox2;
    private CheckBox mCheckBox3;
    private CheckBox mCheckBox4;
    private RadioGroup mRadioGroup;
    private EditText mAnswerField;
    private String mName;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);


        QuizzActivity prevActivity = (QuizzActivity) getLastCustomNonConfigurationInstance();
        if (prevActivity != null) {
            mPageNumber = prevActivity.mPageNumber;

        }

        Intent intent = getIntent();
        mName = intent.getStringExtra("name");
        if (mName == null) {
            mName = "Friend";
        }

        mQuestionNumberView = (TextView) findViewById(R.id.questionNumberTextView);
        mQuestionTextView = (TextView) findViewById(R.id.questionTextView);
        mSubmit = (Button) findViewById(R.id.submitButton);
        mNext = (Button) findViewById(R.id.nextButton);

        if (mPageNumber <= 9) {

            mChoice1 = (RadioButton) findViewById(R.id.checkBox1);
            mChoice2 = (RadioButton) findViewById(R.id.checkBox2);
            mChoice3 = (RadioButton) findViewById(R.id.checkBox3);
            mChoice4 = (RadioButton) findViewById(R.id.checkBox4);
            mRadioGroup = (RadioGroup) findViewById(R.id.radioButtonGroup);
            loadPage(mPageNumber);
        } else if (mPageNumber == 10) {


            loadPageSingleLine();
        } else if (mPageNumber == 11) {
            loadPageMultipleAnswer();
        }

    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return this;
    }

    private void loadPageMultipleAnswer() {
        setContentView(R.layout.activity_quizz_3);
        mQuestionNumberView = (TextView) findViewById(R.id.questionNumberTextView);
        mQuestionTextView = (TextView) findViewById(R.id.questionTextView);
        mSubmit = (Button) findViewById(R.id.submitButton);
        mNext = (Button) findViewById(R.id.nextButton);
        mCheckBox1 = (CheckBox) findViewById(R.id.checkBox1);
        mCheckBox2 = (CheckBox) findViewById(R.id.checkBox2);
        mCheckBox3 = (CheckBox) findViewById(R.id.checkBox3);
        mCheckBox4 = (CheckBox) findViewById(R.id.checkBox4);
        mCurrentPageMultipleAnswers = mQuestions.getPageMultipleCorrectAnswers();

        Options options = mCurrentPageMultipleAnswers.getOptions();
        final int correctOption1 = options.getCorrectOption1();
        final int correctOption2 = options.getCorrectOption2();

        String questionNumberText = mCurrentPageMultipleAnswers.getQuestionNumber();
        String questionText = mCurrentPageMultipleAnswers.getQuestion();

        mQuestionNumberView.setText(questionNumberText);
        mQuestionTextView.setText(questionText);
        mCheckBox1.setText(options.getOption1());
        mCheckBox2.setText(options.getOption2());
        mCheckBox3.setText(options.getOption3());
        mCheckBox4.setText(options.getOption4());


        mNext.setVisibility(View.INVISIBLE);
        mSubmit.setVisibility(View.VISIBLE);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCheckBox1.isChecked() && mCheckBox2.isChecked() && !(mCheckBox3.isChecked()) && !(mCheckBox4.isChecked())) {
                    Toast.makeText(QuizzActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    mCorrectAnswers++;
                } else if (mCheckBox1.isChecked() && !(mCheckBox2.isChecked()) && !(mCheckBox3.isChecked()) && !(mCheckBox4.isChecked())) {
                    Toast.makeText(QuizzActivity.this, "Partly correct. Option 2 is also correct.", Toast.LENGTH_SHORT).show();

                } else if (!(mCheckBox1.isChecked()) && mCheckBox2.isChecked() && !(mCheckBox3.isChecked()) && !(mCheckBox4.isChecked())) {
                    Toast.makeText(QuizzActivity.this, "Partly correct. Option 1 is also correct.", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(QuizzActivity.this, "Incorrect. Options 1 & 2 are correct.", Toast.LENGTH_SHORT).show();
                }

                mSubmit.setVisibility(View.INVISIBLE);
                mNext.setVisibility(View.VISIBLE);
            }
        });

        mNext.setText("PLAY AGAIN");
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuizzActivity.this, "Score: " + mCorrectAnswers + " out of 12", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }

    private void loadPageSingleLine() {
        setContentView(R.layout.activity_quizz_2);
        mAnswerField = (EditText) findViewById(R.id.answerEditText);
        mQuestionNumberView = (TextView) findViewById(R.id.questionNumberTextView);
        mQuestionTextView = (TextView) findViewById(R.id.questionTextView);
        mSubmit = (Button) findViewById(R.id.submitButton);
        mNext = (Button) findViewById(R.id.nextButton);
        mCurrentPageSingleLine = mQuestions.getPageSingleLine();

        final String correctAnswer = mCurrentPageSingleLine.getCorrectAnswer();
        String questionNumberText = mCurrentPageSingleLine.getQuestionNumber();
        String questionText = mCurrentPageSingleLine.getQuestion();

        mQuestionNumberView.setText(questionNumberText);
        mQuestionTextView.setText(questionText);

        mNext.setVisibility(View.INVISIBLE);
        mSubmit.setVisibility(View.VISIBLE);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = mAnswerField.getText().toString();
                if (correctAnswer.equalsIgnoreCase(answer)) {
                    Toast.makeText(QuizzActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    mCorrectAnswers++;
                } else {
                    Toast.makeText(QuizzActivity.this, "Incorrect. Correct answer is " + correctAnswer, Toast.LENGTH_SHORT).show();
                }

                mSubmit.setVisibility(View.INVISIBLE);
                mNext.setVisibility(View.VISIBLE);
            }
        });

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadPageMultipleAnswer();
            }
        });


    }

    private void loadPage(int pageNumber) {
        mCurrentPage = mQuestions.getPage(pageNumber);

        String questionNumberText = mCurrentPage.getQuestionNumber();
        String questionText = mCurrentPage.getQuestion();
        Options options = mCurrentPage.getOptions();

        mQuestionNumberView.setText(questionNumberText);
        mQuestionTextView.setText(questionText);
        mChoice1.setText(options.getOption1());
        mChoice2.setText(options.getOption2());
        mChoice3.setText(options.getOption3());
        mChoice4.setText(options.getOption4());

        final int correctOption = options.getCorrectOption1();

        mNext.setVisibility(View.INVISIBLE);
        mSubmit.setVisibility(View.VISIBLE);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!mChoice1.isChecked() && !mChoice2.isChecked() && !mChoice3.isChecked() && !mChoice4.isChecked()){
                    Toast.makeText(QuizzActivity.this, "You didn't select anything", Toast.LENGTH_SHORT).show();

                }

                else {

                    if (correctOption == 1 && mChoice1.isChecked()) {
                        Toast.makeText(QuizzActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                        mCorrectAnswers++;
                    } else if (correctOption == 2 && mChoice2.isChecked()) {
                        Toast.makeText(QuizzActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                        mCorrectAnswers++;
                    } else if (correctOption == 3 && mChoice3.isChecked()) {
                        Toast.makeText(QuizzActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                        mCorrectAnswers++;
                    } else if (correctOption == 4 && mChoice4.isChecked()) {
                        Toast.makeText(QuizzActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                        mCorrectAnswers++;
                    } else {
                        Toast.makeText(QuizzActivity.this, "Incorrect. Correct answer is " + correctOption, Toast.LENGTH_SHORT).show();

                    }

                    mSubmit.setVisibility(View.INVISIBLE);
                    mNext.setVisibility(View.VISIBLE);
                }
            }
        });


        if (mCurrentPage.isFinal()) {
            mNext.setText("PLAY AGAIN");
            mNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(QuizzActivity.this, "Score: " + mCorrectAnswers + " out of 10", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        } else {
            mNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mPageNumber++;
                    mRadioGroup.clearCheck();

                    if (mPageNumber <= 9)
                        loadPage(mPageNumber);

                    else
                        loadPageSingleLine();
                }
            });

        }
    }
}


