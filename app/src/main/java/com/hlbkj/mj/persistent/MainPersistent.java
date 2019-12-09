package com.hlbkj.mj.persistent;

import com.hlbkj.mj.base.BasePersistent;
import com.hlbkj.mj.persistent.view.MainView;

/**
 * 文件名:MainPersistent
 * 创建者:zed
 * 创建日期:2019/3/15 13:09
 * 描述:TODO
 */
public class MainPersistent extends BasePersistent<MainView> {

    @Override
    protected void init() {

    }

    public MainPersistent(MainView baseView) {
        super(baseView);
    }
}
