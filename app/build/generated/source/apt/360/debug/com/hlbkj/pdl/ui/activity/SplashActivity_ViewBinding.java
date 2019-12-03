// Generated code from Butter Knife. Do not modify!
package com.hlbkj.pdl.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hlbkj.pdl.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SplashActivity_ViewBinding implements Unbinder {
  private SplashActivity target;

  private View view2131231119;

  @UiThread
  public SplashActivity_ViewBinding(SplashActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SplashActivity_ViewBinding(final SplashActivity target, View source) {
    this.target = target;

    View view;
    target.mIvSplash = Utils.findRequiredViewAsType(source, R.id.iv_splash, "field 'mIvSplash'", ImageView.class);
    target.mPbSplash = Utils.findRequiredViewAsType(source, R.id.pb_splash, "field 'mPbSplash'", ProgressBar.class);
    target.mTvLoading = Utils.findRequiredViewAsType(source, R.id.tv_loading, "field 'mTvLoading'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_jump, "field 'mTvJump' and method 'onViewClicked'");
    target.mTvJump = Utils.castView(view, R.id.tv_jump, "field 'mTvJump'", TextView.class);
    view2131231119 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SplashActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mIvSplash = null;
    target.mPbSplash = null;
    target.mTvLoading = null;
    target.mTvJump = null;

    view2131231119.setOnClickListener(null);
    view2131231119 = null;
  }
}
