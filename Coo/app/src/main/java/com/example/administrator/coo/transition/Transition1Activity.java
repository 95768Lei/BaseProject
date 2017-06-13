package com.example.administrator.coo.transition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
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
public class Transition1Activity extends BaseActivity {

    @BindView(R.id.user_icon)
    ImageView userIcon;
    @BindView(R.id.user_name)
    TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_transition1);
        ButterKnife.bind(this);
        userIcon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    //跳转
                    Pair<View, String> pair1 = new Pair<View, String>(userIcon, "userIcon");
                    Pair<View, String> pair2 = new Pair<View, String>(userName, "userName");
                    startActivity(new Intent(mActivity, Transition2Activity.class), ActivityOptions.makeSceneTransitionAnimation(mActivity, pair1, pair2).toBundle());
                } else {
                    startActivity(new Intent(mActivity, Transition2Activity.class));
                }
            }
        });
    }
}
