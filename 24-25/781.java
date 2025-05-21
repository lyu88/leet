// 利用map remove key更方便理解
class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> mapFreq = new HashMap<>();
        int ret = 0;
        for (int ans : answers) {
            if (ans == 0) {
                ret++;
                continue;
            }
            mapFreq.put(ans, mapFreq.getOrDefault(ans, 0) + 1);
            if (mapFreq.get(ans) == ans+1) {
                ret += ans+1;
                mapFreq.remove(ans);
            }
        }
        for (var key : mapFreq.keySet()) {
            ret += key+1;
        }
        return ret;
    }
}


// bumpy when submitting the solution
class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> mapFreq = new HashMap<>();
        for (int ans : answers) {
            mapFreq.put(ans, mapFreq.getOrDefault(ans, 0) + 1);
        }
        int ret = 0;
        for (var entry : mapFreq.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (key == 0) {
                ret += val;
                continue;
            }
            if (val%(key + 1)== 0) {
                ret += val/(key+1) * (key + 1);
            } else {
                ret += (val/(key+1) + 1)*(key+1);
            }
        }
        return ret;
    }
}

// learned from classmate just to remove the key 