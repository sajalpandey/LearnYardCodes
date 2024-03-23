class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int freq = Integer.MIN_VALUE,num=Integer.MAX_VALUE;
        for(int ele :  nums) {
            if(ele%2==0){
                map.put(ele, map.getOrDefault(ele,0)+1);
                if(map.get(ele) == freq && ele <= num) {
                    num = ele;
                    freq = map.get(ele);
                } else if(map.get(ele) > freq) {
                    num = ele;
                     freq = map.get(ele);
                }
            }
        }
        return (map.size()==0 ? -1 : num);
    }
}