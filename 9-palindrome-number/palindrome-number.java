import java.util.Scanner;
class Solution {
    public  static boolean isPalindrome(int x) {
            if (x<0){
                return false;
            }
        String s = Integer.toString(Math.abs(x)); 
        int len = s.length();
        for(int i=0;i<= len/2;i++){
            if(s.charAt(i)!= s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        int k=s.nextInt();
        if (isPalindrome(k)==true){
            System.out.print("True");

        }
        else{
            System.out.print("False");
        }
        s.close();
    }
}