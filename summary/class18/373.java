class Solution {
    public List<int[]> kSmallestPairs(int[] a, int[] b, int k) {
        List<int[]> results = new ArrayList<>();
        if (a.length == 0 || b.length == 0) {
            return results;
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(a[o1[0]] + b[o1[1]], a[o2[0]] + b[o2[1]]));
        boolean[] posA = new boolean[a.length];
        boolean[] posB = new boolean[b.length];
        minHeap.add(new int[]{0, 0});
        posA[0] = true;
        posB[0] = true;
        while (!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            int i = node[0];
            int j = node[1];
            int[] result = {a[i], b[j]};
            results.add(result);
            if (results.size() == k) {
                break;
            }
            if (i + 1 < a.length && !posA[i + 1]) {
                posA[i + 1] = true;
                minHeap.add(new int[]{i + 1, j});
            }
            if (j + 1 < b.length && !posB[j + 1]) {
                posB[j + 1] = true;
                minHeap.add(new int[]{i, j + 1});
            }
        }
        
        return results;
    }


    public List<int[]> kSmallestPairs1(int[] a, int[] b, int k) {
        List<int[]> results = new ArrayList<>();
        if (a.length == 0 || b.length == 0) {
        	return results;
        }
        PriorityQueue<Node> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.sum, o2.sum));
        Set<Node> set = new HashSet<>();
        Node node = new Node(0, 0, a[0] + b[0]);
        heap.add(node);
        set.add(node);
        while (!heap.isEmpty()) {
        	node = heap.poll();
        	int i = node.i;
        	int j = node.j;
        	int[] result = {a[i], b[j]};
        	results.add(result);
        	if (results.size() == k) {
        		break;
        	}
        	if (i + 1 < a.length) {
        		Node newNode = new Node(i + 1, j, a[i + 1] + b[j]); 
        		if (!set.contains(newNode))
        		{
        			heap.add(newNode);
        			set.add(newNode);
        		}	
        	}
        	if (j + 1 < b.length) {
        		Node newNode = new Node(i, j + 1, a[i] + b[j + 1]);
        		if (!set.contains(newNode))
        		{
        			heap.add(newNode);
        			set.add(newNode);
        		}
        	}
        }
        
        return results;
    }

    public List<int[]> kSmallestPairs2(int[] a, int[] b, int k) {
        List<int[]> results = new ArrayList<>();
        if (a.length == 0 || b.length == 0) {
        	return results;
        }
        PriorityQueue<Node> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.sum, o2.sum));
        boolean[][] isVisited = new boolean[a.length][b.length];
        
        heap.add(new Node(0, 0, a[0] + b[0]));
        isVisited[0][0] = true;
        while (!heap.isEmpty()) {
        	Node node = heap.poll();
        	int i = node.i;
        	int j = node.j;
        	int[] result = {a[i], b[j]};
        	results.add(result);
        	if (results.size() == k) {
        		break;
        	}
        	if (i + 1 < a.length && !isVisited[i+1][j])
        	{
        		heap.add(new Node(i + 1, j, a[i + 1] + b[j]));
        		isVisited[i + 1][j] = true;
        	}
        	if (j + 1 < b.length && !isVisited[i][j + 1])
        	{
        		heap.add(new Node(i, j + 1, a[i] + b[j + 1]));
        		isVisited[i][j + 1] = true;
        	}
        }
        
        return results;
    }

    private class Node {
    	int i;
    	int j;
    	int sum;
    	public Node(int i, int j, int sum) {
    		this.i = i;
    		this.j = j;
    		this.sum = sum;
    	}

    	@Override
	    public boolean equals(Object o) {

	        if (o == this) return true;
	        if (!(o instanceof Node)) {
	            return false;
	        }
	        Node node = (Node) o;
	        return i == node.i &&
	            j == node.j &&
	            sum == node.sum;
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(i, j, sum);
	    }
    }
}