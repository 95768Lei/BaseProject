package com.example.administrator.coo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.administrator.coo.Base.BaseActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private XRecyclerView rlv;
    private MyAdapter adapter;
    private List<String> mList = new ArrayList<>();
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rlv = (XRecyclerView) findViewById(R.id.main_rlv);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rlv.setLayoutManager(manager);
        adapter = new MyAdapter(this, mList);
        //设置XRecyclerView
//        rlv.setArrowImageView(R.mipmap.ic_launcher);
//        rlv.setRefreshProgressStyle(ProgressStyle.SemiCircleSpin);
        rlv.setAdapter(adapter);

        initData();
        initListener();
    }

    private void initListener() {
        rlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        rlv.refreshComplete();
                    }
                }, 500);
            }

            @Override
            public void onLoadMore() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        rlv.loadMoreComplete();
                    }
                }, 500);

            }
        });

        adapter.setOnClickItemListener(new MyAdapter.OnClickItemListener() {
            @Override
            public void onItemListener(int position) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");//设置类型，我这里是任意类型，任意后缀的可以这样写。
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {//是否选择，没选择就不会继续
            Uri uri = data.getData();//得到uri，后面就是将uri转化成file的过程。
            String[] proj = {MediaStore.Images.Media.DATA};
            Cursor actualimagecursor = managedQuery(uri, proj, null, null, null);
            int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            actualimagecursor.moveToFirst();
            String img_path = actualimagecursor.getString(actual_image_column_index);
            File file = new File(img_path);
            Toast.makeText(MainActivity.this, file.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            mList.add("");
        }
        adapter.notifyDataSetChanged();
    }
}
