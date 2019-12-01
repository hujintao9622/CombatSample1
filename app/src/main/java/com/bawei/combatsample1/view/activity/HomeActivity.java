package com.bawei.combatsample1.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.bawei.combatsample1.R;
import com.bawei.combatsample1.base.BaseActivity;
import com.bawei.combatsample1.contract.IHomeContract;
import com.bawei.combatsample1.model.bean.LawyerBean;
import com.bawei.combatsample1.presenter.HomePresenter;
import com.bawei.combatsample1.view.adapter.HomeAdapter;

import java.util.List;

/**
 * 功能：列表展示
 * 作者：胡锦涛
 * 时间：2019年12月1日19:09:29
 */
public class HomeActivity extends BaseActivity {

    private GridView gv;

    @Override
    protected void initData() {
        HomePresenter homePresenter = new HomePresenter();
        homePresenter.getHomeData(new IHomeContract.IView() {
            @Override
            public void onHomeSuccess(LawyerBean lawyerBean) {
                List<LawyerBean.ListdataBean> listdata = lawyerBean.getListdata();
                gv.setAdapter(new HomeAdapter(listdata));
            }

            @Override
            public void onHomeFailure(Throwable e) {
                Toast.makeText(HomeActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void initView() {
        //找控件
        gv = findViewById(R.id.gv);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
}
