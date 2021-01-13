package com.company.project.career.algorithms.arrow2offer;

/**
 * 矩阵中的路径<br>
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，
 * 向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如在下面的3x4的矩阵中包含一条字符串"bcced"的路径（路径中的字母用斜体表示
 * ）。但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * 
 * @author zhangyanxiang 2020年12月31日 上午11:18:20
 */
public class PathInMatrix {

    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        char[][] data = buildMatrix("adhagiewtkgeafaewlkfie".toCharArray(), rows, cols);
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (isHasCertainPath(data, rows, cols, i, j, 0, "aae".toCharArray(), visited))//i,j为匹配的第一个字符
                    System.out.println("===");
        ;
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

    private static boolean isHasCertainPath(char[][] data, int rows, int cols, int r, int c, int pathLength,
                                            char[] str, boolean[][] hasVisited) {
        if (r < 0 || c < 0 || r >= rows || c >= cols) {
            return false;
        }

        if (str.length == pathLength)
            return true;

        if (hasVisited[r][c])
            return false;

        if (data[r][c] == str[pathLength]) {
            pathLength++;
            hasVisited[r][c] = true;
            if (isHasCertainPath(data, rows, cols, r, c - 1, pathLength, str, hasVisited)
                    || isHasCertainPath(data, rows, cols, r - 1, c, pathLength, str, hasVisited)
                    || isHasCertainPath(data, rows, cols, r, c + 1, pathLength, str, hasVisited)
                    || isHasCertainPath(data, rows, cols, r + 1, c, pathLength, str, hasVisited)) {
                return true;
            } else {
                pathLength--;
                hasVisited[r][c] = false;
                return false;
            }

        } else {
            return false;
        }
    }
}
