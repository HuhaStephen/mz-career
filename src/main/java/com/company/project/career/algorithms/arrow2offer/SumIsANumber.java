package com.company.project.career.algorithms.arrow2offer;

/**
 * 和为s的数字<br>
 * 题目1：和为s的2个数字。<br>
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数字，使得它们的和正好是s。<br>
 * 题目2：和为s的连续正数序列。<br>
 * 输入一个正数s，打印所有和为s的连续正数序列。
 * 
 * @author zhangyanxiang 2021年1月4日 上午11:32:40
 */
public class SumIsANumber {

    public static void main(String[] args) {
        System.out.println(sum(3, 9));
        print(15);
    }

    private static void print(int s) {
        if (s <= 0)
            return;

        int index = -1;
        for (int i = (s + 1) / 2; i > 1; i--) {
            index = i - 1;
            while (index > 0) {
                if (s == sum(index, i)) {
                    print(index, i);
                    break;
                }
                index--;
            }

        }

    }

    private static void print(int left, int right) {
        System.out.println();
        for (int i = left; i <= right; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int sum(int left, int right) {
        int num = (right - left) + 1;
        if (num % 2 == 0) {
            return (left + right) * num / 2;
        } else {
            return (left + right) * (num - 1) / 2 + (left + right) / 2;
        }

    }

}
