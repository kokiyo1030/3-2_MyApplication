package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CallActivity extends AppCompatActivity {
    EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.callactivity);

        mEdit = (EditText)findViewById(R.id.stredit);
        Intent intent = getIntent();
        String text = intent.getStringExtra("TextIn");

        if (text != null) {
            mEdit.setText(text);
        }
    }

    public void mOnClick(View view) {
        switch (view.getId()) {
            case R.id.btnok:
                Intent intent = new Intent();
                intent.putExtra("TextOut", mEdit.getText().toString());
                setResult(RESULT_OK, intent);
                break;
            case R.id.btncancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}