package com.github.xwc.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.*;

/**
 * Created by xwc on 2018/7/2.
 */

public class TextDrawableView extends android.support.v7.widget.AppCompatTextView {

    private int defaultColor = 0;
    private int pressedColor = 0;

    public TextDrawableView(Context context) {
        this(context, null);
    }

    public TextDrawableView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextDrawableView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextDrawableView);
        defaultColor = getTextColors().getDefaultColor();
        pressedColor = typedArray.getColor(R.styleable.TextDrawableView_pressedColor, pressedColor);
        typedArray.recycle();
        setClickable(true);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                setTextColor(pressedColor);
                break;
            case MotionEvent.ACTION_UP:
                setTextColor(defaultColor);
                break;
            case MotionEvent.ACTION_CANCEL:
                setTextColor(defaultColor);
                break;
        }
        return super.dispatchTouchEvent(event);
    }
}
