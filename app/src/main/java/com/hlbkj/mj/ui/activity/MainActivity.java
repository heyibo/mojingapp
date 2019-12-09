package com.hlbkj.mj.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hlbkj.mj.R;
import com.hlbkj.mj.base.BaseActivity;
import com.hlbkj.mj.base.BaseFragment;
import com.hlbkj.mj.fragment.HomeFragment;
import com.hlbkj.mj.fragment.MessageFragment;
import com.hlbkj.mj.fragment.YuLeFragment;
import com.hlbkj.mj.util.StatusBarUtil;
import com.hlbkj.mj.util.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 首页
 */
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.rgGroup)
    RadioGroup rgGroup;
    @BindView(R.id.rbYuLe)
    RadioButton rbYuLe;
    @BindView(R.id.rbHome)
    RadioButton rbHome;
    @BindView(R.id.rbMessage)
    RadioButton rbMessage;

    private YuLeFragment mYuLeFragment;
    private HomeFragment mHomeFragment;
    private MessageFragment mMessageFragment;
    BaseFragment baseFragment;
    private long exitTime = 0;
    int mCheckedId;//记住已经选中的id
    Bundle bundle = new Bundle();

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        StatusBarUtil.setColorNoTranslucent(this, ContextCompat.getColor(this, R.color.app_color));
        //Activity全屏显示，且状态栏被隐藏覆盖掉
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        mYuLeFragment = new YuLeFragment();
        mHomeFragment = new HomeFragment();
        mMessageFragment = new MessageFragment();
        rgGroup.setOnCheckedChangeListener(this);
        select(R.id.rbHome);
    }

    /**
     * 切换page
     *
     * @param view 点击的view、
     */
    public void select(View view) {
        select(view.getId());
    }

    /**
     * 切换page
     *
     * @param resId id、
     */
    public void select(int resId) {
        switch (resId) {
            case R.id.rbYuLe:
                if (mYuLeFragment == null)
                    mYuLeFragment = new YuLeFragment();
                replace(mYuLeFragment);
//                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
//                StatusBarUtil.setColorNoTranslucent(this, ContextCompat.getColor(this, R.color.app_color));
                break;
            case R.id.rbHome:
                //Activity全屏显示，且状态栏被隐藏覆盖掉
//                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
                if (mHomeFragment == null)
                    mHomeFragment = new HomeFragment();
                replace(mHomeFragment);
                break;
            case R.id.rbMessage:
                if (mMessageFragment == null)
                    mMessageFragment = new MessageFragment();
                replace(mMessageFragment);
//                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
//                StatusBarUtil.setColorNoTranslucent(this, ContextCompat.getColor(this, R.color.app_color));
                break;
        }
    }

    /**
     * 替换页面
     *
     * @param fragment
     */
    private void replace(BaseFragment fragment) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        if (!fragment.isAdded()) {
            if (baseFragment == null) {
                fragmentTransaction.add(R.id.flContainer, fragment).show(fragment);
            } else {
                fragmentTransaction.add(R.id.flContainer, fragment).hide(baseFragment).show(fragment);
            }
        } else {
            fragmentTransaction.hide(baseFragment).show(fragment);
        }
        baseFragment = fragment;
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(new Bundle());
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rbYuLe:
                select(checkedId);
                break;
            case R.id.rbHome:
                select(checkedId);
                break;
            case R.id.rbMessage:
                select(checkedId);
                break;
        }
    }

    //双击退出应用
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {

            if ((System.currentTimeMillis() - exitTime) > 2000) {
                ToastUtils.showShort("再按一次退出APP");
                exitTime = System.currentTimeMillis();
                return true;
            } else {
                finish();
                System.exit(0);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}