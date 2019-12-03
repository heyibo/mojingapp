package com.hlbkj.pdl.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.RadioGroup;

import com.hlbkj.pdl.R;
import com.hlbkj.pdl.base.BaseActivity;
import com.hlbkj.pdl.base.BaseFragment;
import com.hlbkj.pdl.fragment.HomeFragment;
import com.hlbkj.pdl.util.StatusBarUtil;

import butterknife.BindView;

/**
 * 首页
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.rgGroup)
    RadioGroup rgGroup;

    private HomeFragment mLoanFragment;
    private HomeFragment mRepayFragment;
    private HomeFragment mMineFragment;
    BaseFragment baseFragment;

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        StatusBarUtil.setColorNoTranslucent(this, ContextCompat.getColor(this, R.color.app_color));
        mLoanFragment = new HomeFragment();
        mRepayFragment = new HomeFragment();
        mMineFragment = new HomeFragment();
        select(R.id.rbLoan);
    }

    /**
     * 切换page
     * @param view 点击的view、
     */
    public void select(View view) {
        select(view.getId());
    }

    /**
     * 切换page
     * @param resId id、
     */
    public void select(int resId) {
        switch (resId) {
            case R.id.rbLoan:
                if (mLoanFragment == null)
                    mLoanFragment = new HomeFragment();
                replace(mLoanFragment);
                break;
            case R.id.rbRepay:
                if (mRepayFragment == null)
                    mRepayFragment = new HomeFragment();
                replace(mRepayFragment);
                break;
            case R.id.rbMy:
                if (mMineFragment == null) {
                    mMineFragment = new HomeFragment();
                    replace(mMineFragment);
                    break;
                }
        }
    }

    /**
     * 替换页面
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
        fragmentTransaction.commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(new Bundle());
    }
}