// dfs solution
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        final int len = s.length();
        Boolean[] allRes = new Boolean[len + 1];
        allRes[len] = true;
        return dfs(s, 0, wordDict, allRes);
    }

    private boolean dfs(String s, int index, List<String> wordDict, Boolean[] allRes) {
        if (allRes[index] != null) {
            return allRes[index];
        }
        boolean flag = false;
        for (String word : wordDict) {
            int len = word.length();
            if (index + len <= s.length()
                && word.equals(s.substring(index, index + len)) && dfs(s, index + len, wordDict, allRes)) {
                flag = true;
                break;
            }   
        }
        allRes[index] = flag;
        return flag;
    }
}

// dp solution
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        final int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (String word : wordDict) {
                int len = word.length();
                if (i + len <= n && s.substring(i, i + len).equals(word) && dp[i + len]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}

// did again
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        final int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[len] = true;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j <= len; j++) {
                if (set.contains(s.substring(i,j)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}