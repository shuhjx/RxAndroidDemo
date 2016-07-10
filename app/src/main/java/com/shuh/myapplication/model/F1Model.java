package com.shuh.myapplication.model;

import com.shuh.mymodule.model.BaseModel;

/**
 * Created by Administrator on 2016/7/9 0009.
 */
public class F1Model extends BaseModel {

    /**
     * content : 一个苍蝇落在了丈夫的光头上，妻子扑哧的笑了，丈夫感到莫名其妙的问妻子笑什么？妻子说：一只苍蝇落在了你的光头上，你猜我想起了什么？丈夫摸着铮亮的光头问想起了什么？妻子说：我想到了苍蝇不叮无逢的蛋！
     * hashId : 46890e404a6c5dd557cd8e950601780c
     * unixtime : 1467129231
     * updatetime : 2016-06-28 23:53:51
     * url : http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201607/09/E21156C522572A4CC0CF677897C816AA.gif
     */

    private String content;
    private String hashId;
    private int unixtime;
    private String updatetime;
    private String url;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public int getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(int unixtime) {
        this.unixtime = unixtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "F1Model{" +
                "content='" + content + '\'' +
                ", hashId='" + hashId + '\'' +
                ", unixtime=" + unixtime +
                ", updatetime='" + updatetime + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
