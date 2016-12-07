package com.jc.pullrefresh;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jc.pullrefresh.model.Contentlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivyxjc on on 2016/12/7.
 * This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Contentlist> datas=new ArrayList<>();
    private Context mContext;
    private OnItemClickListener mCallback;

    public interface OnItemClickListener{
        void onClick(String url,String title);
    }

    public RecyclerViewAdapter(Context context, List<Contentlist> datas){
        mContext=context;
        this.datas=datas;
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mCallback=listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext)
                .inflate(R.layout.item_list,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemViewHolder)holder).update(position);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void refresh(List<Contentlist> datas){
        this.datas=datas;
        notifyDataSetChanged();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Contentlist mItem;
        private TextView mTextView;
        public ItemViewHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mCallback.onClick(mItem.getLink(),mItem.getTitle());
        }

        public void update(int position){
            mItem=datas.get(position);
            mTextView=(TextView)itemView.findViewById(R.id.list_text);
            mTextView.setText(mItem.getTitle());
        }
    }
}
