package com.hlbkj.pdl.alipay;

/**
 * Created by 傅令杰
 */

public interface IAlAutherResultListener {

    void onPaySuccess(String authercode);

    void onPaying();

    void onPayFail();

    void onPayCancel();

    void onPayConnectError();
}
