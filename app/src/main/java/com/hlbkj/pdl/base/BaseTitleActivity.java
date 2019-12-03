package com.hlbkj.pdl.base;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hlbkj.pdl.R;
import com.hlbkj.pdl.constant.SpConstant;
import com.hlbkj.pdl.ui.activity.LoginActivity;
import com.hlbkj.pdl.util.StatusBarUtil;
import com.hlbkj.pdl.util.ToastUtils;
import com.hlbkj.pdl.util.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public abstract class BaseTitleActivity<T extends BasePersistent> extends BaseActivity<T> {
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
    @BindView(R.id.view_title)
    View viewTitle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //容器
        ViewGroup contentView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.activity_base, null);
        setContentView(contentView);
        StatusBarUtil.setTranslucentForImageView(this, 0, null);
        //添加新主体容器
        View childView = LayoutInflater.from(this).inflate(setBodyId(), contentView, false);
        contentView.addView(childView);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childView.getLayoutParams();
        layoutParams.weight = 1;
        //绑定ui
        bind = ButterKnife.bind(this, contentView);
        initView();
        Utils.setStatusTextColor(true, BaseTitleActivity.this);//黑色
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
            finish();
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

    /*
   * 设置控件是否隐藏
   * */
    protected void setTitleViewVisible(boolean isView) {
        if (viewTitle != null) {
            if(isView){
                viewTitle.setVisibility(View.VISIBLE);
            }else {
                viewTitle.setVisibility(View.GONE);
            }
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
                    (resId == -1 ? null : ContextCompat.getDrawable(this, resId),
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
     * 设置标题文字和颜色
     *
     * @param word 文字
     */
    protected void setTitleColor(String word, int colorId) {
        if (tvTitle != null) {
            tvTitle.setText(word);
            tvTitle.setTextColor(getResources().getColor(colorId));
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
                            resId == -1 ? null : ContextCompat.getDrawable(this, resId),
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
                            resId == -1 ? null : ContextCompat.getDrawable(this, resId),
                            null);
        }
    }

    /**
     * 设置背景颜色
     *
     * @param color
     */
    protected void setTitleBackgroundColor(int color) {
        if (rlTitleContainer != null)
            rlTitleContainer.setBackgroundColor(color);
    }

    public abstract int setBodyId();

    /**
     * 点击空白区域隐藏键盘.
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent me) {
        if (me.getAction() == MotionEvent.ACTION_DOWN) {  //把操作放在用户点击的时候
            View v = getCurrentFocus();      //得到当前页面的焦点,ps:有输入框的页面焦点一般会被输入框占据
            if (isShouldHideKeyboard(v, me)) { //判断用户点击的是否是输入框以外的区域
                hideKeyboard(v.getWindowToken());   //收起键盘
            }
        }
        return super.dispatchTouchEvent(me);
    }

    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时则不能隐藏
     *
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideKeyboard(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {  //判断得到的焦点控件是否包含EditText
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0],    //得到输入框在屏幕中上下左右的位置
                    top = l[1],
                    bottom = top + v.getHeight(),
                    right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击位置如果是EditText的区域，忽略它，不收起键盘。
                return false;
            } else {
                return true;
            }
        }
        // 如果焦点不是EditText则忽略
        return false;
    }

    /**
     * 获取InputMethodManager，隐藏软键盘
     *
     * @param token
     */
    private void hideKeyboard(IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token, InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    protected void startTargeActivity() {
        if (getIntent().getExtras() != null && getIntent().getExtras().getString(SpConstant.CLASS_NAME) != null) {
            String className = getIntent().getExtras().getString(SpConstant.CLASS_NAME);
            getIntent().removeExtra(SpConstant.CLASS_NAME);
            if (className != null && !className.equals(context.getClass().getName())) {
                try {
                    ComponentName componentName = new ComponentName(context, Class.forName(className));
                    startActivity(getIntent().setComponent(componentName));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        finish();
    }

    public void startActivityAfterLogin(Intent intent) {
        //未登录（这里用自己的登录逻辑去判断是否未登录）
        if (!getUserInfo().isLogin()) {
            ComponentName componentName = new ComponentName(context, LoginActivity.class);
            intent.putExtra(SpConstant.CLASS_NAME, intent.getComponent().getClassName());
            intent.setComponent(componentName);
            super.startActivity(intent);
        } else {
            super.startActivity(intent);
        }
    }

    public void doCall(String phone) {
        //拨打电话前先检测是否插入运营商卡
        TelephonyManager telManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String operator = telManager.getSimOperator();
        if (operator != null) {
//                            if(operator.equals("46000") || operator.equals("46002")){
//                                //中国移动
//                            }else if(operator.equals("46001")){
//                                //中国联通
//                            }else if(operator.equals("46003")){
//                                //中国电信
//                            }
            if (!TextUtils.isEmpty(phone)) {
                if (!hasPermission()) {
                    // 在6.0 系统中请求某些权限需要检查权限
                    int curApiVersion = Build.VERSION.SDK_INT;
                    if (curApiVersion >= Build.VERSION_CODES.M) {
                        // 动态请求拨打电话权限
                        requestPermissions(
                                new String[]{Manifest.permission.CALL_PHONE},
                                0x11);
                    } else {
                        if (null != phone && !"null".equals(phone) && !"NULL".equals(phone) && phone.length() > 0) {
                            intentToCall(phone);
                        } else {
                            ToastUtils.showShort("您拨打的号码不正确");
                        }
                    }
                } else {
                    if (null != phone && !"null".equals(phone) && !"NULL".equals(phone) && phone.length() > 0) {
                        intentToCall(phone);
                    } else {
                        ToastUtils.showShort("您拨打的号码不正确");
                    }
                }
            }
        } else {
            ToastUtils.showShort("您还未插入手机运营商卡，请先插入运营商卡");
        }
    }

    @SuppressLint("NewApi")
    private boolean hasPermission() {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        return true;
    }

    @SuppressLint("MissingPermission")
    public void intentToCall(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + phoneNumber);
        intent.setData(data);
        startActivity(intent);
    }
}
