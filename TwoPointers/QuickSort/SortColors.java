class Solution {
    public void sortColors(int[] nums) {
        int lastpos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(lastpos++, i, nums);
            }
        }
        if (lastpos == nums.length) {
            return;
        }
        for (int i = lastpos; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(lastpos++, i, nums);
            }
        }
        if (lastpos == nums.length) {
            return;
        }
        for (int i = lastpos; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(lastpos++, i, nums);
            }
        }
    }
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        
        int pl = 0;
        int pr = a.length - 1;
        int i = 0;
        while (i <= pr) {
            if (a[i] == 0) {
                swap(a, pl, i);
                pl++;
                i++;
            } else if(a[i] == 1) {
                i++;
            } else {
                swap(a, pr, i);
                pr--;
            }
        }
    }
}
 // Arrays.sort(nums);
