class Solution {
    public int[] smallestRange(List<List<Integer>> a) {
        TreeSet<Pos> bst = new TreeSet<>((o1, o2) -> a.get(o1._row).get(o1._col), a.get(o2._row).get(o2._col) == 0 ? -1 : a.get(o1._row).get(o1._col), a.get(o2._row).get(o2._col));
    	for (int i = 0; i < a.size(); i++) {
    		if (!a.get(i).isEmpty()) {
    			bst.add(new Pos(i, 0))
    		}
    	}

    	int diff = Integer.MAX_VALUE;
    	int[] ret = new int[2];
    	while (bst.size() == a.size()) {
    		Pos posOfLargest = bst.last();
    		Pos posOfSmallest = bst.pollFirst();

    		int smallest = a.get(posOfSmallest._row).get(posOfSmallest._col);
    		int largest = a.get(posOfLargest._row).get(posOfLargest._col);

    		if (largest - smallest < diff) {
    			diff = largest - smallest;
    			ret[0] = smallest;
    			ret[1] = largest; 
    		}
    		if (posOfSmallest._col + 1 < a.get(posOfSmallest._row).size()) {
    			bst.add(new Pos(posOfSmallest._row, posOfSmallest._col + 1));
    		}
    	}

    	return ret;
    }

    private class Pos {
    	int _row;
    	int _col;
    	public Pos(int row, int col) {
    		_row = row;
    		_col = col;
    	}
    }
}