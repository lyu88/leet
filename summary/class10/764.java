class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] left = new int[N][N];
        int[][] right = new int[N][N];
        int[][] up = new int[N][N];
        int[][] down = new int[N][N];

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        
        for (int k = 0; k < mines.length; k++) {
            int i = mines[k][0];
            int j = mines[k][1];
            if (map.containsKey(i)) {
                HashSet<Integer> set = map.get(i);
                set.add(j);
                map.put(i, set);
            } else {
                HashSet<Integer> set = new HashSet<Integer>();
                set.add(j);
                map.put(i, set);
            }
        }
        
        for (int i = 0; i < N; i++) {
            int pre = 0;
            for (int j = 0; j < N; j++) {
                if (!map.containsKey(i) || !map.get(i).contains(j)) {
                    left[i][j] = pre + 1;
                    pre++;
                } else {
                    pre = 0;
                }
            }
            
            pre = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (!map.containsKey(i) || !map.get(i).contains(j)) {
                    right[i][j] = pre + 1;
                    pre++;
                } else {
                    pre = 0;
                }
            }
        }
        
        for (int j = 0; j < N; j++) {
            int pre = 0;
            for (int i = 0; i < N; i++) {
                if (!map.containsKey(i) || !map.get(i).contains(j)) {
                    up[i][j] = pre + 1;
                    pre++;
                } else {
                    pre = 0;
                }
            }
            
            pre = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (!map.containsKey(i) || !map.get(i).contains(j)) {
                    down[i][j] = pre + 1;
                    pre++;
                } else {
                    pre = 0;
                }
            }
            
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int min = min(left[i][j], right[i][j], up[i][j], down[i][j]);
                max = Math.max(max, min);
            }
        }
        return max;
    }
    
    private int min(int val1, int val2, int val3, int val4) {
        return Math.min(Math.min(val1, val2), Math.min(val3, val4));
    }
    
    
}