class Solution {
    public int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE)
        	return 0;
        int flag = 1;
        if (x < 0) flag = -1;
        x = Math.abs(x);
        int ret = 0;
        while (x > 0) {
        	try{
        		ret = Math.addExact(Math.multiplyExact(ret, 10), x % 10);
        	} catch(ArithmeticException e) {
    			return 0;
			}
            x /= 10;
        }
        return ret * flag;
    }
}