package com.jc.rxjava_custom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    String tag="observer";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Observer<String> observer=new Observer<String>() {
//            @Override
//            public void onCompleted() {
//                Log.d(tag, "Completed!");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(tag, "Error!");
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.d(tag, "Item: " + s);
//            }
//        };
//
//        Action1<String> onNextAction = new Action1<String>() {
//            // onNext()
//            @Override
//            public void call(String s) {
//                Log.d(tag, s);
//            }
//        };
//
//        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
//            // onError()
//            @Override
//            public void call(Throwable throwable) {
//                // Error handling
//            }
//        };
//
//
//        Action0 onCompletedAction = new Action0() {
//            // onCompleted()
//            @Override
//            public void call() {
//                Log.d(tag, "completed");
//            }
//        };

//        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("Hello");
//                subscriber.onNext("Hi");
//                subscriber.onNext("Aloha");
//                subscriber.onCompleted();
//            }
//        });

//        String[] names={"aa","bb","cc","dd"};
//        Observable.from(names)
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        Log.d(tag,s);
//                    }
//                });

//        observable.subscribe(onNextAction);
//        observable.subscribe(onNextAction,onErrorAction);
//        observable.subscribe(onNextAction,onErrorAction,onCompletedAction);
//
//        Simple s=new Simple();
//        s.start();

        DoubanRun douban=new DoubanRun();
        douban.start();
    }
}
