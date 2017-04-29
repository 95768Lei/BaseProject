package com.example.administrator.coo.meterial;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.coo.R;

/**
 * @author zhanglei
 * @date 17/04/29
 */
public class BNVFragment extends Fragment {

    public static final int HOME = 0;
    public static final int SEARCH = 1;
    public static final int QUN = 2;
    public static final int SELEF = 3;
    private ImageView icon;

    private final int[] icons = {
            R.drawable.ic_home_black_24dp,
            R.drawable.ic_search_black_24dp,
            R.drawable.ic_people_outline_black_24dp,
    R.drawable.ic_perm_identity_black_24dp};

    public BNVFragment() {
        // Required empty public constructor
    }

    public static BNVFragment newInstance(int tag) {
        BNVFragment fragment = new BNVFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("tag", tag);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bnv, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        icon = (ImageView) view.findViewById(R.id.bnv_icon);
    }

    private void initData() {
        Bundle bundle = getArguments();
        int tag = bundle.getInt("tag");
        icon.setImageResource(icons[tag]);
    }

}
