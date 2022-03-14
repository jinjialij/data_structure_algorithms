package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        //-4,-1,-1,0,1,2
        List<List<Integer>> res = threeSum(nums);
        for (List<Integer> re : res) {
            System.out.println(re.toString());
        }

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = 0 - nums[i];
            List<List<Integer>> twoSumLists = twoSum(nums, i + 1, sum);//array, start index, target
            List<Integer> temp;
            if (twoSumLists != null && !twoSumLists.isEmpty()) {
                for (List<Integer> list : twoSumLists) {
                    temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.addAll(list);
                    res.add(temp);
                }

            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    public static List<List<Integer>> twoSum(int[] nums, int startIndex, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = startIndex;
        int hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo];
            int right = nums[hi];
            if (sum < target) {
                while (lo < hi && nums[lo] == left)
                    lo++;
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right)
                    hi--;
            } else {
                res.add(Arrays.asList(nums[lo], nums[hi]));
                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;
            }
        }
        return res;
    }
}
