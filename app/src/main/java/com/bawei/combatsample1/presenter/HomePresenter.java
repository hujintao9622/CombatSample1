package com.bawei.combatsample1.presenter;

import com.bawei.combatsample1.contract.IHomeContract;
import com.bawei.combatsample1.model.HomeModel;
import com.bawei.combatsample1.model.bean.LawyerBean;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2019/12/1 0001 下午 7:09
 */
public class HomePresenter {
    public void getHomeData(final IHomeContract.IView iView){
        HomeModel homeModel = new HomeModel();
        homeModel.getHomeData(new IHomeContract.IModelCallback() {
            @Override
            public void onHomeSuccess(LawyerBean lawyerBean) {
                iView.onHomeSuccess(lawyerBean);
            }

            @Override
            public void onHomeFailure(Throwable e) {
                iView.onHomeFailure(e);
            }
        });
    }
}
