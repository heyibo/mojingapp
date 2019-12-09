package com.hlbkj.mj.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hlbkj.mj.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public abstract class BaseTitleFragment<T extends BasePersistent> extends BaseFragment<T> {
    @Nullable
    @BindView(R.id.btLeft)
    Button btLeft;
    @Nullable
    @BindView(R.id.btRight)
    Button btRight;
    @Nullable
    @BindView(R.id.btRightOne)
    Button btRightOne;
    @Nullable
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @Nullable
    @BindView(R.id.rlTitleContainer)
    RelativeLayout rlTitleContainer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //容器
        ViewGroup contentView = (ViewGroup) LayoutInflater.from(getActivity()).inflate(R.layout.activity_base, container, false);
        //添加新主体容器
        View childView = LayoutInflater.from(getActivity()).inflate(setBodyId(), contentView, false);
        contentView.addView(childView);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childView.getLayoutParams();
        layoutParams.weight = 1;
        //绑定ui
        bind = ButterKnife.bind(this, contentView);
        initView();
        return contentView;
    }


    //自己实现父类方法，不需要父类处理ui
    @Override
    public final int setLayoutId() {
        return disableLayout;
    }

    @OnClick(R.id.btLeft)
    protected void leftClick(View view) {
        //组件默认状态为INVISIBLE 当设置了按钮后状态更新为VISIBLE
        //表示可以操作组件 默认为关闭
        if (view.getVisibility() == View.VISIBLE)
            getActivity().finish();
    }

    @OnClick(R.id.btRight)
    protected void rightClick(View view) {
    }

    @OnClick(R.id.btRightOne)
    protected void rightClickOne(View view) {
    }

    /**
     * 设置左标题
     *
     * @param word 文字
     */
    protected void setTitleLeft(String word) {
        if (btLeft != null) {
            btLeft.setVisibility(View.VISIBLE);
            btLeft.setText(word);
        }
    }

    /**
     * 设置左标题
     *
     * @param word  文字
     * @param resId 资源
     */
    protected void setTitleLeft(String word, int resId) {
        if (btLeft != null) {
            btLeft.setVisibility(View.VISIBLE);
            btLeft.setText(word);
            btLeft.setCompoundDrawablesRelativeWithIntrinsicBounds
                    (resId == -1 ? null : ContextCompat.getDrawable(getActivity(), resId),
                            null, null, null);
        }
    }

    /**
     * 设置标题
     *
     * @param word 文字
     */
    protected void setTvTitle(String word) {
        if (tvTitle != null) {
            tvTitle.setText(word);
        }
    }

    /**
     * 设置右标题
     *
     * @param word 文字
     */
    protected void setTitleRight(String word) {
        if (btRight != null) {
            btRight.setVisibility(TextUtils.isEmpty(word) ? View.INVISIBLE : View.VISIBLE);
            btRight.setText(word);
        }
    }

    /**
     * 设置右标题
     *
     * @param word  文字
     * @param resId 资源
     */
    protected void setTitleRight(String word, int resId) {
        if (btRight != null) {
            btRight.setVisibility(View.VISIBLE);
            btRight.setText(word);
            btRight.setCompoundDrawablesRelativeWithIntrinsicBounds
                    (null,
                            null,
                            resId == -1 ? null : ContextCompat.getDrawable(getActivity(), resId),
                            null);
        }
    }

    /**
     * 设置右标题
     *
     * @param word 文字
     */
    protected void setTitleRightOne(String word) {
        if (btRightOne != null) {
            btRightOne.setVisibility(TextUtils.isEmpty(word) ? View.INVISIBLE : View.VISIBLE);
            btRightOne.setText(word);
        }
    }

    /**
     * 设置右标题
     *
     * @param word  文字
     * @param resId 资源
     */
    protected void setTitleRightOne(String word, int resId) {
        if (btRightOne != null) {
            btRightOne.setVisibility(View.VISIBLE);
            btRightOne.setText(word);
            btRightOne.setCompoundDrawablesRelativeWithIntrinsicBounds
                    (null,
                            null,
                            resId == -1 ? null : ContextCompat.getDrawable(getActivity(), resId),
                            null);
        }
    }

    /**
     * 设置背景颜色
     * @param color
     */
    protected void setTitleBackgroundColor(int color) {
        if (rlTitleContainer != null)
            rlTitleContainer.setBackgroundColor(color);
    }
    public abstract int setBodyId();
}
