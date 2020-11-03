package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

public class AutoComplete extends AppCompatActivity {
    String[] arWords = new String[] {
            "가구", "가로수", "가방", "가슴", "가치", "가훈", "나그네", "다리미",
            "above", "about", "absolute", "access", "activity", "adjust"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autocomplete);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_dropdown_item_1line, arWords);

        AutoCompleteTextView autoEdit = (AutoCompleteTextView)findViewById(R.id.autoedit);
        autoEdit.setAdapter(adapter);

        MultiAutoCompleteTextView automultiEdit = (MultiAutoCompleteTextView)findViewById(R.id.automultiedit);
        automultiEdit.setAdapter(adapter);
        automultiEdit.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}