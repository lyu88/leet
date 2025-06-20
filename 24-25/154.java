// binary search with special handling
class Solution {
    public int findMin(int[] a) {
        int start = 0, end = a.length - 1;
        while (start < end) {
            if (a[start] < a[end]) {
                return a[start];
            }
            int mid = start + (end - start)/2;
            if (a[mid] < a[start]) {
                end = mid;
            } else if (a[mid] > a[start]) {
                start = mid + 1;
            } else {
                start++;
            }
        }
        return a[start];
    }
}