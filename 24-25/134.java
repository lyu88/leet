
// 最低洼地的下一位
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = -1, totalGas = 0, totalCost = 0, min = Integer.MAX_VALUE;
        final int n = gas.length;

        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            if (totalGas - totalCost < min) {
                index = i;
                min = totalGas - totalCost;
            }
        }
        if (totalGas < totalCost) {
            return -1;
        }
        return (index + 1)%n;
    }
}


// wrong; please consider it as circular
// test case:
// gas = [5,8,2,8]
// cost = [6,5,6,6]
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = -1, totalGas = 0, totalCost = 0, max = Integer.MIN_VALUE;
        final int n = gas.length;

        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            if (gas[i] > cost[i] && gas[i] - cost[i] > max) {
                index = i;
                max = gas[i] - cost[i];
            }
        }
        if (totalGas < totalCost) {
            return -1;
        }
        return index;
    }
}