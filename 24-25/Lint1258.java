// 这个版本更好理解
public class Solution {
    /**
     * @param nums: an integer list
     * @param numOdds: an integer
     * @return: return the number of beautiful subarrays
     */
    public int beautifulSubarrays(int[] nums, int goal) {
        // write your code here
        int ret = 0, cntOdd = 0, cntEven = 0, start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]%2 == 1) {
                cntOdd++;
            }
            // 先砍掉前面多余的
            while (cntOdd > goal) {
                if (nums[start++]%2 == 1) {
                    cntOdd--;
                }
                cntEven = 0;
            }
            // 计算前文
            if (cntOdd == goal && start <= i) {
                while (start < i && nums[start] % 2 == 0) {
                    start++;
                    cntEven++;
                }
                ret += cntEven + 1;
            }
        }
        return ret;
    }
}

// AI 更正
public class Solution {
    /**
     * @param nums: an integer list
     * @param numOdds: an integer
     * @return: return the number of beautiful subarrays
     */
    public int beautifulSubarrays(int[] nums, int numOdds) {
        int left = 0;
        int cnt = 0, oddCount = 0; // record in the window
        int ret = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) {
                oddCount++;
                cnt = 0; // reset in the window
            }
            while (oddCount == numOdds) {
                cnt++;
                if (nums[left++] % 2 == 1) {
                    oddCount--;
                }
            }
            // IDEA跑了一遍，那个很精彩
            // 没有reset的情况下，下一个even number把前文的cnt再加一遍
            ret += cnt;
        }

        return ret;
    }
}

// 错了，因为left右移没有记录完整
public int beautifulSubarrays(int[] nums, int numOdds) {
        // write your code here
        int cnt = 0, ret = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                cnt++;
            }
            while (cnt > numOdds) {
                if (nums[start++] % 2 == 1) {
                    cnt--;
                }
            }
            if (cnt == numOdds) {
                ret++;
            }
        }
        return ret;
    }