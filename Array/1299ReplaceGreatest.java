class Solution {
    public int[] replaceElements(int[] arr) {
        //update a max value from right of the array
        int current_max = -1;
        int pre_max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            current_max = Math.max(current_max, arr[i]);
            arr[i] = pre_max;
            pre_max = current_max;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
}