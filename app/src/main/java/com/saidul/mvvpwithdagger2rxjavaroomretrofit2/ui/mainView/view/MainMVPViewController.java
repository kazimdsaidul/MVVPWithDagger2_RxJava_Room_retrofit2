package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ui.mainView.view;

import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.APIResponse;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.base.BaseMVPView;

/**
 * Created by Name name on 12/26/2017.
 * company Ltd
 * example@gmail.com
 */
public interface MainMVPViewController extends BaseMVPView {

     void showAPIRespose(APIResponse apiResponse);
     void resetData(APIResponse mainViewModel);
}
