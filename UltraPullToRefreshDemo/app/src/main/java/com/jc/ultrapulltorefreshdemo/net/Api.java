package com.jc.ultrapulltorefreshdemo.net;

import android.content.Context;

import com.jc.ultrapulltorefreshdemo.model.Contentlist;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jc on 12/6/2016.
 */

public class Api {

    public static final String BASE_URL="http://apis.baidu.com/showapi_open_bus/channel_news/search_news";


    public interface NewsService{
        @GET()
        Observable<ArrayList<Contentlist>> getList(@Query("page") int page);
    }
}
