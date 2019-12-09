package com.hlbkj.mj.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hlbkj.mj.R;
import com.hlbkj.mj.base.BaseTitleFragment;
import com.hlbkj.mj.persistent.YuLeFragmentPersistent;
import com.hlbkj.mj.persistent.view.YuLeFragmentView;
import com.hlbkj.mj.ui.adapter.YuLeBomAdapter;
import com.hlbkj.mj.ui.bean.YuLeBomBean;
import com.hlbkj.mj.ui.customview.SpacesItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.hlbkj.mj.constant.SpConstant.DOWN_COMPLATE;
import static com.hlbkj.mj.constant.SpConstant.PULL_COMPLATE;

/**
 * 娱乐
 */
public class YuLeFragment extends BaseTitleFragment<YuLeFragmentPersistent>
        implements YuLeFragmentView {

    @BindView(R.id.rl_sing)
    RelativeLayout rlSing;
    @BindView(R.id.rl_dance)
    RelativeLayout rlDance;
    @BindView(R.id.rl_yuc)
    RelativeLayout rlYuc;
    @BindView(R.id.ll_huanyipi)
    LinearLayout llHuanyipi;
    @BindView(R.id.tv_title1)
    TextView tvTitle1;
    @BindView(R.id.iv_fangjian1)
    RelativeLayout ivFangjian1;
    @BindView(R.id.tv_singname1)
    TextView tvSingname1;
    @BindView(R.id.tv_title2)
    TextView tvTitle2;
    @BindView(R.id.iv_fangjian2)
    RelativeLayout ivFangjian2;
    @BindView(R.id.tv_singname2)
    TextView tvSingname2;
    @BindView(R.id.tv_title3)
    TextView tvTitle3;
    @BindView(R.id.iv_fangjian3)
    RelativeLayout ivFangjian3;
    @BindView(R.id.tv_singname3)
    TextView tvSingname3;
    @BindView(R.id.ryc_yulelist)
    RecyclerView rycYulelist;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    List<YuLeBomBean> yuLeBomBeanList;
    YuLeBomAdapter mAdapter;

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case PULL_COMPLATE:
                    refreshLayout.finishLoadmore();
                    break;
                case DOWN_COMPLATE:
                    refreshLayout.finishRefresh();
                    break;
            }
        }
    };

    @Override
    public int setBodyId() {
        return R.layout.fragment_yule;
    }

    @Override
    public void initView() {
        setTvTitle("娱乐");
        setTitleRight("", R.mipmap.renwu);
        //创建布局管理
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rycYulelist.addItemDecoration(new SpacesItemDecoration(5));
        rycYulelist.setLayoutManager(gridLayoutManager);
        yuLeBomBeanList = new ArrayList<>();
        mAdapter = new YuLeBomAdapter(R.layout.item_yulelist, yuLeBomBeanList);
        rycYulelist.setAdapter(mAdapter);
        //刷新
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(DOWN_COMPLATE);
                    }
                }, 0);
            }
        });
        //加载更多
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(PULL_COMPLATE);
                    }
                }, 0);
            }
        });
        setData();
    }

    private void setData() {
        if (null != yuLeBomBeanList) {
            yuLeBomBeanList.clear();
        }
        for (int i = 0; i < 20; i++) {
            YuLeBomBean yuLeBomBean = new YuLeBomBean();
            yuLeBomBean.setImageId(R.mipmap.item_bg);
            yuLeBomBeanList.add(yuLeBomBean);
        }
        if (null != mAdapter)
            mAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.rl_sing, R.id.rl_dance, R.id.rl_yuc, R.id.ll_huanyipi, R.id.iv_fangjian1,
            R.id.iv_fangjian2, R.id.iv_fangjian3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_sing:
                break;
            case R.id.rl_dance:
                break;
            case R.id.rl_yuc:
                break;
            case R.id.ll_huanyipi:
                break;
            case R.id.iv_fangjian1:
                break;
            case R.id.iv_fangjian2:
                break;
            case R.id.iv_fangjian3:
                break;
        }
    }

}
