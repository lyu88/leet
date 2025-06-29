import java.util.*;

public class Main {
  public static void main(String[] args) {
    String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
    System.out.println(getLines(words, 16));
  }

  static List<List<Integer>> getLines(String[] words, int maxWidth) {
    List<List<Integer>> lines = new ArrayList<>();
    int start = 0;
    do {
      List<Integer> list = findIndex(words, maxWidth, start);
      start += list.size();
      lines.add(list);
    } while (start < words.length);
    return lines;
  }

  static List<Integer> findIndex(String[] words, int maxWidth, int start) {
    int len = 0;
    List<Integer> list = new ArrayList<>();
    while (start < words.length && len + words[start].length() <= maxWidth) {
      len += words[start].length();
      list.add(words[start].length());
      len++;
      start++;
    }
    return list;
  }
}

// 在往上叠一个fullyJustified
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<>();
        List<List<String>> lines = getLines(words, maxWidth);
        for (int i = 0; i < lines.size(); i++) {
            boolean isLast = i == lines.size() - 1;
            ret.add(fullyJustified(lines.get(i), maxWidth, isLast));
        }
        return ret;
    }

    String fullyJustified(List<String> words, int maxWidth, boolean isLast) {
        if (isLast || words.size() == 1) {
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                sb.append(word).append(' ');
            }
            sb.setLength(sb.length() - 1);
            String fix = " ".repeat(maxWidth - sb.length());
            sb.append(fix);
            return sb.toString();
        }
        int totalSpaces = maxWidth;
        for (String word : words) {
            totalSpaces -= word.length();
        }
        int spaceSlots = words.size() - 1;
        int evenSpace = totalSpaces / spaceSlots;
        int extraSpace = totalSpaces % spaceSlots;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size() - 1; i++) {
            sb.append(words.get(i));
            // Add even spaces
            for (int s = 0; s < evenSpace; s++) {
                sb.append(' ');
            }
            // Distribute extra spaces from the left
            if (extraSpace > 0) {
                sb.append(' ');
                extraSpace--;
            }
        }
        // Add the last word
        sb.append(words.getLast());
        return sb.toString();
    }

    List<List<String>> getLines(String[] words, int maxWidth) {
        List<List<String>> lines = new ArrayList<>();
        int start = 0;
        do {
            List<String> list = findIndex(words, maxWidth, start);
            start += list.size();
            lines.add(list);
        } while (start < words.length);
        return lines;
    }

    List<String> findIndex(String[] words, int maxWidth, int start) {
        int len = 0;
        List<String> list = new ArrayList<>();
        while (start < words.length && len + words[start].length() <= maxWidth) {
            len += words[start].length();
            list.add(words[start]);
            len++;
            start++;
        }
        return list;
    }
}