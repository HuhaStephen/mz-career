package com.company.project.career.algorithms.arrow2offer;

/**
 * 数组中重复的数字：<br>
 * 在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某些数字是重复的，但是不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。例如，如果输入长度为7,的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数组2或者3。
 * 
 * @author zhangyanxiang 2020年11月5日 上午10:07:14
 */
public class RepeatNumInArray {

    public static void main(String[] args) {
        int[] data = { 4, 6, 1, 0, 2, 5, 3 };
        System.out.println(findRepeatNum(data));

    }

    /**
     * 思路：<br>
     * 不重复的话，数组中的数字刚好能够一一填充到 数组的 0~n-1 的索引位置上，如果在把当前数字 a 填充到 a 索引上时候，a 索引上的数字刚好是
     * a ，则表示有重复数字
     * 
     * @param data
     * @return
     */
    public static int findRepeatNum(int[] data) {//{ 2, 3, 1, 0, 2, 5, 3 }

        for (int i = 0; i < data.length; i++) {
            int index = data[i];
            while (index != i) {
                if (index == data[index])
                    return index;

                int temp = data[index];
                data[index] = data[i];
                data[i] = temp;

                index = data[i];
            }
        }
        return -1;
    }

}
