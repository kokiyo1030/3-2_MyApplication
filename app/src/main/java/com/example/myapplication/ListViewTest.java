package com.example.myapplication;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListViewTest extends AppCompatActivity {
    ArrayAdapter<CharSequence> madapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewtest);

//        ArrayList<String> arGeneral = new ArrayList<String>();
//        arGeneral.add("김유신");
//        arGeneral.add("이순신");
//        arGeneral.add("강감찬");
//        arGeneral.add("을지문덕");

//        String[] arGeneral = {"김유신", "이순신", "강감찬", "을지문덕"};

//        ArrayAdapter<String> adapter = new ArrayAdapter<>
//                (this, android.R.layout.simple_list_item_1, arGeneral);

        madapter = ArrayAdapter.createFromResource(this,
                R.array.country, android.R.layout.simple_list_item_1);
        ListView view = (ListView)findViewById(R.id.list);
        view.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        view.setDivider(new ColorDrawable(Color.YELLOW));
        view.setDividerHeight(5);

        view.setAdapter(madapter);

        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = "Select Item = " + madapter.getItem(position);
                Toast.makeText(ListViewTest.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
