package com.boot.service;

/**
 * Created by Administrator on 2017/7/12.
 */
public interface AsynResourceService {
    String transferAsynByResourceName(String rName) throws Exception;

    void setContent() throws Exception;
}
