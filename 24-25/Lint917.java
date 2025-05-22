 
// null value in middle not valid; won't pass test case

 public class Solution {
    /**
     * @param s: the given string
     * @return: all the palindromic permutations (without duplicates) of it
     *          we will sort your return value in output
     */
    public List<String> generatePalindromes(String s) {
        // write your code here
        int[] map = new int[256];
        if (!canDo(s, map)) {
            return new ArrayList<>();
        }
        char[] st = new char[s.length()/2];
        char ch = findSingle(map, st);
        Set<String> set = new HashSet<>();
        permute(st, 0, set);
        List<String> ret = new ArrayList<>();
        for (String item : set) {
            String res = item + (ch == 0 ? "":ch) + (new StringBuilder(item)).reverse().toString();
            ret.add(res);
        }
        return ret;
    }

    char findSingle(int[] map, char[] st) {
        int k = 0;
        char ret = 0;
        for (int i = 1; i < 256; i++) {
            if (map[i]%2 == 1) {
                ret = (char)i;
            }
            for (int j = 0; j < map[i]/2; j++) {
                st[k++] = (char)i;
            }
        }
        return ret;
    }

    boolean canDo(String s, int[] map) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0)
                count--;
            else
                count++;
        }
        return count <= 1;
    }

    void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    void permute(char[] s, int start, Set<String> set) {
        if (start == s.length - 1) {
            set.add(new String(s));
        } else {
            permute(s, start + 1, set);
            for (int end = start + 1; end < s.length; end++) {
                if (s[end] != s[start]) {
                    swap(s, start, end);
                    permute(s, start + 1, set);
                    swap(s, start, end);
                }
            }
        }
    }
}