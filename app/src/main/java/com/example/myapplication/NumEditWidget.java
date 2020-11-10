package com.example.myapplication;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class NumEditWidget extends LinearLayout {
    EditText mEdit;
    TextView mText;

    public NumEditWidget(Context context) {
        super(context);
        init();
    }

    public NumEditWidget(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NumEditWidget(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    void init() {
        LinearLayout layout = (LinearLayout) View.inflate(getContext(), R.layout.numeditwidget, this);
        mText = (TextView) layout.findViewById(R.id.textView);
        mText.setText("Now Length : 0 Characters");
        mEdit = (EditText)layout.findViewById(R.id.textedit);
        mEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mText.setText("Now Length : " + s.length() + " Characters");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
