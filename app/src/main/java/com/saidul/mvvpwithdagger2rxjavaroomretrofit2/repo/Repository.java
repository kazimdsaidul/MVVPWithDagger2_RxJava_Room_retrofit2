package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.repo;

import android.arch.lifecycle.LiveData;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.APIResponse;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.RequestBody;

/**
 * Created by Name name on 12/14/2017.
 * company Ltd
 * example@gmail.com
 */
public interface Repository {
    public LiveData<APIResponse> callCurrencyConverterAPI(RequestBody requestBody);

}
