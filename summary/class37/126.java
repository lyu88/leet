//TLE too naive

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> allRes = new ArrayList<>();
        int finalLevel = bfs(beginWord, endWord, dict);
        if (finalLevel == 0) {
            return allRes;
        }
        List<String> path = new ArrayList<String>();
        path.add(beginWord);
        dfs(beginWord, 1, finalLevel, endWord, dict, path, allRes);
        return allRes;
    }
    
    private void dfs(String word, int level, final int finalLevel, String endWord, Set<String> dict, List<String> path, List<List<String>> allRes) {
        if (level == finalLevel) {
            if (word.equals(endWord)) {
                allRes.add(new ArrayList<String>(path));
            }
            return;
        }
        
        StringBuilder sb = new StringBuilder(word);
        for (int j = 0; j < word.length(); j++) {
            for (char c = 'a'; c <= 'z'; c++) {
                sb.setCharAt(j, c);
                String mutant = sb.toString();
                if (dict.contains(mutant)) {
                    path.add(mutant);
                    dfs(mutant, level + 1, finalLevel, endWord, dict, path, allRes);
                    path.remove(path.size() - 1);   
                }
            }
            sb.setCharAt(j, word.charAt(j));
        }
    }
    
    
    private int bfs(String beginWord, String endWord, Set<String> dict)    {
        if (!dict.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        
        Set<String> set = new HashSet<>();
        int level = 0;
        while (!queue.isEmpty()) {
            final int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return level;
                }
                if (set.contains(word)) {
                    continue;
                }
                set.add(word);
                StringBuilder sb = new StringBuilder(word);
                for (int j = 0; j < word.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(j, c);
                        String mutant = sb.toString();
                        if (dict.contains(mutant)) {
                            queue.offer(mutant);
                        }
                    }
                    sb.setCharAt(j, word.charAt(j));
                }
            }
            
        }
        return 0;
    }
}

// Rocky's solution with parents
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    
    }

    private DagNode bfsBuildDag(String beginWord, String endWord, Set<String> dict) {
        Queue<DagNode> queue = new ArrayDeque<>();
        DagNode beginNode = new DagNode(beginWord);
        queue.offer(beginNode);
        Map<String, DagNode> curAndAboveLayer = new HashMap<>();
        curAndAboveLayer.put(beginWord, beginNode);

        while (!queue.isEmpty) {
            final size = queue.size();
            Map<String, DagNode> childLayer = new HashMap<>();
            if (node._word.equals(endWord)) {
                return node;
            }
            StringBuilder sb = new StringBuilder(node._word);
            for (int index = 0; index < node._word.length(); index++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    sb.setCharAt(index, c);
                    String next = sb.toString();
                    if (dict.contains(next) && !curAndAboveLayer.containsKey(next)) {
                        if (childLayer.containsKey(next)) {
                            childLayer.get(next)._parents.add(node);
                        } else {
                            DagNode childNode = new DagNode(next);
                            childNode._parents.add(node);
                            queue.add(childNode);
                            childLayer.put(next, childNode);
                        }
                    }
                }
                sb.setCharAt(index, node._word.charAt(index));
            }
            curAndAboveLayer.putAll(childLayer);
        }
        return null;
    }

    private class DagNode {
        final String _word;
        ArrayList<DagNode> _parents;
        public DagNode(String word) {
            _word = word;
            _parents = new ArrayList<DagNode>();
        }
    }
}

// try with children - which doesn't help dfs pruning still TLE

// with parents - AC

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> allRes = new ArrayList<>();
        Map<String, Set<String>> mapParents = new HashMap<>();
        int level = bfs(beginWord, endWord, dict, mapParents);
        if (level == 0) {
            return allRes;
        }
        LinkedList<String> path = new LinkedList<String>();
        dfs(1, level, endWord, beginWord, mapParents, path, allRes);
        return allRes;
    }
    
    private void dfs(int step, final int level, String word, String beginWord, Map<String, Set<String>> mapParents, LinkedList<String> path, List<List<String>> allRes) {
        if (step > level) {
            return;
        }
        path.addFirst(word);
        if (word.equals(beginWord)) {
            allRes.add(new LinkedList<String>(path));
        } else {
            for (String parent : mapParents.get(word)) {
                dfs(step + 1, level, parent, beginWord, mapParents, path, allRes);
            }
        }
        path.removeFirst();
    }
    
    
    private int bfs(String beginWord, String endWord, Set<String> dict, Map<String, Set<String>> mapParents)    {
        if (!dict.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            final int size = queue.size();
            level++;
            Map<String, Set<String>> mapSameLevel = new HashMap<>(); // for the purpose that multiple parents generate this node.
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return level;
                }
                StringBuilder sb = new StringBuilder(word);
                for (int j = 0; j < word.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(j, c);
                        String mutant = sb.toString();
                        if (dict.contains(mutant) && !mapParents.containsKey(mutant)) {
                            if (mapSameLevel.containsKey(mutant)) {
                                mapSameLevel.get(mutant).add(word);
                            } else { // this is the first time meeting the child, hence put in queue.
                                Set<String> set = new HashSet<>();
                                set.add(word);
                                mapSameLevel.put(mutant, set);
                                queue.offer(mutant);
                            }
                        }
                    }
                    sb.setCharAt(j, word.charAt(j));
                }
            }
            mapParents.putAll(mapSameLevel);
        }
        return 0;
    }
}



