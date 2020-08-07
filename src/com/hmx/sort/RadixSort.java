package com.hmx.sort;

import java.util.List;

/**
 * @program: eoms-workflow
 * @description:
 * @author: HeMingXin
 * @create: 2020/8/7 15:11
 **/
public class RadixSort extends Sort<Integer>{

    @Override
    protected void sort() {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] > max){
                max = array[i];
            }
        }
        for (int divider = 1; divider <= max; divider *= 10) {
            countingSort(divider);
        }
    }

    protected void countingSort(int divider) {
        //开辟空间，存储次数
        int[] counts = new int[10];

        //根据新的统计表获得索引
        for (int i = 0; i < array.length; i++) {
            counts[array[i] / divider % 10]++;
        }

        //累加次数
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[ i - 1];
        }

        //从后往前便利元素，让其放入有序数组的适应位置
        int[] newArray = new int[array.length];
        //减去数组中最小的元素找到对应索引然后-1就是适合位置
        for (int i = array.length - 1; i >= 0; i--) {
            newArray[--counts[array[i]] / divider % 10] = array[i];
        }

        //将有序数据复制到array
        for (int i = 0; i < newArray.length; i++) {
            array[i]  = newArray[i];
        }
    }
}
