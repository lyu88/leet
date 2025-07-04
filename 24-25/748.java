class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int minLen = Integer.MAX_VALUE;
        String ret = "";

        int[] tableP = new int[26];
        int diff = 0;
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                if (c >= 'a') {
                    tableP[c - 'a']++;
                } else {
                    tableP[c - 'A']++;
                }
                diff++;
            }
        }
        for (String word : words) {
            // faster as not to check if word length >= minLen
            if (word.length() < minLen && isCover(word, tableP)) {
                minLen = word.length();
                ret = word;
            }
        }
        return ret;
    }

    boolean isCover(String word, int[] tableP) {
        int diff = 0;
        for (int i : tableP) {
            if (i > 0) {
                diff += i;
            }
        }
        int[] tableS = new int[26];
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                final int index;
                if (c >= 'a') {
                    index = c - 'a';
                    tableS[index]++;
                } else {
                    index = c - 'A';
                    tableS[index]++;
                }
                if (tableS[index] <= tableP[index]) diff--;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }
}

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int minLen = Integer.MAX_VALUE;
        String ret = "";

        int[] tableP = new int[26];
        int diff = 0;
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                if (c >= 'a') {
                    tableP[c - 'a']++;
                } else {
                    tableP[c - 'A']++;
                }
                diff++;
            }
        }
        for (String word : words) {
            int[] tableS = new int[26];
            int delta = diff;
            for (char c : word.toCharArray()) {
                if (Character.isLetter(c)) {
                    final int index;
                    if (c >= 'a') {
                        index = c - 'a';
                        tableS[index]++;
                    } else {
                        index = c - 'A';
                        tableS[index]++;
                    }
                    if (tableS[index] <= tableP[index]) delta--;
                }
                // 词很长，还没走完就发现cover 
                if (delta == 0) {
                    if (word.length() < minLen) {
                        minLen = word.length();
                        ret = word;
                    }
                    break;
                }
            }
        }
        return ret;
    }
}