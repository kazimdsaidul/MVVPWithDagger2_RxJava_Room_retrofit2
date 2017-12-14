package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.repo;

import android.util.Log;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.APIConstant;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.APIService;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.APIResponse;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.Body;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.RequestBody;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Name name on 12/14/2017.
 * company Ltd
 * example@gmail.com
 */
public class RepositoryManager implements  Repository {

    private static final String TAG = RepositoryManager.class.getName();

    private Retrofit retrofit;

    @Inject
    public RepositoryManager(Retrofit retrofit){

        this.retrofit = retrofit;
    }


    @Override
    public void callApi() {

        Body body = new Body();
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


        retrofit.create(APIService.class).getPosts(requestBody).enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                Log.e(TAG, "onResponse: ");
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: ");
            }
        });
    }
}
