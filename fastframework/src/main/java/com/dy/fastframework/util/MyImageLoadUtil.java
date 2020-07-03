package com.dy.fastframework.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dy.fastframework.R;


public class MyImageLoadUtil {
    public static int mPlaceHolder;
    public static int mErroHolder;
    public static Context mContext;




    private static void checkInit(){
        if(mContext==null){
            throw new IllegalStateException("传入Context为空，请重新传入");
        }
    }



    /**
     *初始化配置之后使用
     * @param view
     * @param picUrl
     */
    public static void loadImage(Context context,ImageView view, String picUrl){
        mContext=context;
        checkInit();
        if(mPlaceHolder!=0&&mErroHolder!=0) {
            Glide.with(mContext).load(picUrl).placeholder(mPlaceHolder).error(mErroHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(view);
        }else if(mPlaceHolder==0&&mErroHolder==0){
            Glide.with(mContext).load(picUrl).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(view);
        }else if(mPlaceHolder==0&&mErroHolder!=0){
            Glide.with(mContext).load(picUrl).error(mErroHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(view);
        }else{
            Glide.with(mContext).load(picUrl).placeholder(mPlaceHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(view);
        }
    }

    public static void loadImage(Context context,ImageView view, int picUrl){
        mContext=context;
        checkInit();
        if(mPlaceHolder!=0&&mErroHolder!=0) {
            Glide.with(mContext).load(picUrl).placeholder(mPlaceHolder).error(mErroHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(view);
        }else if(mPlaceHolder==0&&mErroHolder==0){
            Glide.with(mContext).load(picUrl).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(view);
        }else if(mPlaceHolder==0&&mErroHolder!=0){
            Glide.with(mContext).load(picUrl).error(mErroHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(view);
        }else{
            Glide.with(mContext).load(picUrl).placeholder(mPlaceHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(view);
        }
    }

    public static void loadImageThumb(Context context,ImageView view, int picUrl){
        mContext=context;
        checkInit();
        if(mPlaceHolder!=0&&mErroHolder!=0) {
            Glide.with(mContext).load(picUrl).placeholder(mPlaceHolder).error(mErroHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).override(view.getWidth()).into(view);
        }else if(mPlaceHolder==0&&mErroHolder==0){
            Glide.with(mContext).load(picUrl).diskCacheStrategy(DiskCacheStrategy.RESOURCE).override(view.getWidth()).into(view);
        }else if(mPlaceHolder==0&&mErroHolder!=0){
            Glide.with(mContext).load(picUrl).error(mErroHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).override(view.getWidth()).into(view);
        }else{
            Glide.with(mContext).load(picUrl).placeholder(mPlaceHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).override(view.getWidth()).into(view);
        }
    }

    public static void loadImageThumb(Context context,ImageView view, String picUrl){
        mContext=context;
        checkInit();
        if(mPlaceHolder!=0&&mErroHolder!=0) {
            Glide.with(mContext).load(picUrl).placeholder(mPlaceHolder).error(mErroHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).override(view.getWidth()).into(view);
        }else if(mPlaceHolder==0&&mErroHolder==0){
            Glide.with(mContext).load(picUrl).diskCacheStrategy(DiskCacheStrategy.RESOURCE).override(view.getWidth()).into(view);
        }else if(mPlaceHolder==0&&mErroHolder!=0){
            Glide.with(mContext).load(picUrl).error(mErroHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).override(view.getWidth()).into(view);
        }else{
            Glide.with(mContext).load(picUrl).placeholder(mPlaceHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).override(view.getWidth()).into(view);
        }
    }

    public static void loadImageThumb(Context context,ImageView view, String picUrl, int placeholder){
        mContext=context;
        checkInit();
        if(placeholder!=0){
            mPlaceHolder=placeholder;
            mErroHolder=placeholder;
        }
        if(mPlaceHolder!=0&&mErroHolder!=0) {
            Glide.with(mContext).load(picUrl).placeholder(mPlaceHolder).error(mErroHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).override(view.getWidth()).into(view);
        }else if(mPlaceHolder==0&&mErroHolder==0){
            Glide.with(mContext).load(picUrl).diskCacheStrategy(DiskCacheStrategy.RESOURCE).override(view.getWidth()).into(view);
        }else if(mPlaceHolder==0&&mErroHolder!=0){
            Glide.with(mContext).load(picUrl).error(mErroHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).override(view.getWidth()).into(view);
        }else{
            Glide.with(mContext).load(picUrl).placeholder(mPlaceHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).override(view.getWidth()).into(view);
        }
    }

    public static void loadImageThumb(Context context,ImageView view, String picUrl, int placeholder, int erroHolder){
        mContext=context;
        checkInit();
        if(placeholder!=0){
            mPlaceHolder=placeholder;
            mErroHolder=placeholder;
        }
        if(erroHolder!=0){
            mErroHolder=erroHolder;
        }
        if(mPlaceHolder!=0&&mErroHolder!=0) {
            Glide.with(mContext).load(picUrl).placeholder(mPlaceHolder).error(mErroHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).override(view.getWidth()).into(view);
        }else if(mPlaceHolder==0&&mErroHolder==0){
            Glide.with(mContext).load(picUrl).diskCacheStrategy(DiskCacheStrategy.RESOURCE).override(view.getWidth()).into(view);
        }else if(mPlaceHolder==0&&mErroHolder!=0){
            Glide.with(mContext).load(picUrl).error(mErroHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).override(view.getWidth()).into(view);
        }else{
            Glide.with(mContext).load(picUrl).placeholder(mPlaceHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).override(view.getWidth()).into(view);
        }
    }


    public static void loadImage(Context context,ImageView view, int picUrl, int placeHolder, int erroHolder){
        mContext=context;
        checkInit();
        if(placeHolder!=0&&erroHolder!=0) {
            Glide.with(mContext).load(picUrl).placeholder(placeHolder).error(erroHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(view);
        }else if(placeHolder==0&&erroHolder==0){
            Glide.with(mContext).load(picUrl).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(view);
        }else if(placeHolder==0&&erroHolder!=0){
            Glide.with(mContext).load(picUrl).error(erroHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(view);
        }else{
            Glide.with(mContext).load(picUrl).placeholder(placeHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(view);
        }
    }

    public static void loadImage(Context context,ImageView view, int picUrl, int placeHolder){
        mContext=context;
        checkInit();
        if(placeHolder!=0) {
            Glide.with(mContext).load(picUrl).placeholder(placeHolder).error(placeHolder).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(view);
        }else{
            Glide.with(mContext).load(picUrl).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(view);
        }
    }



}
