class MovingAverage {

    List<Integer> list;
    int size = 0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        list = new ArrayList<>();
        this.size = size;
    }
    
    public double next(int val) {
        list.add(val);
        int sum = 0;
        if (list.size() <= size) {
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
            }
            return (double)sum / list.size();
        } else {
            int i = list.size() - size;
            int j = i + size;
            for (int k = i; k < j; k++) {
                sum += list.get(k);
            }
            double ans = (double)sum / size;
            return sum*1.0 / size;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
