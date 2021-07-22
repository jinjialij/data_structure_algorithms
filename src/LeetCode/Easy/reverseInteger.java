package LeetCode.Easy;

public class reverseInteger {
    public static void main(String []args){
        int x = -123;
        int y = reverse(x);
        System.out.println(y);

    }

    public static int reverse(int x){
        int rev =0;
        while(x!=0) {
            int pop=x%10;
            x=x/10;
            /*
            * if rev is greater than Integer.MAX_VALUE/10, it will get overflow when rev=rev*10
            * You don't have to know the last digit of INT_MAX and INT_MIN in advance. You can find it by yourself pretty easy:
            2^1 = 2
            2^2 = 4
            2^3 = 8
            2^4 = 16
            After these 4 numbers, last digits 2,4,8 and 6 are repeating:
            2^5 = 32
            2^6 = 64
            2^7 = 128
            2^8 = 256
            So, you could represent 2^31 like 2^(4x7+3), and last digit will be determined by 2^3 = 8,
            * because with 2^(4x7) = 2^28 you only jumped "close enough" to 2^31, and because 2^31 = 2^28 * 2^3
            * last digit of 2^31 is 8.
            * But since the INT_MAX = 2^31 - 1, last digit is 7. So if pop > 7 you have caused overflow.
            Similar logic can be applied for INT_MIN = -2^31
            * -2^(28+4)=-2^28-8
            * */
            if (rev>Integer.MAX_VALUE/10 || (rev==Integer.MAX_VALUE/10 && pop>7))
                return 0;
            /*
             * if rev is less than Integer.MAX_VALUE/10, it will get overflow when rev=rev*10
             * */
            if (rev<Integer.MIN_VALUE/10 || (rev==Integer.MIN_VALUE/10 && pop<-8))
                return 0;
            rev = rev * 10 +pop;
        }
        return rev;
    }

//    public static int reverse(int x) {
//        String str = String.valueOf(x);
//        String result = "";
//        if(str.substring(0,1).equals("-")){
//            result = result +"-";
//            for (int i=str.length();i>1;i--){
//                result += str.substring(i-1,i);
//            }
//        } else {
//            for (int i=str.length();i>0;i--){
//                result += str.substring(i-1,i);
//            }
//        }
//        return Integer.valueOf(result);
//    }
}
