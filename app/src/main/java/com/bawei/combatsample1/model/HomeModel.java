package com.bawei.combatsample1.model;

import com.bawei.combatsample1.contract.IHomeContract;
import com.bawei.combatsample1.model.bean.LawyerBean;
import com.bawei.combatsample1.util.NetUtils;
import com.google.gson.Gson;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2019/12/1 0001 下午 7:03
 */
public class HomeModel {
    public void getHomeData(final IHomeContract.IModelCallback iModelCallback){
        NetUtils.getInstance().getJson("http://blog.zhaoliang5156.cn/api/news/lawyer.json", new NetUtils.MyBackCall() {
            @Override
            public void onGetJson(String json) {
                //解析
                LawyerBean lawyerBean = new Gson().fromJson(json, LawyerBean.class);
                iModelCallback.onHomeSuccess(lawyerBean);
            }

            @Override
            public void onError(Throwable e) {
                iModelCallback.onHomeFailure(e);
            }
        });
    }
}
