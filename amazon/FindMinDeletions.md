# Problem

(Look into LC 664. Strange Printer may help :)

Given a string, determine the minimum number of operations (deletions) required to make the string empty.

You can perform the deletion operation as many times as you prefer::

- Pick any group of consecutive chars in the string, with a group size s ranging from 1 up to the curr len of the string. Delete them only when all the chars in this group are the same.

**Function Description**

Complete the function `minimumOperationsToRemove` in the editor.

`minimumOperationsToRemove` has the following parameter:

1. `String s`: the string to be processed

**Returns**

int: the minimum number of operations required

### **Example**

#### **Input**

s = "abaca"

#### **Output**

3

# Solution

```java
public class Solution {
    public int findMinDeletions(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // shrink
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        s = sb.toString();
        final int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int dist = 1; dist + i < n; dist++) {
                int j = dist + i;
                boolean flag = s.charAt(i) == s.charAt(j);
                if (dist == 1) {
                    dp[i][j] = flag ? 1 : 2;
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k + 1 <= j; k++) {
                    int tmp = dp[i][k] + dp[k + 1][j];
                    dp[i][j] = Math.min(dp[i][j], tmp);
                }
                if (flag) {
                    dp[i][j]--;
                }
            }
        }
        return dp[0][n - 1];
    }
}
```
