class Solution {
    public int maxChunksToSorted(int[] a) {
        Stack<Integer> stack = new Stack<>();
        for (int val : a) {
        	boolean flag = false; 
       	  	while (!stack.isEmpty()) {
       	  		int max = stack.peek();
       	  		if (val >= max) {
       	  			break;
       	  		} else {
       	  			stack.pop();
       	  			flag = true;
       	  		}
       	   	}
       	   	if (!flag)
       			stack.push(val);
        }
        return stack.size();
    }
}