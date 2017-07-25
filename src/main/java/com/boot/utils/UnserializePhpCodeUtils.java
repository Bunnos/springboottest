package com.boot.utils;

import com.alibaba.druid.util.StringUtils;
import com.boot.model.master.BokaNews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/11.
 */
public class UnserializePhpCodeUtils {


    public static String unSerializePhpCode(BokaNews entity,String content) {
        String newContent = "";
        try {
            if (!StringUtils.isEmpty(content) && content.length() < 253) {
                Object unserialize = PHPSerializer.unserialize(content.getBytes());
                if (unserialize != null) {
                    if (unserialize instanceof List) {
                        List<List> list = (List<List>) unserialize;
                        if (list != null && list.size() > 0) {
                            for (List<String> entityList : list) {
                                if (entityList != null && entityList.size() > 0) {
                                    newContent = entityList.get(0);
                                }
                            }
                        }
                    }
                    if (unserialize instanceof Map) {
                        Map<String, List> map = (HashMap) unserialize;
                        for (Map.Entry set : map.entrySet()) {
                            List<String> mapList = (List) set.getValue();
                            if (mapList != null && mapList.size() > 0) {
                                newContent = mapList.get(0);
                            }
                        }
                    }
                }
            }else {
                System.out.println("id:"+entity.getId());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return newContent;
    }

    public static List<String> unEbookSerializePhpCode(String content) {
        List<String> result = new ArrayList<>();
        try {
//            if (!StringUtils.isEmpty(content) && content.length() < 253) {
            if (!StringUtils.isEmpty(content)) {
                Object unserialize = PHPSerializer.unserialize(content.getBytes());
                if (unserialize != null) {
                    if (unserialize instanceof List) {
                        List<List> list = (List<List>) unserialize;
                        if (list != null && list.size() > 0) {
                            result = list.get(0);
                        }
                    }
                    if (unserialize instanceof Map) {
                        Map<String, List> map = (HashMap) unserialize;
                        for (Map.Entry set : map.entrySet()) {
                            List<String> mapList  = (List) set.getValue();
                            if (mapList != null && mapList.size() > 0) {
                                result.add(mapList.get(0));
                            }
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
//        String s = "a:1:{i:0;a:2:{i:0;s:87:\"month_201411/6YCJ5LuMi0x44CK5LuO5bmz6Z2i5ZCR6YeP5Yiw56m66Ze05ZCR6YeP44CL5LqV_HjwPo5.ppt\";i:1;s:0:\"\";}}";
//        String a = "a:1:{i:1;a:2:{i:0;s:88:\"month_201409/TWljcm9zb2Z0UG93ZXJQb2ludC3kuI3nlKjmloflrZfnmoTkuablkozkv6Fb5YW8_gKstuH.swf\";i:1;s:0:\"\";}}";
//        String t = "a:3:{i:0;a:2:{i:0;s:84:\"month_201506/6JC95a6e44CK5oyH5Y2X44CL57K56We77yM5LD6Lb5bm85YS5YGl5bq35YR5_XI8vMK.ppt\";i:1;s:0:\"\";}i:1;a:2:{i:0;s:84:\"month_201506/6JC95a6e44CK5oyH5Y2X44CL57K56We77yM5LD6Lb5bm85YS5YGl5bq35YR5_SO2E7W.swf\";i:1;s:0:\"\";}i:2;a:2:{i:0;";
//        String str = "a:6:{i:35;a:1:{i:0;s:27:\"2014gzls/bx3/gzlsbx3035.jpg\";}i:36;a:1:{i:0;s:27:\"2014gzls/bx3/gzlsbx3036.jpg\";}i:37;a:1:{i:0;s:27:\"2014gzls/bx3/gzlsbx3037.jpg\";}i:38;a:1:{i:0;s:27:\"2014gzls/bx3/gzlsbx3038.jpg\";}i:39;a:1:{i:0;s:27:\"2014gzls/bx3/gzlsbx3039.jpg\";}i:40;a:1:{i:0;s:27:\"2014gzls/bx3/gzlsbx3040.jpg\";}}";
//        List<String> list = UnserializePhpCodeUtils.unEbookSerializePhpCode(str);
        String s = "abcd0123".replaceAll("\\d+", "");
        String n = "abcd0123".replaceAll("\\D+", "");
        String str = "xx3-3/3-3069.jpg";
        String substring = str.substring(0,str.indexOf("."));
        int count =0;
        char[] array = substring.toCharArray();
        for (int i = array.length-1; i > -1; i--) {
            if (array[i] > 'a' && array[i] < 'z' || array[i] > 'A' && array[i] < 'Z') {
                count = i;
                break;
            }
        }
        String substring3 = substring.substring(count+1);
        String substring4 = substring.substring(0,count+1);
        System.out.println("substring3: "+substring3);
        System.out.println("substring4: "+substring4);
    }
}

