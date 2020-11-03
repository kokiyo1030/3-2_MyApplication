package com.example.myapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class ProgressBarTest extends AppCompatActivity {
    ProgressBar mProgBar;
    ProgressBar mProgCircle;
    ProgressDialog mDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressbartest);

        mProgBar = (ProgressBar)findViewById(R.id.progress);
        mProgCircle = (ProgressBar)findViewById(R.id.progcircle);
    }

    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.decfirst:
                mProgBar.incrementProgressBy(-2);
                break;
            case R.id.incfirst:
                mProgBar.incrementProgressBy(2);
                break;
            case R.id.decsecond:
                mProgBar.incrementSecondaryProgressBy(-2);
                break;
            case R.id.incsecond:
                mProgBar.incrementSecondaryProgressBy(2);
                break;
            case R.id.start:
                mProgCircle.setVisibility(View.VISIBLE);

//                mDialog= new ProgressDialog(this);
//                mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//                mDialog.setMessage("데이터를 확인하는 중입니다.");
//                mDialog.show();
                break;
            case R.id.stop:
                mProgCircle.setVisibility(View.INVISIBLE);
//                if (mDialog != null){
//                    mDialog.dismiss();
//                }
                break;
        }
    }
}