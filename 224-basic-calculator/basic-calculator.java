class Solution {
    public int calculate(String s) {
        int n = s.length();
        int result = 0;   // current result
        int sign = 1;     // current sign (+1 or -1)
        int num = 0;      // current number
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                // Build the full number (could have multiple digits)
                num = num * 10 + (ch - '0');
            } 
            else if (ch == '+') {
                // Add the previous number to result
                result += sign * num;
                sign = 1;
                num = 0;
            } 
            else if (ch == '-') {
                // Add the previous number, switch sign
                result += sign * num;
                sign = -1;
                num = 0;
            } 
            else if (ch == '(') {
                // Push current result and sign for later use
                stack.push(result);
                stack.push(sign);
                // Reset for inner expression
                result = 0;
                sign = 1;
            } 
            else if (ch == ')') {
                // Add last number before closing parenthesis
                result += sign * num;
                num = 0;

                // Retrieve previous sign and result
                result *= stack.pop();  // sign
                result += stack.pop();  // previous result
            }
        }

        // Add last number if any
        result += sign * num;
        return result;
    }
}
