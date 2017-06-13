package com.example.administrator.coo.Base;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

/**
 * Created by zhanglei on 2017/6/8.
 * 封装popwindow时的基类
 */

public abstract class BasePopupWindow implements View.OnClickListener, PopupWindow.OnDismissListener {

    protected Activity mActivity;
    protected PopupWindow popupWindow;

    public BasePopupWindow(Activity activity) {
        this.mActivity = activity;
    }

    /**
     * 初始化PopupWindow
     *
     * @param layoutView
     */
    protected void initPopupWindow(View layoutView) {
        popupWindow = new PopupWindow(layoutView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOnDismissListener(this);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                hideWindow();
            }
        });
    }

    /**
     * 设置PopupWindow的动画效果
     *
     * @param animStyle
     */
    protected void setAnimation(int animStyle) {
        popupWindow.setAnimationStyle(animStyle);

    }

    /**
     * 设置界面的透明度
     *
     * @param alpha
     */
    protected void setAlpha(float alpha) {
        Window window = mActivity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = alpha;
        window.setAttributes(attributes);
    }

    /**
     * 显示popupwindow
     *
     * @param view
     */
    protected void showWindow(View view) {

    }

    /**
     * 隐藏popupwindow
     */
    protected void hideWindow() {
        popupWindow.dismiss();
        setAlpha(1f);
    }

}
