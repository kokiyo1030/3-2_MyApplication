package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;

public class ActionModeTest extends AppCompatActivity {
    ActionMode mActionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionmodetest);
    }
    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.btnaction:
                if (mActionMode == null) {
                    mActionMode = startSupportActionMode(new ActionMode.Callback(){
                        @Override
                        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                            MenuInflater inflater = mode.getMenuInflater();
                            inflater.inflate(R.menu.actionmodetestmenu, menu);
                            return true;
                        }

                        @Override
                        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                            return false;
                        }

                        @Override
                        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.add:
                                    Toast.makeText(ActionModeTest.this, "add", Toast.LENGTH_SHORT).show();
                                    break;
                                case R.id.edit:
                                    Toast.makeText(ActionModeTest.this, "edit", Toast.LENGTH_SHORT).show();
                                    break;
                                case R.id.search:
                                    Toast.makeText(ActionModeTest.this, "search", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                            return false;
                        }

                        @Override
                        public void onDestroyActionMode(ActionMode mode) {
                            mActionMode = null;
                        }
                    });
                    mActionMode.setTitle("Test");
                }
                break;
        }
    }
}