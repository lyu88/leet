class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        if (deads.contains("0000")) {
        	return -1;
        }
        int step = 0;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("0000");

        Set<String> passed = new HashSet<>();
    }



}