package Sorting;

import java.util.LinkedList;

public class InsertionSort {
    public static void main(String []args){
        int [] arr = { 12, 11, 13, 5, 6 };

        insertSort(arr);

        printArray(arr);
    }

    public static void insertSort(int [] arr){
        for(int i=1;i<arr.length;i++){
            int j=i;
            while(j>0 && arr[j]<arr[j-1]){
                int temp = arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }
    }

    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}
