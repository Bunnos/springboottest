package com.boot.service;

import com.boot.vo.FileConvertVo;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/7/18.
 */
public interface FileConvertService {
    /**
     * 文件转化
     * @return

     */
    public String convertFile() throws Exception;

    /**
     * 转换后回调
     * @param fileConvertVo
     * @return
     */
    public String convertFileCallBack(HttpServletResponse response, FileConvertVo fileConvertVo) throws Exception;
}
