/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if (s.isEmpty()) {
            return new NestedInteger();
        }
        return deserialize(s, 0, s.length() - 1);
    }

    NestedInteger deserialize(String s, int start, int end) {
        NestedInteger ret = new NestedInteger();
        if (s.charAt(start) != '[') {
            ret.setInteger(Integer.valueOf(s.substring(start, end + 1)));
            return ret;
        }
        int lvl = 0, lstart = start + 1;
        for (int i = start + 1; i < end; i++) {
            if (s.charAt(i) == '[') {
                lvl++;
            } else if (s.charAt(i) == ']') {
                lvl--;
            } else if (s.charAt(i) == ',' && lvl == 0) { // if lvl != 0 meet comma it means inside the nested item
                ret.add(deserialize(s, lstart, i - 1));
                lstart = i + 1;
            }
        }
        if (lstart < end) {
            ret.add(deserialize(s, lstart, end - 1));
        }
        return ret;
    }
}