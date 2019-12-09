// Generated code from Butter Knife. Do not modify!
package com.hlbkj.mj.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hlbkj.mj.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragment_ViewBinding implements Unbinder {
  private HomeFragment target;

  private View view2131230923;

  private View view2131230913;

  private View view2131230932;

  private View view2131230971;

  private View view2131230976;

  private View view2131230970;

  private View view2131230926;

  private View view2131230937;

  private View view2131230938;

  private View view2131230975;

  @UiThread
  public HomeFragment_ViewBinding(final HomeFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.iv_headimage, "field 'ivHeadimage' and method 'onViewClicked'");
    target.ivHeadimage = Utils.castView(view, R.id.iv_headimage, "field 'ivHeadimage'", CircleImageView.class);
    view2131230923 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_ar, "field 'ivAr' and method 'onViewClicked'");
    target.ivAr = Utils.castView(view, R.id.iv_ar, "field 'ivAr'", ImageView.class);
    view2131230913 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_qiandao, "field 'ivQiandao' and method 'onViewClicked'");
    target.ivQiandao = Utils.castView(view, R.id.iv_qiandao, "field 'ivQiandao'", ImageView.class);
    view2131230932 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvJinbi = Utils.findRequiredViewAsType(source, R.id.tv_jinbi, "field 'tvJinbi'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_nielian, "field 'llNielian' and method 'onViewClicked'");
    target.llNielian = Utils.castView(view, R.id.ll_nielian, "field 'llNielian'", LinearLayout.class);
    view2131230971 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_zhuangban, "field 'llZhuangban' and method 'onViewClicked'");
    target.llZhuangban = Utils.castView(view, R.id.ll_zhuangban, "field 'llZhuangban'", LinearLayout.class);
    view2131230976 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_kongjian, "field 'llKongjian' and method 'onViewClicked'");
    target.llKongjian = Utils.castView(view, R.id.ll_kongjian, "field 'llKongjian'", LinearLayout.class);
    view2131230970 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_makemovie, "field 'ivMakemovie' and method 'onViewClicked'");
    target.ivMakemovie = Utils.castView(view, R.id.iv_makemovie, "field 'ivMakemovie'", ImageView.class);
    view2131230926 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_task, "field 'ivTask' and method 'onViewClicked'");
    target.ivTask = Utils.castView(view, R.id.iv_task, "field 'ivTask'", ImageView.class);
    view2131230937 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_zuji, "field 'ivZuji' and method 'onViewClicked'");
    target.ivZuji = Utils.castView(view, R.id.iv_zuji, "field 'ivZuji'", ImageView.class);
    view2131230938 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_topright, "field 'llTopright' and method 'onViewClicked'");
    target.llTopright = Utils.castView(view, R.id.ll_topright, "field 'llTopright'", LinearLayout.class);
    view2131230975 = view;
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
    HomeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivHeadimage = null;
    target.ivAr = null;
    target.ivQiandao = null;
    target.tvJinbi = null;
    target.llNielian = null;
    target.llZhuangban = null;
    target.llKongjian = null;
    target.ivMakemovie = null;
    target.ivTask = null;
    target.ivZuji = null;
    target.llTopright = null;

    view2131230923.setOnClickListener(null);
    view2131230923 = null;
    view2131230913.setOnClickListener(null);
    view2131230913 = null;
    view2131230932.setOnClickListener(null);
    view2131230932 = null;
    view2131230971.setOnClickListener(null);
    view2131230971 = null;
    view2131230976.setOnClickListener(null);
    view2131230976 = null;
    view2131230970.setOnClickListener(null);
    view2131230970 = null;
    view2131230926.setOnClickListener(null);
    view2131230926 = null;
    view2131230937.setOnClickListener(null);
    view2131230937 = null;
    view2131230938.setOnClickListener(null);
    view2131230938 = null;
    view2131230975.setOnClickListener(null);
    view2131230975 = null;
  }
}
