package com.hmx;

import com.hmx.sort.*;
import com.hmx.tools.Asserts;
import com.hmx.tools.Integers;
import com.hmx.union.UnionFind;

import java.util.Arrays;

/**
 * @ClassName Main
 * @Description TODO
 * @Author xin
 * @Date 2020/4/24 18:17
 * @Version 1.0
 **/
@SuppressWarnings("rawtypes")
public class Main {
    public static void main(String[] args) {
        //Integer[] array = Integers.random(50000, 1, 50000);
        //Integer[] array = {3,6,11,18,8,10,12,14};
        //Integer[] array = {8,7,6,5,4,3,2,1};
//        for (int j = 0; j < array.length-1; j++) {
//            for (int i = 0; i < array.length-1-j; i++) {
//                if(array[i] > array[i+1]){
//                    int tmp = array[i];
//                    array[i] = array[i+1];
//                    array[i+1] = tmp;
//                }
//            }
//        }
        /*testSorts(array,
                *//*new HeapSort(),
                new BubbleSort3(),
                new SelectionSort(),
                new InsertionSort1(),
                new InsertionSort2(),
                new InsertionSort3(),*//*
                new MergeSort(),
                new QuickSort()
        );*/
        unionFind();



//        Asserts.test(BinarySearch.search(array, 5) == 2);
//        Asserts.test(BinarySearch.search(array, 1) == 0);
//        Asserts.test(BinarySearch.search(array, 15) == 7);
//        Asserts.test(BinarySearch.search(array, 8) == 5);
    }

    static void testSorts(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }
        Arrays.sort(sorts);
        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }

    static void bubbleSort1(Integer[] array) {
        for (int j = array.length; j > 0; j--) {
            for (int i = 1; i < j; i++) {
                if (array[i] < array[i - 1]) {
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                }
            }
        }
    }

    static void bubbleSort2(Integer[] array) {
        for (int j = array.length; j > 0; j--) {
            boolean flag = true;
            for (int i = 1; i < j; i++) {
                if (array[i] < array[i - 1]) {
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                    flag = false;
                }
            }
            if (flag) break;
        }
    }

    static void bubbleSort3(Integer[] array) {
        for (int j = array.length; j >= 0; j--) {
            int sortedIndex = 0;
            for (int i = 1; i < j; i++) {
                if (array[i] < array[i - 1]) {
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                    sortedIndex = i;
                }
            }
            j = sortedIndex;
        }
    }

    static void selectionSort(Integer[] array) {
        for (int j = array.length - 1; j > 0; j--) {
            int maxIndex = 0;
            for (int i = 1; i <= j; i++) {
                if (array[maxIndex] <= array[i]) {
                    maxIndex = i;
                }
            }
            int tmp = array[maxIndex];
            array[maxIndex] = array[j];
            array[j] = tmp;
        }
    }

    static void unionFind() {
        UnionFind unionFind = new UnionFind(12);
        unionFind.union(0, 1);
        unionFind.union(0, 3);
        unionFind.union(0, 4);
        unionFind.union(2, 3);
        unionFind.union(2, 5);

        unionFind.union(6, 7);

        unionFind.union(8, 10);
        unionFind.union(9, 10);
        unionFind.union(8, 11);

        unionFind.union(4,6);

        System.out.println(unionFind.isSame(0, 6));
        System.out.println(unionFind.isSame(0, 5));
        System.out.println(unionFind.isSame(0, 7));
    }
}
