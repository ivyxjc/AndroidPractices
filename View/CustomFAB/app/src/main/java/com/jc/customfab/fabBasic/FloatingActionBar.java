package com.jc.customfab.fabBasic;

import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Checkable;
import android.widget.FrameLayout;

/**
 * Created by jc on 10/18/2016.
 */
public class FloatingActionBar extends FrameLayout implements Checkable {

    private Context mContext;
    private OnCheckedChangeListener mListener;
    private boolean mChecked;



    public FloatingActionBar(Context context) {
        this(context, null, 0, 0);
    }

    public FloatingActionBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0, 0);
    }

    public FloatingActionBar(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,

                0);
    }

    public FloatingActionBar(Context context, AttributeSet attrs, int defStyleAttr,
                                int defStyleRes) {
        super(context, attrs, defStyleAttr);

        setClickable(true);

        // Set the outline provider for this view. The provider is given the outline which it can
        // then modify as needed. In this case we set the outline to be an oval fitting the height
        // and width.
        setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setOval(0, 0, getWidth(), getHeight());
            }
        });

        // Finally, enable clipping to the outline, using the provider we set above
        setClipToOutline(true);
    }


    public interface OnCheckedChangeListener{
        void onChecked(FloatingActionBar fab,boolean isChecked);
    };

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener){
        mListener=listener;
    }


    @Override
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    //interface checkable
    @Override
    public void setChecked(boolean b) {
        if(mChecked==b){
            return;
        }
        mChecked=b;

        refreshDrawableState();

        if (mListener != null) {
            mListener.onChecked(this,isChecked());
        }

    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void toggle() {
        setChecked(!mChecked);
    }

    private static final int[] CHECKED_STATE_SET = {
            android.R.attr.state_checked
    };

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }
}
