package com.jc.viewabout.customView.customOnDrawView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jc.viewabout.R;

/**
 * Created by ivyxjc on on 2016/12/15.
 * This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 */

public class CustomOnDrawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_on_draw_view_demo);

        CustomOnDrawView customView=(CustomOnDrawView)findViewById(R.id.custom_ond_draw_view);

    }
}
