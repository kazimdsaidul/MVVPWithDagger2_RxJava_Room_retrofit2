package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView.ui;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.R;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.APIResponse;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.base.BaseActivity;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.di.component.ActivityComponent;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView.presenter.MainPresenter;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView.view.MainMVPViewController;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity implements LifecycleOwner, MainMVPViewController {

    private static final String TAG = MainActivity.class.getName();
    MainPresenter mainPresenter;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniitilization();

        getActivityComponent().inject(this);

        setToolbar();
        setupActionButton();
        setViewModel();


    }

    private void iniitilization() {
        textView =  findViewById(R.id.textView);
    }

    private void setViewModel() {
        MainViewModel viewModel = createViewModel();
        mainPresenter = new MainPresenter(this, viewModel, repositoryManager);
    }

    MainViewModel createViewModel() {
        return ViewModelProviders.of(this).get(MainViewModel.class);
    }

    private void setupActionButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mainPresenter.clickActionButton();

            }
        });
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }





    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    @Override
    public void showLoading() {
        showprogessdialog();
    }

    @Override
    public void hideLoading() {
            hiddenProgressDialog();
    }

    @Override
    public void onError(int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(int resId) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void hideKeyboard() {

    }

    @Override
    public void showAPIRespose(APIResponse apiResponse) {
       textView.setText(String.format("%s", apiResponse.getRate()));
    }

    @Override
    public void resetData(APIResponse apiResponse) {
        textView.setText(String.format("reset %s", apiResponse.getRate()));
    }
}
