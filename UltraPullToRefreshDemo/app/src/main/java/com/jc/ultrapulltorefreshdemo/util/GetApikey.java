package com.jc.ultrapulltorefreshdemo.util;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jc on 12/6/2016.
 */

public class GetApikey {


    public static void getKey(Context context,String filename){
        try{
            InputStream is=context.getAssets().open(filename);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
