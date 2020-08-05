package com.dy.fastframework.activity;

import com.dy.fastframework.R;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.config.HttpGlobalConfig;

import yin.deng.superbase.activity.SuperBaseActivity;

public abstract class BaseActivity extends SuperBaseActivity {
    @Override
    public void onNotInitFirst() {
        ViseHttp.CONFIG().setOnRequestWatingDialogListener(new HttpGlobalConfig.OnRequestWatingDialogListener() {
            @Override
            public void onTimeOverToShowLoading() {
                showLoadingDialog(getResources().getString(R.string.loading), true);
            }

            @Override
            public void onRequestOverLoadingNeedClose() {
                closeDialog();
            }
        });
        super.onNotInitFirst();
    }
}
