package com.jc.viewabout.customView.slideRecyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.jc.viewabout.R;

/**
 * Created by ivyxjc on on 2016/12/13.
 * This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 */

public class SlideRecyclerView extends RecyclerView implements View.OnTouchListener , GestureDetector.OnGestureListener {

    private final String TAG="sliderecyclerview";
    private GestureDetector mGestureDetector;
    private boolean mIsDelbtnShown;
    private Button mDelButton;
    private ViewGroup mViewGroup;
    private LinearLayoutManager mLayoutManager;
    private OnDeleteListener mListener;
    private boolean mIsFlingValid=false;

    public SlideRecyclerView(Context context, AttributeSet attrs){
        super(context,attrs);
        mGestureDetector=new GestureDetector(getContext(),this);
        setOnTouchListener(this);
        mLayoutManager=(LinearLayoutManager)getLayoutManager();
        setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public interface OnDeleteListener{
        public void onDelete(int position);
    }

    public void setOnDeleteListener(OnDeleteListener listener){
        mListener=listener;
    }

    @Override
    public boolean onDown(MotionEvent e)
    {
        Log.i("slide","onDown()");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.i("slide","onScroll()");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.i("slide","onFling()");
        if(mViewGroup==null){
            mIsFlingValid=false;
        }else {
            mIsFlingValid=true;
        }
        if(!mIsDelbtnShown&&mIsFlingValid&&Math.abs(velocityX)>Math.abs(velocityY)*2){
            if(mDelButton==null){
                mDelButton=(Button)LayoutInflater.from(getContext()).inflate(R.layout.slide_del_btn,null);
            }
            mDelButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewGroup.removeView(mDelButton);
                    mListener.onDelete(indexOfChild(mViewGroup));
                    mIsDelbtnShown=false;
                }
            });
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    AbsListView.LayoutParams.WRAP_CONTENT, AbsListView.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            params.addRule(RelativeLayout.CENTER_VERTICAL);
            mViewGroup.addView(mDelButton,params);
            mIsDelbtnShown=true;
        }
        return false;
    }

//    public int pointToPosition(int x, int y) {
//        Rect frame = mTouchFrame;
//        if (frame == null) {
//            mTouchFrame = new Rect();
//            frame = mTouchFrame;
//        }
//
//        final int count = getChildCount();
//        for (int i = count - 1; i >= 0; i--) {
//            final View child = getChildAt(i);
//            if (child.getVisibility() == View.VISIBLE) {
//                child.getHitRect(frame);
//                if (frame.contains(x, y)) {
//                    return mFirstPosition + i;
//                }
//            }
//        }
//        return INVALID_POSITION;
//    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.i("slide","onTouch()");

        //ListView中有根据pointToPosition(x, y)获取点击item的position
        //RecyclerView中可以根据x,y获取所在的view
        mViewGroup=(ViewGroup)findChildViewUnder((int)event.getX(),(int)event.getY());

        if(mIsDelbtnShown){
            mViewGroup.removeView(mDelButton);
            mIsDelbtnShown=false;
            return false;
        }else {
            return mGestureDetector.onTouchEvent(event);
        }

    }
}
