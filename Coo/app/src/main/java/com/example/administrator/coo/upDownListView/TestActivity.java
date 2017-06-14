package com.example.administrator.coo.upDownListView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.coo.R;
import com.note.zl.sanjiopopupwindow.SanJiaoWindow;

public class TestActivity extends Activity {

    private SanJiaoWindow window;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Button button = new Button(this);
        button.setText("内容");

        window = new SanJiaoWindow(this);

        ListView listView = new ListView(this);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"item1", "item2", "item3", "item4", "item5"});
        listView.setAdapter(adapter);
        window.addView(listView);
    }

    public void openWindow(View view) {
        window.showWindow(view);
    }
}
