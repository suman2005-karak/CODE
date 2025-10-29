class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int[] n1 = parse(num1);
        int[] n2 = parse(num2);

        int a = n1[0], b = n1[1];
        int c = n2[0], d = n2[1];

        int real = a * c - b * d;
        int imag = a * d + b * c;

        return real + "+" + imag + "i";
    }

    private int[] parse(String num) {
        // Split the string into real and imaginary parts
        String[] parts = num.split("\\+");
        int real = Integer.parseInt(parts[0]);
        int imag = Integer.parseInt(parts[1].replace("i", ""));
        return new int[]{real, imag};
    }
}
