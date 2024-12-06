class Solution {
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> mapFreq = new TreeMap<>();
        for (int num : nums) {
            mapFreq.put(num, mapFreq.getOrDefault(num, 0) + 1);
        }
        int pick = 0, notPick = 0;
        for (var entry : mapFreq.entrySet()) {
            int num = entry.getKey();
            int pic = 0, notPic = 0;
            if (!mapFreq.containsKey(num - 1)) {
                pic = num * entry.getValue() + Math.max(pick, notPick);
                notPic = Math.max(pick, notPick);
            } else {
                notPic = Math.max(pick, notPick);
                pic = notPick + num * entry.getValue();
            }
            pick = pic;
            notPick = notPic;
        }
        return Math.max(pick, notPick);
    }
}