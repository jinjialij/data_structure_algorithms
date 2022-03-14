package Sorting;

import static Sorting.Print.print;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 7, 8, 5, 2, 1, 9, 5, 4};
        //3,1,8,5,2,7,9,5,4
        //l             r p
        //3,1,2,5,8,7,9,5,4
        //3,1,2,4,8,7,9,5,5
        //3,1,2   8,7,9,5,5
        //1,3,2   5,7,9,5,8
        //1,3,2   5,7,9,8,5
        //1,2,3   5,7,5,8,9
        //1,2,3   5,5,7,8,9
        print(arr);
        quickSort(arr);
        print(arr);
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int from, int to) {
        if (from >= to)
            return;
        //choose pivot
        int pivot = arr[to];//can improve: by select a random one

        //do the partition
        int index = partition(arr, from, to, pivot);

        quickSort(arr, from, index - 1);
        quickSort(arr, index + 1, to);
    }

    public static int partition(int[] arr, int from, int to, int pivot) {
        //thr last one is the pivot
        int left = from, right = to;
        while (left < right) {
            while (arr[left] <= pivot && left < right) {
                left++;
            }
            while (arr[right] >= pivot && left < right) {
                right--;
            }

            //swap values
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        //swap with pivot
        int temp = arr[left];
        arr[left] = arr[to];
        arr[to] = temp;

        print(arr);
        return left;
    }
}
