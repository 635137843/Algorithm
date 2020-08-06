package com.hmx.sort;

/**
 * @program: eoms-workflow
 * @description:
 * @author: HeMingXin
 * @create: 2020/8/2 19:00
 **/
public class QuickSort<T extends Comparable<T >> extends Sort<T>{
    @Override
    protected void sort() {
        sort(0, array.length);
    }
    
    
    /**
     * @Description  对范围的元素进行快速排序
     * @Param  [begin, end]
     * @Return  void
     * @Author  HeMingXin
     * @Date  2020/8/2 19:07
     */
    private void sort(int begin, int end){
        if(end - begin < 2) return;

        //确定轴点位置
        int mid = pivotIndex(begin, end);
        //对子序列进行快速排序
        sort(begin, mid);
        sort(mid+1, end);
    }

    /**
     * @Description  构造出[begin, end) 范围的轴点元素
     * @Param  [begin, end]
     * @Return  int 轴点元素的位置
     * @Author  HeMingXin
     * @Date  2020/8/2 19:08
     */
    private int pivotIndex(int begin, int end){
        swap(begin, begin + (int)Math.random() * (end - begin));
        //备份begin位置
        T pivot = array[begin];
        end--;

        while (begin < end){
            while (begin < end) {
                if (cmp(pivot, array[end]) < 0) {
                    end--;
                } else {
                    array[begin++] = array[end];
                    break;
                }
            }

            while (begin < end) {
                if (cmp(pivot, array[begin]) > 0) {
                    begin++;
                } else {
                    array[end--] = array[begin];
                    break;
                }
            }
        }

        //将轴点元素放入最终的位置
        array[begin] = pivot;

        return begin;
    }
}
