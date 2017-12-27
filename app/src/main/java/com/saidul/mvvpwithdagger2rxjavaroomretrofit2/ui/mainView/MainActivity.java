package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView;

import android.app.ProgressDialog;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.R;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.APIResponse;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.base.BaseActivity;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.repo.RepositoryManager;

import org.w3c.dom.Text;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class MainActivity extends BaseActivity implements LifecycleOwner, MainViewController{

    private static final String TAG = MainActivity.class.getName();




    MainPresenter mainPresenter;
    private ProgressDialog progDailog;

    @Inject
    Retrofit retrofit;


    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =(TextView) findViewById(R.id.textView);

        getActivityComponent().inject(this);
        setToolbar();
        setupActionButton();
        setViewModel();






    }

    private void setViewModel() {
        MainViewModel viewModel = createViewModel();
        mainPresenter = new MainPresenter(this, viewModel,new RepositoryManager(retrofit));
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


    @Override
    public void showError() {

        textView.setText("showError");
    }

    @Override
    public void showapAPIResponse(APIResponse apiResponse) {
        textView.setText(""+apiResponse.getRate());
    }

    @Override
    public void noDataFound() {
        textView.setText("No Data found");
    }

    @Override
    public void showProcessBar() {
        showProgressBar();
    }

    @Override
    public void hiddenProcessBar() {
        hiddenProgressDialog();

    }

    @Override
    public void resetData(APIResponse apiResponse) {
        textView.setText("resetData "+apiResponse.getRate());
    }
}
