/**
 * This Class is an Implementation class For the UnionFind.
 * This Impl. is the Lazy approach for implementing Union Find
 * ---------------------------------------------------------------------------
 *                                 WORST CASE
 * ---------------------------------------------------------------------------
 *  ..... Union Query ........|........ Find Query ........|........ Count
 * ---------------------------------------------------------------------------
 *  .....    O(N)       ........|......... O(N)........|........    O(N)
 * ---------------------------------------------------------------------------
 */
public class QuickUnionFind extends UnionFind {


    public QuickUnionFind(int N) {
        super(N);
    }

    protected int root(int p){
        while(p!=ids[p])p=ids[p];
        return p;
    }

    @Override
    void union(int p, int q) {
        ids[root(p)]=root(q);
    }

    @Override
    boolean connected(int p, int q) {
        return root(p)==root(q);
    }

    @Override
    int count() {
        int count =0;
        for (int i = 0; i < SIZE; i++) {
            if(i==ids[i])count++;
        }
        return count;
    }
}
