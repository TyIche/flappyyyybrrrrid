package com.example.flappybrid.fg;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.example.flappybrid.R;

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
}
