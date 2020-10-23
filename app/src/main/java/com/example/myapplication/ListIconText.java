package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListIconText extends AppCompatActivity {
    ArrayList<MyItem> myItems;
    MyListAdapter myAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewtest);

        myItems = new ArrayList<>();
        myItems.add(new MyItem(R.drawable.androboy, "예쁜 꽃"));
        myItems.add(new MyItem(R.drawable.androboy, "귀여운 꽃"));
        myItems.add(new MyItem(R.drawable.androboy, "멋있는 꽃"));

        myAdapter = new MyListAdapter(this, R.layout.icontext, myItems);

        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(myAdapter);
    }
}

class MyItem {
    int mIcon;
    String mName;

    public MyItem(int mIcon, String mName) {
        this.mIcon = mIcon;
        this.mName = mName;
    }
}

class  MyListAdapter extends BaseAdapter {
    Context mContext;
    int mLayout;
    ArrayList<MyItem> mDatas;
    LayoutInflater mInflater;

    public MyListAdapter(Context context, int layout, ArrayList<MyItem> datas) {
        this.mContext = context;
        this.mLayout = layout;
        this.mDatas = datas;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public  int getCount() {
        return  mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(mLayout, parent, false);
        }

        ImageView img = (ImageView)convertView.findViewById(R.id.img);
        img.setImageResource(mDatas.get(position).mIcon);

        TextView txt = (TextView)convertView.findViewById(R.id.text);
        txt.setText(mDatas.get(position).mName);

        Button btn = (Button)convertView.findViewById(R.id.btn);
        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = mDatas.get(position).mName + "를 주문합니다";
                Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}