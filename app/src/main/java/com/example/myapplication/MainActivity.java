package com.example.myapplication;

        import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        LinearLayout linear = new LinearLayout(this);
        linear.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
        linear.setLayoutParams(params);
        linear.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams params2 =
                new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

        TextView text1 = new TextView(this);
        text1.setLayoutParams(params2);
        text1.setText("Hello");
        text1.setTextColor(Color.RED);
        text1.setTextSize(TypedValue.COMPLEX_UNIT_PT, 20);
        text1.setTypeface(null, Typeface.ITALIC);
        linear.addView(text1);

        TextView text2 = new TextView(this);
        text2.setLayoutParams(params2);
        text2.setText("안녕하세요");
        text2.setBackgroundColor(Color.BLUE);
        text2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        linear.addView(text2);

        TextView text3 = new TextView(this);
        text3.setLayoutParams(params2);
        text3.setText("Good Morning");
        text3.setTextColor(Color.parseColor("#8000ff00"));
        text3.setTextSize(TypedValue.COMPLEX_UNIT_MM, 5);
        text3.setTypeface(Typeface.SERIF);
        linear.addView(text3);

        setContentView(linear);
        */
    }
}
