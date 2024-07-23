class Pair implements Comparable<Pair>{
    int ele;
    int freq;
    Pair(int ele, int freq) {
        this.ele = ele;
        this.freq = freq;
    }

    public int compareTo(Pair b) {
        if(b.freq > this.freq)
            return -1;
        else if(b.freq == this.freq){
            if(b.ele > this.ele)
                return 1;
            return -1;
        }
        else
            return 1;
    }
}
class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : nums)
            map.put(ele, map.getOrDefault(ele, 0)+1);
        int[] result = new int[nums.length];
        int k = 0;
        List<Pair> list = new ArrayList<>();
        for(int p : map.keySet())
            list.add(new Pair(p, map.get(p)));
        Collections.sort(list);
        for(Pair pair : list) {
            for(int i=0; i<pair.freq; i++)
                result[k++] = pair.ele;
        }
            
        return result;
    }
}