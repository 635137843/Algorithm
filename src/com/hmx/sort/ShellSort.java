package com.hmx.sort;

import com.hmx.tools.Integers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName ShellSort
 * @Description TODO
 * @Author xin
 * @Date 2020/8/3 21:01
 * @Version 1.0
 **/
public class ShellSort<T extends Comparable<T>> extends Sort<T> {


    @Override
    protected void sort() {
        List<Integer> stepSequence = sedgewickStepSequence();
        for (Integer step : stepSequence) {
            sort(step);
        }
    }

    /**
     * 分成step列进行排序
     *
     * @param step
     */
    private void sort(int step) {
        for (int col = 0; col < step; col++) {
            for (int begin = col + step; begin < array.length; begin += step) {
                int cur = begin;
                while (cur > col && cmp(cur, cur - step) < 0) {
                    swap(cur, cur - step);
                    cur -= step;
                }
            }
        }
    }


    /**
     * 获取步长序列
     *
     * @return
     */
    private List<Integer> shellStepSequence() {
        List<Integer> setSequence = new ArrayList<>();
        int step = array.length;

        while ((step >>= 1) > 0) {
            setSequence.add(step);
        }
        return setSequence;
    }

    private List<Integer> sedgewickStepSequence() {
        List<Integer> stepSequence = new LinkedList<>();
        int k = 0, step = 0;
        while (true) {
            if (k % 2 == 0) {
                int pow = (int) Math.pow(2, k >> 1);
                step = 1 + 9 * (pow * pow - pow);
            } else {
                int pow1 = (int) Math.pow(2, (k - 1) >> 1);
                int pow2 = (int) Math.pow(2, (k + 1) >> 1);
                step = 1 + 8 * pow1 * pow2 - 6 * pow2;
            }
            if (step >= array.length) break;
            stepSequence.add(0, step);
            k++;
        }
        return stepSequence;
    }
}