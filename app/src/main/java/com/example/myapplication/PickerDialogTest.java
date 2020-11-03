package com.example.myapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PickerDialogTest extends AppCompatActivity {
    int mYear, mMonth, mDay, mHour, mMinute;
    TextView mTxtDate;
    TextView mTxtTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickerdialogtest);

        mTxtDate = (TextView)findViewById(R.id.txtdate);
        mTxtTime = (TextView)findViewById(R.id.txttime);

        Calendar cal = new GregorianCalendar();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);
        mHour = cal.get(Calendar.HOUR_OF_DAY);
        mMinute = cal.get(Calendar.MINUTE);

        UpdateNow();
    }
    public void mOnClick(View v) {
        switch(v.getId()){
            case R.id.btnchangedate:
                new DatePickerDialog(this,R.style.MySpinnerDatePickerStyle, mDateSetListener, mYear,mMonth,mDay).show();
                break;
            case R.id.btnchangetime:
                new TimePickerDialog(this,R.style.MySpinnerTimePickerStyle, mTimeSetListener,mHour,mMinute,false).show();
                break;
        }
    }

    DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mYear = year;
            mMonth = dayOfMonth;
            mDay = dayOfMonth;
            UpdateNow();
        }
    };

    TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet (TimePicker view, int hourOfDay, int minute) {
        mHour = hourOfDay;
        mMinute = minute;
        UpdateNow();
    }
};

    void UpdateNow() {
        mTxtDate.setText(String.format("%d/%d/%d", mYear,mMonth + 1, mDay));
        mTxtTime.setText(String.format("%d:%d", mHour, mMinute));
    }
}