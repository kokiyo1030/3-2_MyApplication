package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActionView extends AppCompatActivity {
    MenuItem mSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionviewmenu, menu);
        mSearch = menu.findItem(R.id.search);

        mSearch.setOnActionExpandListener(new MenuItem.OnActionExpandListener(){
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                TextView text = (TextView)findViewById(R.id.txtstatus);
                text.setText("현재 상태 : 축소됨");
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                TextView text = (TextView)findViewById(R.id.txtstatus);
                text.setText("현재 상태 : 확장됨");
                return true;
            }
        });

        SearchView search = (SearchView)mSearch.getActionView();
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                TextView text = (TextView)findViewById(R.id.txtresult);
                text.setText(query + "를 검색합니다.");
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                TextView text = (TextView)findViewById(R.id.txtsearch);
                text.setText("검색식 : " + newText);
                return true;
            }
        });
        return true;
    }

    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.btnexpand:
                mSearch.expandActionView();
                break;
            case R.id.btncollapse:
                mSearch.collapseActionView();
                break;
        }
    }
}