package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CounterFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.counterfragment, container, false);
        Button btnIncrease = (Button)root.findViewById(R.id.btnincrease);
        final TextView textCounter = (TextView)root.findViewById(R.id.txtcounter);

        if(savedInstanceState != null) {
            textCounter.setText(Integer.toString(savedInstanceState.getInt("counter")));
        }

        btnIncrease.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(textCounter.getText().toString());
                textCounter.setText(Integer.toString(count + 1));
            }
        });
        return root;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView textView = (TextView)getView().findViewById(R.id.txtcounter);
        int num = Integer.parseInt(textView.getText().toString());
        outState.putInt("counter", num);
    }
}
