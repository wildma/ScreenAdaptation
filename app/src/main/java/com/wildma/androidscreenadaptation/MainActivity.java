package com.wildma.androidscreenadaptation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wildma.androidscreenadaptation.utils.ConvertUtils;
import com.wildma.androidscreenadaptation.utils.ScreenUtils;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
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
        dynamicSet();
    }

    /**
     * 获取屏幕相关参数
     *
     * @return
     */
    public String getScreenParams() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int heightPixels = ScreenUtils.getScreenHeight(this);
        int widthPixels = ScreenUtils.getScreenWidth(this);
        float xdpi = dm.xdpi;
        float ydpi = dm.ydpi;
        int densityDpi = dm.densityDpi;
        float density = dm.density;
        float scaledDensity = dm.scaledDensity;
        float heightDP = heightPixels / density;
        float widthDP = widthPixels / density;
        float smallestWidthDP;
        if(widthDP < heightDP) {
            smallestWidthDP = widthDP;
        }else {
            smallestWidthDP = heightDP;
        }
        String str = "heightPixels: " + heightPixels + "px";
        str += "\nwidthPixels: " + widthPixels + "px";
        str += "\nxdpi: " + xdpi + "dpi";
        str += "\nydpi: " + ydpi + "dpi";
        str += "\ndensityDpi: " + densityDpi + "dpi";
        str += "\ndensity: " + density;
        str += "\nscaledDensity: " + scaledDensity;
        str += "\nheightDP: " + heightDP + "dp";
        str += "\nwidthDP: " + widthDP + "dp";
        str += "\nsmallestWidthDP: " + smallestWidthDP + "dp";
        return str;
    }

    /**
     * 动态设置dp或sp
     */
    public void dynamicSet() {

        /**
         * 注意：
         * getDimension()方法并不是直接拿到dimens.xml文件中的dp或sp值
         * 而是將dimens.xml文件中的dp或sp值乘以屏幕密度（density）来换算成px值
         * 所以拿到该值后还需要换算成对应的dp或sp
         */

        /*获取sp值*/
        float pxValue = getResources().getDimension(R.dimen.sp_20);//获取对应资源文件下的sp值
        int spValue = ConvertUtils.px2sp(this, pxValue);//将px值转换成sp值
        mTvShowParams.setTextSize(spValue);//设置文字大小

        /*获取dp值*/
        float pxValue2 = getResources().getDimension(R.dimen.dp_360);//获取对应资源文件下的dp值
        int dpValue = ConvertUtils.px2dp(this, pxValue2);//将px值转换成dp值

        Log.d(TAG, "pxValue= " + pxValue);
        Log.d(TAG, "spValue= " + spValue);
        Log.d(TAG, "pxValue2= " + pxValue2);
        Log.d(TAG, "dpValue= " + dpValue);
    }
}
