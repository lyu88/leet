class Solution {
	// the most optimal O(nk) runtime complexity
    public int minCostII(int[][] costs) {
        final int n = costs.length;
        Node preMin0 = new Node(-1, 0);
        Node preMin1 = new Node(-1, 0);
        Node curMin0;
        Node curMin1;
        Node[] cur = new Node[3];
        for (int i = 0; i < n; i++) {
        	
        	findMin(costs[i], cur);
        	if (preMin0._color == cur[0]._color) {
                long cost01 = preMin0._cost + cur[1]._cost;
                long cost10 = preMin1._cost + cur[0]._cost;
        		if (cost01 < cost10) {
        			curMin0 = new Node(cur[1]._color, cost01);
                    long cost02 = preMin0._cost + cur[2]._cost;
                    if (cost10 < cost02) {
        			    curMin1 = new Node(cur[0]._color, cost10);
                    } else {
                        curMin1 = new Node(cur[2]._color, cost02);
                    }
        		} else {
        			curMin0 = new Node(cur[0]._color, cost10);
        			curMin1 = new Node(cur[1]._color, cost01);
        		}
        	} else {
        		curMin0 = new Node(cur[0]._color, preMin0._cost + cur[0]._cost);
        		if (preMin0._color != cur[1]._color) {
        			curMin1 = new Node(cur[1]._color, preMin0._cost + cur[1]._cost);
        		} else {
                    long cost02 = preMin0._cost + cur[2]._cost;
                    long cost11 = preMin1._cost + cur[1]._cost;
        			if (cost02 < cost11) {
        				curMin1 = new Node(cur[2]._color, cost02);
        			} else {
        				curMin1 = new Node(cur[1]._color, cost11);
        			}
        		}
        	}
            preMin0 = curMin0;
            preMin1 = curMin1;
        }
        return (int)preMin0._cost;
    }

    private void findMin(int[] a, Node[] cur) {
    	for (int i = 0; i < 3; i++) {
    		int min = Integer.MAX_VALUE;
    		int minIndex = -1;
    		for (int j = 0; j < a.length; j++) {
    			if (i == 1 && j == cur[0]._color) {
    				continue;
    			}
    			if (i == 2 && (j == cur[0]._color || j == cur[1]._color)) {
    				continue;
    			}
    			if (a[j] < min) {
    				min = a[j];
    				minIndex = j;
    			}
    		}
            cur[i] = new Node(minIndex, min);
    	}
    }

    private class Node {
    	public int _color;
    	public long _cost;
    	public Node(int color, long cost) {
    		_color = color;
    		_cost = cost;
    	}
    }
}