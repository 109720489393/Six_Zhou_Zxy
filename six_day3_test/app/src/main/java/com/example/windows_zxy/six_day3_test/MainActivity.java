package com.example.windows_zxy.six_day3_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.windows_zxy.six_day3_test.View.IView;
import com.example.windows_zxy.six_day3_test.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements IView {

    private TextView text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_view = findViewById(R.id.text_view);
        Presenter presenter = new Presenter(this);
        presenter.getModelData();
    }

    @Override
    public void getPresenterData(String s) {
        text_view.setText(s);
    }
}
