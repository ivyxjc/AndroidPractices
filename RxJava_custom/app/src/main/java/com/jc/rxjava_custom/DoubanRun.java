package com.jc.rxjava_custom;

import android.util.Log;

import com.jc.rxjava_custom.Pojo.Douban;
import com.jc.rxjava_custom.Pojo.Subjects;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by jc on 11/25/2016.
 */

public class DoubanRun extends Thread {

    @Override
    public void run() {
        super.run();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.douban.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        DoubanService doubanService=retrofit.create(DoubanService.class);

        doubanService.getList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Douban>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Douban douban) {
                        for (Subjects l:douban.getSubjects()){
                            Log.i("TAGGGG",l.getId()+" "+l.getTitle());

                        }
                    }
                });
    }
}
