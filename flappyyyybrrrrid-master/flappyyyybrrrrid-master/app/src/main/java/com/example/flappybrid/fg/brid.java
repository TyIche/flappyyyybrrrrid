package com.example.flappybrid.fg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.example.flappybrid.R;
import com.example.flappybrid.vector.Vector;

import java.util.Timer;
import java.util.TimerTask;

public class brid extends AppCompatImageView {
    int con[] = {R.drawable.boat_000,R.drawable.boat_002};
    int k = 0;
    public brid(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setImageResource(con[k]);k=(k+1)%2;
        Timer timer =new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                post(new Runnable() {
                    @Override
                    public void run() {
                        setImageResource(con[k]);k=(k+1)%2;
                    }
                });
            }
        },500L,500L);

    }

//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        Vector ap= new Vector(getX()+getWidth()/2,
//                getY()+getHeight()/2);
//
//        Vector [] ve = {new Vector(),new Vector(),new Vector(),new Vector()};
//        //Log.d("deb",String.valueOf(ve[0].x));
//        for(int i = 0;i < 4;i++)
//        {
//
//            Vector v_ = new Vector(ap,getRotation()+i*90);
//            v_.x*=(200/Math.sqrt(2));v_.y*=(200/Math.sqrt(2));
//            ve[i].x = (v_.x);
//            ve[i].y = (v_.y);
//            Log.d("deb",String.valueOf(i));
//        }
////        Path p = new Path();
////        p.moveTo(ve[0].x,ve[0].y);
////        for(int i = 0;i<4;i++)
////            p.lineTo(ve[(i+1)%4].x,ve[(i+1)%4].y);
////        Paint pp = new Paint();
////        //设置颜色
////        pp.setColor(0xFFFF6600);
////        //设置画笔类型
////        pp.setStyle(Paint.Style.FILL);
////        canvas.drawPath(p,pp);
//        Paint paint = new Paint();
//        //设置颜色
//        paint.setColor(0xFFFF6600);
//        //设置画笔类型
//        paint.setStyle(Paint.Style.FILL);
//        //使用画笔在画布上画矩形
//        canvas.drawRect(0,0,200,100,paint);
//    }
}
