package com.example.pver.coordinatorlayout_master.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.pver.coordinatorlayout_master.R;
import com.example.pver.coordinatorlayout_master.adapter.MinePageAdapter;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @version : 1.0
 * @Description :
 * @autho : dongyiming
 * @data : 2017/8/10 21:34
 */
public class AnimateFloadingActivity extends AppCompatActivity {

    private CircleImageView circleImageView;
    private TabLayout tabView;
    private ViewPager pagerView;
    private String[] titles = new String[]{
            "音乐", "动态", "关于我"
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate);
        circleImageView = (CircleImageView) findViewById(R.id.circleimg_mine);
        tabView = (TabLayout) findViewById(R.id.tab_mine);
        pagerView = (ViewPager) findViewById(R.id.viewpager_mine);
        initComponent();
    }

    public void initComponent() {

        pagerView.setAdapter(new MinePageAdapter(getSupportFragmentManager(), titles));
        tabView.setupWithViewPager(pagerView);
        tabView.getTabAt(0).select();
    }

    public static void start(Context mContext) {
        mContext.startActivity(new Intent(mContext, AnimateFloadingActivity.class));
    }
}
