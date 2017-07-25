package com.boot.web;

import com.boot.service.FileConvertService;
import com.boot.vo.FileConvertVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/7/18.
 */
@RestController
@RequestMapping("/c")
public class FileConvertController {
    @Autowired
    private FileConvertService convertService;

    @ResponseBody
    @RequestMapping("/convert")
    public String contertFile(){
        try {
            convertService.convertFile();
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }
    /**
     * 转换后回调地址
     * @param fileConvertVo
     */
    @RequestMapping("/convertFileCallBack")
    @ResponseBody
    public String convertFileCallBack(HttpServletResponse response, FileConvertVo fileConvertVo) {
        try {
            convertService.convertFileCallBack(response,fileConvertVo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }
}
