package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.application.AppController;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.di.component.ActivityComponent;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.di.component.DaggerActivityComponent;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.di.module.ActivityModule;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView.MainModelFactory;

import javax.inject.Inject;


/**
 * Created by Name name on 11/30/2017.
 * company Ltd
 * example@gmail.com
 */
public class BaseActivity extends AppCompatActivity {

    public ActivityComponent mActivityComponent;

    @Inject
    MainModelFactory mainModelFactory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent((AppController.getComponent()))
                .build();






    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }
}
