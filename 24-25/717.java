class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        final int len = bits.length;
        for (int i = 0; i < len; ) {
            if (i == len - 1) {
                return true;
            }
            if (bits[i] == 0) {
                i++;
            } else {
                i += 2;
            }
        }
        return false;
    }
}