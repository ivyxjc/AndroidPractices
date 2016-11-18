package com.jc.recyclerview.Common.logger;

/**
 * Created by jc on 9/26/2016.
 */
public class Log {

    public static final int NONE = -1;
    public static final int VERBOSE = android.util.Log.VERBOSE;
    public static final int DEBUG = android.util.Log.DEBUG;
    public static final int INFO = android.util.Log.INFO;
    public static final int WARN = android.util.Log.WARN;
    public static final int ERROR = android.util.Log.ERROR;
    public static final int ASSERT = android.util.Log.ASSERT;

    private static LogNode mLogNode;

    public static LogNode getLogNode() {
        return mLogNode;
    }

    /**
     * Sets the LogNode data will be sent to.
     */
    public static void setLogNode(LogNode node) {
        mLogNode = node;
    }

    public static void println(int priority,String tag,String msg,Throwable tr){
        mLogNode.println(priority,tag,msg,tr);
    }

    public static void println(int priority,String tag,String msg){
        mLogNode.println(priority,tag,msg,null);
    }

    public static void v(String tag,String msg){
        println(VERBOSE,tag,msg);
    }

    public static void v(String tag,String msg, Throwable tr){
        println(VERBOSE,tag,msg,tr);
    }

    public static void d(String tag,String msg){
        println(DEBUG,tag,msg);
    }

    public static void d(String tag,String msg, Throwable tr){
        println(DEBUG,tag,msg,tr);
    }

    public static void i(String tag,String msg){
        println(INFO,tag,msg);
    }

    public static void i(String tag,String msg, Throwable tr){
        println(INFO,tag,msg,tr);
    }


    public static void w(String tag,String msg){
        println(WARN,tag,msg);
    }

    public static void w(String tag,String msg, Throwable tr){
        println(WARN,tag,msg,tr);
    }

    public static void e(String tag,String msg){
        println(ERROR,tag,msg);
    }

    public static void e(String tag,String msg, Throwable tr){
        println(ERROR,tag,msg,tr);
    }

    public static void a(String tag,String msg){
        println(ASSERT,tag,msg);
    }

    public static void a(String tag,String msg, Throwable tr){
        println(ASSERT,tag,msg,tr);
    }
}
