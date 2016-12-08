package com.jc.customfab.fabBasic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jc.customfab.fabBasic.R;

/**
 * Created by jc on 10/18/2016.
 */
public class FragmentFoatingActionButton extends Fragment implements FloatingActionBar.OnCheckedChangeListener{

    private FloatingActionBar fab_1;
    private FloatingActionBar fab_2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fab_layout,container,false);

        fab_1=(FloatingActionBar)view.findViewById(R.id.fab_1);
        fab_1.setOnCheckedChangeListener(this);
        fab_2=(FloatingActionBar)view.findViewById(R.id.fab_2);
        fab_2.setOnCheckedChangeListener(this);

        return view;
    }


    @Override
    public void onChecked(FloatingActionBar fab, boolean isChecked) {
        switch (fab.getId()){
            case R.id.fab_1:

                break;
            case R.id.fab_2:

                break;
        }
    }
}
