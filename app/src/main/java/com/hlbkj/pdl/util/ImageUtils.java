package com.hlbkj.pdl.util;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.View;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.hlbkj.pdl.GlideApp;

import java.io.File;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Consumer;

/**
 * Created by 47804 on 2019/9/3.
 */

public class ImageUtils {
    /**
     * View to bitmap.
     *
     * @param view The view.
     * @return bitmap
     */
    public static Bitmap view2Bitmap(final View view) {
        if (view == null)
            return null;
        Bitmap ret = Bitmap.createBitmap(view.getWidth(),
                view.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(ret);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null) {
            bgDrawable.draw(canvas);
        } else {
            canvas.drawColor(Color.WHITE);
        }
        view.draw(canvas);
        return ret;
    }

    /**
     * 保存图片到本地
     *
     * @param context
     * @param imagePath
     */
    public static void saveImageToLocal(final Context context, final String imagePath){
        Flowable.create(new FlowableOnSubscribe<File>() {
            @Override
            public void subscribe(FlowableEmitter<File> e) throws Exception {
                e.onNext(GlideApp.with(context).asFile()
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                        .load(imagePath)
                        .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                        .get());
                e.onComplete();
            }
        },BackpressureStrategy.BUFFER)
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(io.reactivex.schedulers.Schedulers.newThread())
                .subscribe(new Consumer<File>() {
                    @Override
                    public void accept(File file) {
                        try{
                            //系统相册目录
                            File appDir = new File(Environment.getExternalStorageDirectory()
                                    + File.separator + Environment.DIRECTORY_DCIM
                                    +File.separator+"Camera"+File.separator);
                            if (!appDir.exists()) {
                                appDir.mkdirs();
                            }
                            String fileName = System.currentTimeMillis() + ".jpg";
                            File destFile = new File(appDir, fileName);
                            //把gilde下载得到图片复制到定义好的目录中去
                            if (FileUtils.copyFile(file, destFile)){
                                //插入刷新本地图库
                                ContentValues values = new ContentValues(2);
                                values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
                                values.put(MediaStore.Images.Media.DATA, destFile.getAbsolutePath());
                                context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                                Looper.prepare();
                                ToastUtils.showShort("保存成功");
                                Looper.loop();
                            }else {
                                Looper.prepare();
                                ToastUtils.showShort("保存失败");
                                Looper.loop();
                            }
                        }catch (Exception e){
                            Looper.prepare();
                            ToastUtils.showShort("保存失败");
                            Looper.loop();
                        }
                    }
                });
    }
}
