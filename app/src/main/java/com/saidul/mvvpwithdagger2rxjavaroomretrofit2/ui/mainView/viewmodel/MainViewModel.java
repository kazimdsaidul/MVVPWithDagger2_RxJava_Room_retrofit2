package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.APIResponse;


public class MainViewModel extends ViewModel {
    private static final String TAG = MainViewModel.class.getName();

    public APIResponse mApiResponse;

    public MainViewModel(){

    }


}
