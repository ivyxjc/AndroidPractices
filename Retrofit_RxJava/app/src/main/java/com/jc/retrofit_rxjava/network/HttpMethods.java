package com.jc.retrofit_rxjava.network;

import com.jc.retrofit_rxjava.model.MovieEntity;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by jc on 11/22/2016.
 */

public class HttpMethods {
    private static final String BASE_URL="https://api.douban.com/v2/movie/";

    private static final int DEFAULT_TIMEOUT=5;

    private Retrofit mRetrofit;
    private API.MovieService mMovieService;

    private HttpMethods(){
        OkHttpClient.Builder httpClientBuilder=new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        mRetrofit=new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        mMovieService=mRetrofit.create(API.MovieService.class);
    }

    //静态内部类单例, java并发编程实战推荐的单例模式 生成方法 线程安全
    private static class SingletonHolder{
        private static final HttpMethods INSTANCE=new HttpMethods();
    }

    public static HttpMethods getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public void getTopMovie(Subscriber<MovieEntity> subscriber,int start, int end){
        mMovieService.getTopMovie(start,end)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
