package com.boot.utils;

import com.alibaba.druid.util.StringUtils;
import com.boot.constants.CommonConst;
import com.boot.constants.NewResourceTypeConst;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/7.
 */
public class ResourceTypeTransfeUtils {

    public static NewResourceTypeConst transerferResouceType(String type) {
        NewResourceTypeConst newType;
        switch (type) {
            case "file":
                newType = NewResourceTypeConst.UNSURE;
                break;
            case "pic":
                newType = NewResourceTypeConst.IMAGE;
                break;
            case "text":
                newType = NewResourceTypeConst.DOCUMENT;
                break;
            case "video":
                newType = NewResourceTypeConst.VIDEO;
                break;
            default:
                newType = NewResourceTypeConst.OTHER;
                break;
        }
        return newType;
    }

    public static NewResourceTypeConst transferFileType(String content) {
        NewResourceTypeConst type = NewResourceTypeConst.DOCUMENT;
        if (!StringUtils.isEmpty(content)) {
            int i = content.lastIndexOf(".");
            if (i > -1) {
                String suffix = content.substring(i, content.length());
                if (CommonConst.ZIP.equals(suffix) || CommonConst.RAR.equals(suffix)) {
                    type = NewResourceTypeConst.OTHER;
                }
            }
        }
        return type;
    }

    public static boolean isEndWith(String content, String suffix) {
        boolean flag = false;
        if (!StringUtils.isEmpty(content)) {
            int i = content.lastIndexOf(".");
            if (i > -1) {
                String substring = content.substring(i, content.length());
                if (suffix.equals(substring)) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public static Map<String, String> getFileType(String path) {
        NewResourceTypeConst newType;
        if (isEndWith(path, CommonConst.PDF) || isEndWith(path, CommonConst.SWF) || isEndWith(path, CommonConst.PPT) || isEndWith(path, CommonConst.DOC)) {
            newType = NewResourceTypeConst.DOCUMENT;
        } else if (isEndWith(path, CommonConst.RM) || isEndWith(path, CommonConst.RMVB) || isEndWith(path, CommonConst.FLV)) {
            newType = NewResourceTypeConst.VIDEO;
        } else if (isEndWith(path, CommonConst.JPG) || isEndWith(path, CommonConst.PNG)) {
            newType = NewResourceTypeConst.IMAGE;
        } else {
            newType = NewResourceTypeConst.OTHER;
        }
        Map<String, String> map = new HashMap<>();
        map.put("formatId", newType.getName());
        map.put("formatValue", newType.getDesc());
        return map;
    }
}
