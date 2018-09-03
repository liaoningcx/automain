package com.mic.generator.beforecommon.util.string;

import org.apache.commons.lang.StringUtils;

/**
 * String转换工具 -- dbcxue
 */
public class StringUtil {

    /**
     * 首字母转小写
     * @param s
     * @return
     */
    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    /**
     * 首字母大写
     * @param s
     * @return
     */
    public static String toUpperCaseFirstOne(String s){
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }


    /**
     * 字符串驼峰形式转换（首字母小写）
     * @param s 要转换的字符串
     * @param segmentation 分割符
     * @return 转换后的字符串
     */
    public static String humpToLowerCaseFirstOne(String s, String segmentation){
        String[] args = StringUtils.split(s,segmentation);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<args.length; i++){
            if(i==0){
                sb.append(toLowerCaseFirstOne(StringUtils.lowerCase(args[i])));
            }else{
                sb.append(toUpperCaseFirstOne(StringUtils.lowerCase(args[i])));
            }
        }
        return sb.toString();
    }

    /**
     * 字符串驼峰形式转换（首字母小写）
     * @param s 要转换的字符串
     * @param segmentation 分割符
     * @return 转换后的字符串
     */
    public static String humptoUpperCaseFirstOne(String s, String segmentation){
        String[] args = StringUtils.split(s,segmentation);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<args.length; i++){
            sb.append(toUpperCaseFirstOne(StringUtils.lowerCase(args[i])));
        }
        return sb.toString();
    }
}
