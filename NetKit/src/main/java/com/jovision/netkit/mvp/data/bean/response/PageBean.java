package com.jovision.netkit.mvp.data.bean.response;

public class PageBean {
    private int total;
    private int curPage;
    private int size;

    @Override
    public String toString() {
        return "PageBean{" +
                "total=" + total +
                ", curPage=" + curPage +
                ", size=" + size +
                '}';
    }

    public PageBean(int total, int curPage, int size) {
        this.total = total;
        this.curPage = curPage;
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
