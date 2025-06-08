// TLE 重复计算非用stack不可
class Solution {

    final int mod = 1_000_000_007;
    public int sumSubarrayMins(int[] arr) {
        final int len = arr.length;
        int[] dp = new int[len];
        dp[0] = arr[0];
        for (int i = 1; i < len; i++) {
            dp[i] = (dp[i - 1] + calc(arr, i)) % mod;
        }
        return dp[len - 1];
    }

    int calc(int[] arr, int index) {
        int sum = arr[index], min = arr[index];
        for (int i = index - 1; i >= 0; i--) {
            min = Math.min(min, arr[i]);
            sum = (sum + min) % mod;
        }
        return sum;
    }

}

// 1 monoInc stack working solution
class Solution {

    final int mod = 1_000_000_007;
    public int sumSubarrayMins(int[] arr) {
        final int len = arr.length;
        int[] dp = new int[len];
        dp[0] = arr[0];
        int[] ple = ple(arr);
        for (int i = 1; i < len; i++) {
            dp[i] = (dp[i - 1] + calc(arr, ple, i)) % mod;
        }
        return dp[len - 1];
    }

    int[] ple(int[] arr) {
        final int len = arr.length;
        int[] ret = new int[len];
        Arrays.fill(ret, -1);
        Stack<Integer> mono = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!mono.isEmpty() && arr[mono.peek()] > arr[i]) {
                mono.pop();
            }
            ret[i] = mono.isEmpty() ? -1 : mono.peek();
            mono.push(i);
        }
        return ret;
    }

    int calc(int[] arr, int[] ple, int index) {
        int sum = 0;
        while (ple[index] != -1) {
            sum += (index - ple[index]) * arr[index];
            sum = sum % mod;
            index = ple[index];
        }
        sum += (index - ple[index]) * arr[index];
        return sum % mod;
    }

}

// 哪里错了，不好排查啊 - case 87 didn't pass
class Solution {

    final int mod = 1_000_000_007;
    int[] ple, nle;
    public int sumSubarrayMins(int[] arr) {
        ple(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] * (i - ple[i]) * (nle[i] - i) ;
            sum %= mod;
        }
        return sum;
    }

    void ple(int[] arr) {
        final int len = arr.length;
        ple = new int[len];
        nle = new int[len];
        Stack<Integer> mono = new Stack<>();
        Stack<Integer> monoInc = new Stack<>();
        for (int i = 0; i < len; i++) {
            // for prev less element strict
            while (!mono.isEmpty() && arr[mono.peek()] >= arr[i]) {
                mono.pop();
            }
            ple[i] = mono.isEmpty() ? -1 : mono.peek();
            mono.push(i);

            // for next less element non-strict
            nle[i] = len;
            while (!monoInc.isEmpty() && arr[monoInc.peek()] >= arr[i]) {
                nle[monoInc.pop()] = i;
            }
            monoInc.push(i);
        }
    }

}

// 抄抄高手
class Solution {

    private int MOD = (int)(1e9 + 7);
    public int sumSubarrayMins(int[] arr) {
        int N = arr.length;
        long res = 0;
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < arr.length; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] > arr[i]) {
                int pkIdx = deque.pollLast();
                int stIdx;
                if (deque.isEmpty()) stIdx = -1;
                else stIdx = deque.peekLast();
                res += (long)arr[pkIdx] * (long)(i - pkIdx) * (long)(pkIdx - stIdx);
            }
            deque.offerLast(i);
        }
        
        while (!deque.isEmpty()) {
            int pkIdx = deque.pollLast();
            int stIdx;
            if (deque.isEmpty()) stIdx = -1;
            else stIdx = deque.peekLast();
            res += (long)arr[pkIdx] * (long)(N - pkIdx) * (long)(pkIdx - stIdx);
        }
        return (int)(res % MOD);
    }

}