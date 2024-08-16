class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        //1. Add all task with their frequency in map, will schedule most frequent task first
        for(char ch : tasks)
            map.put(ch, map.getOrDefault(ch, 0)+1);
        
        //2. Make a maxHeap to get most frequest task
        PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
        maxH.addAll(map.values());

        //3. Now we run cooldown cycles and try to place diff task in them, if all task exhausted then we will be idle
        int interval = 0;
        while(!maxH.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            //coz after one task we have to wait for n min more so 0 for placing and then n min wait
            for(int i=0; i<=n; i++) {
                if(!maxH.isEmpty()) {
                    temp.add(maxH.remove());
                }
            }

            for(int ele : temp) {
                //if task still need to be performed
                if(--ele > 0)
                    maxH.add(ele);
            }

            interval += maxH.isEmpty() ? temp.size() : n+1;
        }
        return interval;
    }
}