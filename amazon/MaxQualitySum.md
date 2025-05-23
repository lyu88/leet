Amazon's AWS provides fast and efficient server solutions. The developers want to stress-test the quality of the servers' channels. They must ensure the following:

- Each of the packets must be sent via a single channel.
- Each of the channels must transfer at least one packet.

The quality of the transfer for a channel is defined by the median of the sizes of all the data packets sent through that channel.

Note: The median of an array is the middle element if the array is sorted in non-decreasing order. If the number of elements in the array is even, the median is the average of the two middle elements.

Find the maximum possible sum of the qualities of all channels. If the answer is a floating-point value, round it to the next higher integer.

** Manyyy thanks to spike -- the GG of error-free excellence! **

**Constraints:**

- 1 ≤ len(packets) ≤ 5×10^5
- 1 ≤ packets[i] ≤ 10^9
- 1 ≤ channels ≤ len(packets)

### **Example**

#### **Input**

packets = [1, 2, 3, 4, 5]
channels = 2

#### **Output**

8

### 🔍 **Key Insight**

To maximize the **sum of medians**, we need to:

- **Place the largest values near the centers** of the `channels` — since medians are central values.

- That means: assign **the largest `channels` number of elements as medians** — one per channel.

- This works because medians are the values that most influence the total channel quality.

---

### ✅ **Greedy Strategy**

1. **Sort** the packets in increasing order.

2. For `channels = c`, you will make `c` partitions.

3. You want **the `c` largest medians**.
   
   - To do that, take the largest `c` values from the right half of the sorted array — one median per channel.
   
   - The safest positions to select medians are every `2` elements from the end (for even distribution).

```java
import java.util.*;

public class Solution {
    public int maxQuality(int[] packets, int channels) {
        Arrays.sort(packets);
        int n = packets.length;

        // The optimal strategy is to take the largest `channels` medians from the back
        int sum = 0;
        int i = 1;
        while (i <= channels - 1) {
            // Pick the largest elements for each channel except the last
            sum += packets[n - i];
            i++;
        }

        // The remaining packets go to the last channel
        int remaining = n - i+1;
        int[] lastGroup = Arrays.copyOfRange(packets, 0, remaining);

        double median;
        if (remaining % 2 == 1) {
            median = lastGroup[remaining / 2];
        } else {
            median = (lastGroup[remaining / 2 - 1] + lastGroup[remaining / 2]) / 2.0;
        }

        return sum + (int)Math.ceil(median);
    }
}

```


