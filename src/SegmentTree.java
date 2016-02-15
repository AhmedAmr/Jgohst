
/**
 * Created by AhmedAmr on 2/15/16.
 */
public class SegmentTree {
    private int[] tree;
    private int[] values;
    private int LENGTH;

    public SegmentTree(int [] arr) {
        LENGTH = arr.length;
        int l = (int) Math.pow(2,Math.ceil(Math.log(LENGTH)/Math.log(2))+1);
        tree = arr;
        values = new int[l];
        build(1, 0, LENGTH - 1);
    }

    public int getRangeQuery(int i, int j) {
        return getRangeQuery(1, 0, LENGTH - 1, i, j);
    }

    private void update(int vertex , int l , int r,int i ){
        if(r<i||l>i)return;
        if(l==i&&r==i){
            values[vertex]= i;
            return;
        }
        int nL = vertex*2;
        int nR = nL + 1;
        int mid = (l+r)/2;
        update(nL, l, mid, i);
        update(nR, mid + 1, r, i);

        int p1 = values[nL];
        int p2 = values[nR];

        if(compare(tree[p1],tree[p2])==tree[p1]){
            values[vertex]=p1;
        }else{
            values[vertex]=p2;
        }

    }

    public void update(int i,int value) {
        tree[i] = value;
        update(1, 0, LENGTH - 1, i);
    }

    private void build(int vertex,int l , int r){
        if(l==r){
            values[vertex]=l;
            return;
        }
        int nL = 2*vertex; // left child index
        int nR = nL+1; // right child index
        int mid = (l+r)/2;
        build(nL,l,mid);
        build(nR,mid+1,r);

        int p1 = values[nL];
        int p2 = values[nR];
        int v1 = tree[p1];
        int v2 = tree[p2];

        if(compare(v1,v2)==v1){
            values[vertex]=p1;
        }else{
            values[vertex]=p2;
        }

    }

    private int getRangeQuery(int vertex,int l , int r,int i,int j){
        if(j<l||i>r)return -1; // outside the range
        if(l>=i&&r<=j)return values[vertex];  // inside the range


        int mid = (l+r)/2;
        int nL = 2*vertex;
        int nR = nL+1;
        int p1 = getRangeQuery(nL, l, mid, i, j);
        int p2 = getRangeQuery(nR, mid + 1, r, i, j);

        if(p1==-1)return p2;
        if(p2==-1)return p1;
        return compare(tree[p1],tree[p2])==p1?p1:p2;

    }


    // This method customize the Segment tree to answer either MinRangeQ or MaxRangeQ
    private int compare(int v1 , int v2) {
        //Minimum Range Query
        return Math.min(v1, v2);

        //Maximum Range Query
        //Uncomment the next Line
//        return Math.max(v1, v2);

        //for other compare methods , just replace this method with yours
    }

    public static void main(String[] args) {
        int arr[] = {8, 7, 3, 9, 5, 1, 10};
        SegmentTree s = new SegmentTree(arr);
        System.out.println(s.getRangeQuery(4, 6));
        s.update(5, 100);
        System.out.println(s.getRangeQuery(4, 6));
    }
}
