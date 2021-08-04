package com.example.flappybrid.bg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import com.example.flappybrid.fg.BridLayout;
import com.example.flappybrid.vector.Recc;
import com.example.flappybrid.vector.Vector;

public class GV extends View {
    public Vector[] ve = {new Vector(),new Vector(0,500),new Vector(500,500),new Vector(500,0)};
    public Vector[] ve2 = {new Vector(),new Vector(0,500),new Vector(500,500),new Vector(500,0)};
    public GV(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }
    public void gove(Vector[] vv)
    {
        for(int i = 0;i < 4;i ++) {ve[i].x = vv[i].x;ve[i].y = vv[i].y;}

    }
    public void gove2(Vector[] vv)
    {
        for(int i = 0;i < 4;i ++) {ve2[i].x = vv[i].x;ve2[i].y = vv[i].y;}

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(int i = 0;i < 4;i ++)
        {
            Log.d("deb2",String.valueOf(ve[i].x)+" "+ String.valueOf(ve[i].y));
        }
        Path p = new Path();
        p.moveTo(ve[0].x,ve[0].y);
        for(int i = 0;i<4;i++)
            p.lineTo(ve[(i+1)%4].x,ve[(i+1)%4].y);
        Paint pp = new Paint();
        //设置颜色
        pp.setColor(0xFFFF6600);
        //设置画笔类型
        pp.setStyle(Paint.Style.FILL);
        canvas.drawPath(p,pp);

        for(int i = 0;i < 4;i ++)
        {
            Log.d("deb2",String.valueOf(ve2[i].x)+" "+ String.valueOf(ve2[i].y));
        }
        p = new Path();
        p.moveTo(ve2[0].x,ve2[0].y);
        for(int i = 0;i<4;i++)
            p.lineTo(ve2[(i+1)%4].x,ve2[(i+1)%4].y);
        pp = new Paint();
        //设置颜色
        pp.setColor(0xFFFF6600);
        //设置画笔类型
        pp.setStyle(Paint.Style.FILL);
        canvas.drawPath(p,pp);
    }
}
