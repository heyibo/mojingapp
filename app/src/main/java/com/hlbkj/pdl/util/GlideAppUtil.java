package com.hlbkj.pdl.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.hlbkj.pdl.GlideApp;
import com.hlbkj.pdl.callback.GlideCallBack;

/**
 * 图片工具类
 */
public class GlideAppUtil {

    /**
     * 加载图片
     *
     * @param mContext 上下文
     * @param url      图片地址
     * @param view     展示测容器
     */
    public static void loadImage(Context mContext, String url, ImageView view) {
        loadImage(mContext, url, view, -1);
    }

    /**
     * 加载图片
     *
     * @param mContext    上下文
     * @param url         图片地址
     * @param view        展示测容器
     * @param placeHolder 占位图
     */
    public static void loadImage(Context mContext, String url, ImageView view, int placeHolder) {
        GlideApp.with(mContext)
                .asBitmap()
                .load(url)
                .placeholder(placeHolder)
                .into(view);
    }

    /**
     * 加载图片
     *
     * @param mContext 上下文
     * @param url      图片地址
     * @param view     展示测容器
     * @param callBack 回调
     */
    public static void loadImage(Context mContext, String url, ImageView view, final GlideCallBack callBack) {
        GlideApp.with(mContext)
                .asBitmap()
                .load(url)
                .addListener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        callBack.failed();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                        callBack.success();
                        return false;
                    }
                })
                .into(view);
    }

    /**
     * 加载图片
     *
     * @param mContext 上下文
     * @param resId    图片地址
     * @param view     展示测容器
     */
    public static void loadImage(Context mContext, int resId, ImageView view) {
        GlideApp.with(mContext)
                .asBitmap()
                .load(resId)
                .into(view);
    }

    /**
     * 加载图片
     *
     * @param mContext 上下文
     * @param url      图片地址
     * @param view     展示测容器
     * @param corner   圆角
     */
    public static void loadCornerImage(Context mContext, String url, ImageView view, int corner) {
        loadCornerImage(mContext, url, view, corner, -1);
    }

    /**
     * 加载图片
     *
     * @param mContext    上下文
     * @param url         图片地址
     * @param view        展示测容器
     * @param corner      圆角
     * @param placeHolder 占位图
     */
    public static void loadCornerImage(Context mContext, String url, ImageView view, int corner, int placeHolder) {
        GlideApp.with(mContext)
                .asBitmap()
                .load(url)
                .placeholder(placeHolder)
                .transform(new RoundedCorners(ScreenUtils.dp2px(mContext, corner)))
                .into(view);
    }
}
