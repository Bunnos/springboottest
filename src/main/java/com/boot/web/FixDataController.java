package com.boot.web;

import com.boot.service.FixDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/f")
public class FixDataController {
    @Autowired
    private FixDataService fixDataService;

    @RequestMapping("fixWuli")
    public String fixWuli() {
        try {
            fixDataService.fixWuli();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }

    @RequestMapping("fixPhoto")
    public String fixPhoto() {
        try {
            fixDataService.fixPhoto();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }
}
