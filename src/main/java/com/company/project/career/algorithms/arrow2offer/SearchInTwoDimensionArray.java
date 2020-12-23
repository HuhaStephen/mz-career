package com.company.project.career.algorithms.arrow2offer;

/**
 * 二维数组中的查找<br>
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * 
 * @author zhangyanxiang 2020年11月8日 上午11:09:10
 */
public class SearchInTwoDimensionArray {

    public static void main(String[] args) {
        int[][] data = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 } };
        System.out.println(searchInTwoDimensionArray(data, 13));
        ;
    }

    /**
     * 思路：<br>
     * 首先遍历行，过滤掉不符合的列；然后列遍历，过滤掉不符合的行；
     * 
     * @param data
     * @param target
     * @return
     */
    public static boolean searchInTwoDimensionArray(int[][] data, int target) {
        /*
         * 行数：data.length；列数：data[0].length
         */
        boolean onlyRow = false;
        int i = 0;
        int j = data[0].length - 1;

        for (; i < data.length;) {
            if (!onlyRow) {
                for (; j >= 0; j--) {
                    if (data[i][j] == target)
                        return true;
                    if (data[i][j] > target)
                        continue;
                    onlyRow = true;
                    break;
                }
                if (j < 0)
                    return false;
            }

            if (data[i][j] == target)
                return true;
            if (data[i][j] < target) {
                i++;
                continue;
            }
            onlyRow = false;
        }

        return false;
    }
}
