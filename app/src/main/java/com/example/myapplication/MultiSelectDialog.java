package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MultiSelectDialog extends AppCompatActivity {
    boolean[] mSelect = { false, false, false, false };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogtest);
    }

    public void mOnClick(View view) {
        new AlertDialog.Builder(this)
                .setTitle("음식을 선택하세요")
                .setIcon(R.drawable.androboy)
                .setMultiChoiceItems(R.array.foods, mSelect, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        mSelect[which] = isChecked;
                    }
                })
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String[] foods = getResources().getStringArray(R.array.foods);
                        TextView text = (TextView)findViewById(R.id.dialogtext);
                        String result = "선택한 음식 : ";
                        for(int i=0; i<mSelect.length; i++) {
                            if(mSelect[i]) result += foods[i] + " ";
                        }
                        text.setText(result);
                    }
                })
                .setNegativeButton("취소", null)
                .setCancelable(false)
                .show();
    }
}
