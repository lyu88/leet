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

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param = obj.isUnique(word);
 */