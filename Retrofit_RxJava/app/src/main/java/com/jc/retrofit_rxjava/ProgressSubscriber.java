package com.jc.retrofit_rxjava;

import android.content.Context;
import android.widget.Toast;

import rx.Subscriber;

/**
 * Created by jc on 11/24/2016.
 */

public class ProgressSubscriber<T> extends Subscriber<T> implements ProgressCancelListener {

    private SubscriberOnNextListener<T> mSubscriberOnNextListener;
    private Context mContext;

    public ProgressSubscriber(Context context,SubscriberOnNextListener<T> listener){
        mContext=context;
        mSubscriberOnNextListener=listener;
    }

    @Override
    public void onCompleted() {
        Toast.makeText(mContext, "Get Top Movie Completed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(mContext, "error:" + e.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNext(T t) {
        mSubscriberOnNextListener.onNext(t);
    }

    @Override
    public void onCancelProgress() {
        if(!this.isUnsubscribed()){
            this.unsubscribe();
        }
    }
}
