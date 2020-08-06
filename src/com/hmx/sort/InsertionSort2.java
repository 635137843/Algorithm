package com.hmx.sort;

/**
 * @ClassName InsertionSort1
 * @Description TODO
 * @Author xin
 * @Date 2020/5/11 18:29
 * @Version 1.0
 **/
public class InsertionSort2<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            E v = array[cur];
            while (cur > 0 && cmp(v,array[cur - 1]) < 0) {
                array[cur] = array[cur - 1];
                cur--;
            }
            array[cur] = v;
        }
    }
}
