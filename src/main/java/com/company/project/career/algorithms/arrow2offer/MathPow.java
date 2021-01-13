package com.company.project.career.algorithms.arrow2offer;

/**
 * 数值的整数次方
 * 
 * @author zhangyanxiang 2021年1月2日 下午6:02:31
 */
public class MathPow {

    public static void main(String[] args) {
        System.out.println(4.0 == pow(2.0, 2));
    }

    private static double pow(double base, int exponent) {

        if (base == 0 && exponent < 0)
            return 0;
        int absExponet = Math.abs(exponent);
        double pow = doPow(base, absExponet);
        if (exponent < 0)
            pow = 1 / pow;
        return pow;

    }

    private static double doPow(double base, int exponent) {
        double pow = 1;
        for (int i = 1; i <= exponent; i++) {
            pow *= base;
        }
        return pow;
    }

}
