package com.jc.recyclerview.recyclerview;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jc.recyclerview.Common.logger.Log;
import com.jc.recyclerview.R;

/**
 * Created by jc on 9/26/2016.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    private final String TAG="CustomAdapter";

    private String[] mDataSet;


    public CustomAdapter(String[] dataSet) {
        mDataSet = dataSet;
    }


    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_row_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder holder, int position) {
        Log.d(TAG, "Element " + position + " set.");
        holder.update(position);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;


        public ViewHolder(View v) {
            super(v);
            mTextView=(TextView) v.findViewById(R.id.textView);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG,"Element "+getAdapterPosition()+" is clicked");
                }
            });
        }

        public void update(int position){
            mTextView.setText("Element "+position+" set.");
        }
    }
}





