class Solution {
    public String[] findWords(String[] words) {
        final int size = 256;
        final int[] array1 = new int[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        final int[] array2 = new int[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        final int[] array3 = new int[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        boolean[] row1 = new int[size];
        initRow(row1, array1);
        boolean[] row2 = new int[size];
        initRow(row2, array2);
        boolean[] row3 = new int[size];
        initRow(row3, array3);

        List<String> result = new ArrayList<>();
        for (String word : words) {
        	if (word == null || word.length < 2) {
        		result.add(word);
        	}
        	char c = word.charAt(0);
        	if (isInRow(word, row1)) {
        		result.add(word);
        	} else if (isInRow(word, row2)){
				result.add(word);
        	} else if (isInRow(word, row3)) {
        		result.add(word);
        	} 
        }
        return result.toArray();
    }

    private boolean isInRow(String s, boolean[] row) {
    	for (int i = 0; i < word.length(); i++) {
        	c = word.charAt(i);
        	if (!row[c] && !row[c + 32]) {
    			return false;
    		}
        }
    	return true;
    }

    private void initRow(boolean[] row, int[] array){
    	for (int i = 0; i < array.length; i++) {
    		row[array[i]] = true;
    	}
    }
}