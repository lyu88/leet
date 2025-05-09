public class Solution {
    /**
     * @param digits: A digital string
     * @return: all possible letter combinations
     *          we will sort your return value in output
     */

    String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> allRes = new ArrayList<>();
        if (digits.isEmpty()) {
            return allRes;
        }
        dfs(0, digits, new StringBuilder(), allRes);
        return allRes;
    }

    private void dfs(int index, String digits, StringBuilder sb, List<String> allRes) {
        int i = digits.charAt(index) - '2';
        String s = map[i];
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            sb.append(c);
            if (index == digits.length() - 1) {
                allRes.add(sb.toString());
            } else {
                dfs(index + 1, digits, sb, allRes);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}