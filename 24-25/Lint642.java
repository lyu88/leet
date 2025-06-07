public class MovingAverage {

    double sum;
    int size;
    Queue<Integer> que;
    /*
    * @param size: An integer
    */
    public MovingAverage(int size) {
        // do intialization if necessary
        que = new ArrayDeque<>();
        this.size = size;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        // write your code here
        que.add(val);
        sum += val;
        if (que.size() > size) {
            sum -= que.poll();
        }
        return sum/que.size();
    }
}