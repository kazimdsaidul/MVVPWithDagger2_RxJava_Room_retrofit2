package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView;

import android.arch.lifecycle.ViewModelProvider;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.repo.MainRepository;

import javax.inject.Inject;

/**
 * Created by Name name on 12/14/2017.
 * company Ltd
 * example@gmail.com
 */
public  class MainModelFactory implements ViewModelProvider.Factory {

    private final MainRepository useCase;

    @Inject
    public MainModelFactory(MainRepository useCase) {
        this.useCase = useCase;
    }

    @Override
    public MainViewModel create(Class modelClass) {
        return new MainViewModel(useCase);
    }
}