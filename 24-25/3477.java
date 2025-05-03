
// slow
class Solution {
    public int numOfUnplacedFruits(int[] f, int[] b) {
        Set<Integer> set = new HashSet<>();
        int ret = f.length;
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (b[j] >= f[i] && !set.contains(j)) {
                    ret--;
                    set.add(j);
                    break;
                }
            }
        }
        return ret;
    }
}