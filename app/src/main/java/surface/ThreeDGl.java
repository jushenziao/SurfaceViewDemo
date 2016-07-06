package surface;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by cloud on 2016/7/6 17:37.
 * mail：1032863320@qq.com
 */
public class ThreeDGl implements GLSurfaceView.Renderer {
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {
        /*
        glHint 用于告诉 OpenGL 我们希望进行最好的透视修正，这会轻微地影响性能，但会使得透视图更好看。
        glClearColor 设置清除屏幕时所用的颜色，色彩值的范围从 0.0f~1.0f 大小从暗到这的过程。
        glShadeModel 用于启用阴影平滑度。阴影平滑通过多边形精细地混合色彩，并对外部光进行平滑。
        glDepthFunc 为将深度缓存设想为屏幕后面的层，它不断地对物体进入屏幕内部的深度进行跟踪。
        glEnable 启用深度测试。
         */
        // 启用阴影平滑
        gl.glShadeModel(GL10.GL_SMOOTH);
        // 黑色背景
        gl.glClearColor(0, 0, 0, 0);
        // 设置深度缓存
        gl.glClearDepthf(1.0f);
        // 启用深度测试
        gl.glEnable(GL10.GL_DEPTH_TEST);
        // 所作深度测试的类型
        gl.glDepthFunc(GL10.GL_LEQUAL);
        // 告诉系统对透视进行修正
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        //设置OpenGL场景的大小
        gl.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        //设置投影矩阵
        gl.glMatrixMode(GL10.GL_PROJECTION);
        //重置投影矩阵
        gl.glLoadIdentity();
        // 设置视口的大小
        // 选择模型观察矩阵
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        // 重置模型观察矩阵
        gl.glLoadIdentity();
    }
}
