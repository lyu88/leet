// DAG bfs - using hash table to prevent revisit
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> dict = new HashSet<>(Arrays.asList(bank));
        
        int step = 0;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        
        Set<String> set = new HashSet<>();
        char[] cTable = new char[]{'A','C','G','T'};
        
        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(end)) {
                    return step;
                }
                set.add(word);
                StringBuilder sb = new StringBuilder(word);
                for (int index = 0; index < word.length(); index++) {
                    for (char c : cTable) {
                        sb.setCharAt(index, c);
                        String mutant = sb.toString();
                        if (!set.contains(mutant) && dict.contains(mutant)) {
                            queue.offer(mutant);
                        }
                    }
                    
                    sb.setCharAt(index, word.charAt(index));
                }
            }
            step++;
        }
        return -1;
    }
}







