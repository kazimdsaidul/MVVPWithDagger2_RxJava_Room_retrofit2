package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.APIConstant;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.APIResponse;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.Body;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.RequestBody;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.repo.RepositoryManager;

/**
 * Created by Name name on 12/26/2017.
 * company Ltd
 * example@gmail.com
 */
public class MainPresenter {

    MainViewModel mainViewModel;
    RepositoryManager repository;
    MainViewController mainViewController;

    public MainPresenter(MainViewController mainViewController, MainViewModel mainViewModel, RepositoryManager repository ) {
        this.mainViewController = mainViewController;
        this.mainViewModel = mainViewModel;
        this.repository = repository;

        resetData(mainViewController, mainViewModel);

    }

    private void resetData(MainViewController mainViewController, MainViewModel mainViewModel) {
        if (this.mainViewModel.mApiResponse!=null){
            mainViewController.resetData(mainViewModel.mApiResponse);
        }
    }

    public void clickActionButton() {
        mainViewController.showProcessBar();

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
                   if (apiResponse!=null){

                       mainViewController.showapAPIResponse(apiResponse);
                       mainViewModel.mApiResponse = apiResponse;

                   }else {
                       mainViewController.showError();
                   }
                   mainViewController.hiddenProcessBar();
               }
           });


    }
}
