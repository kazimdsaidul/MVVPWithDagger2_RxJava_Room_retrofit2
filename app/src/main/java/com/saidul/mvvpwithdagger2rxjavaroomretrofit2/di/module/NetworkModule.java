package com.saidul.mvvpwithdagger2rxjavaroomretrofit2.di.module;

import android.app.Application;



import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.DoubleDefault0Adapter;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.Example;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.ExampleDeserializer;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.IntegerDefault0Adapter;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.LongDefault0Adapter;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.NullStringToEmptyAdapterFactory;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.APIConstant;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.apiServices.model.APIResponse;
import com.saidul.mvvpwithdagger2rxjavaroomretrofit2.di.GlobalAppScope;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import dagger.Module;
import dagger.Provides;
import io.reactivex.annotations.Nullable;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


;

/**
 * Created by Lenovo on 11/7/2017.
 */


@Module
public class NetworkModule {

    @Provides
    @GlobalAppScope
    Cache provideHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }


    @Provides
    @GlobalAppScope
    Gson provideGson(NullStringToEmptyAdapterFactory nullStringToEmptyAdapterFactory) {
        GsonBuilder gsonBuilder = new GsonBuilder( );
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        gsonBuilder.registerTypeAdapter(Integer.class, new IntegerDefault0Adapter());
        gsonBuilder.registerTypeAdapter(int.class, new IntegerDefault0Adapter());
        gsonBuilder.registerTypeAdapter(Double.class, new DoubleDefault0Adapter());
        gsonBuilder .registerTypeAdapter(double.class, new DoubleDefault0Adapter());
        gsonBuilder.registerTypeAdapter(Long.class, new LongDefault0Adapter());
        gsonBuilder.registerTypeAdapter(long.class, new LongDefault0Adapter());

        return gsonBuilder.create();
    }

    @Provides
    @GlobalAppScope
    NullStringToEmptyAdapterFactory provoider(){
        return new NullStringToEmptyAdapterFactory();
    }



    @Provides
    @GlobalAppScope
    HttpLoggingInterceptor provideLogger() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

    @Provides
    @GlobalAppScope
    OkHttpClient.Builder provideOkhttpClient(Cache cache, HttpLoggingInterceptor loggingInterceptor) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(loggingInterceptor);
        client.cache(cache);
        return client;
    }

    @Provides
    @GlobalAppScope
    Retrofit provideRetrofit(Gson gson, OkHttpClient.Builder okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(APIConstant.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient.build())
                .build();
    }





}
