package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ShowHideActionBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showhideactionbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbarmenu, menu);
        return true;
    }

    public void mOnClick(View view){
        switch(view.getId()){
            case R.id.btntoggle:
                ActionBar bar = getSupportActionBar();
                if(bar.isShowing()){
                    bar.hide();
                    ((Button)view).setText("Show Action Bar");
                }else{
                    bar.show();
                    ((Button)view).setText("Hide Action Bar");
                }
                break;
        }
    }
}