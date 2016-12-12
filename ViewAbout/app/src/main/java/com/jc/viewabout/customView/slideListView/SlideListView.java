package com.jc.viewabout.customView.slideListView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.jc.viewabout.R;

/**
 * Created by ivyxjc on on 2016/12/12.
 * This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 */

/**
 * 自定义ListView, 支持侧滑删除.
 */
public class SlideListView extends ListView implements View.OnTouchListener ,GestureDetector.OnGestureListener {

    private final String TAG="slidelistview";
    private GestureDetector mGestureDetector;

    private boolean mIsDelbtnShown=false;

    private View mDelButton;
    private ViewGroup mViewGroup;
    private int selectedItemIndex;
    private OnDeleteListener listener;

    public SlideListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mGestureDetector = new GestureDetector(getContext(), this);
        setOnTouchListener(this);
    }

    /**
     * 删除操作监听接口
     */
    public interface OnDeleteListener{
        public void onDelete(int position);
    }

    public void setOnDeleteListener(OnDeleteListener listener){
        this.listener=listener;
    }



    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Log.i("slidelistview","onFling");
        if(!mIsDelbtnShown && Math.abs(v)>Math.abs(v1)*2&&selectedItemIndex>=0){
            if(mDelButton==null){
                mDelButton= LayoutInflater.from(getContext()).inflate(R.layout.slide_listview_del_btn,null);
            }
            mDelButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    mViewGroup.removeView(mDelButton);
                    listener.onDelete(selectedItemIndex);
                    mDelButton=null;
                    mIsDelbtnShown=false;
                }
            });
            Log.i(TAG,"item index"+selectedItemIndex);
            mViewGroup=(ViewGroup)getChildAt(selectedItemIndex-getFirstVisiblePosition());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            params.addRule(RelativeLayout.CENTER_VERTICAL);
            mViewGroup.addView(mDelButton,params);
            Log.i(TAG,"addView");
            mIsDelbtnShown=true;
        }
        return false;
    }


    /**
     *  onTouchListner
     */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        selectedItemIndex=pointToPosition((int)motionEvent.getX(),(int)motionEvent.getY());
        if (mIsDelbtnShown) {
            Log.i(TAG,"onTouch_btn");
            mViewGroup.removeView(mDelButton);
            mIsDelbtnShown = false;
            return false;
        } else {
            Log.i(TAG,"onTouch_gesture");
            return mGestureDetector.onTouchEvent(motionEvent);
        }

    }


}
