package com.jc.actionbarcompat_shareactionprovider;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView mImageView;
    ViewPager mViewPager;

    private ShareActionProvider mShareActionProvider;
    private ArrayList<ContentItem> mItems=getSampleContent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPager.setAdapter(mPagerAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setShareItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);

        MenuItem shareItem=menu.findItem(R.id.share_item);

        mShareActionProvider=(ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);

        int currentViewPagerItem=((ViewPager)findViewById(R.id.viewPager)).getCurrentItem();
        setShareItem(currentViewPagerItem);
        return super.onCreateOptionsMenu(menu);
    }


    public void setShareItem(int i){
        if(mShareActionProvider!=null){
            ContentItem item=mItems.get(i);

            Intent intent=item.getShareIntent(this);

            mShareActionProvider.setShareIntent(intent);
        }
    }

    private final PagerAdapter mPagerAdapter=new PagerAdapter() {
        LayoutInflater mInflater;

        @Override
        public int getCount() {
            return mItems.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            if(mInflater==null){
                mInflater=LayoutInflater.from(MainActivity.this);
            }

            final ContentItem item = mItems.get(position);

            switch (item.getContentType()){
                case ContentItem.CONTENT_TYPE_IMAGE:
                    ImageView iv=(ImageView)mInflater.inflate(R.layout.item_image,container,false);
//                    iv.setImageBitmap(BitmapFactory.decodeResource(MainActivity.this.getResources(),item.getContentResourceId()));
                    iv.setImageURI(item.getContentUri());
                    container.addView(iv);
                    return iv;
                case ContentItem.CONTENT_TYPE_TEXT:
                    TextView tv=(TextView)mInflater.inflate(R.layout.item_text,container,false);
                    tv.setText(item.getContentResourceId());
                    container.addView(tv);
                    return tv;
            }
            return null;
        }
    };

    static ArrayList<ContentItem> getSampleContent() {
        ArrayList<ContentItem> items = new ArrayList<ContentItem>();

        items.add(new ContentItem(ContentItem.CONTENT_TYPE_IMAGE,"photo_1"));
        items.add(new ContentItem(ContentItem.CONTENT_TYPE_TEXT, R.string.quote_1));
        items.add(new ContentItem(ContentItem.CONTENT_TYPE_TEXT, R.string.quote_2));
        items.add(new ContentItem(ContentItem.CONTENT_TYPE_IMAGE,"photo_2.jpg"));
        items.add(new ContentItem(ContentItem.CONTENT_TYPE_TEXT, R.string.quote_3));
        items.add(new ContentItem(ContentItem.CONTENT_TYPE_IMAGE, "photo_3.jpg"));

        return items;
    }


}
