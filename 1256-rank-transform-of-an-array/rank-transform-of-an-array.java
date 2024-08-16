class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int N = arr.length;
        TreeSet<Integer> set = new TreeSet<>();
        for(int ele : arr)
            set.add(ele);
        HashMap<Integer, Integer> map = new HashMap<>();
        int j=1;
        while(!set.isEmpty()) {
            map.put(set.pollFirst(), j++);
            
        }
        
        int[] result = new int[N];
        for(int i=0; i<N; i++) {
            result[i] = map.get(arr[i]);
        }
        return result;
    }
}