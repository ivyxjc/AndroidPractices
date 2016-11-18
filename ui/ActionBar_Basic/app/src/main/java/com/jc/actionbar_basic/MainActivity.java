package com.jc.actionbar_basic;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.button_forbid_refresh)
    Button mButtonForbidRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mButtonForbidRefresh.setOnClickListener(new View.OnClickListener() {
            private int i=0;
            @Override
            public void onClick(View view) {
                i++;
                if(i%2==1)
                    mButtonForbidRefresh.setActivated(true);
                else
                    mButtonForbidRefresh.setActivated(false);
                invalidateOptionsMenu();
            }
        });

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item=menu.findItem(R.id.menu_refresh);
        if(mButtonForbidRefresh.isActivated()){
           item.setEnabled(false);
        }

        MenuItem location = menu.add(0, R.id.menu_location, Menu.CATEGORY_SECONDARY, "Location");
        location.setIcon(R.mipmap.ic_action_location);
        MenuItemCompat.setShowAsAction(location, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);

        return super.onPrepareOptionsMenu(menu);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//
//        MenuItem location = menu.add(0, R.id.menu_location, Menu.CATEGORY_SECONDARY, "Location");
//        location.setIcon(R.mipmap.ic_action_location);
//        MenuItemCompat.setShowAsAction(location, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_setting:
                Toast.makeText(this,"setting",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_location:
                Toast.makeText(this,"location",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_refresh:
                Toast.makeText(this,"refresh",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
