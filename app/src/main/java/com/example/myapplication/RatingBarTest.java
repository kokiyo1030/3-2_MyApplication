package com.example.myapplication;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RatingBarTest extends AppCompatActivity {
    RatingBar mRating;
    TextView mRateText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ratingbartest);

        mRating = (RatingBar)findViewById(R.id.ratingbar);
        mRateText = (TextView)findViewById(R.id.ratetext);

        mRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                mRateText.setText("Now Rate : " + rating);
            }
        });
    }
}