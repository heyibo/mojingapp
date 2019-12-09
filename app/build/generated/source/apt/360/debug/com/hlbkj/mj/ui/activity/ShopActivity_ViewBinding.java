// Generated code from Butter Knife. Do not modify!
package com.hlbkj.mj.ui.activity;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hlbkj.mj.R;
import com.hlbkj.mj.base.BaseTitleActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ShopActivity_ViewBinding extends BaseTitleActivity_ViewBinding {
  private ShopActivity target;

  private View view2131230957;

  private View view2131230958;

  private View view2131230959;

  private View view2131230960;

  private View view2131230961;

  private View view2131230962;

  @UiThread
  public ShopActivity_ViewBinding(ShopActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ShopActivity_ViewBinding(final ShopActivity target, View source) {
    super(target, source);

    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.ll_chongzhinum1, "field 'llChongzhinum1' and method 'onViewClicked'");
    target.llChongzhinum1 = Utils.castView(view, R.id.ll_chongzhinum1, "field 'llChongzhinum1'", LinearLayout.class);
    view2131230957 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_chongzhinum2, "field 'llChongzhinum2' and method 'onViewClicked'");
    target.llChongzhinum2 = Utils.castView(view, R.id.ll_chongzhinum2, "field 'llChongzhinum2'", LinearLayout.class);
    view2131230958 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_chongzhinum3, "field 'llChongzhinum3' and method 'onViewClicked'");
    target.llChongzhinum3 = Utils.castView(view, R.id.ll_chongzhinum3, "field 'llChongzhinum3'", LinearLayout.class);
    view2131230959 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_chongzhinum4, "field 'llChongzhinum4' and method 'onViewClicked'");
    target.llChongzhinum4 = Utils.castView(view, R.id.ll_chongzhinum4, "field 'llChongzhinum4'", LinearLayout.class);
    view2131230960 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_chongzhinum5, "field 'llChongzhinum5' and method 'onViewClicked'");
    target.llChongzhinum5 = Utils.castView(view, R.id.ll_chongzhinum5, "field 'llChongzhinum5'", LinearLayout.class);
    view2131230961 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_chongzhinum6, "field 'llChongzhinum6' and method 'onViewClicked'");
    target.llChongzhinum6 = Utils.castView(view, R.id.ll_chongzhinum6, "field 'llChongzhinum6'", LinearLayout.class);
    view2131230962 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  public void unbind() {
    ShopActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.llChongzhinum1 = null;
    target.llChongzhinum2 = null;
    target.llChongzhinum3 = null;
    target.llChongzhinum4 = null;
    target.llChongzhinum5 = null;
    target.llChongzhinum6 = null;

    view2131230957.setOnClickListener(null);
    view2131230957 = null;
    view2131230958.setOnClickListener(null);
    view2131230958 = null;
    view2131230959.setOnClickListener(null);
    view2131230959 = null;
    view2131230960.setOnClickListener(null);
    view2131230960 = null;
    view2131230961.setOnClickListener(null);
    view2131230961 = null;
    view2131230962.setOnClickListener(null);
    view2131230962 = null;

    super.unbind();
  }
}
