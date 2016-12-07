package com.jc.ultrapulltorefreshdemo.model;

/**
 * Created by ivyxjc on on 2016/12/7.
 * This work is licensed under a Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.
 */

public class News
{
    private String showapi_res_error;

    private String showapi_res_code;

    private Showapi_res_body showapi_res_body;

    public String getShowapi_res_error ()
    {
        return showapi_res_error;
    }

    public void setShowapi_res_error (String showapi_res_error)
    {
        this.showapi_res_error = showapi_res_error;
    }

    public String getShowapi_res_code ()
    {
        return showapi_res_code;
    }

    public void setShowapi_res_code (String showapi_res_code)
    {
        this.showapi_res_code = showapi_res_code;
    }

    public Showapi_res_body getShowapi_res_body ()
    {
        return showapi_res_body;
    }

    public void setShowapi_res_body (Showapi_res_body showapi_res_body)
    {
        this.showapi_res_body = showapi_res_body;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [showapi_res_error = "+showapi_res_error+", showapi_res_code = "+showapi_res_code+", showapi_res_body = "+showapi_res_body+"]";
    }
}