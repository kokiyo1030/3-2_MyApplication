package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class RadioCheck extends AppCompatActivity {
    TextView mSample;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiocheck);

        mSample = (TextView)findViewById(R.id.txtsample);

        RadioGroup colGroup = (RadioGroup)findViewById(R.id.colorgroup);
        colGroup.setOnCheckedChangeListener(mRadioCheck);

        CheckBox backWhite = (CheckBox)findViewById(R.id.chkwhiteback);
        backWhite.setOnCheckedChangeListener(mCheckChange);

        ToggleButton langToggle = (ToggleButton)findViewById(R.id.tglanguage);
        langToggle.setOnCheckedChangeListener(mCheckChange);
    }

    RadioGroup.OnCheckedChangeListener mRadioCheck = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (group.getCheckedRadioButtonId()){
                case R.id.red:
                    mSample.setTextColor(Color.RED);
                    break;
                case R.id.green:
                    mSample.setTextColor(Color.GREEN);
                    break;
                case R.id.blue:
                    mSample.setTextColor(Color.BLUE);
                    break;
            }
        }
    };

    CompoundButton.OnCheckedChangeListener mCheckChange = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(buttonView.getId() == R.id.chkwhiteback){
                if(isChecked){
                    mSample.setBackgroundColor(Color.WHITE);
                } else {
                    mSample.setBackgroundColor(Color.parseColor("#121212"));
                }
            }
        }
    };
}
