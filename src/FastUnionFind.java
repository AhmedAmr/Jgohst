/**
 * This Class is the Fastest Implementation class For the UnionFind.
 * This Impl. uses both balancing and path compression techniques to reduce the running time of the root method
 * that the union and find depends on it.
 * ---------------------------------------------------------------------------
 *                                 Amortized Analysis
 * ---------------------------------------------------------------------------
 * By [Hopcroft-Ulman, Tarjan]
 * Starting from an empty data structure, any sequence of M union-find operations
 * on N objects makes ≤ c ( N + M lg* N ) array accesses
 * ------------------------------------------------------------------------
 * where we can assume that lg* function is maximally = 5
 * ---------------------------------------------------------------------------
 */
public class FastUnionFind extends WeightedQuickUnionFind {

    public FastUnionFind(int N) {
        super(N);
    }

    @Override
    protected int root(int p) {
        while(p!=ids[p]) {
            ids[p] = ids[ids[p]];
            p = ids[p];
        }
        return p;
    }
}
