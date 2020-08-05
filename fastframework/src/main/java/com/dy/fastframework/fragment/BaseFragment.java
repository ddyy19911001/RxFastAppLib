package com.dy.fastframework.fragment;

import com.dy.fastframework.view.CommonMsgDialog;

import yin.deng.superbase.fragment.ViewPagerSuperBaseFragment;

public abstract class BaseFragment extends ViewPagerSuperBaseFragment {
    private CommonMsgDialog commonMsgDialog;

    public void showMsgDialog(String msg){
        commonMsgDialog=getCommonMsgDialog();
        commonMsgDialog.showMsg(msg);
    }

    private CommonMsgDialog getCommonMsgDialog() {
        if(commonMsgDialog==null) {
            commonMsgDialog = new CommonMsgDialog(getActivity());
        }
        return commonMsgDialog;
    }

}
