class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> count[o2] - count[o1]);
        for (int i = 0; i < 26; i++) {
            if(count[i] > 0) maxHeap.add(i);
        }
        int ret = 0;
        while (maxHeap.size() > 0) {
            final int size = maxHeap.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < Math.min(size, n+1); i++) {
                int t = maxHeap.poll();
                list.add(t);
            }
            for (int t : list) {
                if (--count[t] > 0) maxHeap.add(t);
            }
            if (maxHeap.size() > 0) {
                ret += n+1;
            } else {
                ret += size;
            }
        }
        return ret;
    }
}

// there is faster than this
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> freq[o2] - freq[o1]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.add(i);
            }
        }
        int cnt = 0;
        while (len > 0) {
            final int size = maxHeap.size();
            if (len == size) {
                cnt += len;
                break;
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < Math.min(size, n + 1); i++) {
                int index = maxHeap.poll();
                freq[index]--;
                len--;
                list.add(index);
            }
            cnt += n + 1;
            for (int i : list) {
                if (freq[i] > 0) {
                    maxHeap.add(i);
                }
            }
        }
        return cnt;
    }
}


// faster
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int max = 0;
        int[] freq = new int[26];
        for(int task : tasks){
            freq[task - 'A']++;
        }
        
        for(int f : freq){
            max = Math.max(max,f);
        }
        int maxFreqCount = 0;
        for(int f : freq){
            if(f == max){
                maxFreqCount++;
            }
        }
        return Math.max(tasks.length, (n+1)*(max-1) + maxFreqCount);
    }
}