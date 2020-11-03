package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TimePickerTest extends AppCompatActivity {
    TimePicker mTime;
    TextView mTxtTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timepickertest);

        mTime = (TimePicker)findViewById(R.id.timepicker);
        mTxtTime = (TextView)findViewById(R.id.txttime);
        mTime.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                mTxtTime.setText(String.format("%d:%d", hourOfDay, minute));
            }
        });

        findViewById(R.id.btntoggle24).setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                mTime.setIs24HourView(!mTime.is24HourView());
            }
        });

        findViewById(R.id.btnnow).setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                String result = String.format("%d시 %d분",
                        mTime.getCurrentHour(), mTime.getCurrentMinute());
                Toast.makeText(TimePickerTest.this, result, Toast.LENGTH_SHORT).show();
            }
        });
    }
}