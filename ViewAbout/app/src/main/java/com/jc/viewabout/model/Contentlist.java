package com.jc.viewabout.model;

public class Contentlist
{
    private String pubDate;

    private String channelName;

    private String desc;

    private String sentiment_display;

    private String channelId;

    private String nid;

    private String link;

    private String content;



    private String title;



    private String source;

    private String html;

    public String getPubDate ()
    {
        return pubDate;
    }

    public void setPubDate (String pubDate)
    {
        this.pubDate = pubDate;
    }

    public String getChannelName ()
    {
        return channelName;
    }

    public void setChannelName (String channelName)
    {
        this.channelName = channelName;
    }

    public String getDesc ()
    {
        return desc;
    }

    public void setDesc (String desc)
    {
        this.desc = desc;
    }

    public String getSentiment_display ()
    {
        return sentiment_display;
    }

    public void setSentiment_display (String sentiment_display)
    {
        this.sentiment_display = sentiment_display;
    }

    public String getChannelId ()
    {
        return channelId;
    }

    public void setChannelId (String channelId)
    {
        this.channelId = channelId;
    }

    public String getNid ()
    {
        return nid;
    }

    public void setNid (String nid)
    {
        this.nid = nid;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }


    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }


    public String getSource ()
    {
        return source;
    }

    public void setSource (String source)
    {
        this.source = source;
    }

    public String getHtml ()
    {
        return html;
    }

    public void setHtml (String html)
    {
        this.html = html;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [pubDate = "+pubDate+", channelName = "+channelName+", desc = "+desc+", sentiment_display = "+sentiment_display+", channelId = "+channelId+", nid = "+nid+", link = "+link+", content = "+content+", title = "+title+", source = "+source+", html = "+html+"]";
    }
}