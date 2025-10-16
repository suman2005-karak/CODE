class Solution {
    public String optimalDivision(int[] nums) {
        // If only one number, return it as string
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        // If two numbers, just return "a/b"
        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        
        // For more than 2 numbers:
        // To maximize result, we divide the first number by (all others divided together)
        // i.e. nums[0] / (nums[1] / nums[2] / ... / nums[n-1])
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append("/(").append(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            sb.append("/").append(nums[i]);
        }
        sb.append(")");
        
        return sb.toString();
    }
}
