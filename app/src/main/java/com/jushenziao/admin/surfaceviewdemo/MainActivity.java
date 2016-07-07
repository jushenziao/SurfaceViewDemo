package com.jushenziao.admin.surfaceviewdemo;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.Window;

import surface.MySurfaceView;

public class MainActivity extends AppCompatActivity {

    private MySurfaceView mMySurfaceView;
    private int mStatusHeigt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        所有 SurfaceView 和 SurfaceHolder.Callback 的方法都会在UI线程里调用
        所以渲染线程所要访问的各种变量应该作同步处理。
         */
        mMySurfaceView = new MySurfaceView(getApplicationContext());
        setContentView(mMySurfaceView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mMySurfaceView.handleEvent(event, mStatusHeigt);
        return true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            System.out.println("second");
            StringBuilder sb = new StringBuilder();
            Dimension dimen1 = getAreaOne(this);
            Dimension dimen2 = getAreaTwo(this);
            Dimension dimen3 = getAreaThree(this);
            mStatusHeigt = dimen1.mHeight - dimen3.mHeight;
        }
    }

    private Dimension getAreaOne(Activity activity) {
        Dimension dimen = new Dimension();
        Display disp = activity.getWindowManager().getDefaultDisplay();
        Point outP = new Point();
        disp.getSize(outP);
        dimen.mWidth = outP.x;
        dimen.mHeight = outP.y;
        return dimen;
    }

    private Dimension getAreaTwo(Activity activity) {
        Dimension dimen = new Dimension();
        Rect outRect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect);
        System.out.println("top:" + outRect.top + " ; left: " + outRect.left);
        dimen.mWidth = outRect.width();
        dimen.mHeight = outRect.height();
        return dimen;
    }

    private Dimension getAreaThree(Activity activity) {
        Dimension dimen = new Dimension();
        // 用户绘制区域
        Rect outRect = new Rect();
        activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT).getDrawingRect(outRect);
        dimen.mWidth = outRect.width();
        dimen.mHeight = outRect.height();
        // end
        return dimen;
    }

    private class Dimension {
        public int mWidth;
        public int mHeight;

        public Dimension() {
        }
    }
}
