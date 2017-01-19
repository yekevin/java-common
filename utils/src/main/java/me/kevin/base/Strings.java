package me.kevin.base;

/**
 * @author Kevin
 * @description
 * @date 2017/1/19
 */
public class Strings {

    /**
     * 判断字符串是否为null或""
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        return s == null || "".equals(s);
    }

}
