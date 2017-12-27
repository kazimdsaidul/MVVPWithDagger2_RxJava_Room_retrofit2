package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView;

import android.arch.lifecycle.LifecycleOwner;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.APIResponse;

/**
 * Created by Name name on 12/26/2017.
 * company Ltd
 * example@gmail.com
 */
public interface MainViewController extends LifecycleOwner {
    public void showError();
    public void showapAPIResponse(APIResponse apiResponse);

    void noDataFound();

    void showProcessBar();

    void hiddenProcessBar();

    void resetData(APIResponse mainViewModel);
}
