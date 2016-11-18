package com.jc.recyclerview.Common.logger;

/**
 * Created by jc on 9/26/2016.
 */
public interface LogNode {
    public void println(int priority,String tag,String msg,Throwable tr);
}
