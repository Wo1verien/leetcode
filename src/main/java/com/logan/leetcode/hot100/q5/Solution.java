package com.logan.leetcode.hot100.q5;

/**
 * Created 2020/4/8. 11:51 上午
 *
 * @author changzheng
 *
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Solution {

    /**
     * 本题最容易想到的一种方法应该就是 中心扩散法。
     * 中心扩散法怎么去找回文串？
     * 从每一个位置出发，向两边扩散即可。遇到不是回文的时候结束。举个例子，str = acdbbdaastr=acdbbdaa 我们需要寻找从第一个 b（位置为 33）出发最长回文串为多少。怎么寻找？
     * 首先往左寻找与当期位置相同的字符，直到遇到不相等为止。
     * 然后往右寻找与当期位置相同的字符，直到遇到不相等为止。
     * 最后左右双向扩散，直到左和右不相等

     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int length = s.length();
        int left,right;
        int maxLen=0,maxStart=0;
        for (int i=0;i<length;i++){
            int len =1;
            left=i-1;
            right=i+1;
            while (left>=0 && s.charAt(left)==s.charAt(i)){
                left--;
                len++;
            }
            while (right<length && s.charAt(right)==s.charAt(i)){
                right++;
                len++;
            }
            while (left>=0 && right<length && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                len+=2;
            }
            if (len>maxLen){
                maxLen=len;
                maxStart=left;
            }
        }
        return s.substring(maxStart+1,maxStart+maxLen+1);
    }
}


