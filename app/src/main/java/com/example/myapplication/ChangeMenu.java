package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ChangeMenu extends AppCompatActivity {
    boolean mBeginner = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changemenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
//        if (mBeginner) {
//            inflater.inflate(R.menu.beginner, menu);
//        } else {
//            inflater.inflate(R.menu.professional, menu);
//        }
        inflater.inflate(R.menu.actionbarmenu, menu);
        return true;
    }

    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.btnbegineer:
                mBeginner = true;
                invalidateOptionsMenu();
                break;
            case R.id.btnprofessional:
                mBeginner = false;
                invalidateOptionsMenu();
                break;
        }
    }
}