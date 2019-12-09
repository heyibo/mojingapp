package com.hlbkj.mj.base;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hlbkj.mj.callback.LoginCallBack;
import com.hlbkj.mj.net.model.bean.UserInfoBean;
import com.hlbkj.mj.ui.activity.LoginActivity;
import com.hlbkj.mj.util.ToastUtils;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<T extends BasePersistent> extends RxFragment implements BaseView {
    //当前类是否处理ui逻辑
    protected final int disableLayout = -10086;
    Unbinder bind;
    protected T persistent = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int setLayoutId = setLayoutId();
        if (disableLayout != setLayoutId) {
            View view = inflater.inflate(setLayoutId, container, false);
            bind = ButterKnife.bind(this, view);
            initView();
            return view;
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    /**
     *设置P
     * @param persistent p
     */
    public void setPersistent(T persistent) {
        this.persistent = persistent;
    }

    public void showLoading() {
        if (getCurrentActivity() == null) return;
        getCurrentActivity().showLoading();
    }

    public void hideLoading() {
        if (getCurrentActivity() == null) return;
        getCurrentActivity().hideLoading();
    }

    /**
     * 判断是否登录
     *
     * @return true 登录 false 未登录
     */
    protected boolean isLogin() {
        return isLogin(null);
    }

    /**
     * 判断是否登录
     *
     * @param callBack 如果没有登录 是否需要自动登录
     */
    protected boolean isLogin(LoginCallBack<UserInfoBean> callBack) {
        if (getCurrentActivity() == null) return false;
        return getCurrentActivity().isLogin(callBack);
    }

    /**
     * 获取父类
     *
     * @return 父类
     */
    public <A extends BaseActivity> A getCurrentActivity() {
        return (A) getActivity();
    }

    @Override
    public <B> LifecycleTransformer<B> getActLifeRecycle() {
        return this.bindUntilEvent(FragmentEvent.DESTROY);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(persistent!=null)
            persistent.onDestroy();
        if (bind != null)
            bind.unbind();
        persistent = null;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    public UserInfoBean getUserInfo() {
        if (getCurrentActivity() == null) return new UserInfoBean();
        return getCurrentActivity().getUserInfo();
    }

    public abstract int setLayoutId();

    public abstract void initView();

    public void startActivityAfterLogin(Intent intent) {
        //未登录（这里用自己的登录逻辑去判断是否未登录）
        if (!getUserInfo().isLogin()) {
            ComponentName componentName = new ComponentName(getActivity(), LoginActivity.class);
            intent.putExtra("className", intent.getComponent().getClassName());
            intent.setComponent(componentName);
            super.startActivity(intent);
        } else {
            super.startActivity(intent);
        }
    }

    public void doCall(String phone) {
        //拨打电话前先检测是否插入运营商卡
        TelephonyManager telManager = (TelephonyManager) getActivity().getSystemService(Context.TELEPHONY_SERVICE);
        String operator = telManager.getSimOperator();
        if (operator != null) {
//                            if(operator.equals("46000") || operator.equals("46002")){
//                                //中国移动
//                            }else if(operator.equals("46001")){
//                                //中国联通
//                            }else if(operator.equals("46003")){
//                                //中国电信
//                            }
            if (!TextUtils.isEmpty(phone)) {
                if (!hasPermission()) {
                    // 在6.0 系统中请求某些权限需要检查权限
                    int curApiVersion = Build.VERSION.SDK_INT;
                    if (curApiVersion >= Build.VERSION_CODES.M) {
                        // 动态请求拨打电话权限
                        requestPermissions(
                                new String[]{Manifest.permission.CALL_PHONE},
                                0x11);
                    } else {
                        if (null != phone && !"null".equals(phone) && !"NULL".equals(phone) && phone.length() > 0) {
                            intentToCall(phone);
                        } else {
                            ToastUtils.showShort("您拨打的号码不正确");
                        }
                    }
                } else {
                    if (null != phone && !"null".equals(phone) && !"NULL".equals(phone) && phone.length() > 0) {
                        intentToCall(phone);
                    } else {
                        ToastUtils.showShort("您拨打的号码不正确");
                    }
                }
            }
        } else {
            ToastUtils.showShort("您还未插入手机运营商卡，请先插入运营商卡");
        }
    }

    @SuppressLint("NewApi")
    private boolean hasPermission() {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        return true;
    }

    @SuppressLint("MissingPermission")
    public void intentToCall(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + phoneNumber);
        intent.setData(data);
        startActivity(intent);
    }

    protected void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtra("initValues", bundle);
        }
        startActivity(intent);
    }
}
