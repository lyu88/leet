class Solution {
    public int minCut(String s) {
        final int len = s.length();
        Integer[] allRes = new Integer[len + 1];
        boolean[][] pal = buildPal(s);
        return dfs(0, s, pal, allRes) - 1;
    }

    private int dfs(int index, String s, boolean[][] pal, Integer[] allRes) {
        if (allRes[index] != null) {
            return allRes[index];
        }
        final int len = s.length();
        if (index == len) {
            allRes[len] = 0;
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = index; i < len; i++) {
            if (!pal[index][i]) {
                continue;
            }
            min = Math.min(min, 1 + dfs(i+1,s,pal,allRes));
        }
        allRes[index] = min;
        return min;
    }

    boolean[][] buildPal(String s) {
        int len = s.length();
        boolean[][] ret = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                ret[i][j] = isPal(s, i, j);
            }
        }
        return ret;
    }

    boolean isPal(String s, int start, int end) {
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

// straight dp solution
// better than first trial
class Solution {
    public int minCut(String s) {
        final int n = s.length();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPal(s, 0, i)) {
                dp[i] = 0;
                continue;
            }
            dp[i] = i;
            for (int x = 0; x < i; x++) {
                if (isPal(s, x+1, i)) {
                    dp[i] = Math.min(dp[i], 1 + dp[x]);
                }
            }
        }
        return dp[n - 1];
    }

    private boolean isPal (String s, int start, int end) {
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

// dp trick too many
// as building pal and dp solution at the same time
class Solution {
    public int minCut(String s) {
        char[] c = s.toCharArray();
        int n = s.length();
        int[] dp = new int[n];
        boolean[][] pal = new boolean[n][n];

        for (int col = 0; col < n; col++) {
            int min = col;
            for (int row = 0; row <= col; row++) {
                if (c[row] == c[col] && (row + 1 > col - 1 || pal[row+1][col-1])) {
                    pal[row][col] = true;
                    if (row == 0) {
                        min = 0;
                    } else {
                        min = Math.min(min, 1 + dp[row - 1]);
                    }
                }
            }
            dp[col] = min;
        }
        return dp[n - 1];
    }
}