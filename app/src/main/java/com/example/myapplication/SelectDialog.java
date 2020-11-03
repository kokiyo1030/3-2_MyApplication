package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SelectDialog extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogtest);
    }

    public void mOnClick(View view) {
        new AlertDialog.Builder(this).setTitle("음식을 선택하세요")
                .setIcon(R.drawable.androboy)
                .setItems(R.array.foods, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String[] food = getResources().getStringArray(R.array.foods);
                        Toast.makeText(SelectDialog.this, food[which], Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("취소", null)
                .setCancelable(false)
                .show();
    }
}
