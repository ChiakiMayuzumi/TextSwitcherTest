package com.example.administrator.textswichertest;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {

    private TextSwitcher textSwitcher;
    private String[] strs=new String[]
            {
                    "第一条",
                    "第二条",
                    "第三条",
                    "第四条"

            };
    private int curStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textSwitcher=(TextSwitcher)findViewById(R.id.textSwitcher);
        textSwitcher.setFactory(new ViewFactory() {

            @Override
            public View makeView() {
                TextView tv = new TextView(MainActivity.this);
                tv.setTextSize(20);
                tv.setTextColor(Color.BLUE);
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                lp.gravity = Gravity.CENTER;
                tv.setLayoutParams(lp);
                return tv;
            }
        });

        //设置淡入淡出效果
        textSwitcher.setInAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), android.R.anim.fade_in));
        textSwitcher.setOutAnimation(AnimationUtils.loadAnimation(
                getApplicationContext(), android.R.anim.fade_out));
        //调用next方法显示下一个字符串
        next(null);
    }
    //事件处理函数，控制显示下一个字符串
    public void next(View source)
    {
        textSwitcher.setText(strs[curStr++%strs.length]);
    }




}