package com.hmx;

/**
 * @ClassName BinarySearch
 * @Description TODO
 * @Author xin
 * @Date 2020/5/11 19:32
 * @Version 1.0
 **/
public class BinarySearch {

    /**
     * 二分搜索
     * @param array
     * @param v
     * @return
     */
    public static int indexOf(int[] array, int v) {
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if(v < array[mid]){
                end = mid;
            }else if(v > array[mid]){
                begin = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static int search(int[] array, int v){
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = array.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if(v < array[mid]){
                end = mid;
            }else{
                begin = mid + 1;
            }
        }
        return begin;
    }
}
