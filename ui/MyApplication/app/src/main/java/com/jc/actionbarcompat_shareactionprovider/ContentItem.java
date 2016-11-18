package com.jc.actionbarcompat_shareactionprovider;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/**
 * Created by jc on 10/6/2016.
 */
public class ContentItem {

    public static final int CONTENT_TYPE_IMAGE = 0;
    // Used to signify a text/string content type
    public static final int CONTENT_TYPE_TEXT = 1;

    private final int contentType;
    private final int contentResourceId;
    private final String contentAssetFilePath;


    public ContentItem(int type,int resourceId) {
        contentType = type;
        contentResourceId = resourceId;
        contentAssetFilePath=null;
    }


    public ContentItem(int type,String assetFilePath){
        contentType=type;
        contentAssetFilePath=assetFilePath;
        contentResourceId=0;
    }


    public int getContentType(){
        return contentType;
    }

    public int getContentResourceId(){
        return contentResourceId;
    }

    public Intent getShareIntent(Context context){
        Intent intent=new Intent(Intent.ACTION_SEND);

        switch (contentType) {
            case CONTENT_TYPE_IMAGE:
                intent.setType("image/jpg");
                intent.putExtra(Intent.EXTRA_STREAM, getContentUri());

                break;

            case CONTENT_TYPE_TEXT:
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, context.getString(contentResourceId));
                break;
        }

        return intent;
    }

    public Uri getContentUri(){
        if(!TextUtils.isEmpty(contentAssetFilePath)){
            return Uri.parse(ShareProvider.CONTENT_URI+contentAssetFilePath);
        }else{
            return null;
        }

    }

}
