package com.hlbkj.mj.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hlbkj.mj.R;
import com.hlbkj.mj.base.BaseActivity;
import com.hlbkj.mj.dialog.TipsDialog;
import com.hlbkj.mj.persistent.NieLianActivityPersistent;
import com.hlbkj.mj.persistent.view.NieLianActivityView;
import com.hlbkj.mj.ui.adapter.NieNianTopAdapter;
import com.hlbkj.mj.ui.bean.NieLianTopBean;
import com.hlbkj.mj.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
* 2019年12月5日 娱乐界面
* */

public class NieLianActivity extends BaseActivity<NieLianActivityPersistent>
        implements NieLianActivityView {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_jinbi)
    TextView tvJinbi;
    @BindView(R.id.ryc_top)
    RecyclerView rycTop;
    @BindView(R.id.tv_shangpinstyle)
    TextView tvShangpinstyle;
    @BindView(R.id.ll_zuixinshangpin)
    LinearLayout llZuixinshangpin;
    @BindView(R.id.pageryc_mid)
    RecyclerView pagerycMid;
    @BindView(R.id.ryc_bom)
    RecyclerView rycBom;
    @BindView(R.id.tv_paygoodsnum)
    TextView tvPaygoodsnum;
    @BindView(R.id.rl_nieliangoumai)
    RelativeLayout rlNieliangoumai;
    List<NieLianTopBean> nieLianTopBeanList;
    NieNianTopAdapter mAdapter;
    int index = 1;

    @Override
    public int setLayoutId() {
        return R.layout.activity_nielian;
    }

    @Override
    public void initView() {
        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rycTop.setLayoutManager(layoutManager);
        nieLianTopBeanList = new ArrayList<>();
        mAdapter = new NieNianTopAdapter(R.layout.item_nielian_sel, nieLianTopBeanList);
        rycTop.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
        setData();
    }

    private void setData() {
        if (null != nieLianTopBeanList) {
            nieLianTopBeanList.clear();
        }
        for (int i = 0; i < 15; i++) {
            NieLianTopBean nieLianTopBean = new NieLianTopBean();
            nieLianTopBean.setIconSelUrl(R.mipmap.lianbunv);
            nieLianTopBean.setIconUnSelUrl(R.mipmap.lianbunv_no);
            nieLianTopBeanList.add(nieLianTopBean);
        }
        if (mAdapter != null)
            mAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.iv_back, R.id.ll_zuixinshangpin,R.id.rl_nieliangoumai})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_zuixinshangpin:
                TipsDialog tipsDialog = TipsDialog.createDialog(context, R.layout.dialog_goodsel).fromBottom();
//                tipsDialog.setnoticeGoodsDisplay(new TipsDialog.noticeGoodsDisplay() {
//                    @Override
//                    public void displayResult(int index, String strDisplay) {
//
//                    }
//                });
                switch (index) {
                    case 0:
                        tipsDialog.setViewChecked(R.id.ctv_mygoods, R.id.iv_mygoods);
                        break;
                    case 1:
                        tipsDialog.setViewChecked(R.id.ctv_newgoods, R.id.iv_newgoods);
                        break;
                    case 2:
                        tipsDialog.setViewChecked(R.id.ctv_ditogao, R.id.iv_ditogao);
                        break;
                    case 3:
                        tipsDialog.setViewChecked(R.id.ctv_gaotodi, R.id.iv_gaotodi);
                        break;
                }
                tipsDialog.bindClick(R.id.rl_mygoods, new TipsDialog.TipClickListener() {
                    @Override
                    public void onClick(View v, TipsDialog dialog) {
                        tvShangpinstyle.setText("我的物品");
                        index = 0;
                        dialog.dismiss();
                    }
                }).bindClick(R.id.rl_newgoods, new TipsDialog.TipClickListener() {
                    @Override
                    public void onClick(View v, TipsDialog dialog) {
                        tvShangpinstyle.setText("最新商品");
                        index = 1;
                        dialog.dismiss();
                    }
                }).bindClick(R.id.rl_ditogao, new TipsDialog.TipClickListener() {
                    @Override
                    public void onClick(View v, TipsDialog dialog) {
                        tvShangpinstyle.setText("价格低到高");
                        index = 2;
                        dialog.dismiss();
                    }
                }).bindClick(R.id.rl_gaotodi, new TipsDialog.TipClickListener() {
                    @Override
                    public void onClick(View v, TipsDialog dialog) {
                        tvShangpinstyle.setText("价格高到低");
                        index = 3;
                        dialog.dismiss();
                    }
                }).bindClick(R.id.tv_quxiao, new TipsDialog.TipClickListener() {
                    @Override
                    public void onClick(View v, TipsDialog dialog) {
                        dialog.dismiss();
                    }
                }).show();
                break;
            case R.id.rl_nieliangoumai:
                TipsDialog.createDialog(context,R.layout.dialog_goumai).fromBottom()
                        .bindClick(R.id.tv_topay, new TipsDialog.TipClickListener() {
                            @Override
                            public void onClick(View v, TipsDialog dialog) {
                                ToastUtils.showShort("购买接口暂未开通");
                                dialog.dismiss();
                            }
                        }).bindClick(R.id.rl_delete, new TipsDialog.TipClickListener() {
                    @Override
                    public void onClick(View v, TipsDialog dialog) {
                        dialog.dismiss();
                    }
                }).show();
                break;
        }
    }
}
