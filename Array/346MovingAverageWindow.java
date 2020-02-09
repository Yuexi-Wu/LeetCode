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
class MovingAverage {

    int[] array;
    int size = 0;
    int counter = 0;
    //this head and tail is not the actial first index and last index of the array, they are next to each other and 
    //tail is the last element(if the array is not full, if full, it is the oldest element id the array, which could be replaced) 
    //in the array and they move forward one index each time.
    int head = 0, tail = 0;
    int sum = 0;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        array = new int[size];
        this.size = size;
    }
    
    public double next(int val) {
        counter++;
        int tail = (head+1) % size;
        sum  = sum + val - array[tail];
        head = tail;
        array[head] = val;
        return sum * 1.0 / Math.min(size, counter);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
