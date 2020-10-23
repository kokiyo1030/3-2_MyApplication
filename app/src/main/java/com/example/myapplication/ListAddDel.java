package com.example.myapplication;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListAddDel extends AppCompatActivity {
    ArrayList<String> Item;
    ArrayAdapter<String> Adapter;
    ListView list;
    EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listadddel);

        Item = new ArrayList<>();
        Item.add("First");
        Item.add("Second");
        Item.add("Third");

        Adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice, Item);
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(Adapter);
//        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        mEditText = (EditText)findViewById(R.id.newitem);
    }

    public void mOnClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                String text = mEditText.getText().toString();
                if(text.length() != 0) {
                    Item.add(text);
                    mEditText.setText("");
                    Adapter.notifyDataSetChanged();
                }
                break;
//            case R.id.delete:
//                int pos = list.getCheckedItemPosition();
//                if(pos != ListView.INVALID_POSITION) {
//                    Item.remove(pos);
//                    list.clearChoices();
//                    Adapter.notifyDataSetChanged();
//                }
//                break;
            case R.id.delete:
                SparseBooleanArray sb = list.getCheckedItemPositions();
                if(sb.size() != 0) {
                    for(int i=list.getCount()-1; i>=0; i--) {
                        if(sb.get(i)) {
                            Item.remove(i);
                        }
                    }
                    list.clearChoices();
                    Adapter.notifyDataSetChanged();
                }
                break;
        }
    }
}
