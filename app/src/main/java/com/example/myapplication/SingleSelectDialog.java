package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SingleSelectDialog extends AppCompatActivity {
    int mSelect = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogtest);
    }

    public void mOnClick(View view) {
        new AlertDialog.Builder(this)
                .setTitle("음식을 선택하세요")
                .setIcon(R.drawable.androboy)
                .setSingleChoiceItems(R.array.foods, mSelect, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mSelect = which;
                    }
                })
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String[] foods = getResources().getStringArray(R.array.foods);
                        TextView text = (TextView)findViewById(R.id.dialogtext);
                        text.setText("선택한 음식 : " + foods[mSelect]);
                    }
                })
                .setNegativeButton("취소", null)
                .show();
    }
}
