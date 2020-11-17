package com.example.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CallOther extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.callother);
    }

    public void mOnClick(View vIew) {
        Intent intent;
        switch (vIew.getId()) {
            case R.id.web:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
                startActivity(intent);
                break;
            case R.id.dial:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-9317-1040"));
                startActivity(intent);
                break;
            case R.id.picture:
                intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 0);
                break;
            default:
                intent = new Intent(Intent.ACTION_MAIN);
                intent.setComponent(new ComponentName("com.example.myapplication",
                        "com.example.myapplication.FreeLine"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
        }
    }
}