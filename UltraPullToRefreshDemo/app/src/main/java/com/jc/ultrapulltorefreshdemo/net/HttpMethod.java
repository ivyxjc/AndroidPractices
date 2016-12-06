package com.jc.ultrapulltorefreshdemo.net;

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
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .a
                .build();

    }
}
