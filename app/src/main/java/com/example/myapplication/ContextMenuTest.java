package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ContextMenuTest extends AppCompatActivity {
    Button mBtn;
    EditText mEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contextmenutest);

        mBtn = (Button)findViewById(R.id.button);
        registerForContextMenu(mBtn);

        mEdit = (EditText)findViewById(R.id.edittext);
        registerForContextMenu(mEdit);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == mBtn){
            menu.setHeaderTitle("Button Menu");
            menu.add(0,1,0,"Red");
            menu.add(0,2,0,"Green");
            menu.add(0,3,0,"Blue");
        }else if(v == mEdit){
            menu.add(0,4,0,"번역하기");
            menu.add(0,5,0,"필기 인식");
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()) {
            case 1:
                mBtn.setTextColor(Color.RED);
                break;
            case 2:
                mBtn.setTextColor(Color.GREEN);
                break;
            case 3:
                mBtn.setTextColor(Color.BLUE);
                break;
            case 4:
                Toast.makeText(this, "번역했다.", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}