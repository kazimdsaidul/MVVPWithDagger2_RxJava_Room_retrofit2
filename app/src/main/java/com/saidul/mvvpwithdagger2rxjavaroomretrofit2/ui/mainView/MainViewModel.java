package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.APIResponse;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.repo.RepositoryManager;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.application.AppController;

import javax.inject.Inject;


public class MainViewModel extends ViewModel {
    private static final String TAG = MainViewModel.class.getName();
    private RepositoryManager repositoryManager;

    MutableLiveData<APIResponse> apiRespose = new MutableLiveData<>();


    public MainViewModel() {
        this(null);
        AppController.getComponent().inject(this);


        Log.e(TAG, "MainViewModel: ");

    }

    @Inject
    public MainViewModel(RepositoryManager repositoryManager) {
        this.repositoryManager = repositoryManager;
        Log.e(TAG, "MainViewModel: ");

    }


    public void clickActionButton() {

        //repositoryManager.callApi();
       apiRespose.setValue(new APIResponse());
    }


    public LiveData<APIResponse> getObservableProduct() {
        return apiRespose;
    }
}
