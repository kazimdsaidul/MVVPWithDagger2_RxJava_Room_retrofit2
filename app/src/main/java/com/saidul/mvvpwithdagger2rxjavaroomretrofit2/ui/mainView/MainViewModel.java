package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.APIResponse;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.repo.Repository;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.repo.RepositoryManager;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.application.AppController;

import javax.inject.Inject;

import retrofit2.Response;


public class MainViewModel extends ViewModel {
    private static final String TAG = MainViewModel.class.getName();
    private RepositoryManager repository;

    private MediatorLiveData<APIResponse> mApiResponse = new MediatorLiveData<>();;


    public MainViewModel() {
        this(null);
        Log.e(TAG, "MainViewModel: ");

    }

    @Inject
    public MainViewModel(RepositoryManager repositoryManager) {
        this.repository = repositoryManager;
        Log.e(TAG, "MainViewModel: ");

    }


    public void getData() {


        mApiResponse.addSource(repository.callApi(), apiResponse -> {
            mApiResponse.setValue(apiResponse);



        });
        Log.e(TAG, "getData: ");

    }

    @NonNull
    public LiveData<APIResponse> getApiRespose() {

        return this.mApiResponse;


    }
}
