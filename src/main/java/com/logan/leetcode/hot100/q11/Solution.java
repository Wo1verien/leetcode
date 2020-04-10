package com.logan.leetcode.hot100.q11;

/**
 * Created 2020/4/10. 4:52 下午
 *
 * @author changzheng
 * <p>
 * 盛水最多的容器
 * <p>
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */
public class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        if (height.length == 0) {
            return res;
        }
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if ((Math.min(height[i], height[j]) * (j - i)) > res) {
                    res = Math.min(height[i], height[j]) * (j - i);

                }
            }
        }
        return res;
    }

    /**
     * 在每一个状态下，无论长板或短板收窄 11 格，都会导致水槽 底边宽度 -1−1：
     * 若向内移动短板，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 可能变大，因此水槽面积 S(i, j)S(i,j) 可能增大。
     * 若向内移动长板，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 不变或变小，下个水槽的面积一定小于当前水槽面积。
     * 因此，向内收窄短板可以获取面积最大值
     */
    public int maxArea1(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j){
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

}
