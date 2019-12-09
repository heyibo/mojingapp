package com.hlbkj.mj.wxapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hlbkj.mj.MyApplication;
import com.hlbkj.mj.util.ToastUtils;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public class WXPayEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {

	private static final int WX_PAY_SUCCESS = 0;
	private static final int WX_PAY_FAIL = -1;
	private static final int WX_PAY_CANCEL = -2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		MyApplication.getApplication().wxApi.handleIntent(getIntent(),this);
    }

	@Override
	public void onReq(BaseReq req) {
	}

	@Override
	public void onResp(BaseResp baseResp) {

		if (baseResp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
			/*
			* 发起支付调用的页面，然后及时finish掉这个页面
			* */
			switch (baseResp.errCode) {
				case WX_PAY_SUCCESS:
					ToastUtils.showShort("支付成功");
					finish();
					overridePendingTransition(0, 0);
					break;
				case WX_PAY_FAIL:
					ToastUtils.showShort("支付失败");
					finish();
					overridePendingTransition(0,0);
					break;
				case WX_PAY_CANCEL:
					ToastUtils.showShort("支付取消");
					finish();
					overridePendingTransition(0,0);
					break;
				default:
					break;
			}
		}
	}
}