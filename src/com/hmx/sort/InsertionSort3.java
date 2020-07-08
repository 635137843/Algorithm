package com.hmx.sort;

/**
 * @ClassName InsertionSort1
 * @Description TODO
 * @Author xin
 * @Date 2020/5/11 18:29
 * @Version 1.0
 **/
public class InsertionSort3<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        int a = 0;
        for (int begin = 0; begin < array.length; begin++) {
            System.out.println("aa");
            search(begin);
            System.out.println("冲突");
        }
    }

    private int search(int index){
        return 12;
    }
}
