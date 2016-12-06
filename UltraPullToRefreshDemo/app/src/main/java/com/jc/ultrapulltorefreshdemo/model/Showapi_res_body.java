package com.jc.ultrapulltorefreshdemo.model;

/**
 * Created by jc on 12/6/2016.
 */


public class Showapi_res_body
{
    private String ret_code;

    private Pagebean pagebean;

    public String getRet_code ()
    {
        return ret_code;
    }

    public void setRet_code (String ret_code)
    {
        this.ret_code = ret_code;
    }

    public Pagebean getPagebean ()
    {
        return pagebean;
    }

    public void setPagebean (Pagebean pagebean)
    {
        this.pagebean = pagebean;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ret_code = "+ret_code+", pagebean = "+pagebean+"]";
    }
}

