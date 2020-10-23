package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditTextTest extends AppCompatActivity {
    EditText mEdit;
    TextView mText;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edittexttest);

        mEdit = findViewById(R.id.textedit);
        mText = findViewById(R.id.textView5);

        mEdit.addTextChangedListener(mWatcher);
        //mEdit.setBackgroundColor(Color.RED);
        //mEdit.setBackgroundResource(R.color.textColor);
        mButton=(Button)findViewById(R.id.button);
        mButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = mEdit.getText().toString();
                Toast.makeText(EditTextTest.this, str, Toast.LENGTH_SHORT).show();
            }
        });
    }

    TextWatcher mWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mText.setText("Now Length : " + s.length() + "Characters");
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
