package com.example.pver.coordinatorlayout_master;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.view.View;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @version : 1.0
 * @Description : 自定义behavior，监听tablayout滑动
 * @autho : dongyiming
 * @data : 2017/8/11 23:03
 */
public class AnimateBehavior extends CoordinatorLayout.Behavior<CircleImageView> {

    private int mStartXPosition;
    private float mStartToolbarPosition;
    private int mStartYPosition;

    private int mFinalYPosition;
    private int finalHeight;
    private int mStartHeight;
    private int mFinalXPosition;
    private int mAvatarMaxSize;

    private Context mContext;

    public AnimateBehavior(Context mContext, AttributeSet attrs) {
        super(mContext, attrs);
        this.mContext = mContext;
        mAvatarMaxSize = (int) mContext.getResources().getDimension(R.dimen.dimes_mine_headpic_radius);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, CircleImageView child, View dependency) {

        return dependency instanceof TabLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, CircleImageView child, View dependency) {

        if (mStartYPosition == 0)
            mStartYPosition = (int) (child.getY() + (child.getHeight() / 2));

        if (mFinalYPosition == 0)
            mFinalYPosition = (int) mContext.getResources().getDimension(R.dimen.common_lh_8);

        if (mStartHeight == 0)
            mStartHeight = child.getHeight();

        if (finalHeight == 0)
            finalHeight = mContext.getResources().getDimensionPixelOffset(R.dimen.common_lh_40);

        if (mStartXPosition == 0)
            mStartXPosition = (int) (child.getX() + (child.getWidth() / 2));

        if (mFinalXPosition == 0)
            mFinalXPosition = mContext.getResources().getDimensionPixelOffset(R.dimen.abc_action_bar_content_inset_material) + (finalHeight / 2);

        if (mStartToolbarPosition == 0)
            mStartToolbarPosition = dependency.getY() + (dependency.getHeight() / 2);

        final int maxScrollDistance = (int) (mStartToolbarPosition - getStatusBarHeight());
        float expandedPercentageFactor = dependency.getY() / maxScrollDistance;

        float distanceYToSubtract = ((mStartYPosition - mFinalYPosition)
                * (1f - expandedPercentageFactor)) + (child.getHeight() / 2);

        float distanceXToSubtract = ((mStartXPosition - mFinalXPosition)
                * (1f - expandedPercentageFactor)) + (child.getWidth() / 2);

        float heightToSubtract = ((mStartHeight - finalHeight) * (1f - expandedPercentageFactor));

        child.setY(mStartYPosition - distanceYToSubtract);
        child.setX(mStartXPosition - distanceXToSubtract);

        int proportionalAvatarSize = (int) (mAvatarMaxSize * (expandedPercentageFactor));

        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        lp.width = (int) (mStartHeight - heightToSubtract);
        lp.height = (int) (mStartHeight - heightToSubtract);
        child.setLayoutParams(lp);
        return true;
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");

        if (resourceId > 0) {
            result = mContext.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
