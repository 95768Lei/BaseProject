package com.note.zl.sanjiopopupwindow;

import android.app.Activity;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2017/6/13.
 */

public class SanJiaoWindow extends BasePopupWindow {

    private final View parentView;
    private final SanJiaoView sjv;
    private final RelativeLayout relative;

    public SanJiaoWindow(Activity activity) {
        super(activity);
        parentView = LayoutInflater.from(activity).inflate(R.layout.sanjiao_layout, null);
        sjv = (SanJiaoView) parentView.findViewById(R.id.sanjiaoView);
        relative = (RelativeLayout) parentView.findViewById(R.id.sanJiao_card);
        initPopupWindow(parentView);
    }

    @Override
    public void showWindow(View view) {
        super.showWindow(view);
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);

        int left = view.getLeft();
        int top = view.getTop();
        int right = view.getRight();

        //获取手机的分辨率
        Display display = mActivity.getWindowManager().getDefaultDisplay();
        int dWidth = display.getWidth();
        int dHeight = display.getHeight();

        //获取popupwindow布局的padding值
        int paddingLeft = parentView.getPaddingLeft();
        int paddingRight = parentView.getPaddingRight();
        parentView.measure(w, h);
        relative.measure(w, h);

        //popupwindow主体的宽度
//        int width1 = parentView.getMeasuredWidth() - (paddingLeft + paddingRight);
        int width1 = relative.getMeasuredWidth();

        //popwindow带padding的宽度
//        int widthP = parentView.getMeasuredWidth();
        int widthP = width1 + paddingLeft + paddingRight;

        //popupwindow上方控件的宽度
        int parentWidth = right - left;

        //小三角的宽度
        sjv.measure(w, h);
        int width = sjv.getMeasuredWidth();

        //小三角最大的marginLeft值
        int maxMarginLeft = width1 - width;

        //控件需调整的margin值
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        //判断使用那种计算方式来计算小三角的位移量
        int centerIndex;
        if (parentWidth > widthP) {
            centerIndex = maxMarginLeft / 2;
        } else if ((dWidth - left) > widthP) {
            centerIndex = parentWidth / 2 - width / 2 - paddingLeft;
        } else {
            int rWidth = dWidth - right;
            centerIndex = width1 - (parentWidth / 2 + rWidth - paddingRight);
        }

        if (centerIndex > maxMarginLeft) {
            centerIndex = maxMarginLeft;
        }

        params.setMargins(centerIndex, 0, 0, 0);
        sjv.setLayoutParams(params);
        Log.e("showWindow", "left:" + left + "\ntop:" + top + "\nright:" + right + "\ncenterIndex:" + centerIndex + "\nwidth:" + width + "\nwidth1:" + width1);
        popupWindow.showAsDropDown(view);
    }

    /**
     * 为PopupWindow添加View
     */
    public void addView(View view) {
        relative.removeAllViews();
        relative.addView(view);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onDismiss() {

    }
}
