package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;

/**
 * 文件名:HlbHeader
 * 创建者:zed
 * 创建日期:2019/3/11 19:05
 * 描述:TODO
 */
public class HlbHeader extends InternalAbstract implements RefreshHeader {
    ImageView mLoadingView;
    AnimationDrawable animDrawable;

    //<editor-fold desc="View">
    public HlbHeader(Context context) {
        this(context, null);
    }

    public HlbHeader(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HlbHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mLoadingView = new ImageView(getContext());
        animDrawable = (AnimationDrawable) getResources().getDrawable(R.drawable.header_loading);
        mLoadingView.setImageDrawable(animDrawable);
        addView(mLoadingView);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mLoadingView.getLayoutParams();
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
    }


    @Override
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
        super.onStateChanged(refreshLayout, oldState, newState);
        Log.d("onStateChanged", oldState.name() + "-" + newState.name());
        if (oldState == RefreshState.RefreshFinish && newState == RefreshState.None && animDrawable.isRunning()) {
            animDrawable.stop();
        } else if (oldState == RefreshState.None && newState == RefreshState.PullDownToRefresh && !animDrawable.isRunning()) {
            animDrawable.start();
        }
    }
}
