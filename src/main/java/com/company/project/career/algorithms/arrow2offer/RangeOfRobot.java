package com.company.project.career.algorithms.arrow2offer;

/**
 * 机器人的运动范围<br>
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7=18。但是，它不能进入方格（35
 * ,38），因为3+5+3+8=19。请问该机器人能够达到多少个格子？
 * 
 * @author zhangyanxiang 2021年1月1日 下午2:10:33
 */
public class RangeOfRobot {

    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        char[][] data = buildMatrix("adhagiewtkgeafaewlkfie".toCharArray(), rows, cols);
        boolean[][] hasVisited = new boolean[rows][cols];
        int count = 0;
        count = isHasCertainPath(data, rows, cols, 0, 0, hasVisited, 3, count);
        System.out.println(count);
    }

    //构造矩阵
    private static char[][] buildMatrix(char[] array, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int i = 0, idx = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                matrix[i][j] = array[idx++];//从左到右从上到下依次赋值
        }
        return matrix;
    }

    // 求一个整数的各个位上数字之和
    private static int sumOfEachNumber(int n) {
        int c = 0;
        while (n > 0) {
            c += n % 10;
            n /= 10;
        }
        return c;
    }

    private static int isHasCertainPath(char[][] data, int rows, int cols, int r, int c, boolean[][] hasVisited,
                                        int threshold, int count) {

        if (checkCanBeMoved(rows, cols, r, c, hasVisited, threshold)) {
            hasVisited[r][c] = true;
            count++;
            count = isHasCertainPath(data, rows, cols, r, c - 1, hasVisited, threshold, count);
            count = isHasCertainPath(data, rows, cols, r - 1, c, hasVisited, threshold, count);
            count = isHasCertainPath(data, rows, cols, r, c + 1, hasVisited, threshold, count);
            count = isHasCertainPath(data, rows, cols, r + 1, c, hasVisited, threshold, count);
        }
        return count;
    }

    private static boolean checkCanBeMoved(int rows, int cols, int r, int c, boolean[][] hasVisited, int threshold) {
        if (r < 0 || c < 0 || r >= rows || c >= cols) {
            return false;
        }

        if (sumOfEachNumber(r) + sumOfEachNumber(c) > threshold)
            return false;

        if (hasVisited[r][c])
            return false;

        return true;
    }
}
