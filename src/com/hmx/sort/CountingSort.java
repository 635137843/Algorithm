package com.hmx.sort;

/**
 * @program: eoms-workflow
 * @description:
 * @author: HeMingXin
 * @create: 2020/8/6 10:33
 **/
public class CountingSort extends Sort<Integer> {

    @Override
    protected void sort() {
        //找出最大值确定数组长度
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        //所需要的数组
        int[] counts = new int[1 + max];
        //统计每个整数出现的次数
        for (int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        }

        //根据出现次数，对整数进行排序
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            //判断counts的数据是否放入数组
            while (counts[i]-- > 0) {
                array[index++] = i;
            }
        }
    }


}
