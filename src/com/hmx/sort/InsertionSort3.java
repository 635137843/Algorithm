package com.hmx.sort;

/**
 * @ClassName InsertionSort1
 * @Description TODO
 * @Author xin
 * @Date 2020/5/11 18:29
 * @Version 1.0
 **/
public class InsertionSort3<E extends Comparable<E>> extends Sort<E> {
    /*protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            E v = array[begin];
            int search = search(begin);
            for (int i = begin; i > search; i--) {
                array[i] = array[i-1];
            }
            array[search] = v;
        }
    }*/
    @Override
    protected void sort(){
        for (int begin = 1; begin < array.length; begin++) {
            insert(begin,search(begin));
        }
    }

    private void insert(int source,int dest) {
        E v = array[source];
        for (int i = source; i > dest; i--) {
            array[i] = array[i-1];
        }
        array[dest] = v;
    }

    private int search(int index){
        int begin = 0;
        int end = index;
        while(begin < end){
            int mid = (begin + end) >> 1;
            if(cmp(array[index],array[mid]) < 0){
                end = mid;
            }else{
                begin = mid + 1;
            }
        }
        return begin;
    }
}
