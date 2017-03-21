package com.example.administrator.coo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.bottom_popwindow.BottomPop;

import java.util.ArrayList;
import java.util.List;

public class BottomPopActivity extends Activity {

    private BottomPop bottomPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_pop);
        bottomPop = new BottomPop(this);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("--LIST--");
        }
        bottomPop.setList(list);
    }

    public void open(View view) {
        bottomPop.showPop(view);
    }
}
