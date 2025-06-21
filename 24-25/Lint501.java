/**
 * Definition of Tweet:
 * public class Tweet {
 *     public int id;
 *     public int user_id;
 *     public String text;
 *     public static Tweet create(int user_id, String tweet_text) {
 *         // This will create a new tweet object,
 *         // and auto fill id
 *     }
 * }
 */


public class MiniTwitter {
    private Map<Integer, Set<Integer>> followings;
    private Map<Integer, List<Tweet>> userTweets;
    public MiniTwitter() {
        // do intialization if necessary
        followings = new HashMap<>();
        userTweets = new HashMap<>();
    }

    /*
     * @param user_id: An integer
     * @param tweet_text: a string
     * @return: a tweet
     */
    public Tweet postTweet(int user_id, String tweet_text) {
        // write your code here
        userTweets.putIfAbsent(user_id, new ArrayList<>());
        Tweet ret = Tweet.create(user_id, tweet_text);
        userTweets.get(user_id).add(ret);
        return ret;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new feeds recently and sort by timeline
     */
    public List<Tweet> getNewsFeed(int user_id) {
        // write your code here
        List<Tweet> ret = new ArrayList<>();
        int size = 0;
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((o1, o2) -> o2.id - o1.id);

        // Get tweets from the user.
        if (userTweets.containsKey(user_id)) {
            maxHeap.addAll(userTweets.get(user_id));
        }
        // Get tweets from followed users.
        Set<Integer> followed = followings.getOrDefault(user_id, new HashSet<>());
        for (int followedId : followed) {
            // Also need to add the followed user themselves.
            if (userTweets.containsKey(followedId)) {
                maxHeap.addAll(userTweets.get(followedId));
            }
        }

        while (!maxHeap.isEmpty() && size < 10) {
            ret.add(maxHeap.poll());
            size++;
        }
        return ret;
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new posts recently and sort by timeline
     */
    public List<Tweet> getTimeline(int user_id) {
        // write your code here
        List<Tweet> ret = new ArrayList<>();
        int size = 0;
        List<Tweet> list = userTweets.getOrDefault(user_id, new ArrayList<>());
        for (int i = list.size() - 1; i >= 0 && size < 10; i--) {
            ret.add(list.get(i));
            size++;
        }
        return ret;
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int from_user_id, int to_user_id) {
        // write your code here
        followings.putIfAbsent(from_user_id, new HashSet<>());
        followings.get(from_user_id).add(to_user_id);
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int from_user_id, int to_user_id) {
        // write your code here
        followings.get(from_user_id).remove(to_user_id);
    }
}