package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MenuCheck extends AppCompatActivity {
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuchenck);
        mButton = (Button)findViewById(R.id.button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucheck, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if (mButton.getTextSize() == 40) {
            menu.findItem(R.id.bigfont).setChecked(true);
        } else {
            menu.findItem(R.id.bigfont).setChecked(false);
        }

        int color = mButton.getTextColors().getDefaultColor();
        if (color == Color.RED) {
            menu.findItem(R.id.red).setChecked(true);
        } else if (color == Color.GREEN) {
            menu.findItem(R.id.green).setChecked(true);
        } else if (color == Color.BLUE) {
            menu.findItem(R.id.blue).setChecked(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.bigfont:
                if(item.isChecked()) {
                    mButton.setTextSize(TypedValue.COMPLEX_UNIT_PX, 20);
                } else {
                    mButton.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
                }
                break;
            case R.id.red:
                mButton.setTextColor(Color.RED);
                break;
            case R.id.green:
                mButton.setTextColor(Color.GREEN);
                break;
            case R.id.blue:
                mButton.setTextColor(Color.BLUE);
                break;
        }
        return true;
    }
}
