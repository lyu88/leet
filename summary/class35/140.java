// top-down without memoization will meet TLE.
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> allRes = new ArrayList<>();
        List<String> ret = new ArrayList<>();
        
        dfs(s, 0, set, allRes, new StringBuilder());
        return allRes;
    }

    private void dfs(String s, int startIndex, Set<String> set, List<String> allRes, StringBuilder path) {
        if (startIndex == s.length()) {
            allRes.add(new String(path));
            return;
        }
        for (int end = startIndex + 1; end <= s.length(); end++) {
            String str = s.substring(startIndex, end);
            if (set.contains(str)) {
                path.append(str);
                if (end != s.length()) {
                    path.append(" ");
                }
                dfs(s, end, set, allRes, path);
                path.setLength(path.length() - str.length());
                if (end != s.length()) {
                    path.setLength(path.length() - 1);
                }
            }
        }
    }
}

// backtracking without any top-down. The key is memoization
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> allRes = new ArrayList<>();
        List<String> ret = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();

        return dfs(s, 0, set, map);
    }

    private List<String> dfs(String s, int startIndex, Set<String> set, Map<Integer, List<String>> map) {
        if (map.containsKey(startIndex)) {
            return map.get(startIndex);
        }

        List<String> res = new ArrayList<>();
        if (startIndex == s.length()) {
            res.add("");
        }
        for (int end = startIndex + 1; end <= s.length(); end++) {
            String str = s.substring(startIndex, end);
            if (set.contains(str)) {
                
                List<String> list = dfs(s, end, set, map);

                for (String t : list) {
                    res.add(str + (t.equals("") ? "" : " ") + t);
                }
                
            }
        }
        map.put(startIndex, res);
        return res;
    }
}