package com.hlbkj.mj.fragment;

import com.hlbkj.mj.R;
import com.hlbkj.mj.base.BaseTitleFragment;
import com.hlbkj.mj.persistent.MessageFragmentPersistent;
import com.hlbkj.mj.persistent.view.MessageFragmentView;

/**
 * 消息
 */
public class MessageFragment extends BaseTitleFragment<MessageFragmentPersistent>
        implements MessageFragmentView {

    @Override
    public int setBodyId() {
        return R.layout.fragment_message;
    }

    @Override
    public void initView() {
        setTvTitle("消息");
        setTitleRightOne("",R.mipmap.sousuo);
        setTitleRight("",R.mipmap.haoyoulu);
    }
}
