public class Solution {
    /**
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     *          we will sort your return value in output
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        Map<Integer, List<String>> memo = new HashMap<>();
        wordDict.remove("");
        memo.put(s.length(), new ArrayList<>(){{add("");}});
        return dfs(s, 0, wordDict, memo);
    }

    private List<String> dfs(String s, int index, Set<String> wordDict,  Map<Integer, List<String>> memo) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        List<String> res = new ArrayList<>();
        for (String word : wordDict) {
            if (index + word.length() <= s.length() 
                && s.substring(index, index + word.length()).equals(word)) {
                List<String> subRes = dfs(s, index + word.length(), wordDict, memo);
                for (String sub : subRes) {
                    if (sub.isEmpty()) {
                        res.add(word);
                    } else {
                        res.add(word + " " + sub);
                    }
                }
            }
        }
        memo.put(index, res);
        return res;
    }
}