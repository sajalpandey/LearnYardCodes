class Solution {
    class comp implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            if (a[0] > b[0])
                return 1;
            else if(a[0] < b[0])
                return -1;
            else
                return 0;
        }
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        /**
        items = [0-[1,2],1-[3,2],2-[2,4],3-[5,6],4-[3,5]]
        queries = [1,2,3,4,5,6]
        loop on queries from 1 to queries.length
            for each query 
            we will find items whose prices are less than equal to query[i]
            and while traversing we will maintain a max beauty

            then the max beauty will be appended in result 
        */
        
        int n = queries.length;

        int map[][] = new int[n][2];
        int result[] = new int[n];
        HashMap<Integer, Integer> qmap = new HashMap<>();
        for(int i=0; i<n; i++) {
            map[i] = new int[]{queries[i], i};
        }
        Arrays.sort(map, new comp());
        Arrays.sort(items , new comp());

        int x = 0;
        int maxbeauty = 0;
        for(int i=0; i<n; ++i) {
            while(x < items.length && map[i][0] >= items[x][0]) {
                maxbeauty = Math.max(maxbeauty , items[x][1]);
                ++x;
            }
            result[map[i][1]] = maxbeauty;
        }
        return result;
    }
}