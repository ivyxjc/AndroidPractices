package com.jc.recyclerview.Common.logger;

/**
 * Created by jc on 9/26/2016.
 */
public class LogWrapper implements LogNode{

    public LogNode mNext;

    public LogNode getNext(){
        return mNext;
    }

    public void setNext(LogNode node){
        mNext=node;
    }


    @Override
    public void println(int priority, String tag, String msg, Throwable tr) {
        String useMsg = msg;
        if (useMsg == null) {
            useMsg = "";
        }

        // If an exeption was provided, convert that exception to a usable string and attach
        // it to the end of the msg method.
        if (tr != null) {
            msg += "\n" + android.util.Log.getStackTraceString(tr);
        }

        // This is functionally identical to Log.x(tag, useMsg);
        // For instance, if priority were Log.VERBOSE, this would be the same as Log.v(tag, useMsg)
        android.util.Log.println(priority, tag, useMsg);

        // If this isn't the last node in the chain, move things along.
        if (mNext != null) {
            mNext.println(priority, tag, msg, tr);
        }
    }
}
