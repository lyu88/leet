/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        intervals.sort((o1, o2) -> Integer.compare(o1.start, o2.start));
        PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>(
            (o1, o2) -> Integer.compare(o1.end, o2.end)
        );
        for (Interval item : intervals) {
            if (minHeap.isEmpty()) {
                minHeap.add(item);
            } else {
                if (item.start >= minHeap.peek().end) {
                    Interval min = minHeap.poll();
                    min.end = item.end;
                    minHeap.add(min);
                } else {
                    minHeap.add(item);
                }
            }
        }
        return minHeap.size();
    }
}

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        intervals.sort((o1, o2) -> o1.start - o2.start);
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (Interval in : intervals) {
            if (!que.isEmpty() && que.peek() <= in.start) {
                que.poll();
            } 
            que.add(in.end);
        }
        return que.size();
    }
}