package com.example.administrator.coo;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by zhanglei on 2016/12/15.
 * 通用的ViewHolder类Universal
 */

public class UniversalViewHolder {

    /**
     * 用来储存View的集合
     */
    private SparseArray<View> mArray = new SparseArray();

    /**
     * 布局id
     */
    private int layoutId;

    private View mView;


    public static UniversalViewHolder get(View convertView, ViewGroup parent, Context context, int layoutId) {
        if (convertView == null) {
            return new UniversalViewHolder(parent, context, layoutId);
        }

        return (UniversalViewHolder) convertView.getTag();
    }

    private UniversalViewHolder(ViewGroup parent, Context context, int layoutId) {
        mView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mView.setTag(this);
        this.layoutId = layoutId;

    }

    /**
     * 找到控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mArray.get(viewId);
        if (view == null) {
            view = mView.findViewById(viewId);
            mArray.put(viewId, view);
        }

        return (T) view;
    }

    /**
     * 获取ConvertView
     *
     * @return
     */
    public View getConvertView() {
        return mView;
    }

    /**
     * 为Text添加数据
     *
     * @param viewId
     * @param text
     */
    public void setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
    }

    public void setTextAndColor(int viewId, int colorId, String text) {
        TextView view = getView(viewId);
        view.setTextColor(colorId);
        view.setText(text);
    }

    /**
     * 设置View的长度
     */
    public void setLayoutLength(int viewId, int length) {
        View view = getView(viewId);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = length;
        view.setLayoutParams(layoutParams);
    }

}
