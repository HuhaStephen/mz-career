package com.company.project.career.algorithms.arrow2offer;

/**
 * 翻转字符串<br>
 * 输入一个英文句子，翻转句子中的单词的顺序，但单词内自负的顺序不变。标点符号和普通字母一样处理。 例： 输入："I am a student."
 * 输出：“student. a am I”<br>
 * 把字符串前面的若干个(n)字符转移到字符串的尾部。 例： 输入："coolday"和n=4 输出：“daycool”
 * 
 * @author zhangyanxiang 2021年1月3日 下午6:40:37
 */
public class ReverseAString {

    public static void main(String[] args) {
        System.out.println(reverseAWord("hello buddy."));
    }

    /**
     * 可以考虑用字符数组替代字符串，减少内存分配
     * 
     * @param str
     * @return
     */

    private static String reverseAWord(String str) {
        String reverse = reverse(str);
        String[] strs = reverse.split(" ");
        String need = "";
        for (String string : strs) {
            if (need.length() == 0) {
                need += reverse(string);
            }

            else {
                need += " " + reverse(string);
            }
        }
        return need;
    }

    private static String reverse(String str) {
        char[] ch = str.toCharArray();
        char temp = ' ';
        for (int i = 0; i < str.length() / 2; i++) {
            temp = ch[i];
            ch[i] = ch[ch.length - 1 - i];
            ch[ch.length - 1 - i] = temp;
        }
        return new String(ch);
    }

}
