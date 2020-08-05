package com.dy.fastframework.activity;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;

import com.dy.fastframework.R;
import com.dy.fastframework.view.CommonMsgDialog;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.config.HttpGlobalConfig;

import yin.deng.superbase.activity.SuperBaseActivity;

public abstract class BaseActivity extends SuperBaseActivity {
    private CommonMsgDialog commonMsgDialog;

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

    public void showMsgDialog(String msg){
        commonMsgDialog=getCommonMsgDialog();
        commonMsgDialog.showMsg(msg);
    }

    private CommonMsgDialog getCommonMsgDialog() {
        if(commonMsgDialog==null) {
            commonMsgDialog = new CommonMsgDialog(this);
        }
        return commonMsgDialog;
    }


    /**
     *
     * @param statubarBackGroundColor  状态栏背景色
     * @param isStatusTextWhite  状态栏文字是否为白色
     */
    public void changeStatustBarColor(int statubarBackGroundColor,boolean isStatusTextWhite){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 设置状态栏底色白色
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(statubarBackGroundColor);
            // 设置状态栏字体颜色
            if(isStatusTextWhite){
                //白色
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            }else{
                //黑色
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }

        }
    }
}
