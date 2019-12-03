package com.hlbkj.pdl.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.hlbkj.pdl.R;
import com.hlbkj.pdl.base.BaseActivity;
import com.xiemiao.guidepagelib.view.GuidePage;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideActivity extends BaseActivity {

    @BindView(R.id.guidePage)
    GuidePage guidePage;
    private Integer[] images = {R.mipmap.guide1, R.mipmap.guide2, R.mipmap.guide3};
    @Override
    public int setLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    public void initView() {
        guidePage.setLocalImageResList(Arrays.asList(images)).setOvalIndicator(Color.parseColor
                ("#00FF00"), Color.parseColor("#FFFFFF"), 10);

        //设置进入按钮（文字，颜色，大小，背景）点击事件
        guidePage.setOnEntryClickListener("立即体验", Color.parseColor("#ffffff"), 18, R.drawable
                .shape_radius_yellow_bg, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,MainActivity.class));
                finish();
            }
        });
    }

}
