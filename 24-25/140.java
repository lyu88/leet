// 等于是用dp把set换了， 还是树dfs写法
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

// 这dag没毛病，虽然比前一种慢
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict); // Fast lookup
        Map<String, List<String>> memo = new HashMap<>();
        memo.put("", List.of(""));
        return dfs(s, set, memo);
    }

    private List<String> dfs(String s, Set<String> set, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        List<String> result = new ArrayList<>();
        for (String word : set) {
            if (s.startsWith(word)) {
                String suffix = s.substring(word.length());
                List<String> subRes = dfs(suffix, set, memo);
                for (String sub : subRes) {
                    if (sub.isEmpty()) {
                        result.add(word);
                    } else {    
                        result.add(word + " " + sub);
                    }
                }
            }
        }
        memo.put(s, result);
        return result;
    } 
}