package LeetCode.Easy;

import java.util.HashMap;

public class TwoSum {
    public static void main(String []args){
        int [] arr = new int []{2,7,11,15};
        int target = 9;
        int [] result = twoSum(arr,target);
        System.out.println(result[0]+ ", " + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap();
        int [] arr = new int [2];
        for (int i=0;i<nums.length;i++){
            int num1 = target-nums[i];
            if (map.containsKey(num1)){
                arr[0]=map.get(num1);
                arr[1]=i;
                return arr;
            } else {
                map.put(nums[i],i);
            }
        }
        return arr;
    }
}
