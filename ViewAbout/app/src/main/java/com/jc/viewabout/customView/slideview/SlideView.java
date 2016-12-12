package com.jc.viewabout.customView.slideview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by ivyxjc on on 2016/12/12.
 * This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 */

public class SlideView extends LinearLayout {

    private Context mContext;

    private OnSlideListener mOnSlideListener;

    //上次滑动的坐标
    private int mLastX = 0;
    private int mLastY = 0;

    public interface OnSlideListener{
        public final int SLIDE_LEFT=0;
        public final int SLIDE_RIGHT=1;

        public void onSlide(View view, int status);
    }

    public SlideView(Context context){
        super(context);
        mContext=context;
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        VelocityTracker velocityTracker=VelocityTracker.obtain();
//        velocityTracker.addMovement(event);
//        velocityTracker.computeCurrentVelocity(100);
//        int xVelocity=(int) velocityTracker.getXVelocity();
//        int yVelocity=(int) velocityTracker.getYVelocity();
//
//        return super.onTouchEvent(event);
//    }

    public void setOnSlideListener(OnSlideListener slideListener){
        mOnSlideListener=slideListener;
    }

    public boolean onCustomTouchEvent(MotionEvent event){
        int x=(int) event.getX();
        int y=(int) event.getY();

        int scrollX = getScrollX();

        switch (event.getAction()){
            case (MotionEvent.ACTION_DOWN):
                break;
            case (MotionEvent.ACTION_MOVE):
                int deltaX=x-mLastX;
                int deltaY=x-mLastY;
                if(Math.abs(deltaX)>Math.abs(deltaY)*2){
                    break;
                }


            case (MotionEvent.ACTION_UP):
                break;
            default:
                break;
        }
        return true;
    }

}
