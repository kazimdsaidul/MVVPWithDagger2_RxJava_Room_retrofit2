package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView;

import android.app.ProgressDialog;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.R;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.APIResponse;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.base.BaseActivity;

import javax.inject.Inject;

import io.reactivex.annotations.Nullable;

public class MainActivity extends BaseActivity implements LifecycleOwner, MainViewController{

    private static final String TAG = MainActivity.class.getName();


    @Inject
    MainModelFactory mainModelFactory;

    MainPresenter mainPresenter;
    private ProgressDialog progDailog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);
        setToolbar();
        setupActionButton();
        setViewModel();




    }

    private void setViewModel() {
        MainViewModel viewModel = createViewModel();
        mainPresenter = new MainPresenter(this, viewModel);
    }

    MainViewModel createViewModel() {
        return ViewModelProviders.of(this, mainModelFactory).get(MainViewModel.class);
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


    @Override
    public void showError() {
        Toast.makeText(getApplicationContext(), "showError", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showapAPIResponse(APIResponse apiResponse) {
        Toast.makeText(getApplicationContext(), ""+apiResponse.getRate(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void noDataFound() {
        Toast.makeText(getApplicationContext(), "No Data found", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProcessBar() {
        showProgressBar();
    }

    @Override
    public void hiddenProcessBar() {
        hiddenProgressDialog();

    }
}
