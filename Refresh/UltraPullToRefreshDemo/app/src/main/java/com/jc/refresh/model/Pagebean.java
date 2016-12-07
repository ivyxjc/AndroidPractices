package com.jc.refresh.model;

import java.util.ArrayList;

/**
 * Created by jc on 12/6/2016.
 */

public class Pagebean
{
    private String allPages;

    private ArrayList<Contentlist> contentlist;

    private String currentPage;

    private String allNum;

    private String maxResult;

    public String getAllPages ()
    {
        return allPages;
    }

    public void setAllPages (String allPages)
    {
        this.allPages = allPages;
    }

    public ArrayList<Contentlist> getContentlist ()
    {
        return contentlist;
    }

    public void setContentlist (ArrayList<Contentlist> contentlist)
    {
        this.contentlist = contentlist;
    }

    public String getCurrentPage ()
    {
        return currentPage;
    }

    public void setCurrentPage (String currentPage)
    {
        this.currentPage = currentPage;
    }

    public String getAllNum ()
    {
        return allNum;
    }

    public void setAllNum (String allNum)
    {
        this.allNum = allNum;
    }

    public String getMaxResult ()
    {
        return maxResult;
    }

    public void setMaxResult (String maxResult)
    {
        this.maxResult = maxResult;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [allPages = "+allPages+", contentlist = "+contentlist+", currentPage = "+currentPage+", allNum = "+allNum+", maxResult = "+maxResult+"]";
    }
}
