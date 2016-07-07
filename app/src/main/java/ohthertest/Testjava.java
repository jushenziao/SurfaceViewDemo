package ohthertest;

import android.util.Log;

/**
 * Created by cloud on 2016/7/7 13:48.
 * mail：1032863320@qq.com
 */
public class Testjava {

    public Testjava() {
        double a = (0.0f + 15.0f) / 2.0f;
        Log.i("lallalall", "" + a);//7.5

        int b = (0 + 15) / 2;
        Log.i("lallalall", "" + b);//7

        float c = (0 + 15f) / 2;
        Log.i("lallalall", "" + c);//7

        double d = (1 + 1.236) / 2;
        Log.i("lallalall", "d" + d);//1.1179999999999999  见http://blog.csdn.net/jushenziao/article/details/51850630精度问题

    }
}
