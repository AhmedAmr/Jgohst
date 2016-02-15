/**
 * Created by AhmedAmr on 1/29/16.
 */

/*
    This is an Abstract Class for Union-Find Problem
 */
public abstract class UnionFind {
    protected int[] ids;
    protected int SIZE;

    public UnionFind(int N) {
        this.SIZE = N;
        ids = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
        }
    }

    abstract void union(int p, int q);

    abstract boolean connected(int p, int q);

    abstract int count();

}
