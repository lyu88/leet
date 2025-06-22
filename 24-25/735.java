class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            if (a < 0) {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(a)) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    if (stack.peek() < 0) {
                        stack.push(a); 
                    } else if (stack.peek() == Math.abs(a)) {
                        stack.pop();
                    }
                } else {
                    stack.push(a);
                }
            } else {
                stack.push(a);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}

//抄来的simulation，思想还是stack
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int[] stack = new int[asteroids.length];
        int top = -1;

        for (int asteroid : asteroids) {
            while (top >= 0 && asteroid < 0 && stack[top] > 0) {
                if (stack[top] < -asteroid) {
                    top--;  
                } else if (stack[top] == -asteroid) {
                    top--;  
                    asteroid =0;
                    break;
                } else {
                    asteroid =0;  
                    break;
                }
            }
            if (asteroid !=0) {
                stack[++top] = asteroid;
            }
        }

        return Arrays.copyOfRange(stack, 0, top + 1);
    }
}