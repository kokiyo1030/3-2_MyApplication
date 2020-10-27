package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.view.ActionProvider;

public class CounterProvider extends ActionProvider {
    Context mContext;
    TextView mCountText;

    public CounterProvider(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public View onCreateActionView() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View linear =  inflater.inflate(R.layout.counterprovider,null);
        mCountText = (TextView)linear.findViewById(R.id.count);

        Button btnInc = (Button)linear.findViewById(R.id.btnincrease);
        btnInc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int count = Integer.parseInt(mCountText.getText().toString());
                mCountText.setText(Integer.toString(count + 1));
            }
        });

        Button btnDec = (Button)linear.findViewById(R.id.btndecrease);
        btnDec.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int count = Integer.parseInt(mCountText.getText().toString());
                mCountText.setText(Integer.toString(count - 1));
            }
        });
        return linear;
    }


    @Override
    public boolean onPerformDefaultAction() {
        super.onPerformDefaultAction();
        Toast.makeText(mContext, "Counter Menu Item selected - " +
                "onPerformDefaultAction", Toast.LENGTH_SHORT).show();
        return true;
    }
}
