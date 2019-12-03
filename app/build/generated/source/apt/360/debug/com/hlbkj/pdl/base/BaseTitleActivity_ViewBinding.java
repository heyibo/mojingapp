// Generated code from Butter Knife. Do not modify!
package com.hlbkj.pdl.base;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hlbkj.pdl.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BaseTitleActivity_ViewBinding implements Unbinder {
  private BaseTitleActivity target;

  private View view2131230801;

  private View view2131230802;

  private View view2131230803;

  @UiThread
  public BaseTitleActivity_ViewBinding(BaseTitleActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BaseTitleActivity_ViewBinding(final BaseTitleActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btLeft, "method 'leftClick'");
    target.btLeft = Utils.castView(view, R.id.btLeft, "field 'btLeft'", Button.class);
    view2131230801 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.leftClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btRight, "method 'rightClick'");
    target.btRight = Utils.castView(view, R.id.btRight, "field 'btRight'", Button.class);
    view2131230802 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.rightClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btRightOne, "method 'rightClickOne'");
    target.btRightOne = Utils.castView(view, R.id.btRightOne, "field 'btRightOne'", Button.class);
    view2131230803 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.rightClickOne(p0);
      }
    });
    target.tvTitle = Utils.findOptionalViewAsType(source, R.id.tvTitle, "field 'tvTitle'", TextView.class);
    target.rlTitleContainer = Utils.findOptionalViewAsType(source, R.id.rlTitleContainer, "field 'rlTitleContainer'", RelativeLayout.class);
    target.viewTitle = Utils.findRequiredView(source, R.id.view_title, "field 'viewTitle'");
  }

  @Override
  @CallSuper
  public void unbind() {
    BaseTitleActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btLeft = null;
    target.btRight = null;
    target.btRightOne = null;
    target.tvTitle = null;
    target.rlTitleContainer = null;
    target.viewTitle = null;

    view2131230801.setOnClickListener(null);
    view2131230801 = null;
    view2131230802.setOnClickListener(null);
    view2131230802 = null;
    view2131230803.setOnClickListener(null);
    view2131230803 = null;
  }
}
