package jp.ac.shohoku.bijoufriends;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;


public class BijouView extends View {
    public BijouView(Context context) {
        super(context);
    }

    public BijouView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BijouView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
