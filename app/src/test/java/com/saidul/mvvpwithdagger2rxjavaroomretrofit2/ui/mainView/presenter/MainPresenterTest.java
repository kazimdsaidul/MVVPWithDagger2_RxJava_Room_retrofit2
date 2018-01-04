package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView.presenter;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.repo.Repository;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView.view.MainMVPViewController;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView.viewmodel.MainViewModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Created by Name name on 12/27/2017.
 * company Ltd
 * example@gmail.com
 */
public class MainPresenterTest {

    @Mock
    MainViewModel mainViewModel;

    @Mock
    Repository repository;
    @Mock
    MainMVPViewController mainViewController;

    @Before
    public void setUp() throws Exception {
        mainViewController = Mockito.mock(MainMVPViewController.class);


    }


    @Test
    public void clickActionButton() throws Exception {



    }

}