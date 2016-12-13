package com.jc.viewabout.customView.slideRecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jc.viewabout.R;

import java.util.ArrayList;

/**
 * Created by jc on 12/13/2016.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<String> mDatas;
    private Context mContext;

    public RecyclerViewAdapter(Context context){
        mContext=context;
        mDatas=new ArrayList<>();
    }

    public RecyclerViewAdapter(Context context,ArrayList<String> datas){
        mContext=context;
        mDatas=datas;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.slide_item,parent,false);
        return new ItemViehHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemViehHolder)holder).update(position);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addAllDatas(ArrayList<String> datas){
        datas=datas;
        notifyDataSetChanged();
    }

    public class ItemViehHolder extends RecyclerView.ViewHolder{

        private TextView mTextView;

        public ItemViehHolder(View itemView){
            super(itemView);
        }

        public void update(int position){
            mTextView=(TextView)itemView.findViewById(R.id.slide_item_tv);
            mTextView.setText(mDatas.get(position));
        }


    }

}
