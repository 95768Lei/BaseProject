package com.example.administrator.coo.upDownListView;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.administrator.coo.Base.BasePopupWindow;
import com.example.administrator.coo.R;

/**
 * Created by Administrator on 2017/6/13.
 */

public class SanJiaoWindow extends BasePopupWindow {

    private final SanJiaoView sjv;
    private final View parentView;

    public SanJiaoWindow(Activity activity) {
        super(activity);
        parentView = LayoutInflater.from(activity).inflate(R.layout.sanjiao_layout, null);
        sjv = (SanJiaoView) parentView.findViewById(R.id.sanjiaoView);
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

        int paddingLeft = parentView.getPaddingLeft();
        int paddingRight = parentView.getPaddingRight();
        parentView.measure(w, h);
        int width1 = parentView.getMeasuredWidth();

        sjv.measure(w, h);
        int width = sjv.getMeasuredWidth();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        //控件需调整的margin值
        int centerIndex = width1 - (paddingLeft + paddingRight) - ((right - left) / 2 - paddingRight);
//        int kuan = width1 - (paddingLeft + paddingRight);
        params.setMargins(centerIndex, 0, 0, 0);
//        sjv.setLayoutParams(params);
        Log.e("showWindow", "left:" + left + "\ntop:" + top + "\nright:" + right + "\ncenterIndex:" + centerIndex + "\nwidth:" + width + "\nwidth1:" + width1);
        popupWindow.showAsDropDown(view);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onDismiss() {

    }
}
