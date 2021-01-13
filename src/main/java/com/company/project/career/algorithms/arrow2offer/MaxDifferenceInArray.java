package com.company.project.career.algorithms.arrow2offer;

/**
 * 股票的最大利润<br>
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可获得的最大利润是多少？
 * 例如，一只股票在某些时间节点的价格为{9,11,8,5,7,12
 * ,16,14}。如果我们能在价格为5的时候买入并在价格为16时卖出，则能获得最大的利润为11.
 * 
 * @author zhangyanxiang 2021年1月3日 下午4:59:41
 */
public class MaxDifferenceInArray {

    public static void main(String[] args) {
        int[] data = { 3, 36, 1, 77, 7, 5 };

        System.out.println(max(data));
    }

    private static int max(int[] data) {
        if (null == data || data.length < 2)
            return 0;
        int max = 0;
        int min = data[0];
        for (int i = 1; i < data.length; i++) {
            max = max >= data[i] - min ? max : data[i] - min;
            min = min > data[i] ? data[i] : min;
        }
        return max;
    }

}
