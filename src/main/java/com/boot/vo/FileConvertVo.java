package com.boot.vo;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/18.
 */
public class FileConvertVo {
    private String busiId; // 业务id
    private String conertState; // 转换状态
    private Date conertDate; // 转换请求时间

    private String conv_url_middle; // 转换后中间文件
    private String conv_url_result; // 转换后最终文件
    private String conv_id; // 转换文件id

    public String getBusiId() {
        return busiId;
    }

    public void setBusiId(String busiId) {
        this.busiId = busiId;
    }

    public String getConertState() {
        return conertState;
    }

    public void setConertState(String conertState) {
        this.conertState = conertState;
    }

    public Date getConertDate() {
        return conertDate;
    }

    public void setConertDate(Date conertDate) {
        this.conertDate = conertDate;
    }

    public String getConv_url_middle() {
        return conv_url_middle;
    }

    public void setConv_url_middle(String conv_url_middle) {
        this.conv_url_middle = conv_url_middle;
    }

    public String getConv_url_result() {
        return conv_url_result;
    }

    public void setConv_url_result(String conv_url_result) {
        this.conv_url_result = conv_url_result;
    }

    public String getConv_id() {
        return conv_id;
    }

    public void setConv_id(String conv_id) {
        this.conv_id = conv_id;
    }
}
