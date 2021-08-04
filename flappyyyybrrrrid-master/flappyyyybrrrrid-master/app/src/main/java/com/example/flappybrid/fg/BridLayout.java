package com.example.flappybrid.fg;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.flappybrid.utils.ScreenUtil;
import com.example.flappybrid.vector.Vector;

public class BridLayout extends FrameLayout {
    public brid brid;
    AnimatorSet set = new AnimatorSet();
    public BridLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        brid = new brid(context,attrs);
        addView(brid,200,200);
        brid.setX(500);
        brid.setY(500);
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

        Vector a= new Vector(brid.getRotation());
        Log.d("quq2",String.valueOf(brid.getRotation()));

        Log.d("quq2",String.valueOf(a.x)+","+String.valueOf(a.y));

        Vector b = new Vector(brid.getX(),brid.getY(),x,y);
        Log.d("quq2",String.valueOf(b.x)+","+String.valueOf(b.y));

        float theta =  Vector.angle(a,b);
        Log.d("quq2",String.valueOf(theta));
        ObjectAnimator an = ObjectAnimator.ofFloat(
        brid,"rotation",brid.getRotation(),brid.getRotation()+theta);

        an.setDuration(30L);
        //an.start();
        Vector vv =new Vector(brid.getX(),brid.getY(),x,y);
        Log.d("quq3",String.valueOf(vv.x)+","+String.valueOf(vv.y));
        vv.gok(40);
        Log.d("quq3",String.valueOf(vv.x)+","+String.valueOf(vv.y));
        Path p = new Path();
        p.moveTo(brid.getX(),brid.getY());
        p.lineTo(brid.getX()+vv.x,brid.getY()+vv.y);
        ObjectAnimator an2 = ObjectAnimator.ofFloat(brid,"x","y",p);
        an2.setDuration(30L);
        set = new AnimatorSet();
        set.playTogether(an,an2);
        set.start();
    }
}
