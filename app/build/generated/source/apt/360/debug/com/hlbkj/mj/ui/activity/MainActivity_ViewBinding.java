// Generated code from Butter Knife. Do not modify!
package com.hlbkj.mj.ui.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hlbkj.mj.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.rgGroup = Utils.findRequiredViewAsType(source, R.id.rgGroup, "field 'rgGroup'", RadioGroup.class);
    target.rbYuLe = Utils.findRequiredViewAsType(source, R.id.rbYuLe, "field 'rbYuLe'", RadioButton.class);
    target.rbHome = Utils.findRequiredViewAsType(source, R.id.rbHome, "field 'rbHome'", RadioButton.class);
    target.rbMessage = Utils.findRequiredViewAsType(source, R.id.rbMessage, "field 'rbMessage'", RadioButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rgGroup = null;
    target.rbYuLe = null;
    target.rbHome = null;
    target.rbMessage = null;
  }
}
