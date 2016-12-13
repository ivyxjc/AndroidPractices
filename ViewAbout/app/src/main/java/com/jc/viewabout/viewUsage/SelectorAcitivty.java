package com.jc.viewabout.viewUsage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.jc.viewabout.R;

/**
 * Created by ivyxjc on on 2016/12/13.
 * This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 */

public class SelectorAcitivty extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selector_demo);

        Button btn=(Button)findViewById(R.id.selector_btn);


    }
}
