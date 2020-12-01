package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentArgument extends AppCompatActivity {
    EditText mStartNum;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmentargument);

        mStartNum = (EditText)findViewById(R.id.startnum);
    }

    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.btnadd:
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction tr = fm.beginTransaction();
                int start = Integer.parseInt(mStartNum.getText().toString());
                CounterFragment cf = CounterFragment.newInstance(start);
                tr.add(R.id.frame,cf, "counter");
                tr.commit();
                break;
        }
    }
}
