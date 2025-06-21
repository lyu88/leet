class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int start = 1, end = x;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return mid;
            }
            if ((long)mid * mid < (long)x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}


// no need long but convert to division
class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int start = 1, end = x - 1;
        while (start < end) {
            int res = start + (end - start)/2;
            if (res <= x/res && (res+1) > x/(res+1)) {
                return res;
            }
            if (res > x/res) {
                end = res - 1;
            } else {
                start = res + 1;
            }
        }
        return start;
    }
}