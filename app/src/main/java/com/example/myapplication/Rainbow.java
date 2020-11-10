package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Rainbow extends AppCompatActivity {
    RainbowProgress mProgress;
    Handler mHandler;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rainbow);

        mProgress = (RainbowProgress)findViewById(R.id.progress);

        Button btn = (Button)findViewById(R.id.start);
        btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                if (mProgress.getPos() == 0) {
                    mProgress.setPos(0);
                    mHandler.sendEmptyMessage(0);
                }
            }
        });
        mHandler = new Handler(Looper.myLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                int Pos;
                Pos = mProgress.getPos();
                if (Pos < mProgress.getMax()) {
                    mProgress.setPos(Pos+1);
                    mHandler.sendEmptyMessageDelayed(0,100);
                } else {
                    Toast.makeText(Rainbow.this, "Completed", Toast.LENGTH_SHORT).show();
                    mProgress.setPos(0);
                }
            }
        };
    }


}