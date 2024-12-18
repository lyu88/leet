class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[][] g = buildGraph(s, set);
        List<String> allRes = new ArrayList<>();
        dfs(0, s, g, allRes, new ArrayList<>());
        return allRes;
    }

    private void dfs(int index, String s, boolean[][] g, List<String> allRes, 
        List<String> path) {
            if (index == s.length()) {
                allRes.add(String.join(" ", path));
                return;
            }
            for (int end = index; end < s.length(); end++) {
                if (g[index][end]) {
                    String link = s.substring(index, end + 1);
                    path.add(link);
                    dfs(end + 1, s, g, allRes, path);
                    path.removeLast();
                }
            }
    }

    private boolean[][] buildGraph(String s, Set<String> set) {
        final int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int start = 0; start < len; start++) {
            for (int end = start; end < len; end++) {
                if (set.contains(s.substring(start, end + 1))) {
                    dp[start][end] = true;
                }
            }
        }
        return dp;
    }
}