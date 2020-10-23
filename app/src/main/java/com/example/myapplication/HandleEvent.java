package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HandleEvent extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View myView = new MyView(this);
        //View myView = new View(this);
        setContentView(myView);

        myView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Toast.makeText(HandleEvent.this,
                            "Touch Event Received1", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }
/*
    View.OnTouchListener mTouchListenerClass = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                Toast.makeText(HandleEvent.this,
                        "Touch Event Received", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }
    };
 */
/*
    TouchListenerClass TouchListener = new TouchListenerClass();

    class TouchListenerClass implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                Toast.makeText(HandleEvent.this,
                        "Touch Event Received", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }
    }
 */

    class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            super.onTouchEvent(event);
            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                Toast.makeText(HandleEvent.this,
                        "Touch Event Received2", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }
    }
}
