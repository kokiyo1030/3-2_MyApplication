package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

public class ScrollViewTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollviewtest);

        ScrollView svw = (ScrollView)findViewById(R.id.scr);
        svw.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//        svw.setVerticalScrollBarEnabled(false);
        svw.addView(new ColorView(this));
    }
}
class ColorView extends View {
    public ColorView(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas) {
        Paint Pnt = new Paint();
        for (int y = 0;y < 2560;y += 10) {
            Pnt.setARGB(255, 255 - y / 10, 255 - y / 10, 255);
            canvas.drawRect(0, y, 2560, y + 10, Pnt);
        }
    }

    protected void onMeasure (int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(2560, 2560);
    }
}
