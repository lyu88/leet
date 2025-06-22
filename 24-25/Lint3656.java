public class SnakeGame {

    private int width;
    private int height;
    private Stack<List<Integer>> foods;
    private int foodIndex;
    private List<int[]> snake;
    private int score;
    private boolean gameOver;

    private Map<String, int[]> directions;

    public SnakeGame(int width, int height, List<List<Integer>> f) {
        this.width = width;
        this.height = height;
        foods = new Stack<>();
        for (int i = f.size() - 1; i >= 0; i--) {
            foods.push(f.get(i));
        }
        this.foodIndex = 0;
        this.score = 0;
        this.gameOver = false;
        
        // 初始化蛇的位置 (0,0)
        this.snake = new ArrayList<>();
        this.snake.add(new int[]{0, 0});
        
        // 初始化方向映射
        this.directions = new HashMap<>();
        directions.put("u", new int[]{-1, 0}); // 上
        directions.put("d", new int[]{1, 0});  // 下
        directions.put("l", new int[]{0, -1}); // 左
        directions.put("r", new int[]{0, 1});  // 右
    }

    /**
     * @param direction: the direction of the move
     * @return: the score after the move
     */
    public int move(String direction) {
        if (gameOver) {
            return -1;
        }
        
        // 获取方向向量
        int[] dir = directions.get(direction);
        if (dir == null) {
            return -1; // 无效方向
        }
        
        // 获取蛇头位置
        int[] head = snake.get(0);
        int newRow = head[0] + dir[0];
        int newCol = head[1] + dir[1];
        
        // 检查是否撞墙
        if (newRow < 0 || newRow >= height || newCol < 0 || newCol >= width) {
            gameOver = true;
            return -1;
        }
        
        // 检查是否撞到自己(not tail)
        for (int i = 0; i < snake.size()-1; i++) {
            int[] body = snake.get(i);
            if (body[0] == newRow && body[1] == newCol) {
                gameOver = true;
                return -1;
            }
        }
        
        // 移动蛇头
        snake.add(0, new int[]{newRow, newCol});
        // 检查是否吃到食物
        boolean ateFood = false;
        if (!foods.isEmpty()) {
            List<Integer> food = foods.peek();
            if (newRow == food.get(0) && newCol == food.get(1)) {
                int[] tail = snake.get(snake.size() - 1);
                // Edge case: eat the food and tail and the same time
                if (newRow == tail[0] && newCol == tail[1]) {
                    gameOver = true;
                    return -1;
                }
                score++;
                foods.pop();
                ateFood = true;
            }
        }
        
        // 如果没有吃到食物，移除蛇尾
        if (!ateFood) {
            snake.remove(snake.size() - 1);
        }
        
        
        return score;
    }
}