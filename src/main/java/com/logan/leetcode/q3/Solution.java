package com.logan.leetcode.q3;

import java.util.ArrayList;
import java.util.List;

/**
 * 3.给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author Logan
 * @date 2020/2/27 22:03
 */
public class Solution {
    /**
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * @param s 给定字符串
     * @return 最长不重复字符长度
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        List<String> tempList = new ArrayList<String>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (!tempList.contains(String.valueOf(s.charAt(i)))) {
                tempList.add(String.valueOf(s.charAt(i)));
                if (tempList.size() > result) {
                    result = tempList.size();
                }
            } else {
                int index = tempList.indexOf(String.valueOf(s.charAt(i)));
                if (index == tempList.size() - 1) {
                    tempList.clear();
                } else {
                    for (int j = 0; j < index + 1; j++) {
                        tempList.remove(0);
                    }
                }
                tempList.add(String.valueOf(s.charAt(i)));
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));

    }
}


