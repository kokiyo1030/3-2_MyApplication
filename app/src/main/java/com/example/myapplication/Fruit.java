package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Fruit extends AppCompatActivity {
    TextView mTextFruit;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruit);

        mTextFruit=(TextView)findViewById(R.id.fruit);
//        Button btnApple = (Button)findViewById(R.id.apple);
//        Button btnOrange = (Button)findViewById(R.id.orange);
//        btnApple.setOnClickListener(ClickListener);
//        btnOrange.setOnClickListener(ClickListener);
    }

    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.apple:
                mTextFruit.setText("Apple");
                break;
            case R.id.orange:
                mTextFruit.setText("Orange");
                break;
        }
    }
//    Button.OnClickListener ClickListener = new Button.OnClickListener(){
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id.apple:
//                    mTextFruit.setText("Apple");
//                    break;
//                case R.id.orange:
//                    mTextFruit.setText("Orange");
//                    break;
//            }
//        }
//    };
}