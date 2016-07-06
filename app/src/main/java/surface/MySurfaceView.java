package surface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by cloud on 2016/7/6 14:24.
 * mail：1032863320@qq.com
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private boolean flag;
    private SurfaceHolder mHolder;
    private int mMeasuredWidth;
    private int mMeasuredHeight;
    private Paint mPaint;

    public MySurfaceView(Context context) {
        this(context, null);
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mHolder = getHolder();
        mHolder.addCallback(this);
        initPaint();
    }

    private void initPaint() {
		
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(30);
    }

    /*和普通的view一样 surfaceVIew也有这些方法*/
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    /*
    由于surface可能被销毁，
    它只在SurfaceHolder.Callback.surfaceCreated()和 SurfaceHolder.Callback.surfaceDestroyed()之间有效，
    所以要确保渲染线程访问的是合法有效的surface。
    */
    /*surfaceholder特有的方法*/
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        RenderThread renderThread = new RenderThread();
        flag = true;
        renderThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mMeasuredWidth = getMeasuredWidth();
        mMeasuredHeight = getMeasuredHeight();
    }

    //surfaceview隐藏前(注意是隐藏)，surface被销毁。
    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        flag = false;
    }

    private class RenderThread extends Thread {
        @Override
        public void run() {
            // 不停绘制界面
            while (flag) {
                drawUI();
            }
            super.run();
        }
    }

    private void drawUI() {

        Canvas canvas = mHolder.lockCanvas();
        try {
            drawCanvas(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mHolder.unlockCanvasAndPost(canvas);
        }
    }

    private void drawCanvas(Canvas canvas) {
        canvas.drawText("SurfaceView演示", mMeasuredWidth / 2, mMeasuredHeight / 2, mPaint);
    }
}
