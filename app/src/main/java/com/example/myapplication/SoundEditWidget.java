package com.example.myapplication;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.util.AttributeSet;
import android.widget.EditText;

public class SoundEditWidget extends EditText {
    SoundPool mPool = null;
    int mClick;

    public SoundEditWidget(Context context) {
        super(context);
        init(context);
    }

    public SoundEditWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SoundEditWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    void init(Context context) {
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        mPool = new SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                .setMaxStreams(1)
                .build();
        mClick = mPool.load(context, R.raw.click, 1);
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        if (mPool != null) {
            mPool.play(mClick, 1, 1, 0, 0, 1);
        }
    }
}
