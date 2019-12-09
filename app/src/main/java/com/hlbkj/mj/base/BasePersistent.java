package com.hlbkj.mj.base;

import com.hlbkj.mj.net.model.bean.UserInfoBean;
import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * 文件名:BasePersistent
 * 创建者:zed
 * 创建日期:2019/3/22 15:00
 * 描述:通用
 */
public abstract class BasePersistent<T extends BaseView> implements IBasePersistent<T> {
    protected T mBaseView;
    protected abstract void init();

    public BasePersistent(T baseView) {
        this.mBaseView = baseView;
        init();
    }

    public <A extends BaseActivity> A getCurrentActivity() {
        return mBaseView == null ? null : (A)mBaseView.getCurrentActivity();
    }

    public T getView() {
        return mBaseView;
    }

    @Override
    public void onDestroy() {
        mBaseView = null;
    }

    protected <B> LifecycleTransformer<B> getActLifeRecycle() {
        if (mBaseView == null) return null;
        return mBaseView.getActLifeRecycle();
    }

    protected UserInfoBean getUserInfo() {
        if (mBaseView == null) return new UserInfoBean();
        return mBaseView.getUserInfo();
    }
}
