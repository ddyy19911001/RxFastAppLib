package com.dy.fastframework.application;

import android.app.Application;
import android.content.Context;


import com.dy.fastframework.R;
import com.dy.fastframework.erro.CrashHandler;
import com.dy.fastframework.util.MyImageLoadUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.viewimpl.MyFooterView;
import com.scwang.smartrefresh.layout.viewimpl.MyHeaderView;
import com.vise.xsnow.common.ViseConfig;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.config.HttpGlobalConfig;
import com.vise.xsnow.http.exception.ApiException;
import com.vise.xsnow.http.exception.IBaseRequestErroLitener;

import yin.deng.normalutils.utils.LogUtils;
import yin.deng.normalutils.utils.SharedPreferenceUtil;


public abstract class SuperBaseApp extends Application {
    private static SharedPreferenceUtil util;
    public static SuperBaseApp app;
    public static int requestWaitShowDialogTimeOut=8;//请求发出后几秒显示转圈等待
    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler.getInstance().init(this);
        app=this;
        //默认开启打印
        initDebugMode(!closeDebugLog());
        initImgLoadSetting();
        initRefreshHeadAndFooter();
        initViseHttp();
        util=new SharedPreferenceUtil(this, getApplicationInfo().packageName);
    }

    public static void setRequestWaitShowDialogTimeOut(int requestWaitShowDialogTimeOut) {
        SuperBaseApp.requestWaitShowDialogTimeOut = requestWaitShowDialogTimeOut;
    }

    public void initViseHttp() {
        //初始化请求工具
        ViseHttp.init(this,setBaseUrl());
        ViseHttp.CONFIG().setNeedShowLoading(needShowLoadingWhenRequestLongTime());
        ViseHttp.CONFIG().setTotalTime(requestWaitShowDialogTimeOut);
    }


    /**
     * 是否需要显示loading的转圈在
     * @return
     */
    public boolean needShowLoadingWhenRequestLongTime(){
        return true;
    }


    /**
     * 设置服务器请求主机地址
     * @return
     */
    protected abstract String setBaseUrl();


    /**
     * 可以指定全局header和footer
     */
    public static void initRefreshHeadAndFooter(){
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
                @Override
                public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                    layout.setEnableOverScrollBounce(false);
                    layout.setEnableScrollContentWhenLoaded(true);//是否在加载完成时滚动列表显示新的内容
                    layout.setEnableOverScrollDrag(true);//是否启用越界拖动（仿苹果效果）1.0.4
                    layout.setPrimaryColorsId(R.color.normal_bg, R.color.normal_4a);//全局设置主题颜色
                    MyHeaderView head = new MyHeaderView(context);
                    return head;//指定为经典Header，默认是 贝塞尔雷达Header
                }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
                @Override
                public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                    //指定为经典Footer，默认是 BallPulseFooter
                    layout.setPrimaryColorsId(R.color.normal_bg, R.color.normal_4a);//全局设置主题颜色
                    MyFooterView footer = new MyFooterView(context);
                    return footer;
                }
        });
    }


    /**
     * 图片加载器初始化
     */
    protected  void initImgLoadSetting(){
        MyImageLoadUtil.mPlaceHolder= R.drawable.ic_default_erro_img;
        MyImageLoadUtil.mErroHolder= R.drawable.ic_default_erro_img;
    }


    public static SharedPreferenceUtil getSharedPreferenceUtil(){
        return util;
    }


    /**
     * 是否不开启debug的Log,release自动关闭log
     * @return
     */
    public abstract boolean closeDebugLog();

    /**
     * 设置日志打印，在正式环境中不显示
     */
    public void initDebugMode(boolean isDebug) {
        yin.deng.normalutils.utils.LogUtils.allowV= isDebug;
        yin.deng.normalutils.utils.LogUtils.allowD= isDebug;
        yin.deng.normalutils.utils.LogUtils.allowE= isDebug;
        yin.deng.normalutils.utils.LogUtils.allowI= isDebug;
        yin.deng.normalutils.utils.LogUtils.allowW= isDebug;

        yin.deng.superbase.activity.LogUtils.allowV= isDebug;
        yin.deng.superbase.activity.LogUtils.allowD= isDebug;
        yin.deng.superbase.activity.LogUtils.allowE= isDebug;
        yin.deng.superbase.activity.LogUtils.allowI= isDebug;
        yin.deng.superbase.activity.LogUtils.allowW= isDebug;

        me.jessyan.autosize.utils.LogUtils.setDebug(isDebug);
    }
}
