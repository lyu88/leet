public class Solution {
    /**
     * @param n: the number of courses
     * @param relations: the relationship between all courses
     * @return: ehe minimum number of semesters required to complete all courses
     */
    public int minimumSemesters(int n, int[][] relations) {
        // write your code here
        int[] indegrees = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] relation : relations) {
            indegrees[relation[1]-1]++;
            graph.putIfAbsent(relation[0]-1, new ArrayList<>());
            graph.get(relation[0]-1).add(relation[1]-1);
        }

        // put all 0 degree into que
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                que.add(i);
            }
        }
        int steps = 0;
        while (!que.isEmpty()) {
            final int size = que.size();
            for (int i = 0; i < size; i++) {
                int num = que.poll();
                List<Integer> neis = graph.getOrDefault(num, new ArrayList<>());
                for (int nei : neis) {
                    if (--indegrees[nei] == 0) {
                        que.add(nei);
                    }
                }
            }
            steps++;
        }
        for (int i = 0; i < n; i++) {
            if (indegrees[i] > 0) {
                return -1;
            }
        }
        return steps;
    }
}