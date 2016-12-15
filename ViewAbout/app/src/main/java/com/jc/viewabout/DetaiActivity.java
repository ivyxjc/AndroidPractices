package com.jc.viewabout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.Collections;

/**
 * Created by jc on 12/7/2016.
 */

public class DetaiActivity extends AppCompatActivity {

    private String url;
    private String title;
    private WebView mWebView;
    private TextView mTextView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent=getIntent();
        url=(String)intent.getSerializableExtra("detail_url");
        title=(String)intent.getSerializableExtra("detail_title");

        mWebView=(WebView)findViewById(R.id.webview);
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(false);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(false);

        mWebView.loadUrl(url);

    }
}
