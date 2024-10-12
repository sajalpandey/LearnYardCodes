class DSU {
    int n;
    int[] size;
    int[] parent;
    DSU(int n) {
        this.n = n;
        size = new int[n+1];
        parent = new int[n+1];
        for(int i=0; i<=n; i++) {
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
    public boolean isValid(int i, int j, int n) {
        return (i>=0 && i<n && j>=0 && j<n);
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n*n);
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0)
                    continue;
                //check all four direction to connect this 1 with them
                int[] dr = {-1,0,1,0};
                int[] dc = {0,1,0,-1};
                for(int k=0; k<4; k++) {
                    int newR = i + dr[k];
                    int newC = j + dc[k];
                    if(isValid(newR, newC, n) && grid[newR][newC] == 1) {
                        int nodeNum = i * n + j;
                        int adjNum = newR * n + newC;
                        dsu.unionBySize(nodeNum, adjNum);
                    }
                }
            }
        }
        int mx = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1)
                    continue;
                //check all four direction to connect this 1 with them
                int[] dr = {-1,0,1,0};
                int[] dc = {0,1,0,-1};
                HashSet<Integer> set = new HashSet<>();
                for(int k=0; k<4; k++) {
                    int newR = i + dr[k];
                    int newC = j + dc[k];
                    
                    if(isValid(newR, newC, n) && grid[newR][newC] == 1) {
                        set.add(dsu.findUlParent(newR * n + newC));
                    }
                }

                int totalSize = 0;
                for(int ele : set)
                    totalSize += dsu.size[ele];

                mx = Math.max(mx, totalSize + 1); // 1 for o converted to 1
            }

        }

        for(int cellNo=0; cellNo < n*n; cellNo++) {
            mx = Math.max(mx, dsu.size[dsu.findUlParent(cellNo)]);
        }

        return mx;
        
    }
}