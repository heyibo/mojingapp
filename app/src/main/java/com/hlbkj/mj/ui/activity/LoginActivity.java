package com.hlbkj.mj.ui.activity;

import android.content.Intent;
import android.view.View;

import com.hlbkj.mj.R;
import com.hlbkj.mj.base.BaseTitleActivity;
import com.hlbkj.mj.constant.SpConstant;
import com.hlbkj.mj.net.model.bean.UserInfoBean;

/**
 * 文件名:LoginActivity
 * 创建者:zed
 * 创建日期:2019/3/28 11:15
 * 描述:TODO
 */
public class LoginActivity extends BaseTitleActivity {
    @Override
    public int setBodyId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        setTvTitle("登录");
    }

    public void ff(View view) {
        setResult(RESULT_OK, new Intent().putExtra(SpConstant.APP_USER_INFO, new UserInfoBean()));
        finish();
    }

    public void cc(View view) {
        setResult(RESULT_CANCELED, new Intent().putExtra(SpConstant.APP_USER_INFO, new UserInfoBean()));
        finish();
    }
}
