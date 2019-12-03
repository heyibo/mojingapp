package com.hlbkj.pdl.net;

import com.hlbkj.pdl.net.model.bean.BannerBean;
import com.hlbkj.pdl.net.model.bean.ResponseBean;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Api {
    //参数为key - value形式的样例
    //获取banner
    @FormUrlEncoded
    @POST("System/GetBanner")
    Observable<BaseResponse<List<BannerBean>>> getBanner(@Field("key") String key, @Field("type") int type);

    //参数为json形式的样例
    //获取车源列表
    @POST("api/carSource/openCarSourcePage")
    Observable<BaseResponse<BannerBean>> getCheYuanList(@Body ResponseBean getcheyuanlist);

    //上传单张图片
    @Multipart
    @POST("upload")
    Observable<BaseResponse<BannerBean>> uploadSingleImg(@Part MultipartBody.Part file);

    //上传多张图片
    @Multipart
    @POST("upload")
    Observable<BaseResponse<BannerBean>> uploadMulteImg(@Part MultipartBody.Part[] parts);
}
