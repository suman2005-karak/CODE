class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int operations = 0;
        
        for (int num : nums) {
            // Zeros clear the stack - they break segment continuity
            if (num == 0) {
                stack.clear();
                continue;
            }
            
            // Current element larger or equal - extends segment
            if (stack.isEmpty() || num >= stack.peek()) {
                // Only count as new operation if truly new (not equal to top)
                if (stack.isEmpty() || num > stack.peek()) {
                    operations++;
                }
                stack.push(num);
            } 
            // Current element smaller - need to adjust stack
            else {
                while (!stack.isEmpty() && stack.peek() > num) {
                    stack.pop();
                }
                
                // Always push and count if we reach here (it's smaller than original top)
                if (stack.isEmpty() || stack.peek() != num) {
                    stack.push(num);
                    operations++;
                }
            }
        }
        
        return operations;
    }
}
