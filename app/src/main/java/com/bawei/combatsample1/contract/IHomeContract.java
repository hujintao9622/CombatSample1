package com.bawei.combatsample1.contract;

import com.bawei.combatsample1.model.bean.LawyerBean;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2019/12/1 0001 下午 7:16
 */
public interface IHomeContract {
    //m层通知p层的接口
    interface IModelCallback{
        void onHomeSuccess(LawyerBean lawyerBean);
        void onHomeFailure(Throwable e);
    }
    //p层通知V层
    interface IView{
        void onHomeSuccess(LawyerBean lawyerBean);
        void onHomeFailure(Throwable e);
    }
}
