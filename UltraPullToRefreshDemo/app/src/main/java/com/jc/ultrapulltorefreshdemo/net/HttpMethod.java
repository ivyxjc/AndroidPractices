package com.jc.ultrapulltorefreshdemo.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jc on 12/6/2016.
 */

public class HttpMethod {
    private static final int DEFAULT_TIMEOUT = 5;
    private Retrofit mRetrofit;
    private Api.NewsService mService;

    private static class RetrofitStaticHolder{
        private static final Retrofit sRetrofit=new Retrofit.Builder()
                .client(getOkHttp())
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    private static class OkHttpStaticHolder{
        private static final OkHttpClient sOkHttp=new OkHttpClient.Builder()
                                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                                .build();
    }


    public static OkHttpClient getOkHttp(){
        return OkHttpStaticHolder.sOkHttp;
    }

    //单例
    public static Retrofit getRetrofit(){
        return RetrofitStaticHolder.sRetrofit;
    }
}
