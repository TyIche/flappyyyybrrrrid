package com.example.flappybrid;
import  com.example.flappybrid.bg.*;
import com.example.flappybrid.fg.BridLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    BgLayout bl;
    BridLayout brl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bl = findViewById(R.id.lll);
        bl.start();

        brl = findViewById(R.id.lll2);
        brl.start();
    }

    public void quq(View view) {
        if(bl!=null)
            bl.stop();
    }

}