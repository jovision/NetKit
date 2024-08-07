package com.jovision.netkit.mvp.data.bean;

import java.util.List;

/**
 * Copyright©中维世纪
 *
 * @author deli
 * 创建日期：2020/11/12
 * 描述：
 */
public class PlayCallBackVideosBean {


    /**
     * page : {"total":69,"curPage":1,"size":69}
     * items : [{"fileName":"/progs/rec/00/20201113/N01000000.mp4","startTime":"20201113000000","endTime":"20201113001002","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01001002.mp4","startTime":"20201113001002","endTime":"20201113002002","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01002003.mp4","startTime":"20201113002003","endTime":"20201113003004","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01003005.mp4","startTime":"20201113003005","endTime":"20201113004006","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01004007.mp4","startTime":"20201113004007","endTime":"20201113005008","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01005008.mp4","startTime":"20201113005008","endTime":"20201113010010","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01010010.mp4","startTime":"20201113010010","endTime":"20201113011010","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01011011.mp4","startTime":"20201113011011","endTime":"20201113012012","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01012013.mp4","startTime":"20201113012013","endTime":"20201113013014","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01013014.mp4","startTime":"20201113013014","endTime":"20201113014016","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01014016.mp4","startTime":"20201113014016","endTime":"20201113015018","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01015018.mp4","startTime":"20201113015018","endTime":"20201113020018","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01020019.mp4","startTime":"20201113020019","endTime":"20201113021020","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01021021.mp4","startTime":"20201113021021","endTime":"20201113022022","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01022022.mp4","startTime":"20201113022022","endTime":"20201113023024","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01023024.mp4","startTime":"20201113023024","endTime":"20201113024024","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01024026.mp4","startTime":"20201113024026","endTime":"20201113025026","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01025027.mp4","startTime":"20201113025027","endTime":"20201113030028","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01030029.mp4","startTime":"20201113030029","endTime":"20201113031030","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01031030.mp4","startTime":"20201113031030","endTime":"20201113032030","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01032031.mp4","startTime":"20201113032031","endTime":"20201113033032","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01033033.mp4","startTime":"20201113033033","endTime":"20201113034034","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01034035.mp4","startTime":"20201113034035","endTime":"20201113035036","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01035036.mp4","startTime":"20201113035036","endTime":"20201113040038","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01040038.mp4","startTime":"20201113040038","endTime":"20201113041040","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01041040.mp4","startTime":"20201113041040","endTime":"20201113042040","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01042041.mp4","startTime":"20201113042041","endTime":"20201113043044","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01043044.mp4","startTime":"20201113043044","endTime":"20201113044044","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01044045.mp4","startTime":"20201113044045","endTime":"20201113045046","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01045047.mp4","startTime":"20201113045047","endTime":"20201113050048","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01050049.mp4","startTime":"20201113050049","endTime":"20201113051050","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01051050.mp4","startTime":"20201113051050","endTime":"20201113052050","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01052051.mp4","startTime":"20201113052051","endTime":"20201113053052","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01053053.mp4","startTime":"20201113053053","endTime":"20201113054054","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01054055.mp4","startTime":"20201113054055","endTime":"20201113055056","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01055056.mp4","startTime":"20201113055056","endTime":"20201113060058","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01060058.mp4","startTime":"20201113060058","endTime":"20201113061100","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01061100.mp4","startTime":"20201113061100","endTime":"20201113062100","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01062101.mp4","startTime":"20201113062101","endTime":"20201113063102","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01063104.mp4","startTime":"20201113063104","endTime":"20201113064104","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01064105.mp4","startTime":"20201113064105","endTime":"20201113065106","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01065106.mp4","startTime":"20201113065106","endTime":"20201113070108","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01070108.mp4","startTime":"20201113070108","endTime":"20201113071110","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01071110.mp4","startTime":"20201113071110","endTime":"20201113072112","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01072112.mp4","startTime":"20201113072112","endTime":"20201113073114","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01073114.mp4","startTime":"20201113073114","endTime":"20201113074116","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01074116.mp4","startTime":"20201113074116","endTime":"20201113075118","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01075118.mp4","startTime":"20201113075118","endTime":"20201113080118","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01080119.mp4","startTime":"20201113080119","endTime":"20201113081118","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01081118.mp4","startTime":"20201113081118","endTime":"20201113082120","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01082120.mp4","startTime":"20201113082120","endTime":"20201113083120","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01083120.mp4","startTime":"20201113083120","endTime":"20201113084120","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01084120.mp4","startTime":"20201113084120","endTime":"20201113085124","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01085124.mp4","startTime":"20201113085124","endTime":"20201113090126","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01090126.mp4","startTime":"20201113090126","endTime":"20201113091128","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01091128.mp4","startTime":"20201113091128","endTime":"20201113092130","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01092130.mp4","startTime":"20201113092130","endTime":"20201113093130","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01093131.mp4","startTime":"20201113093131","endTime":"20201113094132","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01094133.mp4","startTime":"20201113094133","endTime":"20201113095134","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01095136.mp4","startTime":"20201113095136","endTime":"20201113100138","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01100138.mp4","startTime":"20201113100138","endTime":"20201113101140","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01101140.mp4","startTime":"20201113101140","endTime":"20201113102142","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01102143.mp4","startTime":"20201113102143","endTime":"20201113103142","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01103143.mp4","startTime":"20201113103143","endTime":"20201113104146","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01104146.mp4","startTime":"20201113104146","endTime":"20201113105148","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01105149.mp4","startTime":"20201113105149","endTime":"20201113110150","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01110151.mp4","startTime":"20201113110151","endTime":"20201113111152","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01111152.mp4","startTime":"20201113111152","endTime":"20201113111320","recordType":"normal"},{"fileName":"/progs/rec/00/20201113/N01111152.mp4","startTime":"20201113111152","endTime":"20201113111320","recordType":"normal"}]
     */

    private PageBean page;
    private List<PlayBackItemsBean> items;

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public List<PlayBackItemsBean> getItems() {
        return items;
    }

    public void setItems(List<PlayBackItemsBean> items) {
        this.items = items;
    }

    public static class PageBean {
        /**
         * total : 69
         * curPage : 1
         * size : 69
         */

        private int total;
        private int curPage;
        private int size;

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

}
