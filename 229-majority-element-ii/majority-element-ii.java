class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        /** USING MAP 
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int ele : nums) {
            map.put(ele ,map.getOrDefault(ele, 0)+1);
        }

        
        for(int key : map.keySet()) {
            if(map.get(key) > (n/3))
                result.add(key);
        }
        return result;
        */

        /**WITHOUT EXTRA SPACE */
        //Idea is to maintain two majority candidate , as max can be 2 only 
        //Then decide which are truly in majority

        int candidate1 = -1, candidate2 = -1, c1 = 0, c2 = 0;
        for(int ele : nums) {
            if(ele == candidate1)
                c1++;
            else if(ele == candidate2)
                c2++;
            else if(c1 == 0) {
                candidate1 = ele;
                c1 = 1;
            }
            else if(c2 == 0) {
                candidate2 = ele;
                c2 = 1;
            }
            else {
                c1--; c2--;
            }
        }
        
        c1 = 0; c2 = 0;
        for(int ele : nums) {
            if(ele == candidate1)
                c1++;
            else if(ele == candidate2)
                c2++;
        }

        if(c1 > (n/3))
            result.add(candidate1);
        if(c2 > (n/3))
            result.add(candidate2);

        return result;
    }
}