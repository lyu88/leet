class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        final int len = difficulty.length;
        Map<Integer, Integer> challenges = new HashMap<>();
        for (int i = 0; i < len; i++) {
            challenges.put(difficulty[i], Math.max(profit[i], challenges.getOrDefault(difficulty[i], 0)));
        }
        Arrays.sort(difficulty);
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, challenges.get(difficulty[i]));
            challenges.put(difficulty[i], max);
        }
        int sum = 0;
        for (int i = 0; i < worker.length; i++) {
            int index = Arrays.binarySearch(difficulty, worker[i]);
            if (index < 0) {
                if (-index-1 == 0) {
                    continue;
                }
                index = -index-2;
            }
            sum += challenges.get(difficulty[index]);
        }
        return sum;
    }
}

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        final int len = difficulty.length;
        Job[] jobs = new Job[len];
        for (int i = 0; i < len; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs, (o1, o2) -> o2.profit - o1.profit);
        Arrays.sort(worker);
        int i = 0, j = worker.length - 1, sum = 0;
        while (i < jobs.length && j >= 0) {
            if (jobs[i].difficulty <= worker[j]) {
                sum += jobs[i].profit;
                j--;
            } else {
                i++;
            }
        }
        return sum;
    }

    class Job {
        int difficulty;
        int profit;
        Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }
}