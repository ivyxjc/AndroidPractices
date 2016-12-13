package com.jc.viewabout.customView.slideRecyclerView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.jc.viewabout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivyxjc on on 2016/12/13.
 * This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 */

public class SlideRecyclerViewActivity  extends AppCompatActivity{

    private SlideRecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private ArrayList<String> datas;
//    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_recyclerview_demo);

        mRecyclerView=(SlideRecyclerView) findViewById(R.id.slide_rv);
        initDatas();
        mAdapter=new RecyclerViewAdapter(this,datas);
        Toast.makeText(this,datas.size()+"",Toast.LENGTH_LONG).show();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setOnDeleteListener(new SlideRecyclerView.OnDeleteListener() {
            @Override
            public void onDelete(int position) {
                datas.remove(position);
                mAdapter.notifyDataSetChanged();
            }
        });
//        mAdapter.addAllDatas(datas);

    }
    public void initDatas(){
        datas=new ArrayList<>();
        for(int i=0;i<10;i++){
            datas.add("recyclerview position "+i);
        }
    }
}
