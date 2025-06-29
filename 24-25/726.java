class Solution {
    public String countOfAtoms(String formula) {
        Stack<TreeMap<String,Integer>> stack= new Stack<>();
        TreeMap<String,Integer> map= new TreeMap<>();
        final int n = formula.length();
        int i = 0;
        while (i < n) {
            char c = formula.charAt(i);
            i++;
            if (c == '(') {
                stack.push(map);
                map = new TreeMap<>();
            } else if (c == ')') {
                // read num as well
                int num = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    num = num * 10 + formula.charAt(i++) - '0';
                }
                num = num == 0 ? 1 : num;
                TreeMap<String,Integer> cur = map;
                // merge to previous
                map = stack.pop();
                for (String key : cur.keySet()) {
                    map.put(key, cur.get(key) * num + map.getOrDefault(key, 0));
                }
            } else {
                // read atom
                int start = i - 1;
                while(i<n && Character.isLowerCase(formula.charAt(i))){
                 i++;
                }
                String atom = formula.substring(start, i);
                // read num as well
                int num = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    num = num * 10 + formula.charAt(i++) - '0';
                }
                num = num == 0 ? 1 : num;
                map.put(atom, num + map.getOrDefault(atom, 0));
            }
        }
        return output(map);
    }

    String output(TreeMap<String,Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (var entry : map.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }
}