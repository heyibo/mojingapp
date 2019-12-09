package com.hlbkj.mj.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hlbkj.mj.R;
import com.hlbkj.mj.base.BaseTitleActivity;
import com.hlbkj.mj.persistent.JuBaoActivityPersistent;
import com.hlbkj.mj.persistent.view.JuBaoActivityView;

public class JuBaoActivity extends BaseTitleActivity<JuBaoActivityPersistent>
        implements JuBaoActivityView {

    @Override
    public int setBodyId() {
        return R.layout.activity_jubao;
    }

    @Override
    public void initView() {
        setTitleLeft("",R.mipmap.back);
        setTvTitle("匿名举报");
    }
}
