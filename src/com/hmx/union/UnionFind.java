package com.hmx.union;

/**
 * @program: eoms-workflow
 * @description:
 * @author: HeMingXin
 * @create: 2020/8/5 14:17
 **/
public class UnionFind {
    private int[] parents;

    public UnionFind(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must be >= 1!");
        }

        parents = new int[capacity];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }


    /**
     * @Description 查找v所属的集合（即查找v的根节点）
     * @Param [v]
     * @Return int
     * @Author HeMingXin
     * @Date 2020/8/5 14:20
     */
    public int find(int v) {
        rangeCheck(v);
        return parents[v];
    }

    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;

        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == p1) {
                parents[i] = p2;
            }
        }
    }

    /**
     * @Description 检查v1，v2是不是同一个集合
     * @Param [v1, v2]
     * @Return boolean
     * @Author HeMingXin
     * @Date 2020/8/5 14:22
     */
    public boolean isSame(int v1, int v2) {
        return find(v1) == find(v2);
    }

    private void rangeCheck(int v) {
        if (v < 0 || v >= parents.length) {
            throw new IllegalArgumentException("v is out of bounds");
        }
    }
}
