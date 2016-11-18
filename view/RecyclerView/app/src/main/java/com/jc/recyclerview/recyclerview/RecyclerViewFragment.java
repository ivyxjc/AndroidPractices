package com.jc.recyclerview.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.jc.recyclerview.R;
import com.jc.recyclerview.recyclerview.CustomAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jc on 9/26/2016.
 */
public class RecyclerViewFragment extends Fragment {

    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER_TYPE="LayoutManagerType";
    private int SPAN_COUNT=2;
    private LayoutManagerType mCurrentLayoutManagerType;

    private String[] mDatas;



    @Bind(R.id.linear_layout_rb)
    RadioButton mLinearLayoutRb;
    @Bind(R.id.grid_layout_rb)
    RadioButton mGridLayoutRb;
    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;



    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDatas();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(KEY_LAYOUT_MANAGER_TYPE,mCurrentLayoutManagerType);
        super.onSaveInstanceState(outState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_frag, container,false);
        ButterKnife.bind(this, view);

        mCurrentLayoutManagerType=LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        if(savedInstanceState!=null){
            mCurrentLayoutManagerType=(LayoutManagerType)savedInstanceState.getSerializable(KEY_LAYOUT_MANAGER_TYPE);
        }


        CustomAdapter adapter=new CustomAdapter(mDatas);

        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);
        mRecyclerView.setAdapter(adapter);

        mLinearLayoutRb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRecyclerViewLayoutManager(LayoutManagerType.LINEAR_LAYOUT_MANAGER);
            }
        });

        mGridLayoutRb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRecyclerViewLayoutManager(LayoutManagerType.GRID_LAYOUT_MANAGER);
            }
        });

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private void initDatas(){
        mDatas=new String[50];
    }

    private void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType){
        int scrollPosition=0;
        if(mRecyclerView.getLayoutManager()!=null){
            scrollPosition=((LinearLayoutManager)mRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        }

        switch (layoutManagerType){
            case LINEAR_LAYOUT_MANAGER:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                mCurrentLayoutManagerType=LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                mRecyclerView.scrollToPosition(scrollPosition);
                break;
            case GRID_LAYOUT_MANAGER:
                mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),SPAN_COUNT));
                mCurrentLayoutManagerType=LayoutManagerType.GRID_LAYOUT_MANAGER;
                mRecyclerView.scrollToPosition(scrollPosition);
                break;
            default:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                mCurrentLayoutManagerType=LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                mRecyclerView.scrollToPosition(scrollPosition);

        }
    }
}



