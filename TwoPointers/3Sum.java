class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(i==0 || nums[i]!=nums[i-1]){
                int target = 0-nums[i];
                int head = i+1;
                int tail = nums.length-1;
                while(head < tail){
                    if(nums[head] + nums[tail] == target){
                        result.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                        while(head<tail && nums[head] == nums[head+1]){
                            head++;
                            
                        }
                        while(head<tail && nums[tail] == nums[tail-1]){
                            tail--;
                        }
                        head++;
                        tail--;
                    }
                    else if(nums[head] + nums[tail] < target){
                        head++;
                    }
                    else if(nums[head] + nums[tail] > target){
                        tail--;
                    }
                }
            }
            
        }
        return result;
    }
}
