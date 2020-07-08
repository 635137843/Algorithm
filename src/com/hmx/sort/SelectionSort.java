package com.hmx.sort;

/**
 * @ClassName SelectionSort
 * @Description TODO
 * @Author xin
 * @Date 2020/5/11 2:01
 * @Version 1.0
 **/
public class SelectionSort extends Sort {

    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(maxIndex, begin) <= 0) {
                    maxIndex = begin;
                }
            }
            swap(maxIndex, end);
        }
    }

}
