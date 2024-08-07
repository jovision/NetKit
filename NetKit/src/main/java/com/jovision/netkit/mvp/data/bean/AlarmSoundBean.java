package com.jovision.netkit.mvp.data.bean;

/**
 * Created by deli on 2020/12/01.
 */

public class AlarmSoundBean {


    /**
     * file_name : aaaaa
     * file_type : aac
     */

    private String file_name;
    private String file_type;
    private String file_data;

    public String getFile_data() {
        return file_data;
    }

    public void setFile_data(String file_data) {
        this.file_data = file_data;
    }



    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }
}
