package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MultiPage extends AppCompatActivity {
    View mPage1, mPage2, mPage3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multipage);

        mPage1 = findViewById(R.id.page1);
        mPage2 = findViewById(R.id.page2);
        mPage3 = findViewById(R.id.page3);

        Button btn1 = (Button)findViewById(R.id.btnpage1);
        btn1.setOnClickListener(mClickListener);
        findViewById(R.id.btnpage2).setOnClickListener(mClickListener);
        findViewById(R.id.btnpage3).setOnClickListener(mClickListener);
    }

    Button.OnClickListener mClickListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            mPage1.setVisibility(View.INVISIBLE);
            mPage2.setVisibility(View.INVISIBLE);
            mPage3.setVisibility(View.INVISIBLE);
            switch (v.getId()){
                case R.id.btnpage1:
                    mPage1.setVisibility(View.VISIBLE);
                    break;
                case R.id.btnpage2:
                    mPage2.setVisibility(View.VISIBLE);
                    break;
                case R.id.btnpage3:
                    mPage3.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}
