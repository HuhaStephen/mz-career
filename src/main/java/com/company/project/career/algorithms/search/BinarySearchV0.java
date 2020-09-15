package com.company.project.career.algorithms.search;

/**
 * 该二分查找算法的实现：返回目标值的索引，没有返回-1；<br>
 * midIndex 的取值总有疑虑： int midIndex = (left + right) / 2;//midIndex的取值是否合理的？
 * <p>
 * 算法的正确性还需要充分的数据验证，这里只是根据几个简单的测试用例进行了验证；
 * 
 * @author zhangyanxiang 2020年9月15日 上午10:49:29
 */
public class BinarySearchV0 {

    public static void main(String[] args) {
        //testcase-1
        int[] data1 = { 9 };
        System.out.println(-1 == binarySearch(data1, 0, data1.length - 1, 0));

        //testcase-2
        int[] data2 = { 9 };
        System.out.println(0 == binarySearch(data2, 0, data2.length - 1, 9));

        //testcase-3
        int[] data3 = { 9, 9 };
        System.out.println(-1 == binarySearch(data3, 0, data3.length - 1, 0));

        //testcase-4
        int[] data4 = { 9, 9, 10, 35, 89, 99, 99, 101, 103, 109 };
        System.out.println(4 == binarySearch(data4, 0, data4.length - 1, 89));

        //testcase-5
        int[] data5 = { 9, 9, 10, 35, 89, 99, 99, 101, 103, 109 };
        System.out.println(-1 == binarySearch(data5, 0, data5.length - 1, 90));
    }

    /**
     * 假定以升序数据为例
     * 
     * @param data
     * @param left
     * @param right
     * @return
     */
    public static int binarySearch(int[] data, int left, int right, int value) {
        if (left > right)
            return -1;
        int midIndex = (left + right) / 2;//midIndex的取值是否合理的？
        if (value == data[midIndex])
            return midIndex;
        if (value > data[midIndex]) {
            binarySearch(data, midIndex + 1, right, value);
        } else {
            binarySearch(data, left, midIndex - 1, value);
        }
        return -1;
    }

}
