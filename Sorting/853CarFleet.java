class Car {
    int position;
    double time;
    
    public Car(int position, double time) {
        this.position = position;
        this.time = time;
    }
    
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) {
            return 0;
        }
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], (double)(target - position[i]) / speed[i]);
        }
        Arrays.sort(cars, (a, b) -> (a.position - b.position));
        int ans = 1;
        for (int i = n-1; i >= 1; i--) {
            if (cars[i].time < cars[i-1].time) {
                ans++;
            } else {
                cars[i-1].time = cars[i].time;
            }
        }
        return ans;
    }
}
