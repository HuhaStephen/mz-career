package com.company.project.career.algorithms.arrow2offer;

/**
 * 替换空格<br>
 * 请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，则输出“We%20are%20happy.”。
 * 
 * @author zhangyanxiang 2020年11月9日 上午9:58:39
 */
public class ReplaceTheWhiteSpace {

    public static void main(String[] args) {
        String str = "hello world";
        StringBuffer sbu = new StringBuffer();
        for (char c : str.toCharArray()) {
            sbu.append(c == ' ' ? "%20" : c);
        }
        System.out.println(sbu.toString());
    }

}
