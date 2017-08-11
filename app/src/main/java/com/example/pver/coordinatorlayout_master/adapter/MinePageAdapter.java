package com.example.pver.coordinatorlayout_master.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.pver.coordinatorlayout_master.fragment.MineFragmentFactory;

/**
 * @version : 1.0
 * @Description :
 * @autho : dongyiming
 * @data : 2017/8/9 19:47
 */
public class MinePageAdapter extends BaseStatePageAdapter {


    public MinePageAdapter(FragmentManager fm, String[] titles) {
        super(fm, titles);
    }

    @Override
    public Fragment getItemFragment(int position) {
        return MineFragmentFactory.buildFragment(position);
    }

}
