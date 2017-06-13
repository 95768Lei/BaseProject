package com.example.administrator.coo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.coo.Base.BaseActivity;
import com.example.administrator.coo.passwordEditText.PasswordEditTextActivity;
import com.example.administrator.coo.meterial.BottomActivity;
import com.example.administrator.coo.transition.Transition1Activity;

import java.util.ArrayList;
import java.util.List;

public class ModeActivity extends BaseActivity {

    private ListView mode_list;
    private UniversalAdapter<String> adapter;
    private List<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        mode_list = (ListView) findViewById(R.id.activity_mode_list);
        adapter = new UniversalAdapter<String>(this, mList, R.layout.main_item_layout) {
            @Override
            public void convert(UniversalViewHolder holder, int position, String s) {
                View view = holder.getView(R.id.main_item_icon);
                view.setVisibility(View.INVISIBLE);
                holder.setText(R.id.main_item_text, s);
            }
        };
        mode_list.setAdapter(adapter);

        initData();
        initListener();

    }

    private void initListener() {
        mode_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(ModeActivity.this, MainActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(ModeActivity.this, BottomPopActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(ModeActivity.this, TextInputActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(ModeActivity.this, CountDownActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(ModeActivity.this, Transition1Activity.class));
                        break;
                    case 5:
                        startActivity(new Intent(ModeActivity.this, BottomActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(ModeActivity.this, PasswordEditTextActivity.class));
                        break;
                }
            }
        });
    }

    private void initData() {
        mList.add("CoordinatorLayout");
        mList.add("BottomPop");
        mList.add("(仿微博话题)TextInput");
        mList.add("CountDown");
        mList.add("Transition");
        mList.add("BottomNavigation");
        mList.add("PasswordEditText");
        adapter.notifyDataSetChanged();
    }
}
