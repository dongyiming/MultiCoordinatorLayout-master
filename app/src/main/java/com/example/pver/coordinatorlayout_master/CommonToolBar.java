package com.example.pver.coordinatorlayout_master;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @version : 1.0
 * @Description : 自定义toolbar
 * @autho : dongyiming
 * @data : 2017/6/11 17:24
 */
public class CommonToolBar extends Toolbar {

    private TextView mTextTitle;
    private ImageButton mLeftButton;
    private ImageButton mRightButton;
    private LinearLayout mSearch;

    /**
     * 这个构造是直接使用的，默认是super,一直忘记改指向，所以顶部toolbar一直没显示
     *
     * @param context
     */
    public CommonToolBar(Context context) {
        this(context, null);
    }

    public CommonToolBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView();
        if (attrs != null) {

            TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(context, attrs, R.styleable.CommonToolBar, defStyleAttr, 0);
            Drawable leftIcon = tintTypedArray.getDrawable(R.styleable.CommonToolBar_leftIcom);
            Drawable rightIcon = tintTypedArray.getDrawable(R.styleable.CommonToolBar_rightIcon);
            String titleName = tintTypedArray.getString(R.styleable.CommonToolBar_titleName);

            //根据布局的引用设置值
            if (leftIcon != null) {
                setLeftButtonIcon(leftIcon);
            }
            if (rightIcon != null) {
                setRightButtonIcon(rightIcon);
            }
            if (titleName != null) {
                setTitleName(titleName);
            }
            tintTypedArray.recycle();
        }
    }

    private void initView() {

        View mView = LayoutInflater.from(getContext()).inflate(R.layout.toolbar_homepage, null);
        mTextTitle = (TextView) mView.findViewById(R.id.txt_title);
        mLeftButton = (ImageButton) mView.findViewById(R.id.imgBtn_left);
        mRightButton = (ImageButton) mView.findViewById(R.id.imgBtn_right);
        addView(mView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
    }

    public void setTitleName(String titleName) {
        if (mTextTitle != null && mSearch != null) {
            mSearch.setVisibility(View.GONE);
            mTextTitle.setVisibility(View.VISIBLE);
            mTextTitle.setText(titleName);
        }
    }

    public void showSearchView() {
        if (mTextTitle != null && mSearch != null){
            mTextTitle.setVisibility(View.GONE);
            mSearch.setVisibility(VISIBLE);
        }
    }

    public void hideSearchView() {
        if (mSearch != null) {
            mSearch.setVisibility(GONE);
        }
    }

    public void setRightButtonIcon(Drawable icon) {
        if (mRightButton != null) {
            mRightButton.setImageDrawable(icon);
            mRightButton.setVisibility(VISIBLE);
        }
    }

    /**
     * 当我们使用src属性设置按钮的图片的时候，ImageButton默认给我们的按钮添加了一个灰白色的背景框
     * src属性指按钮表层显示图片属性(setImageDrawable)，background属性指按钮底层背景属性(setBackground)
     * 当使用android:src属性时，图片不会拉伸（除非额外设置了Scale Type）
     * 而是用android:background属性时，图片默认会填充整个背景，
     *
     * @param icon
     */
    private void setLeftButtonIcon(Drawable icon) {
        if (mLeftButton != null) {
            mLeftButton.setImageDrawable(icon);
            mLeftButton.setVisibility(VISIBLE);
        }
    }

    public void setRightButtonOnClickLinster(OnClickListener linster) {
        mRightButton.setOnClickListener(linster);
    }

    public void setLeftButtonOnClickLinster(OnClickListener linster) {
        mLeftButton.setOnClickListener(linster);
    }

}
