public class Solution {
    /**
     * @param val: a num from the data stream.
     * @return: nothing
     */

     PriorityQueue<Integer> first = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
     PriorityQueue<Integer> second = new PriorityQueue<Integer>();
    public void add(int val) {
        // write your code here
        second.add(val);
        first.add(second.poll());
        if (first.size() == second.size() + 2) {
            second.add(first.poll());
        }
    }

    /**
     * @return: return the median of the all numbers
     */
    public int getMedian() {
        // write your code here
        return first.peek();
    }
}