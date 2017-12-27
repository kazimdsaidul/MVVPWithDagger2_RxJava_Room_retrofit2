package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.base;

import android.app.ProgressDialog;
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
    private ProgressDialog progDailog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent((AppController.getComponent()))
                .build();

        progDailog = new ProgressDialog(this);

    }




    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    public void showProgressBar(){
        if (progDailog!=null){
            progDailog.setMessage("Please wait...");
            progDailog.show();
        }
    }

    public void hiddenProgressDialog(){
        if (progDailog!=null){
            progDailog.dismiss();
        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        if ( progDailog!=null && progDailog.isShowing() ){
            progDailog.cancel();
        }
    }
}
