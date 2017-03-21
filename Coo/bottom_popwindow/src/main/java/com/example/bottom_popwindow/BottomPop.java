package com.example.bottom_popwindow;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

import java.util.List;

/**
 * Created by zhanglei on 2017/3/18 0018.
 */

public class BottomPop implements View.OnClickListener {

    private Activity context;
    private final View view;
    private final WheelView wheelView;
    private final PopupWindow popupWindow;
    private final View ok;
    private final View cancel;

    public BottomPop(Activity context) {
        this.context = context;
        view = LayoutInflater.from(context).inflate(R.layout.bottom_layout, null);
        wheelView = (WheelView) view.findViewById(R.id.bottom_wheelView);
        ok = view.findViewById(R.id.bottom_ok);
        cancel = view.findViewById(R.id.bottom_cancel);
        wheelView.setOffset(2);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setTouchable(true);
        popupWindow.setAnimationStyle(R.style.pop_window_anim_style);
        popupWindow.setFocusable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setAlpha(1f);
            }
        });
        ok.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    public void showPop(View view) {
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        setAlpha(0.6f);
    }

    public void dismmisPop() {
        popupWindow.dismiss();
    }

    public void setList(List<String> list) {
        wheelView.setItems(list);
    }

    /**
     * 设置屏幕的透明度
     *
     * @param f
     */
    protected void setAlpha(float f) {
        Window window = context.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = f;
        window.setAttributes(attributes);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.bottom_ok) {

        } else if (i == R.id.bottom_cancel) {

        }
    }
}
