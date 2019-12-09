// Generated code from Butter Knife. Do not modify!
package com.hlbkj.mj.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hlbkj.mj.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NieLianActivity_ViewBinding implements Unbinder {
  private NieLianActivity target;

  private View view2131230914;

  private View view2131230977;

  private View view2131231072;

  @UiThread
  public NieLianActivity_ViewBinding(NieLianActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public NieLianActivity_ViewBinding(final NieLianActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.iv_back, "field 'ivBack' and method 'onViewClicked'");
    target.ivBack = Utils.castView(view, R.id.iv_back, "field 'ivBack'", ImageView.class);
    view2131230914 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvJinbi = Utils.findRequiredViewAsType(source, R.id.tv_jinbi, "field 'tvJinbi'", TextView.class);
    target.rycTop = Utils.findRequiredViewAsType(source, R.id.ryc_top, "field 'rycTop'", RecyclerView.class);
    target.tvShangpinstyle = Utils.findRequiredViewAsType(source, R.id.tv_shangpinstyle, "field 'tvShangpinstyle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_zuixinshangpin, "field 'llZuixinshangpin' and method 'onViewClicked'");
    target.llZuixinshangpin = Utils.castView(view, R.id.ll_zuixinshangpin, "field 'llZuixinshangpin'", LinearLayout.class);
    view2131230977 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.pagerycMid = Utils.findRequiredViewAsType(source, R.id.pageryc_mid, "field 'pagerycMid'", RecyclerView.class);
    target.rycBom = Utils.findRequiredViewAsType(source, R.id.ryc_bom, "field 'rycBom'", RecyclerView.class);
    target.tvPaygoodsnum = Utils.findRequiredViewAsType(source, R.id.tv_paygoodsnum, "field 'tvPaygoodsnum'", TextView.class);
    view = Utils.findRequiredView(source, R.id.rl_nieliangoumai, "field 'rlNieliangoumai' and method 'onViewClicked'");
    target.rlNieliangoumai = Utils.castView(view, R.id.rl_nieliangoumai, "field 'rlNieliangoumai'", RelativeLayout.class);
    view2131231072 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    NieLianActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivBack = null;
    target.tvJinbi = null;
    target.rycTop = null;
    target.tvShangpinstyle = null;
    target.llZuixinshangpin = null;
    target.pagerycMid = null;
    target.rycBom = null;
    target.tvPaygoodsnum = null;
    target.rlNieliangoumai = null;

    view2131230914.setOnClickListener(null);
    view2131230914 = null;
    view2131230977.setOnClickListener(null);
    view2131230977 = null;
    view2131231072.setOnClickListener(null);
    view2131231072 = null;
  }
}
