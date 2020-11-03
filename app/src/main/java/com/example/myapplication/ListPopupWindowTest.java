package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ListPopupWindow;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class ListPopupWindowTest extends AppCompatActivity {
    Button mBtn;
    ListPopupWindow mList;
    public String[] Colors = {
            "Red", "Green", "Blue", "Yellow", "Cyan", "Magenta"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listpopupwindowtest);

        mBtn = (Button)findViewById(R.id.btn);
        mList = new ListPopupWindow(this);
        mList.setWidth(300);
        mList.setHeight(300);
        mList.setAnchorView(mBtn);
        mList.setAdapter(new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,Colors));

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:	mBtn.setBackgroundColor(Color.RED); break;
                    case 1:	mBtn.setBackgroundColor(Color.GREEN); break;
                    case 2:	mBtn.setBackgroundColor(Color.BLUE); break;
                    case 3:	mBtn.setBackgroundColor(Color.YELLOW); break;
                    case 4:	mBtn.setBackgroundColor(Color.CYAN); break;
                    case 5:	mBtn.setBackgroundColor(Color.MAGENTA); break;
                }
            }
        });
    }
    public void mOnClick(View v) {
        if (mList.isShowing()) {
            mList.dismiss();
        } else {
            mList.show();
        }
    }
}