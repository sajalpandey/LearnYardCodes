class Twitter {
    //For managing follow/un-follow we will have a map
    //For storing tweets we will use Priority Queue based on times will be sorted

    HashMap<Integer, HashSet<Integer>> friends = new HashMap<>();
    int time = 0;
    PriorityQueue<int[]> timeline = new PriorityQueue<>((a, b) -> (b[0] - a[0]));

    public Twitter() {
        friends.clear();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timeline.add(new int[]{++time, userId, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> temp = new PriorityQueue<>(timeline);
        List<Integer> result = new ArrayList<>();
        int count = 0;
        //System.out.println("getNewsFeed userId : "+userId);
        while(!temp.isEmpty() && count < 10) {
            int[] topTweet = temp.peek();
            //System.out.println(topTweet[0]+"--"+topTweet[1]+"--"+topTweet[2]);
            if(topTweet[1] == userId || friends.containsKey(userId) && friends.get(userId).contains(topTweet[1])) {
                result.add(topTweet[2]);
                count++;
            }
            temp.poll();
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!friends.containsKey(followerId))
            friends.put(followerId, new HashSet<>());
        friends.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(friends.containsKey(followerId))
            friends.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */