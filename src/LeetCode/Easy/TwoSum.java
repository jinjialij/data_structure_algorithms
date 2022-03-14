package LeetCode.Easy;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {

        int[] arr = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(arr, target);
        System.out.println(result[0] + ", " + result[1]);
        int[] result2 = twoSumUsingTwopointers(arr, target);

        System.out.println(result2[0] + ", " + result2[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num1 = target - nums[i];
            if (map.containsKey(num1)) {
                arr[0] = map.get(num1);
                arr[1] = i;
                return arr;
            } else {
                map.put(nums[i], i);
            }
        }
        return arr;
    }

    public static int[] twoSumUsingTwopointers(int[] nums, int target) {
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int right = nums[hi];
            int left = nums[lo];
            if (sum > target) {

                while (lo < hi && nums[hi] == right)
                    hi--;
            } else if (sum == target) {
                return new int[]{lo, hi};
            } else {

                while (lo < hi && nums[lo] == left)
                    lo++;
            }
        }
        return new int[]{-1, -1};
    }
}
