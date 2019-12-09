package com.hlbkj.mj.base;


import com.hlbkj.mj.net.model.bean.UserInfoBean;
import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * 文件名:BaseView
 * 创建者:zed
 * 创建日期:2019/3/22 15:01
 * 描述:TODO
 */
public interface BaseView {
    <A extends BaseActivity> A getCurrentActivity();
    <B> LifecycleTransformer<B> getActLifeRecycle();
    void showLoading();
    void hideLoading();
    UserInfoBean getUserInfo();
}
