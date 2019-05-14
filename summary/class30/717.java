class Solution {
    public boolean isOneBitCharacter(int[] a) {
        final int len = a.length;
        int i = 0;
        while (i < len) {
        	if (i == len - 1) {
	        	return true;
	        }
	        if (a[i] == 1) {
	        	i += 2;
	        } else {
	        	i++;
	        }
        }
        return false;
    }
}