package com.jc.viewabout.customView.customOnDrawView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.jc.viewabout.R;

/**
 * Created by ivyxjc on on 2016/12/15.
 * This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 */

public class CustomOnDrawView extends View {
    private int mColor= Color.BLACK;
    private Paint mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);



    public CustomOnDrawView(Context context, AttributeSet attrs){

        super(context,attrs);
        TypedArray a=context.obtainStyledAttributes(attrs,R.styleable.CustomOnDrawView);
        mColor=a.getColor(R.styleable.CustomOnDrawView_onDrawColor,Color.BLACK);
        init();
    }

    private void init(){
        mPaint.setColor(mColor);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        final int paddingLeft=getPaddingLeft();
        final int paddingRight=getPaddingRight();
        final int paddingTop=getPaddingTop();
        final int paddingBottom=getPaddingBottom();

        int widht=getWidth()-paddingLeft-paddingTop;
        int height=getHeight()-paddingTop-paddingBottom;

        int radius=Math.min(widht,height)/2;
        canvas.drawCircle(paddingLeft+widht/2,paddingTop+height/2,radius,mPaint);
    }
}
