package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.repo;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.database.Observable;
import android.util.Log;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.R;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.APIConstant;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.APIService;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.APIResponse;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.Body;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.RequestBody;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Name name on 12/14/2017.
 * company Ltd
 * example@gmail.com
 */


public class RepositoryManager implements Repository {

    private static final String TAG = RepositoryManager.class.getName();

    private Retrofit retrofit;

    final MutableLiveData<APIResponse> data = new MutableLiveData<>();

    @Inject
    public RepositoryManager(Retrofit retrofit) {
        this.retrofit = retrofit;
    }


    @Override
    public LiveData<APIResponse> callApi() {

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



        // start http calling

        retrofit.create(APIService.class).getPosts(requestBody)
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                          .subscribe(this::handleResults, this::handleError);



        return data;
    }

    private void handleError(Throwable throwable) {
        Log.e(TAG, "handleError: ");
    }

    private void handleResults(APIResponse respose) {
        Log.e(TAG, "handleResults: ");
    }
}
