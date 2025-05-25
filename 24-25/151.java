class Solution {
    public String reverseWords(String s) {
        int start = 0, end = s.length() - 1;
        while (s.charAt(start) == ' ') {
            start++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }
        s = s.substring(start, end + 1);
        start = 0;
        List<String> res = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (s.charAt(i - 1) != ' ') {
                    res.add(s.substring(start, i));
                }
                start = i + 1;
            }
        }
        res.add(s.substring(start));
        StringBuilder sb = new StringBuilder();
        for (int i = res.size() - 1; i >= 0; i--) {
            sb.append(res.get(i)).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}

// ai wrote in-place algo
class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        
        // Step 1: Reverse the entire string
        reverse(chars, 0, n - 1);
        
        // Step 2: Reverse each word back to correct order
        int start = 0;
        for (int end = 0; end <= n; end++) {
            if (end == n || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }
        
        // Step 3: Clean up extra spaces
        return cleanSpaces(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    private String cleanSpaces(char[] chars) {
        int n = chars.length;
        int i = 0, j = 0;
        
        while (j < n) {
            // Skip spaces at the beginning
            while (j < n && chars[j] == ' ') j++;
            
            // Copy non-space characters
            while (j < n && chars[j] != ' ') {
                chars[i++] = chars[j++];
            }
            
            // Skip extra spaces between words
            while (j < n && chars[j] == ' ') j++;
            
            // Add single space if not at the end
            if (j < n) chars[i++] = ' ';
        }
        
        return new String(chars, 0, i);
    }
}