package com.hmx.sort;

/**
 * @ClassName InsertionSort1
 * @Description TODO
 * @Author xin
 * @Date 2020/5/11 18:29
 * @Version 1.0
 **/
public class InsertionSort1<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int begin = 0; begin < array.length; begin++) {
            int cur = begin;
            while (cur > 0 && cmp(cur, cur - 1) < 0) {
                swap(cur, cur - 1);
                cur--;
            }
        }
    }
}
