class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        _score = 0;
        _head = new Node(0, 0);
        _curDirection = "";
        _snake = new LinkedList<Node>();
        _snake.addLast(_head);
        _boardX = width-1;
        _boardY = height-1;
        _foods = new LinkedList<Node>();
        for (int i = 0; i < food.length; i++) {
            Node node = new Node(food[i][0], food[i][1]);
            _foods.add(node);
        }
        _nodes = new HashMap<Integer, HashSet<Integer>>();
        HashSet<Integer> ySet = new HashSet<Integer>();
        ySet.add(0);
        _nodes.put(0, ySet);
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        Node newHead = new Node(_head._x, _head._y);
        if (direction.equals("U")) {
            if (_curDirection.equals("D")) {
                return _score;
            }
            _curDirection = "U";
            newHead._y -= 1;
        } else if (direction.equals("L")) {
            if (_curDirection.equals("R")) {
                return _score;
            }
            _curDirection = "L";
            newHead._x -= 1;
        } else if (direction.equals("R")) {
            if (_curDirection.equals("L")) {
                return _score;
            }
            _curDirection = "R";
            newHead._x += 1;
        } else if (direction.equals("D")) {
            if (_curDirection.equals("U")) {
                return _score;
            }
            _curDirection = "D";
            newHead._y += 1;
        } else {
            return _score;
        }
        
        if (hitFood(newHead)) {
            _score++;
            _foods.remove();
        } else {
            Node oldTail = _snake.getLast();
            removeNode(oldTail);
        }
        if (hitBoarder(newHead) || hitSelf(newHead)) {
            return -1;
        } else {
            _head = newHead;
            addNode(_head);
            return _score;
        }
    }

    private void addNode(Node node) {
        int x = node._x;
        int y = node._y;
        HashSet<Integer> ySet;
        if (_nodes.containsKey(x)) {
            ySet = _nodes.get(x);
            ySet.add(y);
        } else {
            ySet = new HashSet<>();
            ySet.add(y);
        }
        _nodes.put(x, ySet);
        _snake.addFirst(node);
    }

    private void removeNode(Node node) {
        int x = node._x;
        int y = node._y;
        HashSet<Integer> ySet = _nodes.get(x);
        ySet.remove(y);
        _nodes.put(x, ySet);
        _snake.removeLast();
    }

    private boolean hitBoarder(Node newHead) {
        int x = newHead._x;
        int y = newHead._y;
        return x < 0 || x > _boardX || y < 0 || y > _boardY;
    }

    private boolean hitSelf(Node newHead) {
        int x = newHead._x;
        int y = newHead._y;
        if (_nodes.containsKey(x)) {
            HashSet<Integer> ySet = _nodes.get(x);
            if (ySet.contains(y)) {
                return true;
            }
        }
        return false;
    }

    private boolean hitFood(Node newHead) {
        if (_foods.isEmpty()) return false;
        Node food = _foods.element();
        return newHead._x == food._x && newHead._y == food._y;
        
    }

    Deque<Node> _snake;
    HashMap<Integer, HashSet<Integer>> _nodes;
    Node _head;
    String _curDirection;
    Queue<Node> _foods;
    int _score;
    int _boardX;
    int _boardY;

    private class Node {
        int _x;
        int _y;
        public Node(int x, int y) {
            _x = x;
            _y = y;
        }
    }

    
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */