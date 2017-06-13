package com.example.administrator.coo.upDownListView;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.administrator.coo.R;

public class TestActivity extends Activity {

    private SanJiaoWindow window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Button button = new Button(this);
        button.setText("内容");

        window = new SanJiaoWindow(this);

    }

    public void openWindow(View view) {
        window.showWindow(view);
    }
}
