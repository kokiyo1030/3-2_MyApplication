package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Inflation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inflation);

        Button msg = (Button)findViewById(R.id.btnnewmessage);
        msg.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout layout = (RelativeLayout)View.inflate(
                        Inflation.this, R.layout.newmessage, null);
                LinearLayout linear = (LinearLayout)findViewById(R.id.linear);
                if(linear.getChildCount() % 2 == 0) {
                    layout.setBackgroundColor(Color.GRAY);
                } else {
                    layout.setBackgroundColor(Color.GREEN);
                }
                linear.addView(layout);
            }
        });
    }
}
