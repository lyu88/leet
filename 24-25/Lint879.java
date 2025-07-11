// 抄同学的做法
public class Solution {
    /**
     * @param n: a integer, denote the number of teams
     * @return: a string
     */
    public String findContestMatch(int n) {
        List<String> ret = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ret.add(String.valueOf(i));
        }
        while (ret.size() > 1) {
            List<String> list = new ArrayList<>();
            int start = 0, end = ret.size() - 1;
            while (start < end) {
                StringBuilder sb = new StringBuilder();
                sb.append('(').append(ret.get(start))
                    .append(',').append(ret.get(end)).append(')');
                list.add(sb.toString());
                start++;
                end--;
            }
            ret = list;
        }
        return ret.get(0);
    }
}