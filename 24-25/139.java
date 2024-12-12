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