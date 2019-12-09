package com.hlbkj.mj.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hlbkj.mj.R;
import com.hlbkj.mj.base.BaseFragment;
import com.hlbkj.mj.dialog.TipsDialog;
import com.hlbkj.mj.persistent.HomeFragmentPersistent;
import com.hlbkj.mj.persistent.view.HomeFragmentView;
import com.hlbkj.mj.ui.activity.NieLianActivity;
import com.hlbkj.mj.ui.activity.ShopActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 文件名:HomeFragment
 * 创建者:zed
 * 创建日期:2019/4/1 13:47
 * 描述:TODO
 */
public class HomeFragment extends BaseFragment<HomeFragmentPersistent> implements HomeFragmentView {

    @BindView(R.id.iv_headimage)
    CircleImageView ivHeadimage;
    @BindView(R.id.iv_ar)
    ImageView ivAr;
    @BindView(R.id.iv_qiandao)
    ImageView ivQiandao;
    @BindView(R.id.tv_jinbi)
    TextView tvJinbi;
    @BindView(R.id.ll_nielian)
    LinearLayout llNielian;
    @BindView(R.id.ll_zhuangban)
    LinearLayout llZhuangban;
    @BindView(R.id.ll_kongjian)
    LinearLayout llKongjian;
    @BindView(R.id.iv_makemovie)
    ImageView ivMakemovie;
    @BindView(R.id.iv_task)
    ImageView ivTask;
    @BindView(R.id.iv_zuji)
    ImageView ivZuji;
    @BindView(R.id.ll_topright)
    LinearLayout llTopright;

    @Override
    public int setLayoutId() {
        //Activity全屏显示，且状态栏被隐藏覆盖掉
//        getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        setPersistent(new HomeFragmentPersistent(this));
    }

    @OnClick({R.id.iv_headimage, R.id.iv_ar, R.id.iv_qiandao, R.id.ll_nielian, R.id.ll_zhuangban, R.id.ll_kongjian,
            R.id.iv_makemovie, R.id.iv_task, R.id.iv_zuji,R.id.ll_topright})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_headimage:
                break;
            case R.id.iv_ar:
                break;
            case R.id.iv_qiandao:
                break;
            case R.id.ll_nielian:
                startActivity(new Intent(getActivity(), NieLianActivity.class));
                break;
            case R.id.ll_zhuangban:
                break;
            case R.id.ll_kongjian:
                break;
            case R.id.iv_makemovie:
                break;
            case R.id.iv_task:
                break;
            case R.id.iv_zuji:
                break;
            case R.id.ll_topright:
//                TipsDialog tipsDialog = TipsDialog.createDialog(getActivity(),R.layout.dialog_goumaijinbi).fromBottom();
//                tipsDialog.setnoticeInvestDisplay(new TipsDialog.noticeInvestDisplay() {
//                    @Override
//                    public void displayInvestResult(int index, String strDisplay) {
//                        tipsDialog.setText(R.id.tv_querenzhifu,"确认支付  "+strDisplay);
//                    }
//                });
//                tipsDialog.setViewSelected(R.id.ll_jinbinum1,true);
//                tipsDialog.setText(R.id.tv_querenzhifu,"确认支付  (6元)");
//                tipsDialog.bindClick(R.id.ll_jinbinum1, new TipsDialog.TipClickListener() {
//                    @Override
//                    public void onClick(View v, TipsDialog dialog) {
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum1,true);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum2,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum3,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum4,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum5,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum6,false);
//                    }
//                }).bindClick(R.id.ll_jinbinum2, new TipsDialog.TipClickListener() {
//                    @Override
//                    public void onClick(View v, TipsDialog dialog) {
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum1,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum2,true);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum3,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum4,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum5,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum6,false);
//                    }
//                }).bindClick(R.id.ll_jinbinum3, new TipsDialog.TipClickListener() {
//                    @Override
//                    public void onClick(View v, TipsDialog dialog) {
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum1,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum2,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum3,true);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum4,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum5,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum6,false);
//                    }
//                }).bindClick(R.id.ll_jinbinum4, new TipsDialog.TipClickListener() {
//                    @Override
//                    public void onClick(View v, TipsDialog dialog) {
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum1,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum2,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum3,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum4,true);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum5,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum6,false);
//                    }
//                }).bindClick(R.id.ll_jinbinum5, new TipsDialog.TipClickListener() {
//                    @Override
//                    public void onClick(View v, TipsDialog dialog) {
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum1,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum2,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum3,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum4,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum5,true);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum6,false);
//                    }
//                }).bindClick(R.id.ll_jinbinum6, new TipsDialog.TipClickListener() {
//                    @Override
//                    public void onClick(View v, TipsDialog dialog) {
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum1,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum2,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum3,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum4,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum5,false);
//                        tipsDialog.setViewSelected(R.id.ll_jinbinum6,true);
//                    }
//                }).bindClick(R.id.tv_querenzhifu, new TipsDialog.TipClickListener() {
//                    @Override
//                    public void onClick(View v, TipsDialog dialog) {
//                        dialog.dismiss();
//                    }
//                }).show();
                startActivity(new Intent(getActivity(), ShopActivity.class));
                break;
        }
    }
}
