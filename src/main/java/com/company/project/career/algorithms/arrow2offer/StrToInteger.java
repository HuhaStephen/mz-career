package com.company.project.career.algorithms.arrow2offer;

/**
 * 把字符串转换成整数
 * 
 * @author zhangyanxiang 2021年1月3日 下午2:21:17
 */
public class StrToInteger {

    boolean isIllegalParam = false;

    public static void main(String[] args) {
        int num = strToInt("765983747");
        System.out.println(num);
    }

    private static int strToInt(String str) {
        //校验，非法输入，非数字，+-号，最大值

        int num = 0;

        for (int i = 0; i < str.length(); i++) {
            num += Math.pow(10, str.length() - 1 - i) * Integer.parseInt((str.charAt(i)) + "");
        }

        return num;
    }

}
