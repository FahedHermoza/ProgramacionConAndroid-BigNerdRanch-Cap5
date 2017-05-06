package com.fahedhermoza.developer.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Boolean.FALSE;

public class CheatActivity extends AppCompatActivity {

    private static final String TAG = "CheapActivity";
    private static final String EXTRA_ANSWER_IS_TRUE = "com.fahedhermoza.developer.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN = "com.fahedhermoza.developer.geoquiz.answer_shown";
    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswer;

    private boolean mStateCheap;
    private static final String STATE_CHEAP = "state_cheap";


    public static Intent newIntent(Context packageContext, boolean answerIsTrue){
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return i;

    }

    public static boolean wasAnswerShown(Intent result){
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN,false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);
        mShowAnswer = (Button) findViewById(R.id.showAnswerButton);

        if(savedInstanceState != null){
            mStateCheap = savedInstanceState.getBoolean(STATE_CHEAP,false);
            if(mStateCheap){
                if(mAnswerIsTrue){
                    mAnswerTextView.setText(R.string.true_button);
                }else{
                    mAnswerTextView.setText(R.string.false_button);
                }
                mStateCheap = true;
                setExtraAnswerShownResult(mStateCheap);
            }
        }


        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAnswerIsTrue){
                    mAnswerTextView.setText(R.string.true_button);
                }else{
                    mAnswerTextView.setText(R.string.false_button);
                }
                mStateCheap = true;
                setExtraAnswerShownResult(mStateCheap);
            }
        });
    }

    private  void setExtraAnswerShownResult(boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedIntanceState) {
        super.onSaveInstanceState(savedIntanceState);
        Log.i(TAG,"onSaveInstanceState");
        savedIntanceState.putBoolean(STATE_CHEAP,mStateCheap);
    }
}
