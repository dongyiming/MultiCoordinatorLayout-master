package com.example.pver.coordinatorlayout_master.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.pver.coordinatorlayout_master.R;

/**
 * @version : 1.0
 * @Description :
 * @autho : dongyiming
 * @data : 2017/8/10 21:34
 */
public class CardFlodingActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    private int mMaxScrollSize;
    private boolean mIsImageHidden;
    private static final int PERCENTAGE_TO_SHOW_IMAGE = 20;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_card);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        /*setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/

        appBarLayout.addOnOffsetChangedListener(this);
    }

    public static void start(Context mContext) {
        mContext.startActivity(new Intent(mContext, CardFlodingActivity.class));
    }

    /**
     * 监听AppBarLayout的滑动
     *
     * @param appBarLayout
     * @param verticalOffset
     */
    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

        if (mMaxScrollSize == 0)
            mMaxScrollSize = appBarLayout.getTotalScrollRange();

        int currentScrollPercentage = (Math.abs(verticalOffset)) * 100
                / mMaxScrollSize;

        if (currentScrollPercentage >= PERCENTAGE_TO_SHOW_IMAGE) {
            if (!mIsImageHidden) {
                mIsImageHidden = true;

                ViewCompat.animate(floatingActionButton).scaleY(0).scaleX(0).start();
            }
        }

        if (currentScrollPercentage < PERCENTAGE_TO_SHOW_IMAGE) {
            if (mIsImageHidden) {
                mIsImageHidden = false;
                ViewCompat.animate(floatingActionButton).scaleY(1).scaleX(1).start();
            }
        }
    }

}
