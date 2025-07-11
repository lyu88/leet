class Solution {
    public String reverseVowels(String s) {
        int start = 0, end = s.length() - 1;
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] arr = s.toCharArray();
        while (start < end) {
            if (!set.contains(arr[start])) {
                start++;
                continue;
            }
            if (!set.contains(arr[end])) {
                end--;
                continue;
            }
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
        return new String(arr);
    }
}