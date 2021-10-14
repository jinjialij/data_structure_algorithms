package LeetCode.Easy;

public class ConvertSortedArraytoBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {};
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String []args){
        int [] arr = new int []{-10,-3,0,5,9};
        TreeNode a = sortedArrayToBST(arr);
        print(a);
    }

    public static void print(TreeNode a){
        if(a==null) return;
        System.out.print(a.val+", ");
        print(a.left);
        print(a.right);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return formTree(0,nums.length-1,nums);
    }

    private static TreeNode formTree(int left,int right,int[] nums){
        if(left <= right){
            int mid = left + (right-left)/2;
            return new TreeNode(nums[mid],formTree(left,mid-1,nums),formTree(mid+1,right,nums));
        } return null;
    }
}
