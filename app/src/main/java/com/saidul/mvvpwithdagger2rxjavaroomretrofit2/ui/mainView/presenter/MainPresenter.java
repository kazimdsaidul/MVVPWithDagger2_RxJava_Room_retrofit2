package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView.presenter;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.APIConstant;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.APIResponse;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.Body;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.RequestBody;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.repo.Repository;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.repo.RepositoryManager;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView.view.MainMVPViewController;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView.viewmodel.MainViewModel;

/**
 * Created by Name name on 12/26/2017.
 * company Ltd
 * example@gmail.com
 */
public class MainPresenter {

    MainViewModel mainViewModel;
    Repository repository;
    MainMVPViewController mainViewController;

    public MainPresenter(MainMVPViewController mainViewController, MainViewModel mainViewModel, Repository repository) {
        this.mainViewController = mainViewController;
        this.mainViewModel = mainViewModel;
        this.repository = repository;

        resetData(mainViewController, mainViewModel);

    }

    private void resetData(MainMVPViewController mainViewController, MainViewModel mainViewModel) {
        if (this.mainViewModel.mApiResponse != null) {
            mainViewController.resetData(mainViewModel.mApiResponse);
        }
    }

    public void clickActionButton() {
        mainViewController.showLoading();

        final Body body = new Body();
        body.setFrom("INR");
        body.setTo("LKR");
        body.setAmount("10");

        // make a request body
        final RequestBody requestBody = new RequestBody();
        requestBody.setClientId(APIConstant.CLIENT_ID);
        requestBody.setApiKey(APIConstant.API_KEY);
        requestBody.setAppId(APIConstant.APP_ID);
        requestBody.setMethod(APIConstant.METHOD);
        requestBody.setBody(body);


        repository.callCurrencyConverterAPI(requestBody).observe(this.mainViewController, new Observer<APIResponse>() {
            @Override
            public void onChanged(@Nullable APIResponse apiResponse) {
                if (apiResponse != null) {
                    mainViewController.showAPIRespose(apiResponse);
                    mainViewModel.mApiResponse = apiResponse;

                } else {
                    mainViewController.onError("on error");
                }
                mainViewController.hideLoading();
            }
        });


    }
}
