package Sorting;


import static Sorting.Print.print;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        print(arr);
        int [] res = mergeSort(arr);
        print(res);
        //test merge
//        int [] a1={5,6};
//        int [] a2={1,3};
//        merge(a1,a2);
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length > 1) {
            //split the arr into left and right
            int n1 = arr.length / 2;
            int n2 = arr.length - n1;
            int[] left = new int[n1];
            int[] right = new int[n2];
            for (int i = 0; i < n1; i++) {
                left[i] = arr[i];
            }
            for (int i = 0; i < n2; i++) {
                right[i] = arr[i+n1];
            }

            //recursion
            left = mergeSort(left);
            right = mergeSort(right);

            //merge
            arr = merge(left, right);
        }
        return arr;


    }

    public static int[] merge(int[] left, int[] right) {
        int leftP = 0, rightP = 0;
        int pointer = 0;
        int[] result = new int[left.length + right.length];
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] < right[rightP]) {
                result[pointer++] = left[leftP++];
            } else if (left[leftP] > right[rightP]) {
                result[pointer++] = right[rightP++];
            } else {
                result[pointer++] = left[leftP++];
                result[pointer++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            result[pointer++] = left[leftP++];
        }
        while (rightP < right.length) {
            result[pointer++] = right[rightP++];
        }
//        printArray(result);
        return result;
    }
}
