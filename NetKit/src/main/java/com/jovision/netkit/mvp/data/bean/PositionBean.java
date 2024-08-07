package com.jovision.netkit.mvp.data.bean;

/**
 * 位置坐标数据类
 *
 * @author liteng
 * @date 2022/12/6
 */
public class PositionBean {
    private int x;
    private int y;

    private int endx;
    private int endy;

    public PositionBean(int x, int y,int endx, int endy) {
        this.x = x;
        this.y = y;
        this.endx = endx;
        this.endy = endy;
    }

    public PositionBean(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getEndx() {
        return endx;
    }

    public void setEndx(int endx) {
        this.endx = endx;
    }

    public int getEndy() {
        return endy;
    }

    public void setEndy(int endy) {
        this.endy = endy;
    }
}
