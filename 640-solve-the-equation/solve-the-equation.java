class Solution {
    public String solveEquation(String equation) {
        String[] parts = equation.split("=");
        int[] left = evaluate(parts[0]);
        int[] right = evaluate(parts[1]);
        
        // left[0] = coefficient of x
        // left[1] = constant
        int coeff = left[0] - right[0];
        int constant = right[1] - left[1];
        
        if (coeff == 0 && constant == 0) return "Infinite solutions";
        if (coeff == 0) return "No solution";
        
        return "x=" + (constant / coeff);
    }

    private int[] evaluate(String expr) {
        int coeff = 0, constant = 0;
        int sign = 1;  // + or -
        int i = 0;
        int n = expr.length();

        while (i < n) {
            if (expr.charAt(i) == '+') {
                sign = 1;
                i++;
            } else if (expr.charAt(i) == '-') {
                sign = -1;
                i++;
            } else {
                int num = 0;
                boolean isNumber = false;
                while (i < n && Character.isDigit(expr.charAt(i))) {
                    num = num * 10 + (expr.charAt(i) - '0');
                    i++;
                    isNumber = true;
                }

                if (i < n && expr.charAt(i) == 'x') {
                    if (!isNumber) num = 1;  // handle cases like "+x" or "-x"
                    coeff += sign * num;
                    i++;
                } else {
                    constant += sign * num;
                }
            }
        }

        return new int[]{coeff, constant};
    }
}
