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
    private View view;
    private WheelView wheelView;
    private PopupWindow popupWindow;
    private View ok;
    private View cancel;
    private int offsize = 2;

    public BottomPop(Activity context) {
        this.context = context;
        initView();
        initPopupWindow();
        initListener();
    }

    /**
     * 初始化监听事件
     */
    private void initListener() {
        ok.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    /**
     * 初始化控件
     */
    private void initView() {
        view = LayoutInflater.from(context).inflate(R.layout.bottom_layout, null);
        wheelView = (WheelView) view.findViewById(R.id.bottom_wheelView);
        ok = view.findViewById(R.id.bottom_ok);
        cancel = view.findViewById(R.id.bottom_cancel);
        wheelView.setOffset(offsize);
    }

    /**
     * 初始化popupwindow
     */
    private void initPopupWindow() {
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
    }

    public void showPop(View view) {
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        setAlpha(0.6f);
    }

    public void dismissPop() {
        popupWindow.dismiss();
    }

    public void setOffsize(int offsize) {
        this.offsize = offsize;
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
        //确认按钮
        if (i == R.id.bottom_ok) {
            if (listener != null) {
                listener.onClickOk(wheelView.getSeletedItem(), wheelView.getSeletedIndex());
            }
        }
        //取消按钮
        if (i == R.id.bottom_cancel) {
            if (listener != null) {
                listener.onClickCancel();
            }
        }
    }

    /**
     * 回调接口
     */
    public interface OnClickOkCancelListener {
        void onClickOk(String items, int position);

        void onClickCancel();
    }

    private OnClickOkCancelListener listener;

    public void setOnClickOkCancelListener(OnClickOkCancelListener listener) {
        this.listener = listener;
    }
}
