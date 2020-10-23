package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class SetParameter extends AppCompatActivity {
    Button mLeft;
    Button mRight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setparameter);

        mLeft = (Button)findViewById(R.id.btnleft);
        mLeft.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                setParam(3, 1);
            }
        });

        mRight = (Button)findViewById(R.id.btnright);
        mRight.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                setParam(1,3);
            }
        });
    }

    void setParam(int left, int right) {
        LinearLayout.LayoutParams lparam = (LinearLayout.LayoutParams)mLeft.getLayoutParams();
        lparam.weight = left;
        mLeft.setLayoutParams(lparam);

        LinearLayout.LayoutParams rparam = (LinearLayout.LayoutParams)mRight.getLayoutParams();
        rparam.weight = right;
        mRight.setLayoutParams(rparam);
    }
}
