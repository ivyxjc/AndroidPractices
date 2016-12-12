package com.jc.viewabout.customView.titleView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.jc.viewabout.R;

/**
 * Created by ivyxjc on on 2016/12/12.
 * This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 */

public class TitleViewActivity extends AppCompatActivity {
    private LinearLayout mLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title_view_demo);

        mLayout=(LinearLayout)findViewById(R.id.title_view_layout);
        ViewParent parent=mLayout.getParent();
        Log.i("titleview",parent.toString());

    }
}
