package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.base;

import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.StringRes;

/**
 * Created by Name name on 12/27/2017.
 * company Ltd
 * example@gmail.com
 */
public interface BaseMVPView extends LifecycleOwner {

    void showLoading();

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();
}
