package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentManagerTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmentmanagertest);
    }

    public void mOnClick(View view) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.frame);
        switch (view.getId()) {
            case R.id.btnadd:
                if (fragment == null) {
                    FragmentTransaction tr = fm.beginTransaction();
                    tr.add(R.id.frame, new CounterFragment(), "counter");
                    tr.commit();
                } else {
                    Toast.makeText(this, "이미 추가되어 있습니다", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnremove:
                if (fragment == null) {
                    Toast.makeText(this, "프래그먼트가 없습니다", Toast.LENGTH_SHORT).show();
                } else {
                    FragmentTransaction tr = fm.beginTransaction();
                    tr.remove(fragment);
                    tr.commit();
                }
                break;
            case R.id.btnreplace:
                if (fragment == null) {
                    Toast.makeText(this, "프래그먼트가 없습니다", Toast.LENGTH_SHORT).show();
                } else {
                    FragmentTransaction tr = fm.beginTransaction();
                    if (fragment.getTag() == "counter") {
                        tr.replace(R.id.frame, new TextFragment(), "text");
                    } else {
                        tr.replace(R.id.frame, new CounterFragment(), "counter");
                    }
                    tr.commit();
                }
                break;
            case R.id.btnhideshow:
                if (fragment == null) {
                    Toast.makeText(this, "프래그먼트가 없습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    FragmentTransaction tr = fm.beginTransaction();
                    if (fragment.isHidden()) {
                        tr.show(fragment);
                    } else {
                        tr.hide(fragment);
                    }
                    tr.commit();
                }
                break;
        }
    }
}