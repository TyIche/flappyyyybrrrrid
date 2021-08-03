package com.example.flappybrid.bg;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.flappybrid.utils.ScreenUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class BgLayout extends FrameLayout {

    Context context;
    AttributeSet attrs;
    Timer timer;
    List<ValueAnimator> va = new ArrayList<>( );
    public BgLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
        this.attrs = attrs;
//        start();
    }
    public void start()
    {
        removeAllViews();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                post(new Runnable() {
                    @Override
                    public void run() {
                        createBar();
                    }
                });
            }
        },1000L,2000);
    }
    public void stop()
    {
        if(timer!=null)
        timer.cancel();
        for (int i = 0; i< va.size();i++)
            va.get(i).cancel();
    }
    public void createBar()
    {
        BarView bv = new BarView(context,attrs);
        addView(bv);
        bv.x = 500;
        bv.y = 500;
        ValueAnimator an = ValueAnimator.ofFloat(ScreenUtil.getScreenWidth(context),-bv.bw);
        va.add(an);
        an.setInterpolator(new LinearInterpolator());
        an.setDuration(5000);
        an.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                bv.x = (Float)an.getAnimatedValue();
                bv.postInvalidate();
                if(bv.x<=-bv.bw)
                {
                    removeView(bv);
                    va.remove(an);
                    //bv = null;
                }
            }
        });
        an.start();

    }
}
