package com.example.windows_zxy.six_day3_test.presenter;

import com.example.windows_zxy.six_day3_test.MainActivity;
import com.example.windows_zxy.six_day3_test.model.Model;

public class Presenter implements IPresenter, Model.InitView {
    MainActivity mview;
    private final Model model;

    public Presenter(MainActivity mainActivity) {
        this.mview=mainActivity;
        model = new Model(this);
    }

    @Override
    public void getModelData() {
        model.GetData("http://120.27.23.105/product/getProducts?pscid=39&page=1","GET");
    }

    @Override
    public void getViewTrue(String data) {
        mview.getPresenterData(data);
    }

    @Override
    public void getViewFalse() {
        mview.getPresenterData("没有数据");
    }
}
