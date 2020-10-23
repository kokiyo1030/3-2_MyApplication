package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class OptionMenu extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new View(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

//        MenuItem item = menu.add(0, 1, 0, "짜장");
//        item.setCheckable(true);
//        item.setChecked(true);
//        menu.add(0, 2, 0, "짬뽕");
//        SubMenu etc = menu.addSubMenu("기타");
//        etc.add(0, 3, 0, "우동");
//        etc.add(0, 4, 0, "만두");

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionsmenu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.JJajang:
                Toast.makeText(this, "짜장은 달콤해", Toast.LENGTH_SHORT).show();
                break;
            case R.id.JJambbong:
                Toast.makeText(this, "짬뽕은 달콤해", Toast.LENGTH_SHORT).show();
                break;
            case R.id.udong:
                Toast.makeText(this, "우동은 달콤해", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mandoo:
                Toast.makeText(this, "만두는 달콤해", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    public void mOnClick(MenuItem item) {
        item.setChecked(item.isChecked() ? false : true);
    }
}
