package com.example.administrator.coo.upDownListView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by 张磊 on 2017/6/13.
 * 上拉刷新下拉加载的ListView
 */

public class UpDownListView extends ListView {
    public UpDownListView(Context context) {
        super(context);
    }

    public UpDownListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UpDownListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
    }

}
