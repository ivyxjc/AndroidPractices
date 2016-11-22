package com.jc.retrofit_rxjava;


import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.jc.retrofit_rxjava.model.MovieEntity;
import com.jc.retrofit_rxjava.network.API;
import com.jc.retrofit_rxjava.network.HttpMethods;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private final String TAG="retrofit_rxjava_main";

    private TextView mResultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultText=(TextView)findViewById(R.id.result_txt);
        getMovie();
    }

    private void getMovie(){
        String baseUrl="https://api.douban.com/v2/movie/";

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        API.MovieService movieService=retrofit.create(API.MovieService.class);
//        Call<MovieEntity> call=movieService.getTopMovie(0,10);

//        call.enqueue(new Callback<MovieEntity>() {
//            @Override
//            public void onResponse(Call<MovieEntity> call, Response<MovieEntity> response) {
//                mResultText.setText(response.body().toString());
//                Log.i(TAG,"call enqueue success");
//            }
//
//            @Override
//            public void onFailure(Call<MovieEntity> call, Throwable t) {
//                mResultText.setText(t.getMessage());
//                Log.i(TAG,"call enqueue fail");
//            }
//        });

//        movieService.getTopMovie(0,10)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<MovieEntity>() {
//                    @Override
//                    public void onCompleted() {
//                        Toast.makeText(MainActivity.this,"get top movie completed",Toast.LENGTH_SHORT);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        mResultText.setText(e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(MovieEntity movieEntity) {
//                        mResultText.setText(movieEntity.toString());
//                    }
//                });

        Subscriber<MovieEntity> subscriber=new Subscriber<MovieEntity>() {
            @Override
            public void onCompleted() {
                Toast.makeText(MainActivity.this,"get top movie completed",Toast.LENGTH_SHORT);
            }

            @Override
            public void onError(Throwable e) {
                mResultText.setText(e.getMessage());
            }

            @Override
            public void onNext(MovieEntity movieEntity) {
                mResultText.setText(movieEntity.toString());
            }
        };
        HttpMethods.getInstance().getTopMovie(subscriber,0,10);
    }
}
