public class Solution {
    /**
     * @param a: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] a) {
        // write your code here
        quickSort(a, 0, a.length - 1);
    }

    void quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int par = partition(a, start, end);
        quickSort(a, start, par - 1);
        quickSort(a, par + 1, end);
    }

    void swap(int[] a, int index1, int index2) {
        int tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    int partition(int[] a, int start, int end) {
        int par = start - 1;
        int pivot = a[end];
        for (int i = start; i < end; i++) {
            if (a[i] < pivot) {
                swap(a, ++par, i);
            }
        }
        swap(a, ++par, end);
        return par;
    }
}