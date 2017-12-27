package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.APIResponse;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.application.AppController;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.di.component.ActivityComponent;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.di.component.DaggerActivityComponent;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.di.module.ActivityModule;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.repo.RepositoryManager;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView.view.MainMVPViewController;

import javax.inject.Inject;


/**
 * Created by Name name on 11/30/2017.
 * company Ltd
 * example@gmail.com
 */
public class BaseActivity extends AppCompatActivity  {

    public ActivityComponent mActivityComponent;
    private ProgressDialog progDailog;

    @Inject
    public RepositoryManager repositoryManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initilizationDagger2PerActivity();

        progDailog = new ProgressDialog(this);

    }

    private void initilizationDagger2PerActivity() {
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent((AppController.getComponent()))
                .build();


    }

    public void showprogessdialog() {
        if (progDailog != null) {
            progDailog.setMessage("Please wait...");
            progDailog.show();
        }
    }

    public void hiddenProgressDialog() {
        if (progDailog != null) {
            progDailog.dismiss();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (progDailog != null && progDailog.isShowing()) {
            progDailog.cancel();
        }
    }




}
