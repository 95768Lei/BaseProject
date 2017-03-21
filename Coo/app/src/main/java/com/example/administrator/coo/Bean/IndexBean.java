package com.example.administrator.coo.Bean;

/**
 * Created by zhanglei on 2017/3/20 0020.
 * 记录每个要整体删除的字段的首位下标
 */

public class IndexBean {
    private int heardIndex;
    private int footerIndex;
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeardIndex() {
        return heardIndex;
    }

    public void setHeardIndex(int heardIndex) {
        this.heardIndex = heardIndex;
    }

    public int getFooterIndex() {
        return footerIndex;
    }

    public void setFooterIndex(int footerIndex) {
        this.footerIndex = footerIndex;
    }
}
