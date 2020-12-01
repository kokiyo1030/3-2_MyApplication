package com.example.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BackStack extends AppCompatActivity {
    int mStart = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.backstack);

        if (savedInstanceState != null) {
            mStart = savedInstanceState.getInt("mStart");
        }
    }
    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.btnadd:
                mStart += 10;
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction tr = fm.beginTransaction();
                CounterFragment cf = CounterFragment.newInstance(mStart);
                tr.replace(R.id.frame,cf);
                tr.addToBackStack(null);
                tr.commit();
                break;
        }
    }
}