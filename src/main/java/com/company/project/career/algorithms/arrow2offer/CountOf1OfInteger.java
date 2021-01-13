package com.company.project.career.algorithms.arrow2offer;

/**
 * 二进制中1的个数
 * 
 * @author zhangyanxiang 2021年1月2日 下午5:43:11
 */
public class CountOf1OfInteger {

    public static void main(String[] args) {
        System.out.println(2 == count(9));
    }

    private static int count(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

}
