package com.boot.web;

import com.boot.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/7/17.
 */
@RestController
@RequestMapping("/e")
public class EbookController {
    @Autowired
    private EbookService ebookService;

    @RequestMapping("/tran")
    public String transferSyncResByClassType() {
        String response;
        try {
            response = ebookService.transferData();
        } catch (Exception e) {
            response = e.getMessage();
        }
        return response;
    }
}
