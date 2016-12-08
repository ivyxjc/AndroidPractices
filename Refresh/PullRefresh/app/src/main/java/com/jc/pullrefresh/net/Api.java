package com.jc.pullrefresh.net;

<<<<<<< HEAD
import com.jc.pullrefresh.model.News;
=======
import com.jc.pullrefresh.model.*;
>>>>>>> 3ef8d8194b4fcfc9f35ddf05c1126957f722bcec

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jc on 12/6/2016.
 */

public class Api {

    public static final String BASE_URL="http://apis.baidu.com/showapi_open_bus/channel_news/";
    public static final String HEADER_KEY="apikey";

    public interface NewsService{
        @GET("search_news")
        Observable<News> getList(@Header(HEADER_KEY) String apikey, @Query("page") int page);
    }
}
