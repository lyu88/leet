![image.png](/Users/leadingyu88/Downloads/image.png)

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Test case 1
        int[] values1 = {3, 1, 4, 1, 5, 9, 2, 6};
        int k1 = 3;
        int j = (int)Math.ceil((k1 + 1) / 2.0);
        int[] result1 = findMedianGreedy(values1, (k1 + 1)/2, j);
        System.out.println("Array: " + Arrays.toString(values1));
        System.out.println("k = " + k1);
        System.out.println("Max median: " + result1[0] + ", Min median: " + result1[1]);

        // Test case 2: Simple increasing sequence
        int[] values2 = {1, 2, 3, 4, 5};
        int k2 = 3;
        j = (int)Math.ceil((k2 + 1) / 2.0);
        int[] result2 = findMedianGreedy(values2, (k2 + 1)/2, j);
        System.out.println("\nArray: " + Arrays.toString(values2));
        System.out.println("k = " + k2);
        System.out.println("Max median: " + result2[0] + ", Min median: " + result2[1]);

        // Test case 3: Mixed values
        int[] values3 = {5, 1, 3, 9, 2, 8, 4};
        int k3 = 4;
        j = (int)Math.ceil((k3 + 1) / 2.0);
        int[] result3 = findMedianGreedy(values3, (k3+1)/2, j);
        System.out.println("\nArray: " + Arrays.toString(values3));
        System.out.println("k = " + k3);
        System.out.println("Max median: " + result3[0] + ", Min median: " + result3[1]);
    }



    private static int[] findMedianGreedy(int[] values, int k, int j) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>( (o1, o2) -> o2 - o1);

        for (int i = 0; i < values.length; i++) {
            if (i >= k) {
                if (values[i] >= minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(values[i]);
                }
            } else {
                minHeap.add(values[i]);
            }
            if (i >= j) {
                if (values[i] <= maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.add(values[i]);
                }
            } else {
                maxHeap.add(values[i]);
            }
        }
        return new int[]{minHeap.peek(), maxHeap.peek()};
    }
}
```
