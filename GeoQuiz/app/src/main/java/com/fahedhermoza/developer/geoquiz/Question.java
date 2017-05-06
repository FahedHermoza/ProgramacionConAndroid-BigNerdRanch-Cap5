package com.fahedhermoza.developer.geoquiz;

/**
 * Created by mac on 19/03/17.
 */

public class Question {

    private int mTextResId;
    private boolean mAnswerTrue;
    private boolean mIsCheater;

    public Question(int TextResId, boolean AnswerTrue, boolean IsCheater){
        mTextResId = TextResId;
        mAnswerTrue = AnswerTrue;
        mIsCheater = IsCheater;
    }



    public int getTextResId() {
        return mTextResId;

    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public boolean isCheater() {
        return mIsCheater;
    }

    public void setCheater(boolean cheater) {
        mIsCheater = cheater;
    }
}
