package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView;

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

public class MainActivity extends BaseActivity implements LifecycleOwner {

    private static final String TAG = MainActivity.class.getName();
    MainViewModel mainViewModel;

    @Inject
    MainModelFactory mainModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);
        setToolbar();
        setupActionButton();
        setViewModel();
        subscribeDataStreams(mainViewModel);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    private void setViewModel() {
        mainViewModel = createViewModel();
        Log.e(TAG, "setViewModel: ");

    }

    MainViewModel createViewModel() {
        return ViewModelProviders.of(this, mainModelFactory)
                .get(MainViewModel.class);
    }

    private void subscribeDataStreams(MainViewModel mainViewModel) {
        mainViewModel.getApiRespose().observe(this, apiResponse -> {
            Log.e(TAG, "onChanged: ");
            if (apiResponse.getError() != null) {
                handleError(apiResponse.getError());
            } else {
                handleResponse(apiResponse);
            }
        });
    }

    private void handleResponse(APIResponse apiResponse) {
        Toast.makeText(getApplicationContext(), ""+apiResponse.getRate(), Toast.LENGTH_LONG).show();
    }

    private void handleError(Throwable error) {
        Toast.makeText(getApplicationContext(), ""+error, Toast.LENGTH_LONG).show();
    }


    private void setupActionButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mainViewModel.clickActionButton();
            }
        });
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


}
