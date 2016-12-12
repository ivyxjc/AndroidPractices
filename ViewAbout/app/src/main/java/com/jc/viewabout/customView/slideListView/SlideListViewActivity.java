package com.jc.viewabout.customView.slideListView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jc.viewabout.R;

import java.util.ArrayList;

/**
 * Created by ivyxjc on on 2016/12/12.
 * This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 */

public class SlideListViewActivity extends AppCompatActivity{
    private SlideListViewAdapter mAdapter;
    private ArrayList<String> list;
    private SlideListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_listview_demo);
        list=new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add("item position "+i);
        }
        mAdapter=new SlideListViewAdapter(this,R.layout.slide_listview_demo,list);

        mListView=(SlideListView)findViewById(R.id.slide_lv);
        mListView.setAdapter(mAdapter);
        mListView.setOnDeleteListener(new SlideListView.OnDeleteListener() {
            @Override
            public void onDelete(int position) {
                list.remove(position);
                mAdapter.notifyDataSetChanged();
            }
        });
    }

}
