package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.repo;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.APIService;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.APIResponse;
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


public class RepositoryManager implements Repository {
    private static final String TAG = RepositoryManager.class.getName();

    private Retrofit retrofit;

    @Inject
    public RepositoryManager(Retrofit retrofit)
    {
        this.retrofit = retrofit;
    }

    @Override
    public LiveData<APIResponse> callCurrencyConverterAPI(RequestBody requestBody) {

        final MutableLiveData<APIResponse> liveData = new MutableLiveData<>();

        retrofit.create(APIService.class).getPosts(requestBody).enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                Log.e(TAG, "onResponse: ");
                liveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: ");
                liveData.setValue(null);
            }
        });


        return liveData;
    }


}
