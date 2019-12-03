// Generated code from Butter Knife. Do not modify!
package com.hlbkj.pdl.fragment;

import android.support.annotation.UiThread;
import android.view.View;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hlbkj.pdl.R;
import com.hlbkj.pdl.base.BaseTitleFragment_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragment_ViewBinding extends BaseTitleFragment_ViewBinding {
  private HomeFragment target;

  private View view2131231105;

  @UiThread
  public HomeFragment_ViewBinding(final HomeFragment target, View source) {
    super(target, source);

    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tvClick, "method 'click'");
    view2131231105 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.click();
      }
    });
  }

  @Override
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131231105.setOnClickListener(null);
    view2131231105 = null;

    super.unbind();
  }
}
