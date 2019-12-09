package com.hlbkj.mj.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hlbkj.mj.R;
import com.hlbkj.mj.ui.bean.NieLianTopBean;
import com.hlbkj.mj.util.GlideAppUtil;

import java.util.List;

/**
 * Created by EDZ on 2019/12/6.
 */

public class NieNianTopAdapter extends BaseQuickAdapter<NieLianTopBean,BaseViewHolder>{
    public NieNianTopAdapter(int layoutResId, @Nullable List<NieLianTopBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NieLianTopBean item) {
        int position = helper.getPosition();
        if(0 == position){
            GlideAppUtil.loadImage(mContext,item.getIconSelUrl(),helper.getView(R.id.iv_icon));
        }else {
            GlideAppUtil.loadImage(mContext,item.getIconUnSelUrl(),helper.getView(R.id.iv_icon));
        }
    }
}
