package com.hlbkj.pdl.fragment;

import com.google.gson.Gson;
import com.hlbkj.pdl.R;
import com.hlbkj.pdl.base.BaseTitleFragment;
import com.hlbkj.pdl.callback.LoginCallBack;
import com.hlbkj.pdl.net.model.bean.UserInfoBean;
import com.hlbkj.pdl.persistent.HomeFragmentPersistent;
import com.hlbkj.pdl.persistent.view.HomeFragmentView;
import com.hlbkj.pdl.util.ToastUtils;

import butterknife.OnClick;

/**
 * 文件名:HomeFragment
 * 创建者:zed
 * 创建日期:2019/4/1 13:47
 * 描述:TODO
 */
public class HomeFragment extends BaseTitleFragment<HomeFragmentPersistent> implements HomeFragmentView {

    @Override
    public int setBodyId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        setTvTitle(getString(R.string.app_name));
        setPersistent(new HomeFragmentPersistent(this));
    }

    @OnClick(R.id.tvClick)
    void click() {
        ToastUtils.showShort("click");
        isLogin(new LoginCallBack<UserInfoBean>() {
            @Override
            public void loginSuccess(UserInfoBean data) {
                ToastUtils.showShort(new Gson().toJson(data));
            }

            @Override
            public void loginFailed() {
                ToastUtils.showShort("失败");
            }
        });
    }
}
