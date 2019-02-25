class Solution {
    public int numRabbits(int[] answers) {
    	if (answers == null || answers.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
        	int answer = answers[i];
        	if (!map.containsKey(answer)) {
        		map.put(answer, 1);
        	} else {
        		map.put(answer, map.get(answer) + 1);
        	}
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
        	int num = entry.getKey() + 1;
        	int numCount = entry.getValue() / num + (entry.getValue() % num == 0) ? 0 : 1;
        	sum += num * numCount;
        }
        return sum;
    }
}