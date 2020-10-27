package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class PopupMenuTest extends AppCompatActivity {
    Button mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupmenutest);

        mBtn = (Button)findViewById(R.id.btn);
    }

    public void mOnClick(View v){
        PopupMenu pop = new PopupMenu(this,v);

        //3줄 or
        MenuInflater inflater = pop.getMenuInflater();
        Menu menu = pop.getMenu();
        inflater.inflate(R.menu.popupmenutestmenu,menu);
        //1줄
        //pop.inflate(R.menu.popupmenutestmenu);

        pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.popup_red:
                        mBtn.setBackgroundColor(Color.RED);
                        break;
                    case R.id.popup_green:
                        mBtn.setBackgroundColor(Color.GREEN);
                        break;
                    case R.id.popup_blue:
                        mBtn.setBackgroundColor(Color.BLUE);
                        break;
                    case R.id.popup_black:
                        mBtn.setTextColor(Color.BLACK);
                        break;
                    case R.id.popup_white:
                        mBtn.setTextColor(Color.WHITE);
                        break;
                    case R.id.popup_gray:
                        mBtn.setTextColor(Color.GRAY);
                        break;
                }
                return false;
            }
        });
        pop.show();
    }
}