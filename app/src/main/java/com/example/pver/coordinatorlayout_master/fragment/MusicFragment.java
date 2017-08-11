package com.example.pver.coordinatorlayout_master.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.example.pver.coordinatorlayout_master.R;
import com.example.pver.coordinatorlayout_master.adapter.BaseViewHolder;
import com.example.pver.coordinatorlayout_master.adapter.CommonAdapter;
import com.example.pver.coordinatorlayout_master.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @version : 1.0
 * @Description :
 * @autho : dongyiming
 * @data : 2017/8/9 20:58
 */
public class MusicFragment extends BaseFragment {

    private RecyclerView recyclerview;

    @Override
    public View setRootView(LayoutInflater inflater) {

        View view = inflater.inflate(R.layout.fragment_normal, null);

        return view;
    }
}
