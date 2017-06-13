package com.example.administrator.coo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.example.administrator.coo.Base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author zhanglei
 * @date 17/03/23
 * 倒计时跳转
 */
public class CountDownActivity extends BaseActivity {

    @BindView(R.id.count_down_text)
    TextView countDownText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);
        ButterKnife.bind(this);
        Drawable background = countDownText.getBackground();
        background.setAlpha(110);
        //倒计时三秒（由于有误差所以多加一秒）
        CountDownTimer timer = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long l) {

                countDownText.setText((l / 1000) + " | 跳过");
            }

            @Override
            public void onFinish() {

            }
        };
        timer.start();
    }
}
