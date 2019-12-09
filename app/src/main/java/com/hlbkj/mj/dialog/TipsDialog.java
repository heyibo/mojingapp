package com.hlbkj.mj.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.hlbkj.mj.R;
import com.hlbkj.mj.util.ScreenUtils;

/**
 * Created by zd on 16/3/22.
 */
public class TipsDialog {
    private static Dialog dialog;
    private static TipsDialog tipsDialog;

    private static TipsDialog getInstance() {
        if (tipsDialog == null)
            tipsDialog = new TipsDialog();
        return tipsDialog;
    }

    public static TipsDialog createDialog(Context context, int layoutId) {
        getInstance();
        if (dialog != null)
            dialog.dismiss();
        dialog = new Dialog(context, R.style.dialog);
        dialog.setContentView(layoutId);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        return tipsDialog;
    }

    public static TipsDialog createDialog(Context context, int layoutId, int styleIds) {
        getInstance();
        if (dialog != null)
            dialog.dismiss();
        dialog = new Dialog(context, styleIds);
        dialog.setContentView(layoutId);
        return tipsDialog;
    }

    public static TipsDialog createDialog(Context context, View layout) {
        getInstance();
        if (dialog != null)
            dialog.dismiss();
        dialog = new Dialog(context, R.style.dialog);
        dialog.setContentView(layout);
        return tipsDialog;
    }

    public TipsDialog fromBottom() {
        WindowManager.LayoutParams localLayoutParams = dialog.getWindow().getAttributes();
        localLayoutParams.gravity = Gravity.BOTTOM | Gravity.LEFT;
        localLayoutParams.width = ScreenUtils.getScreenWidth();
        localLayoutParams.y = 0;
        localLayoutParams.x = 0;
        dialog.onWindowAttributesChanged(localLayoutParams);
        return tipsDialog;
    }

    public TipsDialog setText(int viewId, String title) {
        if (dialog != null) {
            ((TextView) dialog.findViewById(viewId)).setText(title);
        }
        return tipsDialog;
    }

    public TipsDialog setViewVisible(int viewId, boolean isShow) {
        if (dialog != null) {
            if(isShow){
                (dialog.findViewById(viewId)).setVisibility(View.VISIBLE);
            }else {
                (dialog.findViewById(viewId)).setVisibility(View.GONE);
            }
        }
        return tipsDialog;
    }

    public TipsDialog setViewSelected(int viewId, boolean isShow) {
        if (dialog != null) {
            if(isShow){
                (dialog.findViewById(viewId)).setSelected(true);
            }else {
                (dialog.findViewById(viewId)).setSelected(false);
            }
        }
        return tipsDialog;
    }

    public TipsDialog setViewChecked(int viewId, int viewIdOne) {
        if (dialog != null) {
            ((CheckedTextView)dialog.findViewById(viewId)).setChecked(true);
            dialog.findViewById(viewIdOne).setVisibility(View.VISIBLE);
        }
        return tipsDialog;
    }

    public <T extends View> T getView(int viewId) {
        if (dialog != null) {
            return dialog.findViewById(viewId);
        }
        return null;
    }

    public void show() {
        if (dialog != null)
            dialog.show();
    }

    //通知activity刷新界面
    public void update() {
        if (dialog != null){
            if(null != noticeRefrashViewListener){
                noticeRefrashViewListener.refrashView();
            }
        }
    }

    public void dismiss() {
        if (dialog != null)
            dialog.dismiss();
        tipsDialog = null;
        dialog = null;
    }

    public TipsDialog bindClick(final int viewId, final TipClickListener onClickListener) {
        if (dialog != null) {
            dialog.findViewById(viewId).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickListener != null)
                        onClickListener.onClick(v, TipsDialog.this);
//                    dismiss();
                    switch (v.getId()){
                        case R.id.rl_mygoods:
                            if(null != noticeGoodsDisplayListener){
                                noticeGoodsDisplayListener.displayResult(0,"我的物品");
                            }
                            break;
                        case R.id.rl_newgoods:
                            if(null != noticeGoodsDisplayListener){
                                noticeGoodsDisplayListener.displayResult(1,"最新商品");
                            }
                            break;
                        case R.id.rl_ditogao:
                            if(null != noticeGoodsDisplayListener){
                                noticeGoodsDisplayListener.displayResult(2,"价格低到高");
                            }
                            break;
                        case R.id.rl_gaotodi:
                            if(null != noticeGoodsDisplayListener){
                                noticeGoodsDisplayListener.displayResult(3,"价格高到低");
                            }
                            break;
                        case R.id.ll_jinbinum1:
                            if(null != noticeInvestDisplayListener){
                                noticeInvestDisplayListener.displayInvestResult(0,"(6元)");
                            }
                            break;
                        case R.id.ll_jinbinum2:
                            if(null != noticeInvestDisplayListener){
                                noticeInvestDisplayListener.displayInvestResult(1,"(18元)");
                            }
                            break;
                        case R.id.ll_jinbinum3:
                            if(null != noticeInvestDisplayListener){
                                noticeInvestDisplayListener.displayInvestResult(2,"(30元)");
                            }
                            break;
                        case R.id.ll_jinbinum4:
                            if(null != noticeInvestDisplayListener){
                                noticeInvestDisplayListener.displayInvestResult(3,"(68元)");
                            }
                            break;
                        case R.id.ll_jinbinum5:
                            if(null != noticeInvestDisplayListener){
                                noticeInvestDisplayListener.displayInvestResult(4,"(128元)");
                            }
                            break;
                        case R.id.ll_jinbinum6:
                            if(null != noticeInvestDisplayListener){
                                noticeInvestDisplayListener.displayInvestResult(5,"(298元)");
                            }
                            break;
                    }
                }
            });
        }
        return tipsDialog;
    }

    public TipsDialog OnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        if (dialog != null && onCancelListener != null) {
            dialog.setOnCancelListener(onCancelListener);
        }
        return tipsDialog;
    }

    public interface TipClickListener {
        void onClick(View v, TipsDialog dialog);
    }

    //通知父控件刷新数据
    public interface noticeRefrashView{
        void refrashView();
    }

    private noticeRefrashView noticeRefrashViewListener;

    public void setnoticeRefrashView(noticeRefrashView noticeRefrashViewListener) {
        this.noticeRefrashViewListener = noticeRefrashViewListener;
    }

    //捏脸商品选择回调
    public interface noticeGoodsDisplay{
        void displayResult(int index,String strDisplay);
    }

    private noticeGoodsDisplay noticeGoodsDisplayListener;

    public void setnoticeGoodsDisplay(noticeGoodsDisplay noticeGoodsDisplayListener) {
        this.noticeGoodsDisplayListener = noticeGoodsDisplayListener;
    }

    //金币充值显示回调
    public interface noticeInvestDisplay{
        void displayInvestResult(int index,String strDisplay);
    }

    private noticeInvestDisplay noticeInvestDisplayListener;

    public void setnoticeInvestDisplay(noticeInvestDisplay noticeInvestDisplayListener) {
        this.noticeInvestDisplayListener = noticeInvestDisplayListener;
    }
}
