package com.jc.actionbarcomptlistpopupmenu;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jc on 9/24/2016.
 */
public class PopupListFragment extends ListFragment implements View.OnClickListener{

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // We want to allow modifications to the list so copy the dummy data array into an ArrayList
        ArrayList<String> items = new ArrayList<String>();
        for (int i = 0, z = Cheese.CHEESES.length ; i < z ; i++) {
            items.add(Cheese.CHEESES[i]);
        }

        // Set the ListAdapter
        setListAdapter(new PopupAdapter(items));
    }

    @Override
    public void onClick(final View view) {
        view.post(new Runnable() {
            @Override
            public void run() {
                showPopupMenu(view);
            }
        });
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getActivity(),l.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
        super.onListItemClick(l, v, position, id);
    }

    public void showPopupMenu(View view){
        final PopupAdapter adapter = (PopupAdapter) getListAdapter();
        final String item = (String) view.getTag();

        PopupMenu popup = new PopupMenu(getActivity(), view);
//        Toast.makeText(getActivity(),"item show"+ item,Toast.LENGTH_SHORT).show();

        popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());


        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_remove:
                        adapter.remove(item);
                        return true;
                }
                return false;
            }
        });
        popup.show();
    }

    private class PopupAdapter extends ArrayAdapter<String>{

        private TextView mTextView;
        private ImageView mImageView;

        public PopupAdapter(ArrayList<String> list){
            super(getActivity(),R.layout.item_popup,list);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                convertView=LayoutInflater.from(getActivity()).inflate(R.layout.item_popup,parent,false);
            }
            mTextView=(TextView)convertView.findViewById(R.id.text1);
            mImageView=(ImageView)convertView.findViewById(R.id.button_popup);
            //设置按钮,便于showpopupMenu中找到该按钮所对应的值
            mImageView.setTag(getItem(position));
            mTextView.setText(getItem(position).toString());
            mImageView.setOnClickListener(PopupListFragment.this);
            return convertView;
        }
    }
}



