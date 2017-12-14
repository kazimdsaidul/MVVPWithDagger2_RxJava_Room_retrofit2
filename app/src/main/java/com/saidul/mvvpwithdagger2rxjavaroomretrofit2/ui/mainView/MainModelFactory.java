package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView;

import android.arch.lifecycle.ViewModelProvider;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.repo.RepositoryManager;

import javax.inject.Inject;

/**
 * Created by Name name on 12/14/2017.
 * company Ltd
 * example@gmail.com
 */
public  class MainModelFactory implements ViewModelProvider.Factory {

    private final RepositoryManager useCase;

    @Inject
    public MainModelFactory(RepositoryManager useCase) {
        this.useCase = useCase;
    }

    @Override
    public MainViewModel create(Class modelClass) {
        return new MainViewModel(useCase);
    }
}