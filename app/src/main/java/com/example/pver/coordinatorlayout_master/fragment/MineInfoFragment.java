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
 *  @Description :
 *  @autho : dongyiming
 *  @version : 1.0
 *  @data : 2017/8/9 20:58
 */
public class MineInfoFragment extends BaseFragment {

    @Override
    public View setRootView(LayoutInflater inflater) {

        View view = inflater.inflate(R.layout.fragment_normal, null);

        return view;
    }
}
