To solve the problem, we aim to find the **maximum length of a contiguous subarray** that can be converted into **all the same speed** by **removing at most `k` racers**.

### Approach: Sliding Window with Frequency Map

We can use the **sliding window technique** to maintain a window `[left, right]` where we attempt to make all elements in the window equal to the **most frequent element** within that window. Any other values can be considered for removal (up to `k` times).

### Steps:

1. Use a frequency map to count the number of times each speed appears within the current window.

2. Track the **most frequent count** of any speed in the window.

3. If the window size minus the count of the most frequent speed is greater than `k`, we need to **shrink the window** from the left.

4. Keep track of the maximum valid window size.

```java
import java.util.*;

public class Solution {
    public int getMaxRacers(int[] speed, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < speed.length; right++) {
            int currSpeed = speed[right];
            freq.put(currSpeed, freq.getOrDefault(currSpeed, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(currSpeed));

            int windowSize = right - left + 1;
            int toRemove = windowSize - maxFreq;

            if (toRemove > k) {
                int leftSpeed = speed[left];
                freq.put(leftSpeed, freq.get(leftSpeed) - 1);
                left++;
            } else {
                maxLength = Math.max(maxLength, windowSize);
            }
        }

        return maxLength;
    }
}
```

HackerLand Sports Club wants to send a team for a relay race. There are `n` racers in the group indexed from `0` to `n - 1`. The `i`th racer has a speed of `speed[i]` units.

The coach decided to send some contiguous subsegments of racers for the race i.e. racers with index `i`, `i + 1`, `i + 2` ..., `j` such that each racer has the same speed in the group to ensure smooth baton transfer. To achieve the goal, the coach decided to remove some racers from the group such that the number of racers with the same speed in some contiguous segment is maximum.

Given the array, `racers`, and an integer `k`, find the maximum possible number of racers in some contiguous segment of racers with the same speed after at most `k` racers are removed.

**Function Description**

Complete the function `getMaxRacers` in the editor.

`getMaxRacers` has the following parameter(s):

1. `int speed[n]`: the speeds of the racers
2. `int k`: the maximum number of racers that can be removed

**Returns**

`int`: the maximum number of racers that can be sent after removing at most `k` racers

**Constraints:**

- `1 ≤ n ≤ 3 * 10^5`
- `1 ≤ k ≤ n`

### **Example**

#### **Input**

speed = [1, 4, 4, 2, 2, 4]
k = 2

#### **Output**

3
