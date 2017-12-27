package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.APIResponse;

/**
 * Created by Name name on 12/26/2017.
 * company Ltd
 * example@gmail.com
 */
public class MainPresenter {

    MainViewModel mainViewModel;
    MainViewController mainViewController;

    public MainPresenter(MainViewController mainViewController, MainViewModel mainViewModel) {
        this.mainViewController = mainViewController;
        this. mainViewModel = mainViewModel;

        this.mainViewModel.getApiRespose().observe( this.mainViewController, new Observer<APIResponse>() {
            @Override
            public void onChanged(@Nullable APIResponse apiResponse) {
                if (apiResponse == null){
                    mainViewController.showError();
                }else {
                    mainViewController.showapAPIResponse(apiResponse);

                }

                mainViewController.hiddenProcessBar();

            }
        });
    }

    public void clickActionButton() {
        mainViewController.showProcessBar();
        mainViewModel.getData();
    }
}
