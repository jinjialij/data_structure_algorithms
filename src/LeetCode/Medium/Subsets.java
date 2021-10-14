package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String []args){
        int [] arr = new int []{1,2,3};
        List<List<Integer>> result = subsets(arr);
        System.out.println(result);
    }

//    public static List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> output = new ArrayList();
//        output.add(new ArrayList<Integer>());
//
//        for (int num : nums) {
//            List<List<Integer>> newSubsets = new ArrayList();
//            for (List<Integer> curr : output) {
//                List<Integer> list = new ArrayList<Integer>(curr);
//                list.add(num);
//                newSubsets.add(list);
//                // newSubsets.add(new ArrayList<Integer>(curr){{add(num);}});
//            }
//            for (List<Integer> curr : newSubsets) {
//                output.add(curr);
//            }
//        }
//        return output;
//    }

    //[[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> temp, int [] nums, int start){
        res.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            backtrack(res, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }

//    public static List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        result.add(new ArrayList<>());
//        for(int n : nums){
//            int size = result.size();
//            for(int i=0; i<size; i++){
//                List<Integer> subset = new ArrayList<>(result.get(i));
//                subset.add(n);
//                result.add(subset);
//            }
//        }
//        return result;
//    }
}
