package com.hlbkj.mj.ui.activity;

import android.view.View;
import android.widget.LinearLayout;

import com.hlbkj.mj.R;
import com.hlbkj.mj.base.BaseTitleActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShopActivity extends BaseTitleActivity {

    @BindView(R.id.ll_chongzhinum1)
    LinearLayout llChongzhinum1;
    @BindView(R.id.ll_chongzhinum2)
    LinearLayout llChongzhinum2;
    @BindView(R.id.ll_chongzhinum3)
    LinearLayout llChongzhinum3;
    @BindView(R.id.ll_chongzhinum4)
    LinearLayout llChongzhinum4;
    @BindView(R.id.ll_chongzhinum5)
    LinearLayout llChongzhinum5;
    @BindView(R.id.ll_chongzhinum6)
    LinearLayout llChongzhinum6;
    List<Integer> idsList;

    @Override
    public int setBodyId() {
        return R.layout.activity_shop;
    }

    @Override
    public void initView() {
        setTitleLeft("", R.mipmap.back);
        setTvTitle("商店");
        idsList = new ArrayList<>();
        addIds();
        selected(R.id.ll_chongzhinum1,idsList);
    }

    private void addIds() {
        idsList.add(R.id.ll_chongzhinum1);
        idsList.add(R.id.ll_chongzhinum2);
        idsList.add(R.id.ll_chongzhinum3);
        idsList.add(R.id.ll_chongzhinum4);
        idsList.add(R.id.ll_chongzhinum5);
        idsList.add(R.id.ll_chongzhinum6);
    }

    @OnClick({R.id.ll_chongzhinum1, R.id.ll_chongzhinum2, R.id.ll_chongzhinum3, R.id.ll_chongzhinum4, R.id.ll_chongzhinum5, R.id.ll_chongzhinum6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_chongzhinum1:
                selected(R.id.ll_chongzhinum1,idsList);
                break;
            case R.id.ll_chongzhinum2:
                selected(R.id.ll_chongzhinum2,idsList);
                break;
            case R.id.ll_chongzhinum3:
                selected(R.id.ll_chongzhinum3,idsList);
                break;
            case R.id.ll_chongzhinum4:
                selected(R.id.ll_chongzhinum4,idsList);
                break;
            case R.id.ll_chongzhinum5:
                selected(R.id.ll_chongzhinum5,idsList);
                break;
            case R.id.ll_chongzhinum6:
                selected(R.id.ll_chongzhinum6,idsList);
                break;
        }
    }

    private void selected(int viewId,List<Integer> idsList) {
        for(Integer dataList : idsList){
            if(viewId == dataList){
                findViewById(dataList).setSelected(true);
            }else {
                findViewById(dataList).setSelected(false);
            }
        }
    }
}
