package com.example.administrator.coo.transition;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.coo.Base.BaseActivity;
import com.example.administrator.coo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author zhanglei
 * @date 17/03/23
 * 列表进入详情页动画效果
 */
public class Transition2Activity extends BaseActivity {

    @BindView(R.id.user2_icon)
    ImageView user2Icon;
    @BindView(R.id.user2_name)
    TextView user2Name;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbarLayout)
    CollapsingToolbarLayout toolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition2);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_black);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            user2Icon.setTransitionName("userIcon");
            user2Name.setTransitionName("userName");
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAT();
            }
        });

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finishAT();
        }
        return true;
    }

}
