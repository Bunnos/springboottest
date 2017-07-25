package com.boot.web;

import com.boot.service.TransportService;
import com.boot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/29.
 */
@RestController
public class TestController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TransportService transportService;
    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/")
    public String test() {
        String s = transportService.transCategoriesDict();
        return s;
    }

    @RequestMapping("/relation")
    public String relation() {
        String s = transportService.transCategoriesRelation();
        return s;
    }

    @RequestMapping("/cate")
    public String categories() {
        String s = transportService.transCategories();
        return s;
    }


    @RequestMapping("/user")
    public String user() {
        String s = userService.transportUserInfo();
        return s;
    }

    @RequestMapping("/test")
    public String t() {
        logger.info("this is a log test");
        return "String";
    }

    @RequestMapping("/sort")
    public String categoriesRelationSort() {
        String s = transportService.categoriesRelationSort();
        return s;
    }
}
