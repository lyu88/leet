class Solution {


    //停在最末n - 1, m - 1非常不推荐。
    public boolean isMatch(String s, String p) {
        final int n = s.length();
        final int m = p.length();
        if (m == 0) {
            return n == 0;
        }
        if (n == 0) {
            if (m % 2 == 1) {
                return false;
            }
            for (int i = 1; i < m; i += 2) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }   
            return true;
        }
        boolean[] pre = new boolean[m];
        boolean[] cur = new boolean[m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    cur[j] = s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
                } else if (i == n - 1 && j == m - 2) {
                    cur[j] = p.charAt(j + 1) == '*' && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                } else if (i == n - 1) {
                    if (p.charAt(j + 1) == '*') {
                        cur[j] = cur[j + 2];
                        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                            boolean flag = true;
                            if ((m - 1 - j) % 2 == 1) {
                                for (int k = j + 1; k < m; k += 2) {
                                    if (p.charAt(k) != '*') {
                                        flag = false;
                                    }
                                }
                            } else {
                                flag = false;
                            }
                            cur[j] = cur[j] || flag;
                        }
                    } else {
                        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                            if ((m - 1 -j) % 2 == 0) {
                                boolean flag = true;
                                for (int k = j + 2; k < m; k += 2) {
                                    if (p.charAt(k) != '*') {
                                        flag = false;
                                    }
                                }
                                cur[j] = flag;
                            } else {
                                cur[j] = false;
                            }
                        } else {
                            cur[j] = false;
                        }
                    }
                } else if (j == m - 2) {
                    if (i == n - 2) {
                        if (p.charAt(j + 1) == '*') {
                            cur[j] = (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && pre[j]; 
                        } else {
                            cur[j] = (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && pre[j + 1]; 
                        }
                    } else {
                        cur[j] = p.charAt(j + 1) == '*' && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && pre[j];    
                    }
                } else if (j == m - 1) {
                    cur[j] = false;
                } else {
                    if (p.charAt(j + 1) == '*') {
                        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                            cur[j] = pre[j] || cur[j + 2];
                        } else {
                            cur[j] = cur[j + 2];
                        }
                    } else {
                        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                            cur[j] = pre[j + 1];
                        } else {
                            cur[j] = false;
                        }
                    }
                }
            }
            boolean[] tmp = pre;
            pre = cur;
            cur = tmp;
        }
        return pre[0];
    }
}