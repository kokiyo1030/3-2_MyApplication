package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DatePickerTest extends AppCompatActivity {
    DatePicker mDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepickertest);

        mDate = (DatePicker)findViewById(R.id.datepicker);

        // 선택기로부터 날짜 조사
        findViewById(R.id.btnnow).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String result = String.format("%d년 %d월 %d일", mDate.getYear(),
                        mDate.getMonth() + 1, mDate.getDayOfMonth());
                Toast.makeText(DatePickerTest.this, result, 0).show();
            }
        });
    }
}