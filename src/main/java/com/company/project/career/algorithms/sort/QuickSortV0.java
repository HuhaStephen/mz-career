package com.company.project.career.algorithms.sort;

/**
 * 此版实现是自己根据快速排序的基本思路写的，调试的过程中出现了一些问题并进行了逻辑修改：<br>
 * quickSort 的递归调用发生了无限循环的问题；<br>
 * sortOnePartition 中在 数据为： 9,8,9，left=0,right=2，会发生无限循环的问题
 * <p>
 * 算法的正确性还需要充分的数据验证，这里只是根据几个简单的测试用例进行了验证；
 * 
 * @author zhangyanxiang 2020年9月15日 上午10:40:17
 */
public class QuickSortV0 {

    public static void main(String[] args) {
        //testcase-1
        int[] data = { 9 };
        quickSort(data, 0, data.length - 1);
        System.out.println(toString(data));
        //testcase-2
        int[] data2 = { 3, 4, 2, 1, 9, 5, 9, 98, 7 };
        quickSort(data2, 0, data2.length - 1);
        System.out.println(toString(data2));
        //testcase-3
        int[] data3 = { 7, 6 };
        quickSort(data3, 0, data3.length - 1);
        System.out.println(toString(data3));
    }

    /**
     * <p>
     * 关于递归，每一次递归循环，都会完成下列事情：<br>
     * 对该分区的数据进行按基准值排序，定位到最终的基准值index，根据基准值index分为左区和右区，<br>
     * 对左区处理，怎么处理？（重复递归过程）<br>
     * 对右区处理（重复递归过程）；
     * <p>
     * 关于每个分区都要做的事情：<br>
     * 分区排序，并分隔分区，<br>
     * 对分隔的分区做同样的事情（重复递归过程）；
     */
    private static void quickSort(int[] data, int left, int right) {
        if (left < right) {//此处是一个应该注意的边界值，由于quickSort被递归调用、会有无限循环的可能，当left < right，才需要继续进行
            int baseIndex = sortOnePartition(data, left, right);
            quickSort(data, left, baseIndex - 1);//此处是一个应该注意的边界值，[left,baseIndex - 1],[baseIndex + 1,right]这样的分区就可以，如果是[left,baseIndex],[baseIndex,right]，当baseIndex=left或baseIndex=right时，会无限循环，
            quickSort(data, baseIndex + 1, right);
        }
    }

    /*
     * 对包含left、right索引 之间的分区进行排序，在left<right时候才进行
     */
    private static int sortOnePartition(int[] data, int left, int right) {
        int baseValue = data[left];
        while (left < right) {
            while (data[right] >= baseValue && left < right) {//此处是一个应该注意的边界值，应该是 data[right] > baseValue 还是 data[right] >= baseValue 才移动right指针呢？
                right--;
            }
            //说明从右边轮训的时候，有值小于基准值
            if (left < right) {
                data[left] = data[right];
                left++;//此处移动left指针是可以的
            }
            while (data[left] <= baseValue && left < right) {
                left++;
            }
            if (left < right) {
                data[right] = data[left];
                right--;
            }
        }
        data[left] = baseValue;
        return left;//此时left=right
    }

    private static String toString(int[] data) {
        StringBuilder sbu = new StringBuilder();
        for (int i : data) {
            sbu.append(sbu.length() == 0 ? i : "," + i);
        }
        return sbu.toString();
    }
}
