package com.company.project.career.algorithms.arrow2offer;

import java.util.LinkedList;
import java.util.List;

/**
 * 圆圈中最后剩下的数字<br>
 * 0, 1, … , n-1 这 n 个数字排成一个圈圈，从数字 0 开始每次从圆圏里删除第 m 个数字。求出这个圈圈里剩下的最后一个数字。 例如： 0，
 * 1， 2， 3， 4 这 5 个数字组成一个圆圈，从数字 0 开始每次删除第三个数字，则删除的前四个数字一次为 2， 0， 4，
 * 1，因此，最后剩下的数字是 3.
 * 
 * @author zhangyanxiang 2021年1月3日 下午5:30:42
 */
public class TheLastNumberOfCircle {

    public static void main(String[] args) {
        System.out.println(lastNum(5, 3));
        System.out.println(3 == lastNum(5, 3));

    }

    private static int lastNum(int n, int m) {
        if (n < 2)
            return n;

        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        int deleteIndex = 0;
        while (list.size() > 1) {
            for (int i = 0; i < m - 1; i++) {
                if (index == list.size() - 1) {
                    index = 0;
                } else {
                    index++;
                }

            }
            deleteIndex = index;
            if (index == list.size() - 1)
                index = 0;
            list.remove(deleteIndex);
        }
        return list.get(0);

    }

}
