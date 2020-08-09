package com.hmx.union;

/**
 * @program: eoms-workflow
 * @description: 基于Rank的优化
 * @author: HeMingXin
 * @create: 2020/8/7 17:29
 **/
public class UnionFind_QU_R extends UnionFind {

    private int[] ranks;

    public UnionFind_QU_R(int capacity) {
        super(capacity);

        ranks = new int[capacity];
        for (int i = 0; i < ranks.length; i++) {
            ranks[i] = 1;
        }
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v != parents[v]) {
            v = parents[v];
        }
        return v;
    }

    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;
        if (ranks[p1] < ranks[p2]) {
            parents[p1] = p2;
        }else if(ranks[p2] < ranks[p1]){
            parents[p2] = p1;
        }else {
            parents[p1] = p2;
            ranks[p2] += 1;
        }

    }
}