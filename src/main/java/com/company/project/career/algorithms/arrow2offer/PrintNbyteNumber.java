package com.company.project.career.algorithms.arrow2offer;

/**
 * 打印从1到最大的n位数<br>
 * 比如输入3，打印1、2、3、...999
 * 
 * @author zhangyanxiang 2021年1月2日 下午6:56:15
 */
public class PrintNbyteNumber {

    public static void main(String[] args) {
        print(3);
    }

    /**
     * 需要兼容大数问题
     * 
     * @param n
     */
    private static void print(int n) {

        char[] nChar = new char[n];//char[0]表示最大位，数组的最大索引表示个位

        //        for (int i = 0; i < 10; i++) {
        //            nChar[n - 1] = (char) ((char) i + '0');//给个位设置0-9
        //            doPrint(nChar, n, n - 2);//给其他位设置0-9
        //        }
        doPrint(nChar, n, n - 1);
    }

    private static void doPrint(char[] nChar, int length, int index) {
        if (index < 0) {
            System.out.println(nChar);
            return;
        }

        for (int i = 0; i < 10; i++) {
            nChar[index] = (char) ((char) i + '0');
            doPrint(nChar, length, index - 1);
        }

    }

}
