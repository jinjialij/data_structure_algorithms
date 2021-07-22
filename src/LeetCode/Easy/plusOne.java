package LeetCode.Easy;

public class plusOne {
    public static void main(String []args){
        int [] arr = new int []{-1,-100,3,99};
        int [] arr2 = new int []{1,8,9};
        rotate2(arr, 2);
        //plusOne(arr2);
//        int [] result = plusOne2(arr2);
//        System.out.println("result length: " + result.length);
//        for (int e : result){
        for (int e : arr){
            System.out.println(e+", ");
        }

    }

    public static int[] plusOne(int [] digits){
        int carry=1;
        if(digits.length==1 && digits[0]<9){
            digits[0]=digits[0]+carry;
        } else {
            for(int i=digits.length-1;i>=0;i--){
                if(carry==1){
                    int sum = carry+digits[i];
                    digits[i]=(sum%10);
                    carry= (sum>9) ? 1:0;
                }
            }
            if (carry==1){
                int [] newDigits=new int [digits.length+1];
                newDigits[0]=1;
                for(int i=0;i<digits.length;i++){
                    newDigits[i+1]=digits[i];
                }
                return newDigits;
            }
        }

        return digits;
    }

    public static int[] plusOne2(int [] digits){
        //loop the digits from the end
        //if digits[i]<9, digits[i]++ and return
        //else digits[i]=0, continue the loop
        //outside the loop
        //add 1 to the front of the array
        //return the digit
        for (int i=digits.length-1;i>=0;i--){
            if (digits[i]<9){
                digits[i]+=1;
                return digits;
            }
            digits[i]=0;
        }
        int [] results = new int[digits.length+1];
        results[0]=1;
        return results;
    }

    public static void rotate(int[] nums, int k) {
        // speed up the rotation
//        k %= nums.length;
//        int temp, previous;
//        for (int i = 0; i < k; i++) {
//            previous = nums[nums.length - 1];
//            for (int j = 0; j < nums.length; j++) {
//                temp = nums[j];
//                nums[j] = previous;
//                previous = temp;
//            }
//        }

        int temp, pre;
        for(int i=0;i<k;i++){
            pre=nums[nums.length-1];
            for(int j=0;j<nums.length;j++){
                temp=nums[j];
                nums[j]=pre;
                pre=temp;
            }
        }
    }

    public static void rotate2(int [] nums, int k){
        int [] arr = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            arr[(i+k)%nums.length]=nums[i];
        }
        for( int i=0;i<nums.length;i++){
            nums[i]=arr[i];
        }
    }
}
