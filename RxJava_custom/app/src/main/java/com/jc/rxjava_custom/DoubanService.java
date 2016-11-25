package com.jc.rxjava_custom;

import com.jc.rxjava_custom.Pojo.Douban;

import retrofit2.http.GET;
import rx.Observable;


/**
 * Created by jc on 11/25/2016.
 */

interface DoubanService {
    @GET("/v2/movie/in_theaters")
    Observable<Douban> getList();
}
