package com.jc.refresh;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.jc.refresh.model.Contentlist;
import com.jc.refresh.model.News;
import com.jc.refresh.net.HttpMethod;
import com.jc.refresh.net.Api;
import com.jc.refresh.util.GetApikey;
import com.jc.ultrapulltorefreshdemo.R;

import java.util.ArrayList;


import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import rx.Subscriber;
import rx.schedulers.Schedulers;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView mRecyclerView;
    private ArrayList<Contentlist> datas;
    private RecyclerViewAdapter mAdapter;

    PtrFrameLayout mRefreshLayout;
    private int pageNum=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        mRefreshLayout=(PtrFrameLayout)findViewById(R.id.refresh_layout);
//        mRefreshLayout.setLoadingMinTime(1000);
        mRefreshLayout.setPullToRefresh(true);


        mRecyclerView=(RecyclerView)findViewById(R.id.news_rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        datas=new ArrayList<>();
        mAdapter=new RecyclerViewAdapter(this,datas);
        mRecyclerView.setAdapter(mAdapter);

        final String apiKey=GetApikey.getKey(this,"config.txt");
        final Api.NewsService service=(HttpMethod.getRetrofit()).create(Api.NewsService.class);

        updateDatas(service,apiKey,1);

        mRefreshLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {

                // here check list view, not content.
                return PtrDefaultHandler.checkContentCanBePulledDown(frame,content, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                Log.i("test", "-----onRefreshBegin-----");
                pageNum+=1;
                updateDatas(service,apiKey,pageNum);
            }
        });

    }


    public void updateDatas(Api.NewsService service,String apiKey,int pageNum){
        service.getList(apiKey,pageNum)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<News>() {
                    @Override
                    public void onCompleted() {
                        Log.i("ttttt","complete");

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("ttttt",e.toString());

                    }

                    @Override
                    public void onNext(News news) {
                        Log.i("ttttt",news.toString());
                        datas=news.getShowapi_res_body().getPagebean().getContentlist();
                        Log.i("ttttt",datas.size()+"");
                        Log.i("ttttt",datas.get(0).getTitle());
                        notifyDatasetChanged(datas);
//                        mSwipeRefreshLayout.setRefreshing(false);
                        mRefreshLayout.refreshComplete();
                    }
                });
    }


    private void notifyDatasetChanged(ArrayList<Contentlist> list){
        mAdapter.refresh(list);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
