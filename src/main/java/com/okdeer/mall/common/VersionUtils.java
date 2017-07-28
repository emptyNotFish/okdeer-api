package com.okdeer.mall.common;

import java.util.Comparator;

import org.springframework.util.StringUtils;

/**
 * 版本号工具类 版本号的格式为三段纯数字格式比如1.0.1
 * @author Administrator
 *
 */
public class VersionUtils implements Comparator<String> {
    
    /**
     * 版本号比较器类
     * 比较版本号的大小
     * 版本号的格式为三段纯数字格式比如1.0.1
     * 
     * @author zhaoqc
     */
    @Override
    public int compare(String v1, String v2) {
        String[] v1Segments = v1.split("\\.");
        String[] v2Segments = v2.split("\\.");
        
        for(int i = 0; i <= 2 ; i++) {
            Integer seg1 = Integer.parseInt(v1Segments[i]);
            Integer seg2 = Integer.parseInt(v2Segments[i]);
            
            if(seg1.compareTo(seg2) != 0) {
                return seg1.compareTo(seg2);
            }
        }
        return 0;
    }
    
    /**
     * 计算字符str2在str1里出现的次数
     * 
     * @param counter计数器初始值
     * @param str1
     * @param str2
     * @return
     */
    private static int countStr(int counter, String str1, String str2) {
        if (str1.indexOf(str2) != -1) {
            counter++;
            return countStr(counter, str1.substring(str1.indexOf(str2) + str2.length()), str2);
        }
        return counter;
    }
    
    /**
     * 检查version的格式，正确的格式为V开头三段比如，V1.0.0
     * @param version
     * @return
     */
    public static boolean vaildateVersion(String version) {
        if(StringUtils.isBlank(version)){
            return false;
        }
        char V = version.charAt(0);
        if ('V' != V) {
            return false;
        }

        int num = countStr(0, version, ".");
        if (num != 2) {
            return false;
        }

        return true;
    }
    
    /**
     * 去掉版本开头的V字符和小版本号
     * @param version
     * @return
     */
    public static String rmFirstCharOfVersion(String version) {
        if(version.indexOf("_") != -1) {
            return version.substring(1, version.indexOf("_"));
        }
        
        return version.substring(1, version.length());
    }
    
    /**
     * 去除版本号中小的版本号
     * @param version
     * @return
     */
    public static String simpleVersion(String version) {
        if(version.indexOf("_") != -1) {
            return version.substring(0, version.indexOf("_"));
        } 
        return version;
    }
}
