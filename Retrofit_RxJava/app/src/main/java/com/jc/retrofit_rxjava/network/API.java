package com.jc.retrofit_rxjava.network;

import com.jc.retrofit_rxjava.model.MovieEntity;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jc on 11/22/2016.
 */

public class API {
    public interface MovieService{
        @GET("top250")
        Observable<MovieEntity> getTopMovie(@Query("start") int start, @Query("count")int count);

    }
}
