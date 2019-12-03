package com.hlbkj.pdl.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;

import com.google.gson.Gson;
import com.hlbkj.pdl.ui.activity.LoginActivity;
import com.hlbkj.pdl.callback.LoginCallBack;
import com.hlbkj.pdl.net.model.bean.UserInfoBean;
import com.hlbkj.pdl.constant.SpConstant;
import com.hlbkj.pdl.dialog.LoadingDialog;
import com.hlbkj.pdl.util.SPUtils;
import com.hlbkj.pdl.util.StatusBarUtil;
import com.hlbkj.pdl.util.Utils;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public abstract class BaseActivity<T extends BasePersistent> extends RxAppCompatActivity implements BaseView {
    //当前类是否处理ui逻辑
    protected final int disableLayout = -10086;
    Unbinder bind;
    //loading
    private LoadingDialog loadingDialog;
    //登录回调
    private LoginCallBack<UserInfoBean> mLoginCallBack;
    protected T persistent = null;
    protected Context context = BaseActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //如果 id==disableLayout 则不需要 处理当前逻辑 交给子类处理
        int layoutId = setLayoutId();
        if (disableLayout != layoutId) {
            setContentView(layoutId);
            StatusBarUtil.setTranslucentForImageView(this, 0, null);
            bind = ButterKnife.bind(this);
            initView();
        }
        Utils.setStatusTextColor(true, BaseActivity.this);//黑色
    }

    /**
     * 设置P
     *
     * @param persistent p
     */
    public void setPersistent(T persistent) {
        this.persistent = persistent;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissLoading();
        if (bind != null)
            bind.unbind();
        if (persistent != null)
            persistent.onDestroy();
        persistent = null;
    }

    public void showLoading() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
            loadingDialog.setCancelable(true);
        }
        loadingDialog.show();
    }

    public void hideLoading() {
        if (loadingDialog != null) {
            loadingDialog.hide();
        }
    }

    private void dismissLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }

    //给任意view设置圆角outline.setRoundRect()方法实现
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setClipViewCornerRadius(View view, final int radius) {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            //不支持5.0版本以下的系统
            return;
        }

        if (view == null) return;

        if (radius <= 0) {
            return;
        }
        view.setOutlineProvider(new ViewOutlineProvider() {

            @Override
            public void getOutline(View view, Outline outline) {
//                    outline.setRoundRect(20, 20, view.getWidth()-40,   view.getHeight()-40, radius);
                outline.setRoundRect(40, 0, view.getWidth()-40,   view.getHeight(), radius);//这是设置圆角的关键设置


//                    Rect rect = new Rect();
//                    view.getGlobalVisibleRect(rect);
//                    int leftMargin = 40;
//                    int topMargin = 40;
//                    Rect selfRect = new Rect(leftMargin, topMargin,
//                            rect.right - rect.left - leftMargin, rect.bottom - rect.top - topMargin);
//                    outline.setRoundRect(selfRect, 30);
            }
        });
        view.setClipToOutline(true);

    }

    public UserInfoBean getUserInfo() {
        String info = SPUtils.getInstance().getString(SpConstant.APP_USER_INFO);
        if (TextUtils.isEmpty(info)) {
            return new UserInfoBean();
        }
        return new Gson().fromJson(info, UserInfoBean.class);
    }

    public abstract int setLayoutId();

    public abstract void initView();


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SpConstant.LOGIN_CODE && mLoginCallBack != null) {
            if (resultCode == RESULT_OK) {
                //一般登录完成后都会将登录后的信息保存起来 这里直接取缓存
                mLoginCallBack.loginSuccess(getUserInfo());
            } else {
                mLoginCallBack.loginFailed();
            }
        }
        //循环传递消息
        List<Fragment> frags = getSupportFragmentManager().getFragments();
        if (frags != null) {
            for (Fragment f : frags) {
                if (f != null)
                    f.onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    /**
     * 获取父类
     *
     * @return 父类
     */
    public <A extends BaseActivity> A getCurrentActivity() {
        return (A) this;
    }

    @Override
    public <B> LifecycleTransformer<B> getActLifeRecycle() {
        return this.bindUntilEvent(ActivityEvent.DESTROY);
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
        if (getUserInfo() != null && getUserInfo().isLogin()) {
            return true;
        } else {
            jumpLogin(callBack);
            return false;
        }
    }

    //跳转登录
    protected void jumpLogin(LoginCallBack<UserInfoBean> callBack) {
        startActivityForResult(new Intent(this, LoginActivity.class), SpConstant.LOGIN_CODE);
        mLoginCallBack = callBack;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
