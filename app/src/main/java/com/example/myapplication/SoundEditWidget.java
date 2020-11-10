package com.example.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.util.AttributeSet;
import android.widget.EditText;

public class SoundEditWidget extends EditText {
    SoundPool mPool = null;
    int mClick;
    int mClick2;
    int mSound;
    float mVolume = 1.0f;
    float mSpeed = 1.0f;

    public SoundEditWidget(Context context) {
        super(context);
        init(context, null);
    }

    public SoundEditWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public SoundEditWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    void init(Context context, AttributeSet attrs) {
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        mPool = new SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                .setMaxStreams(1)
                .build();
        mClick = mPool.load(context, R.raw.click, 1);
        mClick2 = mPool.load(context, R.raw.click2, 1);
        mSound = mClick;
        if (attrs != null) {
            TypedArray ar = context.obtainStyledAttributes(attrs, R.styleable.SoundEditWidget);
            mVolume = ar.getFloat(R.styleable.SoundEditWidget_volume, 1.0f);
            mSpeed = ar.getFloat(R.styleable.SoundEditWidget_speed, 1.0f);
            mSound = ar.getInt(R.styleable.SoundEditWidget_sound, mClick);
            ar.recycle();
        }
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        if (mPool != null) {
            mPool.play(mSound, mVolume, mVolume, 0, 0, mSpeed);
        }
    }
}
