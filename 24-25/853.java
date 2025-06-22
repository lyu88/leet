class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        final int n = position.length;
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }
        Arrays.sort(cars, (o1, o2) -> o1.pos - o2.pos);
        Stack<Car> stack = new Stack<>();
        stack.push(cars[n-1]);
        for (int i = n - 2; i >= 0; i--) {
            //double currentTime
            Car car = cars[i];
            double currentTime = calcTime(car, target);
            double forwardTime = calcTime(stack.peek(), target);
            if (currentTime > forwardTime) {
                stack.push(car);
            }
        } 
        return stack.size();
    }

    double calcTime(Car car, int target){
        return (double)(target - car.pos) / car.speed;
    }

    class Car {
        int pos;
        int speed;
        Car(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }
    }
}