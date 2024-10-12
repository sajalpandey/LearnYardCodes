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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            for(int j=1; j<accounts.get(i).size(); j++) {
                if(!map.containsKey(accounts.get(i).get(j))) {
                    map.put(accounts.get(i).get(j), i);
                } else  
                    dsu.unionBySize(i, map.get(accounts.get(i).get(j)));
            }
        }

        List<List<String>> result = new ArrayList<>();

        ArrayList<String>[] mergedMail = new ArrayList[n];
        for(int i=0; i<n; i++)
            mergedMail[i] = new ArrayList<>();
        
        for(String key : map.keySet()) {
            int index = map.get(key);
            mergedMail[dsu.findUlParent(index)].add(key);
        }

        for(int i=0; i<n; i++) {
            if(mergedMail[i].size() > 0) {
                Collections.sort(mergedMail[i]);
                String name = accounts.get(i).get(0);
                ArrayList<String> temp = new ArrayList<>();
                temp.add(name);
                for(String str : mergedMail[i])
                    temp.add(str);
                result.add(temp);
            }
        }
        return result;
    }
}