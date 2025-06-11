public class Solution {
    /**
     * @param words: the words
     * @param s: the string
     * @return: the string with least number of tags
     */
    public String boldWords(String[] words, String s) {
        final int len = s.length();
        boolean[] bolds = new boolean[len];
        for (String word : words) {
            int index = s.indexOf(word, 0);
            while (index != -1) {
                int i = index;
                for (; i < index + word.length(); i++) {
                    bolds[i] = true;
                }
                index = s.indexOf(word, index+1);
            }
        }
        boolean lastBold = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (!lastBold && bolds[i]) {
                sb.append("<b>").append(s.charAt(i));
                lastBold = true;
            } else if (lastBold && !bolds[i] ) {
                sb.append("</b>").append(s.charAt(i));
                lastBold = false;
            } else {
                sb.append(s.charAt(i));
            }
        }
        if (lastBold) {
            sb.append("</b>");
        }
        return sb.toString();
    }
}