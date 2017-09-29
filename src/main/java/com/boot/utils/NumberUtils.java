package com.boot.utils;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/7/5.
 */
public class NumberUtils {

    public static String generateUniqueId(String zj) {
        int seq = 1;
        String date = BaseUtils.formatDate(new Date(), "yyyyMMddHHmmss");
        try {
            if (zj == null) {
                seq = 0;
            } else {
                zj = zj.substring(("1" + date).length(), zj.length() - 3);
                if ("".equalsIgnoreCase(zj)) {
                    seq = 0;
                } else {
                    seq = Integer.parseInt(zj);
                }
            }
            if (seq == 0) {
                seq = 1;
            } else {
                seq++;
            }
        } catch (Exception e) {
        }

        String sseq = "";
        if (seq < 10) {
            sseq = "00" + seq;
        } else if (seq < 100) {
            sseq = "0" + seq;
        } else {
            sseq = seq + "";
        }

        String rnd = "";
        Random r = new Random((int) (Math.random() * 100));
        int rint = r.nextInt(100);
        if (rint < 10) {
            rnd = "00" + rint;
        } else if (rint < 100) {
            rnd = "0" + rint;
        } else {
            rnd = rint + "";
        }
        return "1" + date + sseq + rnd;
    }


    public static Map<String, String> transferEbookPhotoPath(String code) {
        Map<String, String> map = new HashMap();
        String substring = code.substring(0, code.indexOf("."));
        int count = 0;
        char[] array = substring.toCharArray();
        for (int i = array.length - 1; i > -1; i--) {
            if (array[i] > 'a' && array[i] < 'z' || array[i] > 'A' && array[i] < 'Z') {
                count = i;
                break;
            }
        }
        String number = substring.substring(count + 1);
        String preffix = substring.substring(0, count + 1);
        map.put("num", number);
        map.put("preffix", preffix);
        return map;
    }

    public static String transToThreePositionNum(int i) {
        DecimalFormat mFormat = new DecimalFormat("000");//确定格式，把1转换为001
        String s = mFormat.format(i);
        return s;
    }

    public static Map<String, String> transferEbookPhotoPathWithMonth(String code) {
        Map<String, String> map = new HashMap();
        String substring = code.substring(0, code.indexOf("."));
        String pre1 = substring.substring(0, substring.lastIndexOf("_"));
        boolean flag = false;
        if (pre1.indexOf("-") > -1) {
            String new1 = pre1.substring(pre1.length() - 3);
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(new1);
            if (isNum.matches()) {
                flag = true;
            }

            String pre2 = substring.substring(substring.lastIndexOf("_"));
            if (flag) {
                String number = pre1.substring(pre1.length() - 3);
                String preffix = new StringBuilder(pre1.substring(0,pre1.length() - 3)).append(pre2).toString();
                map.put("num", number);
                map.put("preffix", preffix);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        String code = "month_201010/gzsxxx4-6044_9M5g6d.jpg";
        NumberUtils.transferEbookPhotoPathWithMonth(code);

    }
}
