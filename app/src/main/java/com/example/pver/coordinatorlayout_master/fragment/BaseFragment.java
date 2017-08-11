package com.example.pver.coordinatorlayout_master.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;

/**
 * @version : 1.0
 * @Description : 没有经过预加载处理的viewpager,onCreateView 和onActiviteCreate会预加载
 * @autho : dongyiming
 * @data : 2017/5/23 12:50
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    protected WeakReference<Context> mContext;
    protected int visible = 4;
    public boolean isVisible;

    public BaseFragment() {
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mContext = new WeakReference(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.setRootView(inflater);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.initWidget();
        this.registerWidgetEvent();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.initComponent();
    }

    public void onResume() {
        super.onResume();
        this.visible = 0;
    }

    public void onPause() {
        super.onPause();
        this.visible = 4;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * 界面初始化
     *
     * @param inflater
     * @return
     */

    public View setRootView(LayoutInflater inflater) {
        return null;
    }

    /**
     * 控件初始化
     */
    public void initWidget() {
    }

    /**
     * 注册控件的点击事件
     */
    public void registerWidgetEvent() {
    }

    /**
     * view和controller的交互初始化
     */
    public void initComponent() {
    }

    /**
     * 控件的点击
     *
     * @param v
     */
    public void widgetClick(View v) {
    }

    public int getVisible() {
        return this.visible;
    }

    public Fragment getInteractionView() {
        return this;
    }

    public void onClick(View view) {
        this.widgetClick(view);
    }

    public void onVisible() {
    }

    public void onInvisible() {
    }

}
