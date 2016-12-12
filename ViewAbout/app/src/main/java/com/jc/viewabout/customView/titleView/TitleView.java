package com.jc.viewabout.customView.titleView;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jc.viewabout.R;

/**
 * Created by ivyxjc on on 2016/12/12.
 * This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 */

/**
 * 自定义app header , 多个控件组合
 */
public class TitleView extends FrameLayout {

    private TextView mTextView;
    private Button mButton;

    public TitleView(Context context, AttributeSet attrs){
        super(context,attrs);

        LayoutInflater.from(context).inflate(R.layout.title_view,this);

        mTextView=(TextView)findViewById(R.id.title_view_txt);
        mButton=(Button)findViewById(R.id.title_view_btn);

        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)getContext()).finish();
            }
        });

    }

    public void setTitle(String title){
        mTextView.setText(title);
    }

    public void setButtonText(String text){
        mButton.setText(text);
    }

    public void setButtonListener(OnClickListener listener){
        mButton.setOnClickListener(listener);
    }
}
