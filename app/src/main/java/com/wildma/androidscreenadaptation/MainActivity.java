package com.wildma.androidscreenadaptation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTvShowParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvShowParams = (TextView) findViewById(R.id.tv_show_params);
        mTvShowParams.setText(getScreenParams());
    }

    /**
     * 获取屏幕相关参数按钮点击事件
     * @param view
     */
    public void getScreenParams(View view) {
        mTvShowParams.setText(getScreenParams());
    }

    /**
     * 获取屏幕相关参数
     *
     * @return
     */
    public String getScreenParams() {
        DisplayMetrics dm = new DisplayMetrics();
        //        dm = getResources().getDisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int heightPixels = dm.heightPixels;
        int widthPixels = dm.widthPixels;
        float xdpi = dm.xdpi;
        float ydpi = dm.ydpi;
        int densityDpi = dm.densityDpi;
        float density = dm.density;
        float scaledDensity = dm.scaledDensity;
        float heightDP = heightPixels / density;
        float widthDP = widthPixels / density;
        String str = "heightPixels: " + heightPixels + "px";
        str += "\nwidthPixels: " + widthPixels + "px";
        str += "\nxdpi: " + xdpi + "dpi";
        str += "\nydpi: " + ydpi + "dpi";
        str += "\ndensityDpi: " + densityDpi + "dpi";
        str += "\ndensity: " + density;
        str += "\nscaledDensity: " + scaledDensity;
        str += "\nheightDP: " + heightDP + "dp";
        str += "\nwidthDP: " + widthDP + "dp";
        return str;
    }
}
