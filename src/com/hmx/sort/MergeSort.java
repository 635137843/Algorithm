package com.hmx.sort;

/**
 * @ClassName MergeSort
 * @Description TODO
 * @Author xin
 * @Date 2020/7/31 22:37
 * @Version 1.0
 **/
public class MergeSort<T extends Comparable<T>> extends Sort<T> {
    private T[] leftArray;

    @Override
    protected void sort() {
        leftArray = (T[]) new Comparable[array.length >> 1];
        sort(0,array.length);
    }

    private void sort(int begin, int end) {
        if (end - begin < 2) return;

        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);
    }

    private void merge(int begin, int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid, re = end;
        int ai = begin;

        //备份左边数组
        for (int i = li; i < le; i++) {
            leftArray[i] = array[begin + i];
        }

        //如果左边没有结束
        while(li < le){
            /*if(!(ri < re && cmp(array[ri], leftArray[li]) < 0)){
                array[ai++] = leftArray[li++];
            }else{
                array[ai++] = array[ri++];
            }*/
            if(ri >= re && cmp(leftArray[li], array[ri]) <= 0){
                array[ai++] = leftArray[li++];
            }else{
                array[ai++] = array[ri++];
            }
        }

    }
}
