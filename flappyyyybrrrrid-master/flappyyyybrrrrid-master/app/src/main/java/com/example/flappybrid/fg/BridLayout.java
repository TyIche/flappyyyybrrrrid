package com.example.flappybrid.fg;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.flappybrid.utils.ScreenUtil;

public class BridLayout extends FrameLayout {
    brid brid;
    AnimatorSet set = new AnimatorSet();
    public BridLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        brid = new brid(context,attrs);
        addView(brid,200,200);

        //brid.setY(ScreenUtil.getScreenHeight(context)/2);
    }

    public void stop()
    {
        if(set!=null) set.cancel();
    }
    public void start()
    {
        //removeAllViews();
        //set.start();
    }
    public void movee(float x,float y)
    {
        double dy = y - brid.getY();
        double dx = 100;
        ObjectAnimator an = ObjectAnimator.ofFloat(brid,"rotation",brid.getRotation(),(float)Math.toDegrees(Math.atan(dy/dx)));
        an.setDuration(100L);

        Path p = new Path();
        p.moveTo(brid.getX(),brid.getY());
        p.lineTo(x,y);
        ObjectAnimator an2 = ObjectAnimator.ofFloat(brid,"x","y",p);
        an2.setDuration(100L);

        set.playTogether(an,an2);
        //set.start();
    }
}
