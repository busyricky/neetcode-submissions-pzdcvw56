class Twitter {
    Map<Integer, PriorityQueue<int[]>> tweetMap;
    Map<Integer, HashSet<Integer>> followMap;
    int counter = 0;

    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a,b) -> (b[0] - a[0])
        );

        if (tweetMap.containsKey(userId)) {
            heap = tweetMap.get(userId);
        }

        heap.offer(new int[]{counter, tweetId});
        tweetMap.put(userId, heap);

        if (!followMap.containsKey(userId)) {
            HashSet<Integer> set = new HashSet<>();
            set.add(userId);
            followMap.put(userId, set);
        }

        counter++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> (a[0] - b[0])
        );

        for (int follower : followMap.get(userId)) {
            if (tweetMap.containsKey(follower)) {
                for (int[] tweet : tweetMap.get(follower)) {
                    if (minHeap.size() <= 10 || minHeap.peek()[0] < tweet[0]) {
                        minHeap.offer(tweet);
                    }

                    if (minHeap.size() > 10) {
                        minHeap.poll();
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while(minHeap.size() > 0) {
            list.add(minHeap.poll()[1]);
        }

        Collections.reverse(list);

        return list;
    }
    
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> set = new HashSet<>();

        if (!followMap.containsKey(followerId)) {
            set.add(followerId);
        } else {
            set = followMap.get(followerId);
        }

        set.add(followeeId);

        followMap.put(followerId, set);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId) && followerId != followeeId) {
            HashSet<Integer> set = followMap.get(followerId);
            set.remove(Integer.valueOf(followeeId));
            followMap.put(followerId, set);
        }
    }
}
