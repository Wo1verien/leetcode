package com.logan.leetcode.asort;

import java.util.Arrays;

/**
 * Created 2020/3/23. 1:45 下午
 *
 * @author changzheng
 */
public class SortAlgorithm {

    /**
     * 直接插入排序
     *
     * @param array 需要排序的序列
     */
    private static void directInsertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    System.arraycopy(array, j, array, j + 1, i - j);
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 折半插入排序
     * @param arr 数组
     */
    private static void binaryInsertSort(int[] arr){

        int low,high,m,temp,i,j;
        for(i = 1;i<arr.length;i++){
            //折半查找应该插入的位置
            low = 0;
            high = i-1;
            while(low <= high){
                m = (low+high)/2;
                if(arr[m] > arr[i]) {
                    high = m - 1;
                } else {
                    low = m + 1;
                }
            }
            //统一移动元素，然后将这个元素插入到正确的位置
            temp = arr[i];
            for(j=i;j>high+1;j--){
                arr[j] = arr[j-1];
            }
            arr[high+1] = temp;
        }
    }

    /**
     * 直接选择排序
     * @param array 数组
     */
    public static void directSelectionSort(int[] array){
        int length = array.length;
        for (int i =0;i<length-1;i++){
            int minIndex = i;
            for (int j =i+1;j<length;j++){
                if (array[j]<array[i]){
                    minIndex = array[minIndex] < array[j] ? minIndex : j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
            //输出每一次排序后的结果
            System.out.println(Arrays.toString(array));
        }
    }

    /**
     * 冒泡排序
     * @param array 数组
     */
    private static void bubbleSort(int[] array){
        int length = array.length;
        for (int i=length-1;i>0;i--){
            for (int j=0;j<i;j++){
                if (array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    /**
     * 快速排序
     *
     */
    private static void quickSort(int [] array,int low,int high){
        int i,j,temp,t;
        if (low>high){
            return;
        }
        i = low;
        j = high;
        //temp就是基准单位
        temp = array[low];
        while (i<j){
            //先看右边，依次往左递减
            while (array[j]>=temp && i<j){
                j--;
            }
            array[i] = array[j];
            //先看右边，依次往左递减
            while (array[i]<=temp && i<j){
                i++;
            }
            array[j] = array[i];
        }
        array[i] = temp;
        //打印每一次排序的结果
        System.out.println(Arrays.toString(array));
        //递归调用左半数组
        quickSort(array, low, j-1);
        //递归调用右半数组
        quickSort(array, j+1, high);
    }

    public static void main(String[] args) {
        int[] a = {57,68,59,52,22,1,99,21};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
