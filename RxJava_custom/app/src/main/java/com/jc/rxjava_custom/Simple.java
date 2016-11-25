package com.jc.rxjava_custom;

import android.util.Log;

import com.jc.rxjava_custom.Pojo.Contributor;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ivyxjc on on 2016/11/25.
 * This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 */

public class Simple extends Thread{

    @Override
    public void run() {
        super.run();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())//添加 Gson 转换器
                .build();

        API.GitHub gitHub=retrofit.create(API.GitHub.class);

        Call<List<Contributor>> call=gitHub.contributors("square", "retrofit");

        try {
            List<Contributor> list=call.execute().body();
            for (Contributor c:list){
                Log.i("TAGGGG",c.getDdd()+" "+c.getId()+" "+c.getContributions()+" "+c.getUrl());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
