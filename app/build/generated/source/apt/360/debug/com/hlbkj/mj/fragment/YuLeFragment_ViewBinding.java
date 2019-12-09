// Generated code from Butter Knife. Do not modify!
package com.hlbkj.mj.fragment;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hlbkj.mj.R;
import com.hlbkj.mj.base.BaseTitleFragment_ViewBinding;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class YuLeFragment_ViewBinding extends BaseTitleFragment_ViewBinding {
  private YuLeFragment target;

  private View view2131231074;

  private View view2131231065;

  private View view2131231077;

  private View view2131230963;

  private View view2131230918;

  private View view2131230919;

  private View view2131230920;

  @UiThread
  public YuLeFragment_ViewBinding(final YuLeFragment target, View source) {
    super(target, source);

    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.rl_sing, "field 'rlSing' and method 'onViewClicked'");
    target.rlSing = Utils.castView(view, R.id.rl_sing, "field 'rlSing'", RelativeLayout.class);
    view2131231074 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_dance, "field 'rlDance' and method 'onViewClicked'");
    target.rlDance = Utils.castView(view, R.id.rl_dance, "field 'rlDance'", RelativeLayout.class);
    view2131231065 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rl_yuc, "field 'rlYuc' and method 'onViewClicked'");
    target.rlYuc = Utils.castView(view, R.id.rl_yuc, "field 'rlYuc'", RelativeLayout.class);
    view2131231077 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_huanyipi, "field 'llHuanyipi' and method 'onViewClicked'");
    target.llHuanyipi = Utils.castView(view, R.id.ll_huanyipi, "field 'llHuanyipi'", LinearLayout.class);
    view2131230963 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvTitle1 = Utils.findRequiredViewAsType(source, R.id.tv_title1, "field 'tvTitle1'", TextView.class);
    view = Utils.findRequiredView(source, R.id.iv_fangjian1, "field 'ivFangjian1' and method 'onViewClicked'");
    target.ivFangjian1 = Utils.castView(view, R.id.iv_fangjian1, "field 'ivFangjian1'", RelativeLayout.class);
    view2131230918 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvSingname1 = Utils.findRequiredViewAsType(source, R.id.tv_singname1, "field 'tvSingname1'", TextView.class);
    target.tvTitle2 = Utils.findRequiredViewAsType(source, R.id.tv_title2, "field 'tvTitle2'", TextView.class);
    view = Utils.findRequiredView(source, R.id.iv_fangjian2, "field 'ivFangjian2' and method 'onViewClicked'");
    target.ivFangjian2 = Utils.castView(view, R.id.iv_fangjian2, "field 'ivFangjian2'", RelativeLayout.class);
    view2131230919 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvSingname2 = Utils.findRequiredViewAsType(source, R.id.tv_singname2, "field 'tvSingname2'", TextView.class);
    target.tvTitle3 = Utils.findRequiredViewAsType(source, R.id.tv_title3, "field 'tvTitle3'", TextView.class);
    view = Utils.findRequiredView(source, R.id.iv_fangjian3, "field 'ivFangjian3' and method 'onViewClicked'");
    target.ivFangjian3 = Utils.castView(view, R.id.iv_fangjian3, "field 'ivFangjian3'", RelativeLayout.class);
    view2131230920 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvSingname3 = Utils.findRequiredViewAsType(source, R.id.tv_singname3, "field 'tvSingname3'", TextView.class);
    target.rycYulelist = Utils.findRequiredViewAsType(source, R.id.ryc_yulelist, "field 'rycYulelist'", RecyclerView.class);
    target.refreshLayout = Utils.findRequiredViewAsType(source, R.id.refreshLayout, "field 'refreshLayout'", SmartRefreshLayout.class);
  }

  @Override
  public void unbind() {
    YuLeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rlSing = null;
    target.rlDance = null;
    target.rlYuc = null;
    target.llHuanyipi = null;
    target.tvTitle1 = null;
    target.ivFangjian1 = null;
    target.tvSingname1 = null;
    target.tvTitle2 = null;
    target.ivFangjian2 = null;
    target.tvSingname2 = null;
    target.tvTitle3 = null;
    target.ivFangjian3 = null;
    target.tvSingname3 = null;
    target.rycYulelist = null;
    target.refreshLayout = null;

    view2131231074.setOnClickListener(null);
    view2131231074 = null;
    view2131231065.setOnClickListener(null);
    view2131231065 = null;
    view2131231077.setOnClickListener(null);
    view2131231077 = null;
    view2131230963.setOnClickListener(null);
    view2131230963 = null;
    view2131230918.setOnClickListener(null);
    view2131230918 = null;
    view2131230919.setOnClickListener(null);
    view2131230919 = null;
    view2131230920.setOnClickListener(null);
    view2131230920 = null;

    super.unbind();
  }
}
