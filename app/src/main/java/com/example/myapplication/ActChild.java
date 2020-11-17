package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class ActChild extends AppCompatActivity {
    static final String TAG = "ActChild";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actchild);
    }
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    public void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}