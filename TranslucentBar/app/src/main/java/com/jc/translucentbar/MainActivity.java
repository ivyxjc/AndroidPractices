package com.jc.translucentbar;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(mToolbar);


//        SystemBarTintManager tintManager=new SystemBarTintManager(this);
//        tintManager.setStatusBarTintResource(R.color.colorPrimaryDark);
//        tintManager.setStatusBarTintEnabled(true);
    }



}
