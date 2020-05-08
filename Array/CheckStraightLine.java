class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if (n == 2) {
            return true;
        }
        int horizontal = -1, vertical = -1;
        if (coordinates[1][0] == coordinates[0][0]) {
            vertical = coordinates[1][0];
        } else if (coordinates[1][1] == coordinates[0][1]) {
            horizontal = coordinates[1][1];
        }
        int x = coordinates[1][0] - coordinates[0][0];
        int y = coordinates[1][1] - coordinates[0][1];
        for (int i = 1; i < n-1; i++) {
            if (vertical != -1) {
                return coordinates[i+1][0] == vertical;
            } else if (horizontal != -1) {
                return coordinates[i+1][1] == horizontal;
            } else {
                return ((coordinates[i+1][0] - coordinates[i][0]) * y == (coordinates[i+1][1] - coordinates[i][1]) * x);
            }
        }
        return true;
    }
}
