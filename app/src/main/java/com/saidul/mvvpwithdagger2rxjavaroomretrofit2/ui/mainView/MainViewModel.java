package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
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

   public MutableLiveData<APIResponse> apiRespose= new MutableLiveData<>();;


    public MainViewModel() {
        this(null);
        Log.e(TAG, "MainViewModel: ");

    }

    @Inject
    public MainViewModel(RepositoryManager repositoryManager) {
        this.repository = repositoryManager;
        Log.e(TAG, "MainViewModel: ");

    }


    public void clickActionButton() {


        apiRespose.setValue(repository.callApi().getValue());
        Log.e(TAG, "clickActionButton: ");

    }


    public LiveData<APIResponse> getApiRespose() {

        return this.apiRespose;


    }
}
