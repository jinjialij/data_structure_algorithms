package LeetCode.Easy;

import java.util.ArrayList;

public class palindrome {
    public static void main(String []args){
        String s = "A man, a plan, a canal: Panama";
        String s2 ="0P";
        boolean result = isPalindrome(s2);
        System.out.println(result);

    }
    public static boolean isPalindrome(String s) {
        /*
        * use two pointer
        * check if they equal to each other (in lowercase)
        * ignore if it is not char or digits
        * */
        int left = 0;
        int right = s.length()-1;

        while(left<right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if(!Character.isLetter(leftChar) || !Character.isDigit(leftChar)){
                left++;
                continue;
            }

            if(!Character.isLetter(rightChar) || !Character.isDigit(rightChar)){
                right--;
                continue;
            }

            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)){
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
