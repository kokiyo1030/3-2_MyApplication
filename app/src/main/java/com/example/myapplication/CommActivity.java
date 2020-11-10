package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CommActivity extends AppCompatActivity {
    TextView mText;
    final static int ACT_EDIT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.commactivity);

        mText = (TextView)findViewById(R.id.text);
    }

    public void mOnClick(View view) {
        switch (view.getId()) {
            case R.id.btnedit:
                Intent intent = new Intent(this, CallActivity.class);
                intent.putExtra("TextIn", mText.getText().toString());
                startActivityForResult(intent, ACT_EDIT);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case ACT_EDIT:
                if (resultCode == RESULT_OK) {
                    mText.setText(data.getStringExtra("TextOut"));
                }
                break;
        }
    }
}