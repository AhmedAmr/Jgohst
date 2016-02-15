import java.util.Arrays;

/**
 * This Class is an Implementation class For the UnionFind.
 * This Impl. is Overrides the Union Method to improve the performance of the Find and Union ,
 * By keeping the tree balanced as possible.
 * ---------------------------------------------------------------------------
 *                                 WORST CASE
 * ---------------------------------------------------------------------------
 *  ..... Union Query ........|........ Find Query ........|........ Count
 * ---------------------------------------------------------------------------
 *  .....    O(lgN)       ........|......... O(lgN)........|........    O(N)
 * ---------------------------------------------------------------------------
 */

public class WeightedQuickUnionFind extends QuickUnionFind {
    private int[]sz;

    public WeightedQuickUnionFind(int N) {
        super(N);
        sz = new int[N];
        Arrays.fill(sz, 1);
    }

    @Override
    void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if(sz[i]<sz[j]){
            ids[i]=j;
            sz[j] += sz[i];
        }else{
            ids[j]=i;
            sz[i] += sz[j];
        }
    }
}
