package com.company.project.career.algorithms.arrow2offer;

/**
 * 旋转数组的最小数字<br>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}
 * 为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * 
 * @author zhangyanxiang 2020年12月29日 下午6:46:22
 */
public class MinimumNumberInRotatedArray {

    public static void main(String[] args) {
        //testcase-1
        int[] data1 = { 3, 4, 5, 1, 2 };
        System.out.println(getMinimumNumberInRotatedArray(data1, 0, data1.length - 1));
    }

    //以升序为例
    private static int getMinimumNumberInRotatedArray(int[] data, int left, int right) {
        if (right - left == 1)
            return data[right];
        int midIndex = (left + right) / 2;
        int min = -1;
        if (data[midIndex] >= data[left]) {
            //最小值在右半部分
            min = getMinimumNumberInRotatedArray(data, midIndex, right);
        } else if (data[midIndex] <= data[right]) {
            //最小值在左半部分
            min = getMinimumNumberInRotatedArray(data, left, midIndex);
        }

        return min;
    }

}
