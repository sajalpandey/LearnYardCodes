class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<tickets.length; ++i)
            q.add(i);
        int count = 0;
        while(tickets[k] > 0) {
            int index = q.remove();
            tickets[index]--;
            if(tickets[index]>0)
                q.add(index);
            count++;
        }
        return count;
    }
}