package com.example.administrator.coo.meterial;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.administrator.coo.BaseActivity;
import com.example.administrator.coo.R;

import static com.example.administrator.coo.meterial.BNVFragment.HOME;
import static com.example.administrator.coo.meterial.BNVFragment.QUN;
import static com.example.administrator.coo.meterial.BNVFragment.SEARCH;
import static com.example.administrator.coo.meterial.BNVFragment.SELEF;

public class BottomActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_view);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        //初始化加载第一页
        openFragment(HOME);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottom_sy:
                        openFragment(HOME);
                        break;
                    case R.id.bottom_xs:
                        openFragment(SEARCH);
                        break;
                    case R.id.bottom_qf:
                        openFragment(QUN);
                        break;
                    case R.id.bottom_wd:
                        openFragment(SELEF);
                        break;

                }
                return true;
            }
        });
    }

    private void openFragment(int tag) {
        getSupportFragmentManager().beginTransaction().replace(R.id.bottom_rl,BNVFragment.newInstance(tag)).commit();
    }
}
