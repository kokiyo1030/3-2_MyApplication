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
    public static CounterFragment newInstance(int start){
        CounterFragment cf = new CounterFragment();
        Bundle args = new Bundle();
        args.putInt("start",start);
        cf.setArguments(args);
        return cf;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.counterfragment, container, false);
        Button btnIncrease = (Button)root.findViewById(R.id.btnincrease);
        final TextView textCounter = (TextView)root.findViewById(R.id.txtcounter);

        int start = 0;
        Bundle args = getArguments();
        if(args != null){
            start = args.getInt("start");
        }
        textCounter.setText(Integer.toString(start));

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
