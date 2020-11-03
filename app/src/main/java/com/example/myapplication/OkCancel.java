package com.example.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class OkCancel extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogtest);
    }

    public void mOnClick(View view) {
        new AlertDialog.Builder(this).setTitle("질분")
                .setMessage("100만원을 기부하시겠습니까?")
                .setIcon(R.drawable.androboy)
                .setCancelable(false)
                .setPositiveButton("확인", null)
                .setNegativeButton("취소", null)
                .show();
    }
}
