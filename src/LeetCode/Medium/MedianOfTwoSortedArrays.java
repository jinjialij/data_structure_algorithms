package LeetCode.Medium;

public class MedianOfTwoSortedArrays {
    public static void main(String []args){
        int [] arr = new int []{3};
        int [] arr2 = new int []{-2,-1};
        double result = findMedianSortedArrays(arr,arr2);
        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==0 || nums1 ==null){
            return returnMid(nums2);
        }

        if(nums2.length==0 || nums2 == null)
            return returnMid(nums1);

        int minLen = Math.min(nums1.length, nums2.length);
        int [] nums3 = new int [nums1.length+nums2.length];
        int p1=0, p2=0, p3=0;
        while(p1<minLen && p2<minLen){
            if(nums1[p1]<nums2[p2]){
                nums3[p3]=nums1[p1];
                p1++;
                p3++;
            } else if(nums1[p1]>nums2[p2]){
                nums3[p3]=nums2[p2];
                p2++;
                p3++;
            } else {
                nums3[p3]=nums1[p1];
                nums3[++p3]=nums2[p2];
                p3++;
                p2++;
                p1++;
            }
        }
        if(p1==minLen){
            for(;p2<nums2.length;p2++){
                nums3[p3++]=nums2[p2];
            }
        } else if(p2==minLen){
            for(;p1<nums1.length;p1++){
                nums3[p3++]=nums1[p1];
            }
        }

        return returnMid(nums3);

    }

    public static double returnMid(int nums[]){
        double mid = Integer.MIN_VALUE;
        if(nums.length%2!=0){
            int a = nums.length/2;
            mid = (double)nums[a];
        } else {
            mid=(double)(nums[(nums.length-1)/2]+nums[nums.length/2])/2.0;
        }

        return mid;
    }
}
