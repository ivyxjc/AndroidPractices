package com.jc.actionbarcompat_shareactionprovider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by jc on 10/16/2016.
 */
public class ShareProvider extends ContentProvider {

    public static String CONTENT_URI = "android.resource://com.jc.actionbarcompat_shareactionprovider/drawable/";

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }

    @Override
    public AssetFileDescriptor openAssetFile(Uri uri, String mode) throws FileNotFoundException {
        // The asset file name should be the last path segment
        final String assetName = uri.getLastPathSegment();

        // If the given asset name is empty, throw an exception
        if (TextUtils.isEmpty(assetName)) {
            throw new FileNotFoundException();
        }

        try {
            // Try and return a file descriptor for the given asset name
            AssetManager am = getContext().getAssets();
            return am.openFd(assetName);
        } catch (IOException e) {
            e.printStackTrace();
            return super.openAssetFile(uri, mode);
        }
    }


}
