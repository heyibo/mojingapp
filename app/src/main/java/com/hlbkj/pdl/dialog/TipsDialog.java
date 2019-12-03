package com.hlbkj.pdl.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.hlbkj.pdl.R;
import com.hlbkj.pdl.util.ScreenUtils;

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
}
