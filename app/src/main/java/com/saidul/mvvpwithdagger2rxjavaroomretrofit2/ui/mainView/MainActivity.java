package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.R;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.base.BaseActivity;

import javax.inject.Inject;

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
    }

    private void setViewModel() {
        mainViewModel = createViewModel();
        Log.e(TAG, "setViewModel: ");


    }

    MainViewModel createViewModel() {
        return ViewModelProviders.of(this, mainModelFactory)
                .get(MainViewModel.class);
    }

    private void setupActionButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


}
