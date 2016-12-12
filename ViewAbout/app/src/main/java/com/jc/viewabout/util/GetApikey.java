package com.jc.viewabout.util;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by jc on 12/6/2016.
 */

public class GetApikey {


    public static String getKey(Context context,String filename){
        try{
            InputStream is=context.getAssets().open(filename);
            InputStreamReader reader=new InputStreamReader(is);
            char[] cs=new char[100];
            int csLength=reader.read(cs);
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<csLength;i++){
                sb.append(String.valueOf(cs[i]));
            }
            Log.i("tttt",sb.toString());
            return sb.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
