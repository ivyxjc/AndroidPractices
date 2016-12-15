package com.jc.viewabout.customView.slideListView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.jc.viewabout.R;

import java.util.ArrayList;

/**
 * Created by ivyxjc on on 2016/12/12.
 * This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 */

public class SlideListViewAdapter extends ArrayAdapter<String> {

    public SlideListViewAdapter(Context context, int resourceId, ArrayList<String> list){
        super(context,resourceId,list);

    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(R.layout.slide_item,null);
        }else {
            view=convertView;
        }
        TextView textView=(TextView)view.findViewById(R.id.slide_item_tv);
        textView.setText(getItem(position));

        return view;
    }
}
