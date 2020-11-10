package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class RainbowProgress extends View {
    int mMax;
    int mPos;
    int mProgHeight;
    LinearGradient mShader;

    public RainbowProgress(Context context) {
        super(context);
        init();
    }

    public RainbowProgress(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RainbowProgress(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    void init() {
        mMax = 100;
        mPos = 0;
    }

    void setMax(int aMax) {
        if (aMax > 0) {
            mMax = aMax;
            invalidate();
        }
    }

    int getMax() { return mMax; }

    void setPos(int aPos) {
        if (aPos < 0 || aPos > mMax) {
            return;
        }
        mPos = aPos;
        invalidate();
    }

    int getPos() { return mPos; }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mShader == null) {
            mProgHeight = getHeight() - getPaddingTop() - getPaddingBottom();
            int[] colors = { Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE };
            mShader = new LinearGradient(0,0,0,mProgHeight,
                    colors, null, Shader.TileMode.CLAMP);
        }

        RectF rt = new RectF();
        rt.left = getPaddingLeft();
        rt.right = getWidth() - getPaddingRight();
        rt.bottom = getPaddingTop() + mProgHeight;
        rt.top = rt.bottom - mProgHeight * mPos / mMax;

        Paint fillpnt = new Paint();
        fillpnt.setShader(mShader);
        canvas.drawRect(rt, fillpnt);

        rt.top = getPaddingTop();
        Paint outpnt = new Paint();
        outpnt.setColor(Color.WHITE);
        outpnt.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rt, outpnt);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int Width = 48, Height = 200;
        switch (MeasureSpec.getMode(widthMeasureSpec)) {
            case MeasureSpec.AT_MOST:
                Width = Math.min(MeasureSpec.getSize(widthMeasureSpec), Width);
                break;
            case MeasureSpec.EXACTLY:
                Width = MeasureSpec.getSize(widthMeasureSpec);
                break;
        }

        switch (MeasureSpec.getMode(heightMeasureSpec)) {
            case MeasureSpec.AT_MOST:
                Height = Math.min(MeasureSpec.getSize(heightMeasureSpec), Height);
                break;
            case MeasureSpec.EXACTLY:
                Height = MeasureSpec.getSize(heightMeasureSpec);
                break;
        }

        setMeasuredDimension(Width, Height);
    }

}
