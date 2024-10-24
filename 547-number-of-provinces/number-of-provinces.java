class DSU {
    int n;
    int[] size;
    int[] parent;
    DSU(int n) {
        this.n = n;
        size = new int[n+1];
        parent = new int[n+1];
        for(int i=1; i<=n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int  findUlParent(int x) {
        if(x == parent[x])
            return x;
        return findUlParent(parent[x]);
    }

    void unionBySize(int x, int y) {

        int ult_x = findUlParent(x);
        int ult_y = findUlParent(y);

        if(ult_x == ult_y)
            return;
        if(size[x] < size[y]) {
            parent[ult_x] = ult_y;
            size[ult_y] += size[ult_x];
        } else {
            parent[ult_y] = ult_x;
            size[ult_x] += size[ult_y];
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(isConnected[i][j] == 1)
                    dsu.unionBySize(i+1, j+1);
            }
        }
        int count = 0;
        for(int i=1; i<=n; i++) {
            if(dsu.parent[i] == i)
                count++;
        }

        return count;
    }
}