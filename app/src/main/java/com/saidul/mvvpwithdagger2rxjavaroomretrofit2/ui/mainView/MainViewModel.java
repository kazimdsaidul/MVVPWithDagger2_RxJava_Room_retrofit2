package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.repo.MainRepository;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.application.AppController;

import javax.inject.Inject;


public class MainViewModel extends ViewModel {
    private static final String TAG = MainViewModel.class.getName();
    private MainRepository mainRepository;


    public MainViewModel() {
        this(null);
        AppController.getComponent().inject(this);


        Log.e(TAG, "MainViewModel: ");

    }

    @Inject
    public MainViewModel(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
        Log.e(TAG, "MainViewModel: ");

    }


}
