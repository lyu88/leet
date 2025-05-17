// faster as directly setChar on the StringBuilder
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        int level = 1;
        Queue<String> que = new ArrayDeque<>();
        que.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!que.isEmpty()) {
            final int size = que.size();
            for (int i = 0; i < size; i++) {
                String word = que.poll();
                if (word.equals(endWord)) {
                    return level;
                }
                StringBuilder sb = new StringBuilder(word);
                for (int index = 0; index < word.length(); index++) {
                    char c = word.charAt(index);
                    for (char d = 'a'; d <= 'z'; d++) {
                        if (d == c) {
                            continue;
                        }
                        sb.setCharAt(index, d);
                        if (set.contains(sb.toString())) {
                            String s = sb.toString();
                            if (visited.contains(s)) {
                                continue;
                            }
                            que.add(s);
                            visited.add(s);
                        }
                    }
                    sb.setCharAt(index, c);
                }
            }
            level++;
        }
        return 0;
    }
}


// bfs but time is slow
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        int level = 1;
        Queue<String> que = new ArrayDeque<>();
        que.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!que.isEmpty()) {
            final int size = que.size();
            for (int i = 0; i < size; i++) {
                String word = que.poll();
                if (word.equals(endWord)) {
                    return level;
                }
                for (String s : set) {
                    if (!visited.contains(s) && diff(s, word) == 1) {
                        que.add(s);
                        visited.add(s);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    int diff(String s1, String s2) {
        int ret = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                ret++;
            }
        }
        return ret;
    }
}


// StackOverflowError
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Map<String, Integer> allRes = new HashMap<>();
        allRes.put(endWord, 0);
        int res = dfs(beginWord, allRes, set);
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    int dfs(String word, Map<String, Integer> allRes, Set<String> set) {
        if (allRes.containsKey(word)) {
            return allRes.get(word);
        }
        int min = Integer.MAX_VALUE;
        for (String s : set) {
            if (diff(s, word) == 1) {
                min = Math.min(min, dfs(s, allRes, set));
            }
            
        }
        int res = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min+1;
        allRes.put(word, res);
        return res;
    }

    int diff(String s1, String s2) {
        int ret = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                ret++;
            }
        }
        return ret;
    }
}