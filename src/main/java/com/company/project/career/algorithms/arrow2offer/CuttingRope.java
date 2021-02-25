package com.company.project.career.algorithms.arrow2offer;

/**
 * 剪绳子<br>
 * 给定一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],…,k[m]。请问k[0]* k[1]
 * * … *k[m]可能的最大乘积是多少？例如长度为8的绳子，可以剪成2，3，3段，最大乘积为18。
 * 
 * @author zhangyanxiang 2021年1月2日 下午5:24:10
 */
public class CuttingRope {

    public static void main(String[] args) {
        System.out.println(4 == max(4));
        System.out.println(18 == max(8));

        System.out.println(4 == max2(4));
        System.out.println(18 == max2(8));
    }

    /**
     * 分析过程：
     * <p>
     * 剪长度为n的绳子，当剪第一刀的时候，可以剪 1、2、3...n-1 的长度，这时候的最大乘积是 f(n)=max(f(i)*f(n-i)) ，
     * <p>
     * 剪长度为n的绳子，<br>
     * 剪第一刀时，最大乘积为
     * f(n)=max(f(i)*f(n-i))，（这样就将长度为n的绳子的最大乘积问题分解为，两个子问题，长度为i的绳子的最大乘积
     * 、长度为n-i的绳子的最大乘积
     * ，而求出两个子问题的最大乘积，相应的长度为n的绳子的最大乘积就解出来了；而对于长度为i、n-i的两个绳子，可以采用类似的分解思路。）<br>
     * （所以对于给定长度的绳子，剪一刀，就把当前绳子的最大乘积分解为两段子绳子的最大乘积）<br>
     * （每剪一刀，就相当于做了一次分解）
     * 
     * @param n
     * @return
     */
    private static int max(int n) {
        //绳子也可以不剪，就是本身长度
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 3;

        int[] cache = new int[n + 1];//长度为n的绳子，n也要作为数组的一个索引可以被访问
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;
        cache[3] = 3;

        int max = 0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                max = max > cache[j] * cache[i - j] ? max : cache[j] * cache[i - j];
            }
            cache[i] = max;

        }
        return cache[n];

    }

    /**
     * 贪心算法
     * 
     * @param n
     * @return
     */
    private static int max2(int n) {
        //绳子也可以不剪，就是本身长度
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 3;

        int timesOf3 = n / 3;
        if (n - 3 * timesOf3 == 1)
            timesOf3 -= 1;
        int timesOf2 = (n - 3 * timesOf3) / 2;
        Double maxD = Math.pow(3, timesOf3) * Math.pow(2, timesOf2);
        return maxD.intValue();

    }
}
