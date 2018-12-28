package com.example.windows_zxy.six_day3_test.model;

import com.example.windows_zxy.six_day3_test.netWrok.MyAsyncTask;

import java.net.URL;

public class Model implements IModel{
    private InitView initView;

    public Model(InitView initView) {
        this.initView = initView;
    }

    @Override
    public void GetData(String url, String med) {
        new MyAsyncTask<String>(url,med).MyAsyncTask(new MyAsyncTask.DataGet() {
            @Override
            public void setDataTrue(String data) {
                if(data!=null){
                    initView.getViewTrue(data);
                }else{
                    initView.getViewFalse();
                }
            }
        }).execute();
    }
    public interface InitView{
        public void getViewTrue(String data);
        public void getViewFalse();
    }
}
