package com.boot.web;

import com.boot.service.AsynResourceService;
import com.boot.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/7/7.
 */
@RestController
@RequestMapping("/r")
public class ResourcesController {
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private AsynResourceService asynResourceService;

    @RequestMapping("/synRes")
    public String transferSyncResByClassType(int classType) {
        String response;
        try {
            response = resourceService.transferSynByResourceClassType(classType);
        } catch (Exception e) {
            response = e.getMessage();
        }
        return response;
    }

    @RequestMapping("/asynRes")
    public String transferSyncResByClassType(String rname) {
        String response;
        try {
            response = asynResourceService.transferAsynByResourceName(rname);
        } catch (Exception e) {
            response = e.getMessage();
        }
        return response;
    }

    @RequestMapping("/setCode")
    public String setResourceCode() {
        try {
            resourceService.setResourceCode();
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    @RequestMapping("/changeCate")
    public String changeCate() {
        try {
            resourceService.changeCate();
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    @RequestMapping("/setContent")
    public String setContent(){
        try {
            asynResourceService.setContent();
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }
}
