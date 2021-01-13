package com.company.project.career.algorithms.arrow2offer;

/**
 * 求斐波那契数列的第n项<br>
 * 类似问题：青蛙跳台阶问题
 * 
 * @author zhangyanxiang 2020年12月29日 下午4:13:33
 */
public class Fibonacci {
    /*
     * 解法1、用递归 解法；2、从下往上计算 f0=0 f1=1 f2=f1+f0=1 f3=f2+f1=1+1=2 f4=f3+f2=3 f5=5
     * f6=8 f7=13
     */
    public static void main(String[] args) {
        System.out.println(5 == fibonacci(5));
        System.out.println(377 == fibonacci(14));
    }

    private static int fibonacci(int n) {
        if (n <= 1)
            return n;
        int fi = 0;
        int fi_1 = 1;
        int fi_2 = 0;
        for (int i = 2; i <= n; i++) {
            fi = fi_1 + fi_2;
            fi_2 = fi_1;
            fi_1 = fi;
        }
        return fi;
    }

}
