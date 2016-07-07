package com.jushenziao.admin.surfaceviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import surface.MySurfaceView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        所有 SurfaceView 和 SurfaceHolder.Callback 的方法都会在UI线程里调用
        所以渲染线程所要访问的各种变量应该作同步处理。
         */
        MySurfaceView mySurfaceView = new MySurfaceView(getApplicationContext());
        setContentView(mySurfaceView);
    }//son of beath
}
