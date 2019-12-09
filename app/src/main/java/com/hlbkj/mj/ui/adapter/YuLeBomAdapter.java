package com.hlbkj.mj.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hlbkj.mj.R;
import com.hlbkj.mj.ui.bean.YuLeBomBean;
import com.hlbkj.mj.util.GlideAppUtil;

import java.util.List;

/**
 * Created by EDZ on 2019/12/6.
 */

public class YuLeBomAdapter extends BaseQuickAdapter<YuLeBomBean,BaseViewHolder>{
    public YuLeBomAdapter(int layoutResId, @Nullable List<YuLeBomBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, YuLeBomBean item) {
        GlideAppUtil.loadImage(mContext,item.getImageId(),helper.getView(R.id.iv_imgbg));
    }
}
