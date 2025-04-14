class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> allRes = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), allRes);
        return allRes;
    }

    private void dfs(String s, int index, List<String> path, List<List<String>> allRes) {
        if (index == s.length()) {
            allRes.add(new ArrayList<>(path));
        }
        for (int i = index; i < s.length(); i++) {
            if (isPal(s, index, i)) {
                String sub = s.substring(index, i+1);
                path.add(sub);
                dfs(s, i + 1, path, allRes);
                path.removeLast();
            }
        }
    }

    private boolean isPal(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (start == end) {
            return true;
        }
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}