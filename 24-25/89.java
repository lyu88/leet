class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            return new ArrayList<>(List.of(0));
        }
        List<Integer> ret = grayCode(n - 1);
        final int len = ret.size();
        for (int i = len - 1; i >= 0; i--) {
            int x = ret.get(i);
            ret.add(1<<n-1 | x);
        }
        return ret;
    }
}