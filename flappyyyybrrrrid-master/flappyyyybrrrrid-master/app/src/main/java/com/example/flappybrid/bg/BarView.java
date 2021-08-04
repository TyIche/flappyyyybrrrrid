package com.example.flappybrid.bg;

import android.content.Context;
import android.graphics.*;

import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.flappybrid.R;

public class BarView extends View {
    Bitmap bm;
    Paint paint;
    public float bw,bh,x,y;
    float INF = 100000000000000000000000000000000000000f;
    public BarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        bm = BitmapFactory.decodeResource(getResources(), R.drawable.bar);
        paint = new Paint();
        bw = bm.getWidth();
        bh = bm.getHeight();
        x = -INF;
        y = -INF;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(bm,x,y,paint);

    }
}
