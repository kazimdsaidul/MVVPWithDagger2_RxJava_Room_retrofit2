package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices;






import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.APIResponse;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.RequestBody;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Lenovo on 11/7/2017.
 */

public interface APIService {
    @POST("webservice/")
    Observable<APIResponse> getPosts(@Body RequestBody requestBody);
}
