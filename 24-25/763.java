class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] main = new int[26];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (main[index] == 0) {
                main[index]++;
                int[] table = new int[26];
                table[index]++;
                stack.push(table);
            } else {
                int[] table = new int[26];
                table[index]++;
                while (stack.peek()[index] == 0) {
                    int[] top = stack.pop();
                    for (int j = 0; j < 26; j++) {
                        table[j] += top[j];
                    }
                }
                for (int j = 0; j < 26; j++) {
                    stack.peek()[j] += table[j];
                }
            }
        }
        List<Integer> ret = new ArrayList<>();
        for (int[] table : stack) {
            int sum = 0;
            for (int i : table) {
                sum += i;
            }
            ret.add(sum);
        }
        return ret;
    }
}

// optimal
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] main = new int[26];
        for (char c : s.toCharArray()) {
            main[c - 'a']++;
        }
        List<Integer> ret = new ArrayList<>();
        int start = 0, diff = 0;
        int[] left = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            left[c - 'a']++;
            if (left[c - 'a'] == 1) {
                diff += main[c - 'a'] - 1;
            } else {
                diff--;
            }
            if (diff == 0) {
                ret.add(i - start + 1);
                start = i + 1;
            }
        }
        return ret;
    }
}