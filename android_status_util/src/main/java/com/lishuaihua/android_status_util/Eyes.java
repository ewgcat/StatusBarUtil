package com.lishuaihua.android_status_util;


import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.ColorInt;
import androidx.core.graphics.ColorUtils;

public class Eyes {


    private static void setStatusBarColor(Activity activity, int statusColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            EyesLollipop.setStatusBarColor(activity, statusColor);
        }
    }

    public static void translucentStatusBar(Activity activity) {
        translucentStatusBar(activity, false);
    }

    public static void translucentStatusBar(Activity activity, boolean hideStatusBarBackground) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            EyesLollipop.translucentStatusBar(activity, hideStatusBarBackground);
        }
    }

    //
    //    /**
    //     * 设置状态栏和CollapsingToolBar的联动
    //     *
    //     * @param activity
    //     * @param appBarLayout
    //     * @param collapsingToolbarLayout
    //     * @param toolbar
    //     * @param statusColor
    //     */
    //    public static void setStatusBarColorForCollapsingToolbar(@NonNull Activity activity, AppBarLayout appBarLayout,
    //                                                             CollapsingToolbarLayout collapsingToolbarLayout,
    //                                                             Toolbar toolbar, @ColorInt int statusColor) {
    //        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
    //            EyesLollipop.setStatusBarColorForCollapsingToolbar(activity, appBarLayout, collapsingToolbarLayout, toolbar, statusColor);
    //        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
    //            EyesKitKat.setStatusBarColorForCollapsingToolbar(activity, appBarLayout, collapsingToolbarLayout, toolbar, statusColor);
    //        }
    //    }

    /**
     * 设置状态栏颜色
     * 状态栏字体颜色 font color
     * @param activity
     * @param color
     */
    public static void setStatusBarLightMode(Activity activity, int color) {
        Eyes.setStatusBarColor(activity, color);
        Eyes.lintBuildStatusBarMode(activity, color);
    }

    /**
     * 检测 Android sdk 版本 设置 状态栏字体显示颜色
     *
     * @param activity
     * @param color
     */
    private static void lintBuildStatusBarMode(Activity activity, int color) {
        if (isLightColor(color)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        } else {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        }
    }

    /**
     * 判断颜色是不是亮色
     *
     * @param color
     * @return
     * @from
     */
    private static boolean isLightColor(@ColorInt int color) {
        return ColorUtils.calculateLuminance(color) >= 0.5;
    }

    static void setContentTopPadding(Activity activity, int padding) {
        ViewGroup mContentView = activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT);
        mContentView.setPadding(0, padding, 0, 0);
    }

    static int getPxFromDp(Context context, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }
}
