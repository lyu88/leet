public class ValidWordAbbr {
    
    Map<String, Set<String>> map;
    /*
    * @param dictionary: a list of words
    */
    public ValidWordAbbr(String[] dictionary) {
        // do intialization if necessary
        map = new HashMap<>();
        for (String word : dictionary) {
            String abbr = abbr(word);
            if (!map.containsKey(abbr)) {
                Set<String> set = new HashSet<>();
                set.add(word);
                map.put(abbr, set);
            } else {
                map.get(abbr).add(word);
            }
        } 
    }

    private String abbr(String word) {
        if (word.length() <= 2) {
            return word;
        }
        return "" + word.charAt(0) + (word.length()-2) + word.charAt(word.length() - 1);
    }

    /*
     * @param word: a string
     * @return: true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        // write your code here
        String abbr = abbr(word);
        return !map.containsKey(abbr) || map.get(abbr).size() == 1 && map.get(abbr).contains(word);
    }
}

// do it on 0609
public class ValidWordAbbr {
    /*
    * @param dictionary: a list of words
    */
    Map<String, Integer> map; 
    Set<String> set;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        set = new HashSet<>();
        for (String s : dictionary) {
            if (s.length() <= 2) {
                map.put(s, map.getOrDefault(s, 0) + 1);
                set.add(s);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(0)).append(s.length() - 2).append(s.charAt(s.length() - 1));
                String key = sb.toString();
                map.put(key, map.getOrDefault(key, 0) + 1);
                set.add(s);
            }
        }
    }

    /*
     * @param word: a string
     * @return: true if its abbreviation is unique or false
     */
    public boolean isUnique(String s) {
        // write your code here
        String key = s;
        if (s.length() > 2) {
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(0)).append(s.length() - 2).append(s.charAt(s.length() - 1));
            key = sb.toString();
        }
        return !map.containsKey(key) || map.get(key) == 1 && set.contains(s);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param = obj.isUnique(word);
 */