/**
 * Created by Ahmed Amr on 1/29/16.
 */

/**
 * This Class is an Implementation class For the UnionFind.
 * This Impl. can be used when there exist much more Find queries than Union queries.
 * ---------------------------------------------------------------------------
 *                                  Order of Growth
 * ---------------------------------------------------------------------------
 *  ..... Union Query ........|........ Find Query ........|........ Count
 * ---------------------------------------------------------------------------
 *  .....    O(N)       ........|......... O(1)........|........    O(N)
 * ---------------------------------------------------------------------------
 */
public class UnionQuickFind extends UnionFind {

    /**
     * Default Constructor
     * @param N : number of nodes in the union find
     */
    public UnionQuickFind(int N) {
        super(N);
    }

    @Override
    void union(int p, int q) {
        int pid = ids[p];
        int qid = ids[q];
        for (int i = 0; i < SIZE; i++) {
            if(ids[i]==pid)ids[i]=qid;
        }
    }

    @Override
    boolean connected(int p, int q) {
        return ids[p]==ids[q];
    }

    @Override
    int count() {
        int count = 0;
        boolean[] visited = new boolean[SIZE];
        for (int i = 0; i < SIZE; i++) {
            visited[ids[i]]=true;
        }
        for (int i = 0; i < SIZE; i++) {
            if(visited[i])count++;
        }
        return count;
    }
}
