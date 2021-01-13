package com.company.project.career.algorithms.arrow2offer;

/**
 * 构建乘积数组<br>
 * 给定一个数组A[0, 1, …, n-1]，请构建一个数组B[0, 1, …, n-1]，其中B中的元素B[i] =A[0]×A[1]×…
 * ×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 @author zhangyanxiang 2021年1月3日 下午3:30:18
 */
public class BuildAProductArray {

    public static void main(String[] args) {
        int[] param = { 2, 5, 6 };
        for (int i : build(param)) {
            System.out.println(i);
        }
    }

    private static int[] build(int[] param) {

        int[] target = new int[param.length];
        int[] left = new int[param.length];
        int[] right = new int[param.length];
        left[0] = 1;
        right[param.length - 1] = 1;

        for (int i = 0; i < param.length; i++) {
            if (i > 0) {
                left[i] = left[i - 1] * param[i - 1];
                right[param.length - 1 - i] = right[param.length - i] * param[param.length - i];
            }
        }
        for (int i = 0; i < param.length; i++) {
            target[i] = left[i] * right[i];
        }

        return target;
    }
}
